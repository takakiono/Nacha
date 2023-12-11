package com.example.nacha.common.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Optional;

/**
 * 日時共通クラス
 */
public class DatetimeUtils {

    /** APIの日時形式 */
    public static final String API_DATETIME = "uuuu-MM-dd'T'HH:mm:ss'Z'";

    /**
     * プライベートコンストラク
     * 
     */
    private DatetimeUtils(){};

    /**
     * 日付文字列 → Timestamp
     *
     * @param value 日付文字列
     * @return 変換後の文字列
     */
    public static Timestamp parse(String value){
        return parse(value, API_DATETIME);
    }

    /**
     * 日付文字列 → Timestamp(フォーマット指定)
     *
     * @param value 日付文字列
     * @param format 日付文字列のフォーマット
     * @return 日付文字列
     */
    public static Timestamp parse(String value, String format){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        return Optional.ofNullable(value)
                .map(d -> Timestamp.valueOf(
                        LocalDateTime.parse(value, dtf.withResolverStyle(ResolverStyle.STRICT))))
                .orElse(null);
    }

    /**
     * 日付変換
     *
     * @param value Timestamp
     * @return 変換後の文字列
     */
    public static String format(String value){
        return format(parse(value));
    }

    /**
     * 日付変換
     *
     * @param value Timestamp
     * @return 変換後の文字列
     */
    public static String format(Timestamp value){
        return format(value, API_DATETIME);
    }
    
    /**
     * 日付変換(フォーマット指定)
     * @param value Timestamp
     * @param format 変換後のフォーマット
     * @return　変換後の文字列
     */
    public static String format(Timestamp value, String format){
        return Optional.ofNullable(value).map(v -> format(v.toLocalDateTime(), format))
        .orElse(null);
    }

    /**
     * LocalDateTime → 日付変換
     *
     * @param localDateTime 日付
     * @return 日付文字列
     */
    public static String format(LocalDateTime localDateTime){
        return format(localDateTime, API_DATETIME);
    }

    /**
     * LocalDateTime → 日付変換(フォーマット指定)
     *
     * @param localDateTime 日付
     * @param format 変換後のフォーマット
     * @return 日付文字列
     */
    public static String format(LocalDateTime localDateTime, String format){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        return Optional.ofNullable(localDateTime).map(d -> d.format(dtf)).orElse(null);
    }

    /**
     * 現在日時に指定分を加算した時刻取得
     *
     * @param hour 指定時間
     * @return 有効時間
     */
    public static Timestamp addHourCurrentTime(Integer hour){
        return Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")).plusHours(hour));
    }

    /**
     * 現在日時に指定分を加算した時刻取得
     * 
     * @param minute 指定時間
     * @return 有効時間
     */
    public static Timestamp addMinuteCurrentTime(Long minute) {
        return Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")).plusMinutes(minute));
    }

    /**
     * 現在日時に指定分を加算した時刻取得
     *
     * @param days 指定時間
     * @return 有効時間
     */
    public static Timestamp addDaysCurrentTime(Integer days) {
        return Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")).plusDays(days));
    }

    /**
     * 現在日時が指定時間を超えているか
     *
     * @param time　指定時間
     * @return　期限結果
     */
    public static boolean onTime(Timestamp time){
        return time.after(Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC"))));
    }
}
