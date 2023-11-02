package com.example.nacha.repository.entity;

import java.time.LocalDate;
import java.util.Date;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 家計簿エンティティ
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountEntity extends BaseEntity{

    /**
     * 家計簿ID
     */
    private Long accountId;

    /**
     * グループID
     */
    private Long groupId;

    /**
     * カテゴリID
     */
    private Long categoryId;

    /**
     * 備考
     */
    private String note;

    /**
     * 金額
     */
    private Long amount;

    /**
     * 日時
     */
    private LocalDate accountDatetime;

}
