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

    public List<UserEntity> regist(List<UserEntity> users){
        System.out.println("start service");
        userRepository.registUser(users);
        System.out.println("end service");
        return null;
    }
}
