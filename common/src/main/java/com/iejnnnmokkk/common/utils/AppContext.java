package com.iejnnnmokkk.common.utils;

import android.content.Context;

/**
 * @author Sun
 * @Demo class AppContext
 * @Description TODO
 * @date 2024/12/10 15:44
 */
public class AppContext {

    private static Context context;

    public static void init(Context appContext) {
        context = appContext.getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
