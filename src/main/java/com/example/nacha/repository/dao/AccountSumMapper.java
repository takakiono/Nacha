package com.example.nacha.repository.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.nacha.repository.entity.AccountSumEntity;


/**
 * 家計簿合計マッパー
 */
@Mapper
public interface AccountSumMapper {

    /**
     * 家計簿合計情報の取得
     * 
     * @param groupId グループID
     * @param accountId 家計簿ID
     * @param acquisitionYearMonth 取得年月
     */
    List<AccountSumEntity> select(@Param("groupId") Long groupId, @Param("acquisitionYearMonth") String acquisitionYearMonth);

    /**
     * 家計簿合計情報の登録
     * 
     * @param entity 家計簿合計情報
     */
    int regist(@Param("entity") List<AccountSumEntity> entity);
}
