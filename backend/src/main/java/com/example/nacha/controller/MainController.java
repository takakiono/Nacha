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
import com.example.nacha.BirthStone;
import com.example.nacha.repository.entity.UserEntity;
import com.example.nacha.service.api.UserService;

@Controller
@RequestMapping("/nacha") 
@CrossOrigin(origins = "*")
public class MainController {

    @GetMapping("/api")
    @ResponseBody
    public BirthStone getBirthStone() {
        BirthStone birthStone = new BirthStone();
        birthStone.setMonth("2月");
        birthStone.setName("アメジストぉおおおおおおおおおおおおおおおお");
        birthStone.setColor("紫");
        return birthStone;
    }
}
