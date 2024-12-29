package com.iejnnnmokkk.funnyplay.tools;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/**
 * @author Sun
 * @Demo class LanguageUtils
 * @Description TODO
 * @date 2024/12/13 17:32
 */
public class LanguageUtils {
    public static final String GAME_PLAY_TIME_KEY="588d7c648196df853ba365b13abfd65d";

    /**
     * 获取当前语言简称
     *
     * @return en：英语", "th：泰语", "id：印尼语", "pt：葡萄牙语
     */
    public static String getCurrentLanguage() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage();
    }
    public static String getMD5(String input) {
        try {
            // 获取MD5摘要器实例
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 将字符串转换为字节数组
            byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));

            // 转换为16进制字符串
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            // 如果生成的16进制字符串长度不足32位，则在前面补0
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            // 如果JVM不支持MD5算法，抛出异常
            throw new RuntimeException(e);
        }
    }

}
