package com.example.nacha.service.bean;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * カテゴリ合計額
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetSumCategoriesApiResponseBean {
    /**
     * カテゴリ別合計額
     */
    List<SumCategory> sumCategories;
    
    /**
     * 取得月
     */
    String acquisitionMonth;
}

