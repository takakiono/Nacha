package com.example.nacha.controller;

import javax.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.nacha.service.api.AccountService;
import com.example.nacha.service.bean.GetAccountApiResponseBean;
import com.example.nacha.service.bean.GetSumCategoriesApiResponseBean;
import com.example.nacha.service.bean.GetSumUserApiResponseBean;
import com.example.nacha.service.bean.GetSumApiResponseBean;
import com.example.nacha.service.bean.PostAccountApiRequestBean;
import com.example.nacha.service.bean.PostAccountApiResponseBean;

@RestController
@RequestMapping("/nacha") 
@CrossOrigin(origins = "*")
@Validated
public class AccountController {

    @Autowired
    AccountService accountService;

    @Transactional
    @PostMapping("/account")
    @ResponseBody
    public PostAccountApiResponseBean registAccount(@RequestBody @Validated PostAccountApiRequestBean request){
        return accountService.registAccount(request);
    }

    @GetMapping("/account")
    @ResponseBody
    public GetAccountApiResponseBean getAccount(@RequestParam @NotEmpty(message = "{javax.validation.constraints.NotEmpty.message}") String groupId, @RequestParam String acquisitionMonth){
        return accountService.getAccouts(groupId, acquisitionMonth);
    }

    @Transactional
    @DeleteMapping("/account")
    public void deleteAccount(@RequestParam @NotEmpty String accountId){
        accountService.deleteAccount(accountId);
    }

    @GetMapping("/account/sum/category")
    @ResponseBody
    public GetSumCategoriesApiResponseBean getSumCategories(@RequestParam @NotEmpty(message = "{javax.validation.constraints.NotEmpty.message}") String groupId, @RequestParam String acquisitionMonth){
        return accountService.getSumCategories(groupId, acquisitionMonth);
    }

    @GetMapping("/account/sum/user")
    @ResponseBody
    public GetSumUserApiResponseBean getSumUser(@RequestParam @NotEmpty(message = "{javax.validation.constraints.NotEmpty.message}") String groupId, @RequestParam String acquisitionMonth){
        return accountService.getSumUser(groupId, acquisitionMonth);
    }

    @GetMapping("/account/sum")
    @ResponseBody
    public GetSumApiResponseBean getSum(@RequestParam @NotEmpty(message = "{javax.validation.constraints.NotEmpty.message}") String groupId, @RequestParam String acquisitionYear){
        return accountService.getSum(groupId, acquisitionYear);
    }
}
