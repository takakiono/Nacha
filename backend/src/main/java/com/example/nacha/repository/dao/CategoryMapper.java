package com.example.nacha.repository.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.nacha.repository.entity.CategoryEntity;

/**
 * カテゴリマッパー
 */
@Mapper
public interface CategoryMapper {
    
    /**
     * 家計簿情報の登録
     */
    List<CategoryEntity> select();
}
