package com.example.nacha.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nacha.repository.UserRepository;
import com.example.nacha.repository.entity.UserEntity;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * ユーザ情報の取得
     * @return　ユーザ情報
     */
    public List<UserEntity> getUser(){
        return userRepository.getUser();
    }

    /**
     * ユーザ情報の登録
     * @param users
     * @return
     */
    public List<UserEntity> regist(List<UserEntity> users){
        userRepository.registUser(users);
        return null;
    }
}