package com.example.nacha.service.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nacha.repository.UserRepository;
import com.example.nacha.service.bean.GetUsersApiResponseBean;
import com.example.nacha.service.bean.GetUsersApiResponseBean.User;

@Service
public class GroupService {
    
    @Autowired
    private UserRepository userRepository;

    /**
     * グループに紐づくユーザ情報の取得
     * @param id グループID
     * @return　ユーザ情報
     */
    public GetUsersApiResponseBean getUser(String id){
        Long groupId = Long.valueOf(id);
        List<User> users = userRepository.getGroupUser(groupId).stream()
            .map(list -> User.builder()
                .userId(list.getUserId().toString())
                .userName(list.getUserName())    
                .build())
            .toList();

        GetUsersApiResponseBean response = new GetUsersApiResponseBean();
        response.setUsers(users);

        return response;
    }
}
