package com.example.nacha.service.bean;

import java.util.Date;
import java.util.List;
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

    private List<Account> accout;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Account{
        /**
         * グループID
         */
        private String groupId;

        /**
         * カテゴリID
         */
        private String categoryId;

        /**
         * 備考
         */
        private String note;

        /**
         * 金額
         */
        private String amount;

        /**
         * 日時
         */
        private String datetime;
    }
}
