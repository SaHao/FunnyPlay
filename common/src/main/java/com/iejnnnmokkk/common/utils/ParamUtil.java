package com.iejnnnmokkk.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.provider.Settings;
import android.util.Log;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

import java.io.IOException;

public class ParamUtil {
    public static String getAdId(Context context) {
        String gaid = "";
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            gaid = advertisingIdInfo.getId();
        } catch (IOException | GooglePlayServicesRepairableException |
                 GooglePlayServicesNotAvailableException | IllegalStateException e) {
            Log.e("GETGAID", "getAdId: "+e.getMessage());
        }
        return gaid;
    }
    public static  String isVpn(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork != null) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities != null) {

                return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN)?"true":"false";
            }
        }
        return "false";
    }
    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }
}
