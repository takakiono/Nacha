package com.example.nacha.service.bean.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {
     /**
     * カテゴリID
     */
    private String categoryId;

     /**
     * カテゴリ名
     */
    private String categoryName;
}
