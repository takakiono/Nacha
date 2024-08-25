package com.example.nacha.service.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.example.nacha.common.constants.ErrorMessage;
import com.example.nacha.common.exception.NachaBusinessException;
import com.example.nacha.repository.AccountRepository;
import com.example.nacha.repository.AccountSumRepository;
import com.example.nacha.repository.CategoryRepository;
import com.example.nacha.repository.UserRepository;
import com.example.nacha.repository.entity.AccountEntity;
import com.example.nacha.repository.entity.AccountSumEntity;
import com.example.nacha.repository.entity.UserEntity;
import com.example.nacha.service.bean.GetAccountApiResponseBean;
import com.example.nacha.service.bean.GetSumApiResponseBean;
import com.example.nacha.service.bean.GetSumCategoriesApiResponseBean;
import com.example.nacha.service.bean.GetSumUserApiResponseBean;
import com.example.nacha.service.bean.PostAccountApiRequestBean;
import com.example.nacha.service.bean.PostAccountApiResponseBean;
import com.example.nacha.service.bean.SumCategory;
import com.example.nacha.service.bean.SumUser;
import com.example.nacha.service.bean.common.Account;


@Service
public class AccountService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AccountSumRepository accountSumRepository;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter formatterYearMonth = DateTimeFormatter.ofPattern("yyyy-MM");

    /**
     * 家計簿の登録
     * @param request PostAccountApiRequestBean
     * @return 登録情報
     */
    public PostAccountApiResponseBean registAccount(PostAccountApiRequestBean request){
        Long groupId = Long.valueOf(request.getGroupId());
        Long userId = Optional.ofNullable(request.getUserId())
            .filter(str -> !str.isEmpty())
            .map(Long::valueOf)
            .orElse(null);

        LocalDate localDate = LocalDate.parse(request.getDatetime(), formatter);
        AccountEntity entity = AccountEntity.builder()
            .groupId(groupId)
            .categoryId(Long.valueOf(request.getCategoryId()))
            .note(request.getNote())
            .amount(Long.valueOf(request.getAmount()))
            .accountDatetime(localDate.atStartOfDay())
            .userId(userId)
            .build();
        accountRepository.registAccount(entity);

        registSumAccount(groupId, localDate.format(formatterYearMonth));

        List<AccountEntity> responseEntity = accountRepository.selectAccount(groupId, Long.valueOf(entity.getAccountId()), null);
        Account account = Account.builder()
                .accountId(String.valueOf(responseEntity.get(0).getAccountId()))
                .groupId(String.valueOf(responseEntity.get(0).getGroupId()))
                .categoryId(String.valueOf(responseEntity.get(0).getCategoryId()))
                .note(responseEntity.get(0).getNote())
                .amount(String.valueOf(responseEntity.get(0).getAmount()))
                .datetime(responseEntity.get(0).getAccountDatetime().format(formatter))
                .build();

        PostAccountApiResponseBean response = new PostAccountApiResponseBean();
        response.setAccout(account);
        return response;
    }

    /**
     * 家計簿の取得
     * @param request グループID
     * @param acquisitionMonth　取得月
     * @return
     */
    public GetAccountApiResponseBean getAccouts(String request, String acquisitionMonth){
        Long groupId = Long.valueOf(request);
        List<AccountEntity> responseEntity = accountRepository.selectAccount(groupId, null, acquisitionMonth);

        List<Account> accounts = responseEntity.stream()
            .map(list -> Account.builder()
                .accountId(String.valueOf(list.getAccountId()))
                .groupId(String.valueOf(list.getGroupId()))
                .categoryId(String.valueOf(list.getCategoryId()))
                .note(list.getNote())
                .amount(String.valueOf(list.getAmount()))
                .datetime(list.getAccountDatetime().format(formatter))
                .userId(String.valueOf(list.getUserId()))
                .build())
            .sorted((e1, e2) -> e1.getDatetime().compareTo(e2.getDatetime()))
            .collect(Collectors.toList());

        GetAccountApiResponseBean response = new GetAccountApiResponseBean();
        response.setAccounts(accounts);
        return response;
    }

    /**
     * 家計簿の削除
     * @param request 家計簿ID
     */
    public void deleteAccount(String request){
        Long accountId = Long.valueOf(request);

        List<AccountEntity> entity = accountRepository.selectAccount(null, accountId, null);
        if (Objects.isNull(entity) || ObjectUtils.isEmpty(entity)){
            throw new NachaBusinessException(ErrorMessage.NachaNotTargetError);
        }
        int result = accountRepository.deleteAccount(accountId);
        if(result == 0){
            throw new NachaBusinessException(ErrorMessage.NachaDeleteError);
        }

        // 合計値の修正
        registSumAccount(entity.get(0).getGroupId(), entity.get(0).getAccountDatetime().format(formatterYearMonth));
    }

    /**
     * カテゴリ別合計値の取得
     * @param request　グループID
     * @param acquisitionMonth 取得月
     * @return
     */
    public GetSumCategoriesApiResponseBean getSumCategories(String request, String acquisitionMonth){
        Long groupId = Long.valueOf(request);
        
        List<AccountSumEntity> responseEntity = accountSumRepository.selectAccount(groupId, acquisitionMonth);
        List<SumCategory> sum = responseEntity.stream()
            .map(list -> SumCategory.builder()
                .categoryId(String.valueOf(list.getCategoryId()))
                .sum(list.getAmount())
                .build())
            .toList();
        
        return GetSumCategoriesApiResponseBean.builder()
            .sumCategories(sum)
            .sum(responseEntity.stream()
                .map(AccountSumEntity::getAmount)
                .reduce(0L, Long::sum))
            .acquisitionMonth(acquisitionMonth)
            .build();
        
    }

    /**
     * 取得月のユーザ毎の合計値の取得
     * @param request ユーザID
     * @param acquisitionMonth 取得月
     * @return
     */
    public GetSumUserApiResponseBean getSumUser(String request, String acquisitionMonth){
        Long groupId = Long.valueOf(request);
        List<AccountEntity> responseEntity = accountRepository.selectAccount(groupId, null, acquisitionMonth);
        List<UserEntity> userEntity = userRepository.getGroupUser(groupId);

        List<SumUser> sumUser = userEntity.stream()
            .map(list -> {
                Long sumAmount = responseEntity.stream()
                    .filter(e -> (!Objects.isNull(e.getUserId())) && e.getUserId().equals(list.getUserId()))
                    .map(AccountEntity::getAmount)
                    .reduce(0L, Long::sum);
                    
                return SumUser.builder()
                    .userId(String.valueOf(list.getUserId()))
                    .sum(sumAmount)
                    .build();
            })
            .toList();
        
        return GetSumUserApiResponseBean.builder()
            .sumUser(sumUser)
            .acquisitionMonth(acquisitionMonth)
            .build();
    }

    /**
     * カテゴリ別合計値の取得
     * @param request　グループID
     * @param acquisitionYear 取得年
     * @return
     */
    public GetSumApiResponseBean getSum(String request, String acquisitionYear){
        Long groupId = Long.valueOf(request);
        
        List<AccountSumEntity> responseEntity = accountSumRepository.selectAccount(groupId, acquisitionYear);

        // 年月毎に分別
        Map<String, List<AccountSumEntity>> classifiedList =  responseEntity.stream()
            .collect(Collectors.groupingBy(AccountSumEntity::getYearMonth));

        List<GetSumCategoriesApiResponseBean> classifiedRes = new ArrayList<>();
        classifiedList.forEach((yearMonth, list) -> {
            List<SumCategory> response = list.stream()
                .map(l -> SumCategory.builder()
                    .categoryId(String.valueOf(l.getCategoryId()))
                    .sum(l.getAmount())
                    .build())
                .toList();

            // 年月毎のリストを作成
            classifiedRes.add(GetSumCategoriesApiResponseBean.builder()
                .sumCategories(response)
                .sum(list.stream()
                    .map(AccountSumEntity::getAmount)
                    .reduce(0L, Long::sum))
                .acquisitionMonth(yearMonth)
                .build());
        });
        
        return GetSumApiResponseBean.builder()
            .sumMonth(classifiedRes)
            .sum(classifiedRes.stream()
                .map(GetSumCategoriesApiResponseBean::getSum)
                .reduce(0L, Long::sum))
            .acquisitionYear(acquisitionYear)
            .build();
    }

    /**
     * 家計簿の合計を登録する処理
     * @param groupId グループID
     * @param acquisitionMonth 取得月
     */
    private void registSumAccount(Long groupId, String acquisitionMonth){
        List<AccountEntity> responseEntity = accountRepository.selectAccount(groupId, null, acquisitionMonth);

        List<AccountSumEntity> registEntity = responseEntity.stream()
            .collect(Collectors.toMap(
                AccountEntity::getCategoryId, // `categoryId` をキーとする
                list -> AccountSumEntity.builder()
                    .groupId(list.getGroupId())
                    .categoryId(list.getCategoryId())
                    .amount(responseEntity.stream()
                        .filter(e -> e.getCategoryId().equals(list.getCategoryId()))
                        .map(AccountEntity::getAmount)
                        .reduce(0L, Long::sum))
                    .yearMonth(list.getAccountDatetime().format(formatterYearMonth))
                    .build(),
                (existing, replacement) -> existing // 同じ `categoryId` がある場合、既存のものを使用
            ))
            .values().stream()
            .toList();

        accountSumRepository.registAccountSum(registEntity);
        
    }
}
