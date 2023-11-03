package com.example.nacha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.nacha.service.api.UserService;
import com.example.nacha.service.bean.RegistUserApiRequestBean;
import com.example.nacha.service.bean.RegistUserApiResponseBean;
import com.example.nacha.service.bean.UpdateUserApiRequestBean;
import com.example.nacha.service.bean.UpdateUserApiResponseBean;

@RestController
@RequestMapping("/nacha") 
@CrossOrigin(origins = "*")
@Validated
public class UserController {
    
    @Autowired
    UserService userService;
    
    @PostMapping("/user/regist")
    @ResponseBody
    public RegistUserApiResponseBean registUser(@RequestBody @Validated RegistUserApiRequestBean request) {
        return userService.regist(request); 
    }

    @PutMapping("/user/update")
    @ResponseBody
    public UpdateUserApiResponseBean updateUser(@RequestParam String userId, @RequestBody UpdateUserApiRequestBean request){
        return userService.update(userId, request);
    }
}
