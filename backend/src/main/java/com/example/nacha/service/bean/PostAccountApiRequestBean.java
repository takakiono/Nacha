package com.example.nacha.service.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユーザリクエストBean
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostAccountApiRequestBean {

    /* グループID */
    private String groupId;

    /* カテゴリID */
    private String categoryId;
    /* メモ */
    private String note;

    /* 金額 */
    private String amount;
    
    /* 日付 */
    private String datetime;

}
