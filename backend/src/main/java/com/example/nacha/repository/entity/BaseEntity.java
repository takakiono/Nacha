package com.example.nacha.repository.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * ベースエンティティ
 * DBに必ず登録される登録日時・更新日時・論理削除フラグを持つ。
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class BaseEntity {
    
    /**
     * 登録日時
     */
    private Date registrationDatetime;

    /**
     * 更新日時
     */
    private Date updateDatetime;

    /**
     * 論理削除フラグ
     */
    private boolean logicalDeleteFlag;
}
