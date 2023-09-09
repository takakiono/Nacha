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
     * 家計簿情報の取得
     * @param groupId グループID
     * @param acquisitionMonth　取得月
     * @return
     */
    public List<AccountEntity> selectAccount(Long groupId, Long accountId, String acquisitionMonth){
        return accountMapper.select(groupId, accountId, acquisitionMonth);
    }

    /**
     * 家計簿情報の登録
     * @param entity 家計簿情報
     * @return
     */
    public int registAccount(AccountEntity entity){
        return accountMapper.regist(entity);
    }
}
