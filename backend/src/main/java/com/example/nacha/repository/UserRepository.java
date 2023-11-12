package com.example.nacha.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.nacha.repository.entity.UserEntity;
import com.example.nacha.repository.dao.UserMapper;

/**
 * ユーザリポジトリ
 */
@Repository
public class UserRepository {
    /* ユーザMapper */
    @Autowired
    UserMapper userMapper;

    /**
     * ユーザ情報の取得
     */
    public UserEntity getUser(Long userId){
        return userMapper.select(userId);
    }

    /**
     * グループに紐づくユーザ情報の取得
     */
    public List<UserEntity> getGroupUser(Long groupId){
        return userMapper.selectByGroupId(groupId);
    }

    /**
     * ユーザ情報の登録
     * 
     * @param userId ユーザID
     * @param userName ユーザ名
     */
    public int registUser(UserEntity user){
        return userMapper.regist(user);
    }

    /**
     * ユーザ情報の登録
     * 
     * @param userId ユーザID
     * @param userName ユーザ名
     */
    public int updateUser(UserEntity user){
        return userMapper.update(user);
    }

    /**
     * ユーザ情報の削除
     * 
     * @param userId　ユーザID
     */
    public int deleteUser(Long userId){
        return userMapper.delete(userId);
    }
}
