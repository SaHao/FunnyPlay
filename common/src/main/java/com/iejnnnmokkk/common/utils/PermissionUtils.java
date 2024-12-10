package com.iejnnnmokkk.common.utils;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.provider.Settings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Sun
 * @Demo class PermissionManager
 * @Description TODO
 * @date 2024/12/10 11:11
 */
public class PermissionUtils {

    /**
     * 请求权限
     *
     * @param activity   当前的 Activity
     * @param permission 权限
     * @param callback   权限请求的回调
     */
    @SuppressLint("CheckResult")
    public static void requestPermissions(AppCompatActivity activity, String[] permissions, PermissionCallback callback) {
        RxPermissions rxPermissions = new RxPermissions(activity);

        // 请求多个权限
        rxPermissions.requestEach(permissions)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(permission -> {
                    if (permission.granted) {
                        // 权限被授予
                        callback.onPermissionGranted(permission.name);
                    } else if (permission.shouldShowRequestPermissionRationale) {
                        // 权限被拒绝，且用户没有选择不再提醒
                        callback.onPermissionDenied(permission.name);
                    } else {
                        // 权限被拒绝，且用户选择了不再提醒
                        callback.onPermissionDeniedForever(permission.name);
                        // 引导用户跳转到设置页面
                        showPermissionSettings(activity);
                    }
                });
    }

    /**
     * 判断是否应该显示权限请求的说明
     *
     * @param activity   当前的 Activity
     * @param permission 权限
     * @return 是否应该显示权限说明
     */
    private static boolean shouldShowRequestPermissionRationale(@NonNull AppCompatActivity activity, String permission) {
        return activity.shouldShowRequestPermissionRationale(permission);
    }

    /**
     * 跳转到应用设置页面
     *
     * @param activity 当前的 Activity
     */
    private static void showPermissionSettings(AppCompatActivity activity) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(android.net.Uri.parse("package:" + activity.getPackageName()));
        activity.startActivity(intent);
    }

    /**
     * 判断权限是否已经授予
     *
     * @param activity   当前的 Activity
     * @param permission 权限
     * @return 是否已经授予该权限
     */
    public static boolean isPermissionGranted(AppCompatActivity activity, String permission) {
        RxPermissions rxPermissions = new RxPermissions(activity);
        return rxPermissions.isGranted(permission);
    }

    /**
     * 权限回调接口
     */
    public interface PermissionCallback {
        /**
         * 权限已被授予
         */
        void onPermissionGranted(String permission);

        /**
         * 权限被拒绝（用户没有选择不再提醒）
         */
        void onPermissionDenied(String permission);

        /**
         * 权限被拒绝且选择了不再提醒
         */
        void onPermissionDeniedForever(String permission);
    }
}
