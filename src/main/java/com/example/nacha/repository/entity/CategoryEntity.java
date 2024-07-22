package com.example.nacha.repository.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * カテゴリエンティティ
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryEntity {
    
    /**
     * カテゴリID
     */
    private Long categoryId;


    /**
     * カテゴリ名
     */
    private String categoryName;

    /**
     * 登録日時
     */
    private LocalDateTime registrationDatetime;

    /**
     * 更新日時
     */
    private LocalDateTime updateDatetime;

    /**
     * 論理削除フラグ
     */
    private boolean logicalDeleteFlag;
}
