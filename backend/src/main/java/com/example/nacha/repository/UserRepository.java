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
     * ユーザマスタテーブルへの登録
     * 
     * @param userId ユーザID
     * @param userName ユーザ名
     */
    public List<UserEntity> registUser(List<UserEntity> users){
        System.out.println("start Repository");
        userMapper.regist(users);
        System.out.println("end Repository");
        return users;
    }
}
