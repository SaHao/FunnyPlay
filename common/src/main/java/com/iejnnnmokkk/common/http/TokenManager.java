package com.iejnnnmokkk.common.http;

/**
 * @author Sun
 * @Demo class TokenManager
 * @Description TODO
 * @date 2024/12/5 16:25
 */
public class TokenManager {

    private static String token;

    /**
     * 设置 Token
     *
     * @param tokenValue
     */
    public static void setToken(String tokenValue) {
        token = tokenValue;
    }

    /**
     * 获取 Token
     *
     * @return
     */
    public static String getToken() {
        return token;
    }

    /**
     * 清除 Token
     */
    public static void clearToken() {
        token = null;
    }
}
