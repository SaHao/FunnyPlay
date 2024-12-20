package com.iejnnnmokkk.funnyplay.shop;

import android.content.Context;

import com.google.gson.Gson;
import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.common.utils.GsonUtils;
import com.iejnnnmokkk.common.utils.SharedPreferencesUtil;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;
import com.iejnnnmokkk.funnyplay.game.bean.UserInfoBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Sun
 * @Demo class ShopModel
 * @Description TODO
 * @date 2024/12/18 16:06
 */
public class ShopModel {

    private Context context;

    public ShopModel(Context context) {
        this.context = context;
    }

    public void getData(BaseNetworkCallback<ShopBean> callback) {
        String url = "https://api.keepad.xyz/MP/G_D_S";
        EasyHttp.post(url)
                .headers("token", SharedPreferencesUtil.getInstance(context).getValue("token"))
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        callback.onFailure("获取失败");
                    }

                    @Override
                    public void onSuccess(String response) {
                        callback.onSuccess(GsonUtils.fromJson(response, ShopBean.class));
                    }
                });
    }

    public void buy(int pid, BaseNetworkCallback<ShopBean> callback) {
        String url = "https://api.keepad.xyz/MP/E_G_D_S";
        Map<String, String> map = new HashMap<>();
        map.put("is_vpn", "false");
        map.put("gid", pid + "");
        map.put("gaid", "123");
        map.put("channel", "MiniPlay");
        map.put("randomUUID", "842cc6b4-9616-4a3e-a7bf-cd73f00bf7dc");
        map.put("version", "1.0.8");
        map.put("deviceId", "123");
        map.put("versionCode", "0");
        map.put("token", "604deba8b78053a23e5660b4da0fd417");
        map.put("API_URI", "ht.jbtls.xyz");
        EasyHttp.post(url)
                .params(map)
                .headers("token", SharedPreferencesUtil.getInstance(context).getValue("token"))
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        callback.onFailure("获取失败");
                    }

                    @Override
                    public void onSuccess(String response) {
                        callback.onSuccess(GsonUtils.fromJson(response, ShopBean.class));
                    }
                });
    }

    public void use(int pid, BaseNetworkCallback<ShopBean> callback) {
        String url = "https://api.keepad.xyz/MP/S_U_A_O_F";
        Map<String, String> map = new HashMap<>();
        map.put("is_vpn", "false");
        map.put("gid", pid + "");
        map.put("gaid", "123");
        map.put("channel", "MiniPlay");
        map.put("randomUUID", "842cc6b4-9616-4a3e-a7bf-cd73f00bf7dc");
        map.put("version", "1.0.8");
        map.put("deviceId", "123");
        map.put("versionCode", "8");
        map.put("token", "604deba8b78053a23e5660b4da0fd417");
        map.put("API_URI", "ht.jbtls.xyz");
        EasyHttp.post(url)
                .params(map)
                .headers("token", SharedPreferencesUtil.getInstance(context).getValue("token"))
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        callback.onFailure("获取失败");
                    }

                    @Override
                    public void onSuccess(String response) {
                        callback.onSuccess(GsonUtils.fromJson(response, ShopBean.class));
                    }
                });
    }

    public void getUserInfo(Context context, BaseNetworkCallback<UserInfoBean> callback) {
        String url = "https://api.qnpt.xyz/funny_play/user_info";
        Map<String, String> formDataMap = new HashMap<>();
        formDataMap.put("is_vpn", "false");
        formDataMap.put("gaid", "3f40a9a3-8a0b-4b72-b56a-7d6fa9ca9264");
        formDataMap.put("channel", "MiniPlay");
        formDataMap.put("fields", "");
        formDataMap.put("version", "1.0.0");
        formDataMap.put("deviceId", "43986f266f02e67f");
        formDataMap.put("versionCode", "1");
        EasyHttp.post(url)
                .params(formDataMap)
                .headers("token", SharedPreferencesUtil.getInstance(context).getValue("token"))
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        callback.onFailure("获取失败");
                    }

                    @Override
                    public void onSuccess(String response) {
                        SharedPreferencesUtil.getInstance(context).saveValue("user", response);
                        callback.onSuccess(GsonUtils.fromJson(response, UserInfoBean.class));
                    }
                });
    }
}
