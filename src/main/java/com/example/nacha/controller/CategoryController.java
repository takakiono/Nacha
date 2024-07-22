package com.example.nacha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.nacha.service.api.CategoryService;
import com.example.nacha.service.bean.GetCategoryApiResponseBean;

@RestController
@RequestMapping("/nacha") 
@CrossOrigin(origins = "*")
@Validated
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    @ResponseBody
    public GetCategoryApiResponseBean getCategory(){
        return categoryService.getCategory();
    }
}
