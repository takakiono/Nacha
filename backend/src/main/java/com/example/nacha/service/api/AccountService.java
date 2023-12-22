package com.example.nacha.service.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nacha.repository.AccountRepository;
import com.example.nacha.repository.entity.AccountEntity;
import com.example.nacha.service.bean.GetAccountApiResponseBean;
import com.example.nacha.service.bean.PostAccountApiRequestBean;
import com.example.nacha.service.bean.PostAccountApiResponseBean;
import com.example.nacha.service.bean.common.Account;


@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * 家計簿の登録
     * @param request PostAccountApiRequestBean
     * @return 登録情報
     */
    public PostAccountApiResponseBean registAccount(PostAccountApiRequestBean request){
        Long groupId = Long.valueOf(request.getGroupId());

        LocalDate localDate = LocalDate.parse(request.getDatetime(), formatter);
        AccountEntity entity = AccountEntity.builder()
            .groupId(groupId)
            .categoryId(Long.valueOf(request.getCategoryId()))
            .note(request.getNote())
            .amount(Long.valueOf(request.getAmount()))
            .accountDatetime(localDate.atStartOfDay())
            .build();
        accountRepository.registAccount(entity);

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
                .build())
            .collect(Collectors.toList());

        GetAccountApiResponseBean response = new GetAccountApiResponseBean();
        response.setAccouts(accounts);
        return response;
    }
}
