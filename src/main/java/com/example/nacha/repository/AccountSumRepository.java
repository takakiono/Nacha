package com.example.nacha.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.nacha.repository.dao.AccountSumMapper;
import com.example.nacha.repository.entity.AccountSumEntity;

/**
 * 家計簿合計リポジトリ
 */
@Repository
public class AccountSumRepository {
    @Autowired
    AccountSumMapper accountSUmMapper;

    /**
     * 家計簿合計情報の取得
     * @param groupId グループID
     * @param acquisitionMonth　取得月
     * @return
     */
    public List<AccountSumEntity> selectAccount(Long groupId, String acquisitionMonth){
        return accountSUmMapper.select(groupId, acquisitionMonth);
    }

    /**
     * 家計簿合計情報の登録
     * @param entity 家計簿情報
     * @return
     */
    public int registAccountSum(List<AccountSumEntity> entity){
        return accountSUmMapper.regist(entity);
    }

}
