package com.example.nacha.service.bean;

import java.util.List;
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

    private String groupId;
    private String categoryId;
    private String note;
    private String amount;
    private String datetime;

}
