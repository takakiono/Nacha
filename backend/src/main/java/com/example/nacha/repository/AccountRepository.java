package com.example.nacha.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.nacha.repository.dao.AccountMapper;
import com.example.nacha.repository.entity.AccountEntity;

/**
 * 家計簿リポジトリ
 */
@Repository
public class AccountRepository {
    @Autowired
    AccountMapper accountMapper;

    /**
     * 家計簿情報の登録
     * @param entity
     * @return
     */
    public List<AccountEntity> selectAccount(Long groupId){
        return accountMapper.select(groupId);
    }

    /**
     * 家計簿情報の登録
     * @param entity
     * @return
     */
    public int registAccount(AccountEntity entity){
        return accountMapper.regist(entity);
    }
}
