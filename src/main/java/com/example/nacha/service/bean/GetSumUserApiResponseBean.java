package com.example.nacha.service.bean;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユーザ別合計額
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetSumUserApiResponseBean {
    /**
     * ユーザ別合計額
     */
    List<SumUser> sumUser;
    
    /**
     * 取得月
     */
    String acquisitionMonth;
}
