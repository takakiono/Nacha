package com.example.nacha.service.bean;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユーザ別合計額
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetSumApiResponseBean {
    /**
     * 月別合計額
     */
    List<GetSumCategoriesApiResponseBean> sumMonth;

    /**
     * 取得年合計額
     */
    Long sum;
    
    /**
     * 取得年
     */
    String acquisitionYear;
}
