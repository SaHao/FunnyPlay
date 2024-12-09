package com.iejnnnmokkk.common.utils;

import android.util.Log;

/**
 * @author Sun
 * @Demo class LogUtils
 * @Description TODO
 * @date 2024/12/5 11:21
 */
public class LogUtils {

    private static boolean isDebug = true;
    private static final String DEFAULT_TAG = "APP_LOG_PRINT";

    /**
     * 初始化日志工具类
     *
     * @param debug 是否开启调试模式
     */
    public static void init(boolean debug) {
        isDebug = debug;
    }

    /**
     * 打印 Info 日志
     */
    public static void i(String tag, String message) {
        if (isDebug) Log.i(tag, message);
    }

    public static void i(String message) {
        i(DEFAULT_TAG, message);
    }

    /**
     * 打印 Debug 日志
     */
    public static void d(String tag, String message) {
        if (isDebug) Log.d(tag, message);
    }

    public static void d(String message) {
        d(DEFAULT_TAG, message);
    }

    /**
     * 打印 Warning 日志
     */
    public static void w(String tag, String message) {
        if (isDebug) Log.w(tag, message);
    }

    public static void w(String message) {
        w(DEFAULT_TAG, message);
    }

    /**
     * 打印 Error 日志
     */
    public static void e(String tag, String message) {
        if (isDebug) Log.e(tag, message);
    }

    public static void e(String message, Throwable e) {
        if (isDebug) {
            Log.e(DEFAULT_TAG, message);
            if (e != null) {
                Log.e(DEFAULT_TAG, Log.getStackTraceString(e));
            }
        }
    }

    public static void e(String message) {
        e(DEFAULT_TAG, message);
    }

    /**
     * 打印 Verbose 日志
     */
    public static void v(String tag, String message) {
        if (isDebug) Log.v(tag, message);
    }

    public static void v(String message) {
        v(DEFAULT_TAG, message);
    }

}
