package com.example.nacha.service.bean;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユーザ追加
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetUserApiRequestBean {

    /* ユーザID */
    @NotBlank
    private String userId;
}
