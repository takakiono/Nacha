package com.example.nacha.repository.dao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.nacha.repository.entity.UserEntity;

import java.util.List;

/**
 * ユーザマッパー
 */
@Mapper
public interface UserMapper {
    /**
     * ユーザ情報の登録
     * 
     */
    List<UserEntity> select(@Param("groupId") Long groupId);

    /**
     * ユーザ情報の登録
     * 
     * @param userId
     * @param userName
     */
    int regist(@Param("entities") List<UserEntity> entities);
}
