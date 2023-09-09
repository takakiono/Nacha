package com.example.nacha.service.api;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nacha.repository.UserRepository;
import com.example.nacha.repository.entity.UserEntity;
import com.example.nacha.service.bean.GetUsersApiResponseBean;
import com.example.nacha.service.bean.GetUsersApiResponseBean.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * ユーザ情報の取得
     * @param id グループID
     * @return　ユーザ情報
     */
    public GetUsersApiResponseBean getUser(String id){
        Long groupId = Long.valueOf(id);
        List<User> users = userRepository.getUser(groupId).stream()
            .map(list -> User.builder()
                .userId(list.getUserId().toString())
                .userName(list.getUserName())    
                .build())
            .collect(Collectors.toList());

        GetUsersApiResponseBean response = new GetUsersApiResponseBean();
        response.setUsers(users);

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