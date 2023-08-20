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
public class GetUsersApiRequestBean {
    /**
     * グループID
     */
    private String groupId;

    
}
