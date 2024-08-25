package com.example.nacha.repository.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 家計簿合計エンティティ
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountSumEntity{

    /**
     * グループID
     */
    private Long groupId;

    /**
     * カテゴリID
     */
    private Long categoryId;

    /**
     * 金額
     */
    private Long amount;

    /**
     * 日時
     */
    private String yearMonth;

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
