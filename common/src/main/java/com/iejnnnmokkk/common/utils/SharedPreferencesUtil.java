package com.iejnnnmokkk.common.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author Sun
 * @Demo class SharedPreferencesUtil
 * @Description TODO
 * @date 2024/12/10 13:34
 */
public class SharedPreferencesUtil {

    private static final String PREFERENCES_NAME = "funnyPlayPreference";
    private static SharedPreferencesUtil instance;
    private final SharedPreferences sharedPreferences;

    private SharedPreferencesUtil(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized SharedPreferencesUtil getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferencesUtil(context.getApplicationContext());
        }
        return instance;
    }

    /**
     * 存储
     *
     * @param username 用户名
     */
    public void saveValue(String key, String username) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, username);
        editor.apply();
    }

    /**
     * 获取
     *
     * @param defaultUsername 默认值
     * @return 用户名
     */
    public String getValue(String key) {
        return sharedPreferences.getString(key, "");
    }

    public int getInt(String key) {
        return sharedPreferences.getInt(key, 0);
    }
    public void saveInt(String key, int num) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, num);
        editor.apply();
    }
    /**
     * 清除数据
     */
    public void clearAll() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    /**
     * 检查 key 是否存在
     *
     * @return 是否存在
     */
    public boolean containsKey(String key) {
        return sharedPreferences.contains(key);
    }
}
