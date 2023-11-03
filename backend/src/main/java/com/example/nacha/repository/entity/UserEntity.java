package com.example.nacha.repository.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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
public class UserEntity{
    /**
     * ユーザID
     */
    private Long userId;

    /**
     * ユーザ名
     */
    private String userName;

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
