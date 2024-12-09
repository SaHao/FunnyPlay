package com.iejnnnmokkk.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Sun
 * @Demo class DateUtils
 * @Description TODO
 * @date 2024/12/6 13:47
 */
public class DateUtils {

    // 定义日期格式
    private static final String YEAR_FORMAT = "yyyy";                      // 年
    private static final String YEAR_MONTH_FORMAT = "yyyy-MM";             // 年月
    private static final String YEAR_MONTH_DAY_FORMAT = "yyyy-MM-dd";      // 年月日
    private static final String YEAR_MONTH_DAY_HOUR_MINUTE_FORMAT = "yyyy-MM-dd HH:mm"; // 年月日时分
    private static final String YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_FORMAT = "yyyy-MM-dd HH:mm:ss"; // 年月日时分秒
    private static final String HOUR_MINUTE_FORMAT = "HH:mm";              // 时分
    private static final String HOUR_MINUTE_SECOND_FORMAT = "HH:mm:ss";    // 时分秒

    /**
     * 获取当前时间的年（yyyy）
     *
     * @return 当前年份字符串
     */
    public static String getCurrentYear() {
        return formatDate(new Date(), YEAR_FORMAT);
    }

    /**
     * 获取当前时间的年月（yyyy-MM）
     *
     * @return 当前年月字符串
     */
    public static String getCurrentYearMonth() {
        return formatDate(new Date(), YEAR_MONTH_FORMAT);
    }

    /**
     * 获取当前时间的年月日（yyyy-MM-dd）
     *
     * @return 当前年月日字符串
     */
    public static String getCurrentYearMonthDay() {
        return formatDate(new Date(), YEAR_MONTH_DAY_FORMAT);
    }

    /**
     * 获取当前时间的年月日时分（yyyy-MM-dd HH:mm）
     *
     * @return 当前年月日时分字符串
     */
    public static String getCurrentYearMonthDayHourMinute() {
        return formatDate(new Date(), YEAR_MONTH_DAY_HOUR_MINUTE_FORMAT);
    }

    /**
     * 获取当前时间的年月日时分秒（yyyy-MM-dd HH:mm:ss）
     *
     * @return 当前年月日时分秒字符串
     */
    public static String getCurrentYearMonthDayHourMinuteSecond() {
        return formatDate(new Date(), YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_FORMAT);
    }

    /**
     * 获取当前时间的时分（HH:mm）
     *
     * @return 当前时分字符串
     */
    public static String getCurrentHourMinute() {
        return formatDate(new Date(), HOUR_MINUTE_FORMAT);
    }

    /**
     * 获取当前时间的时分秒（HH:mm:ss）
     *
     * @return 当前时分秒字符串
     */
    public static String getCurrentHourMinuteSecond() {
        return formatDate(new Date(), HOUR_MINUTE_SECOND_FORMAT);
    }

    /**
     * 格式化日期
     *
     * @param date   日期对象
     * @param format 格式化的格式
     * @return 格式化后的日期字符串
     */
    private static String formatDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 将时间戳转为指定格式的日期字符串
     *
     * @param timestamp 时间戳
     * @param format    需要的日期格式
     * @return 格式化后的日期字符串
     */
    public static String timestampToDate(long timestamp, String format) {
        return formatDate(new Date(timestamp), format);
    }

    /**
     * 将日期字符串转为时间戳
     *
     * @param dateStr 日期字符串
     * @param format  日期格式
     * @return 对应的时间戳
     * @throws ParseException 如果日期格式不匹配，抛出异常
     */
    public static long dateToTimestamp(String dateStr, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = sdf.parse(dateStr);
        return date.getTime();
    }

    /**
     * 截取年月日（yyyy-MM-dd）
     *
     * @param dateStr 完整的日期字符串（如：yyyy-MM-dd HH:mm:ss）
     * @return 截取后的年月日部分
     * @throws ParseException 如果日期格式不匹配，抛出异常
     */
    public static String getYearMonthDay(String dateStr) throws ParseException {
        return dateStr.substring(0, 10); // yyyy-MM-dd
    }

    /**
     * 截取年月日时分（yyyy-MM-dd HH:mm）
     *
     * @param dateStr 完整的日期字符串（如：yyyy-MM-dd HH:mm:ss）
     * @return 截取后的年月日时分部分
     * @throws ParseException 如果日期格式不匹配，抛出异常
     */
    public static String getYearMonthDayHourMinute(String dateStr) throws ParseException {
        return dateStr.substring(0, 16); // yyyy-MM-dd HH:mm
    }

    /**
     * 获取当前时间的时间戳
     *
     * @return 当前时间的时间戳
     */
    public static long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }
}

