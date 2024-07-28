package com.example.nacha.service.bean;

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
public class SumUser {
    /**
    * ユーザID
    */
   String userId;

   /**
    * 合計値
    */
   Long sum;
}
