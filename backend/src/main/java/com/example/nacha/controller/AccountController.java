package com.example.nacha.controller;

import javax.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.nacha.service.api.AccountService;
import com.example.nacha.service.bean.GetAccountApiResponseBean;
import com.example.nacha.service.bean.PostAccountApiRequestBean;
import com.example.nacha.service.bean.PostAccountApiResponseBean;

@RestController
@RequestMapping("/nacha") 
@CrossOrigin(origins = "*")
@Validated
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/account")
    @ResponseBody
    public PostAccountApiResponseBean registAccount(@RequestBody @Validated PostAccountApiRequestBean request){
        return accountService.registAccount(request);
    }

    @GetMapping("/account")
    @ResponseBody
    public GetAccountApiResponseBean getAccout(@RequestParam @NotEmpty(message = "{javax.validation.constraints.NotEmpty.message}") String groupId, @RequestParam String acquisitionMonth){
        return accountService.getAccouts(groupId, acquisitionMonth);
    }
}
