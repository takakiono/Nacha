package com.example.nacha.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.nacha.repository.dao.CategoryMapper;
import com.example.nacha.repository.entity.CategoryEntity;

/**
 * 家計簿リポジトリ
 */
@Repository
public class CategoryRepository {

    @Autowired
    CategoryMapper mapper;

    /**
     * カテゴリマスタ情報の取得
     * @return カテゴリマスタ情報
     */
    public List<CategoryEntity> selectCategory(){
        return mapper.select();
    }
}
