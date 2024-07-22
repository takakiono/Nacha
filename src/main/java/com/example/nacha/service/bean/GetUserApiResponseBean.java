package com.example.nacha.service.bean;

import com.example.nacha.service.bean.common.User;
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
public class GetUserApiResponseBean {

    /* ユーザ情報 */
    private User user;

    /* 更新日時 */
    private String updatetime;
}
