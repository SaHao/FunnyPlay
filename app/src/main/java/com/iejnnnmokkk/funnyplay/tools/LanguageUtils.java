package com.iejnnnmokkk.funnyplay.tools;

import java.util.Locale;

/**
 * @author Sun
 * @Demo class LanguageUtils
 * @Description TODO
 * @date 2024/12/13 17:32
 */
public class LanguageUtils {

    /**
     * 获取当前语言简称
     *
     * @return en：英语", "th：泰语", "id：印尼语", "pt：葡萄牙语
     */
    public static String getCurrentLanguage() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage();
    }

}
