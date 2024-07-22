package com.example.nacha.service.bean;

import java.util.List;
import com.example.nacha.service.bean.common.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetCategoryApiResponseBean {
    /**
     * カテゴリ
     */
    List<Category> categories;
}
