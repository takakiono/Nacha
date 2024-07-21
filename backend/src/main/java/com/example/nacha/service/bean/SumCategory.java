package com.example.nacha.service.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* カテゴリ別合計額
*/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SumCategory {
   /**
    * カテゴリID
    */
   Long categoryId;

   /**
    * 合計値
    */
   Long sum;

}
