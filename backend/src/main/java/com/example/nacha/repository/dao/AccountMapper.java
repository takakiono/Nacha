package com.example.nacha.repository.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.nacha.repository.entity.AccountEntity;


/**
 * 家計簿マッパー
 */
@Mapper
public interface AccountMapper {

    /**
     * 家計簿情報の取得
     * 
     * @param groupId
     */
    List<AccountEntity> select(@Param("groupId") Long groupId);

    /**
     * 家計簿情報の登録
     * 
     * @param entity 家計簿情報
     */
    int regist(@Param("entity") AccountEntity entity);
}
