package com.example.nacha.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.nacha.repository.entity.UserEntity;
import com.example.nacha.service.api.UserService;
import com.example.nacha.service.bean.GetUsersApiRequestBean;
import com.example.nacha.service.bean.GetUsersApiResponseBean;

@Controller
@RequestMapping("/nacha") 
@CrossOrigin(origins = "*")
public class UserController {
    
    @Autowired
    UserService userService;
    
    @PostMapping("/user")
    @ResponseBody
    public String registUser() {
        List<UserEntity> users = new ArrayList<>();
        UserEntity user = new UserEntity();
        user.setUserId(3L);
        user.setUserName("ccc");
        users.add(user);
        
        userService.regist(users);
        return "OK";
    }

    @GetMapping("/user")
    @ResponseBody
    public List<GetUsersApiResponseBean> getUser(){
        return userService.getUser();
    }
}
