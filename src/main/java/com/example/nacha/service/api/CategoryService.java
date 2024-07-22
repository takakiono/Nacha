package com.example.nacha.service.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nacha.repository.dao.CategoryMapper;
import com.example.nacha.service.bean.GetCategoryApiResponseBean;
import com.example.nacha.repository.entity.CategoryEntity;
import com.example.nacha.service.bean.common.Category;

@Service
public class CategoryService {
    @Autowired
    CategoryMapper categoryMaper;
    public GetCategoryApiResponseBean getCategory(){
        List<CategoryEntity> categoryEntities = categoryMaper.select();

        List<Category> categories = categoryEntities.stream()
            .map(entity -> Category.builder()
                .categoryId(String.valueOf(entity.getCategoryId()))
                .categoryName(entity.getCategoryName())
                .build())
            .toList();

        return GetCategoryApiResponseBean.builder()
            .categories(categories)
            .build();
    }
}
