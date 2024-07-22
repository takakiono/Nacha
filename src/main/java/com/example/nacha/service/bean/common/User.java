package com.example.nacha.service.bean.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User{
    /**
     * ユーザID
     */
    private String userId;
    
    /**
     * ユーザ名
     */
    private String userName;
}
