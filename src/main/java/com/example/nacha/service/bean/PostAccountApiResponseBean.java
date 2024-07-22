package com.example.nacha.service.bean;

import com.example.nacha.service.bean.common.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 家計簿登録リクエストBean
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostAccountApiResponseBean {

    /* 家計簿情報 */
    private Account accout;

}