package com.example.nacha.service.bean.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    /**
     * 家計簿ID
     */
    private String accountId;

    /**
     * グループID
     */
    private String groupId;

    /**
     * カテゴリID
     */
    private String categoryId;

    /**
     * 備考
     */
    private String note;

    /**
     * 金額
     */
    private String amount;

    /**
     * 日時
     */
    private String datetime;
}
