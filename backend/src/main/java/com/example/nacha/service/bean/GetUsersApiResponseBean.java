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
public class GetUsersApiResponseBean {
    /**
     * ユーザID
     */
    private String userId;

    /**
     * ユーザ名
     */
    private String userName;
}
