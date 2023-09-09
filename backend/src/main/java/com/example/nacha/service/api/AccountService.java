package com.example.nacha.service.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nacha.repository.AccountRepository;
import com.example.nacha.repository.entity.AccountEntity;
import com.example.nacha.service.bean.PostAccountApiRequestBean;
import com.example.nacha.service.bean.PostAccountApiResponseBean;
import com.example.nacha.service.bean.PostAccountApiResponseBean.Account;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    /**
     * 家計簿の登録
     * @param request PostAccountApiRequestBean
     * @return 登録情報
     */
    public PostAccountApiResponseBean registAccount(PostAccountApiRequestBean request){
        Long groupId = Long.valueOf(request.getGroupId());
        AccountEntity entity = AccountEntity.builder()
            .groupId(groupId)
            .categoryId(Long.valueOf(request.getCategoryId()))
            .note(request.getNote())
            .amount(Long.valueOf(request.getAmount()))
            .datetime(new Date())
            .build();
        accountRepository.registAccount(entity);

        List<AccountEntity> responseEntity = accountRepository.selectAccount(groupId);
        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        account.setAmount(String.valueOf(responseEntity.get(0).getAmount()));
        accounts.add(account);

        PostAccountApiResponseBean response = new PostAccountApiResponseBean();
        response.setAccout(accounts);
        return response;
    }
}
