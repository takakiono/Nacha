package com.example.nacha.service.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nacha.repository.UserRepository;
import com.example.nacha.repository.entity.UserEntity;
import com.example.nacha.service.bean.GetUsersApiRequestBean;
import com.example.nacha.service.bean.GetUsersApiResponseBean;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * ユーザ情報の取得
     * @return　ユーザ情報
     */
    public List<GetUsersApiResponseBean> getUser(){
        List<GetUsersApiResponseBean> response = userRepository.getUser().stream()
            .map(list -> GetUsersApiResponseBean.builder()
                .userId(list.getUserId().toString())
                .userName(list.getUserName())    
                .build())
            .collect(Collectors.toList());

        return response;
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