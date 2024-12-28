package com.iejnnnmokkk.common.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.OnAttributionChangedListener;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.iejnnnmokkk.common.utils.AppContext;
import com.iejnnnmokkk.common.utils.ParamUtil;
import com.iejnnnmokkk.common.utils.SharedPreferencesUtil;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.converter.SerializableDiskConverter;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.model.HttpHeaders;
import com.zhouyou.http.model.HttpParams;

import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.iaa.topon.library.TopOnManager;

/**
 * @author Sun
 * @Demo class BaseApplication
 * @Description TODO
 * @date 2024/12/5 14:35
 */
public class BaseApplication extends Application {

    /*1 正式     0 测试*/
    public static final int isDev = 1;

    @Override
    public void onCreate() {
        super.onCreate();
        AppContext.init(getApplicationContext());
        //默认初始化,必须调用
        EasyHttp.init(this);
        initAD();
    }
    private void initAD() {
        TopOnManager.getInstance(this)
                .setEnabledLog(true)
                .setEnvironment(true)
                .initAdjust("1f4ixw19lt0g")
                .initTopOn("h675ba24fea676","a5f0fff6f479ba52f2eaf3970fdb4be26");
    }

    private static final class AdjustLifecycleCallbacks implements ActivityLifecycleCallbacks {
        @Override
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(@NonNull Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {
            Adjust.onResume();
        }

        @Override
        public void onActivityPaused(Activity activity) {
            Adjust.onPause();
        }

        @Override
        public void onActivityStopped(@NonNull Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(@NonNull Activity activity) {

        }

    }
}
