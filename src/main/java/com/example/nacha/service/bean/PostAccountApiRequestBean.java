package com.example.nacha.service.bean;

import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @NotBlank
    private String groupId;

    /* カテゴリID */
    private String categoryId;
    
    /* メモ */
    private String note;

    /* 金額 */
    @NotBlank
    private String amount;
    
    /* 日付 */
    @NotBlank
    @JsonFormat(pattern="yyyy-MM-dd")
    private String datetime;

    /* 支払者 */
    private String userId;

}
