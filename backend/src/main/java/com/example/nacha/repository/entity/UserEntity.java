package com.example.nacha.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユーザエンティティ
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {
    /**
     * ユーザID
     */
    private Long userId;

    /**
     * ユーザ名
     */
    private String userName;
}
