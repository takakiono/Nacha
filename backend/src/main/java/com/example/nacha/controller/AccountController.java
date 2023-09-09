package com.example.nacha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.nacha.service.api.AccountService;
import com.example.nacha.service.bean.PostAccountApiRequestBean;
import com.example.nacha.service.bean.PostAccountApiResponseBean;

@Controller
@RequestMapping("/nacha") 
@CrossOrigin(origins = "*")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/account")
    @ResponseBody
    public PostAccountApiResponseBean registAccount(@RequestBody PostAccountApiRequestBean request){
        return accountService.registAccount(request);
    }
}
