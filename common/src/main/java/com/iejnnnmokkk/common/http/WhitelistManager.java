package com.iejnnnmokkk.common.http;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sun
 * @Demo class WhitelistManager
 * @Description TODO
 * @date 2024/12/5 16:21
 */
public class WhitelistManager {

    private static final Set<String> whiteList = new HashSet<>();

    // 静态初始化，添加不需要 token 的接口
    static {
        whiteList.add("/public/login");
        whiteList.add("/public/signup");
    }

    /**
     * 判断当前请求的 URL 是否在白名单中
     *
     * @param url
     * @return
     */
    public static boolean isInWhitelist(String url) {
        return whiteList.contains(url);
    }

    /**
     * 添加一个新的白名单接口
     *
     * @param url
     */
    public static void addToWhitelist(String url) {
        whiteList.add(url);
    }

    /**
     * 从白名单中移除某个接口
     *
     * @param url
     */
    public static void removeFromWhitelist(String url) {
        whiteList.remove(url);
    }

}
