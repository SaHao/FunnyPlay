package com.iejnnnmokkk.common.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.provider.Settings;
import android.util.Log;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.makeramen.roundedimageview.BuildConfig;

import java.io.IOException;

public class ParamUtil {
    public static final String GAME_PLAY_TIME_KEY="588d7c648196df853ba365b13abfd65d";
    public static String getAdId(Context context) {
        String gaid = "";
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            gaid = advertisingIdInfo.getId();
        } catch (IOException | GooglePlayServicesRepairableException |
                 GooglePlayServicesNotAvailableException | IllegalStateException e) {
            Log.e("GETGAID", "getAdId: " + e.getMessage());
        }
        return gaid;
    }

    public static String getPlatform() {
        return "funny_play";
    }

    public static String isVpn(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork != null) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities != null) {

                return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN) ? "true" : "false";
            }
        }
        return "false";
    }

    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    /**
     * 获取应用的 versionCode
     *
     * @param context 上下文
     * @return versionCode
     */
    public static long getVersionCode(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
                return packageInfo.getLongVersionCode();
            } else {
                return packageInfo.versionCode;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 获取应用的 versionName
     *
     * @param context 上下文
     * @return versionName
     */
    public static String getVersionName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }
}
