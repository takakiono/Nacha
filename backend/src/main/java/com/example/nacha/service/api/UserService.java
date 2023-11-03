package com.example.nacha.service.api;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nacha.repository.UserRepository;
import com.example.nacha.repository.entity.UserEntity;
import com.example.nacha.service.bean.RegistUserApiRequestBean;
import com.example.nacha.service.bean.RegistUserApiResponseBean;
import com.example.nacha.service.bean.UpdateUserApiRequestBean;
import com.example.nacha.service.bean.UpdateUserApiResponseBean;
import com.example.nacha.service.bean.common.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * ユーザ情報の登録
     * @param users
     * @return
     */
    public RegistUserApiResponseBean regist(RegistUserApiRequestBean request){
        UserEntity user = UserEntity.builder()
            .userName(request.getUserName())
            .build();
        userRepository.registUser(user);

        UserEntity entity = userRepository.getUser(user.getUserId());
        return RegistUserApiResponseBean.builder()
            .user(User.builder()
                .userId(String.valueOf(entity.getUserId()))
                .userName(entity.getUserName())
                .build())
            .build();
    }

    /**
     * ユーザ情報の更新
     * @param users
     * @return
     */
    public UpdateUserApiResponseBean update(String userId, UpdateUserApiRequestBean request){
        UserEntity user = UserEntity.builder()
            .userId(Long.valueOf(userId))
            .userName(request.getUserName())
            .updateDatetime(LocalDateTime.now())
            .build();
        userRepository.updateUser(user);

        UserEntity entity = userRepository.getUser(user.getUserId());
        return UpdateUserApiResponseBean.builder()
            .user(User.builder()
                .userId(String.valueOf(entity.getUserId()))
                .userName(entity.getUserName())
                .build())
            .build();
    }
}