package com.example.nacha.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.nacha.repository.entity.UserEntity;
import com.example.nacha.service.api.UserService;
import com.example.nacha.service.bean.GetUsersApiResponseBean;

@RestController
@RequestMapping("/nacha") 
@CrossOrigin(origins = "*")
@Validated
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
    public GetUsersApiResponseBean getUser(@RequestParam("groupId") String groupId){
        return userService.getUser(groupId);
    }
}
