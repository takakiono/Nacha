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
     * ユーザ情報の取得
     * 
     */
    UserEntity select(@Param("userId") Long userId);

    /**
     * グループに紐づくユーザ情報の取得
     * 
     */
    List<UserEntity> selectByGroupId(@Param("groupId") Long groupId);

    /**
     * ユーザ情報の登録
     * 
     * @param userId
     * @param userName
     */
    int regist(@Param("entity") UserEntity entity);

    /**
     * ユーザ情報の登録
     * 
     * @param userId
     * @param userName
     */
    int update(@Param("entity") UserEntity entity);
}
