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
public class RegistUsersApiResponseBean {

    /* ユーザ情報リスト */
    private List<User> users;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class User{
        /**
         * ユーザID
         */
        private String userId;
        
        /**
         * ユーザ名
         */
        private String userName;
    }
}
