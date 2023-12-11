package com.example.nacha.common.utils;

import java.time.LocalDateTime;
import com.example.nacha.common.constants.ErrorMessage;
import com.example.nacha.common.exception.NachaBusinessException;

public class ExclusiveUtils {

    /**
     * プライベートコンストラク
     * 
     */
    private ExclusiveUtils(){};

    /**
     * 楽観排他チェック
     *
     * @param request リクエストの更新日時
     * @param upDatetime　DBの更新日時
     * @return
     */
    public static void checkExclusive(String request, LocalDateTime updateDatetime) throws NachaBusinessException{
        if(DatetimeUtils.format(request).equals(DatetimeUtils.format(updateDatetime))){
            return;
        }
        throw new NachaBusinessException(ErrorMessage.NachaExclusionError);
    }
}
