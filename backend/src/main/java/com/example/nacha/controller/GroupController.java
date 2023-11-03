package com.example.nacha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.nacha.service.api.GroupService;
import com.example.nacha.service.bean.GetUsersApiResponseBean;

@RestController
@RequestMapping("/nacha") 
@CrossOrigin(origins = "*")
@Validated
public class GroupController {

    @Autowired
    GroupService groupService;

    @GetMapping("/group/user")
    @ResponseBody
    public GetUsersApiResponseBean getUser(@RequestParam("groupId") String groupId){
        return groupService.getUser(groupId);
    }
}
