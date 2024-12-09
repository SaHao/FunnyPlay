package com.iejnnnmokkk.common.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @author Sun
 * @Demo class ToastUtil
 * @Description TODO
 * @date 2024/12/5 11:20
 */
public class ToastUtils {

    private static Toast toast;

    /**
     * 显示短时间的 Toast
     *
     * @param context 上下文
     * @param message 消息
     */
    public static void showShort(Context context, String message) {
        showToast(context, message, Toast.LENGTH_SHORT);
    }

    /**
     * 显示长时间的 Toast
     *
     * @param context 上下文
     * @param message 消息
     */
    public static void showLong(Context context, String message) {
        showToast(context, message, Toast.LENGTH_LONG);
    }

    /**
     * 显示 Toast
     *
     * @param context  上下文
     * @param message  消息
     * @param duration 显示时长
     */
    private static void showToast(Context context, String message, int duration) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(context.getApplicationContext(), message, duration);
        toast.show();
    }

    /**
     * 显示资源文件中的字符串
     *
     * @param context 上下文
     * @param resId   字符串资源 ID
     */
    public static void showShort(Context context, int resId) {
        showToast(context, context.getString(resId), Toast.LENGTH_SHORT);
    }

    public static void showLong(Context context, int resId) {
        showToast(context, context.getString(resId), Toast.LENGTH_LONG);
    }
}

