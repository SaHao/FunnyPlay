package com.iejnnnmokkk.funnyplay.shop;

import android.content.Context;

import com.google.gson.Gson;
import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.common.utils.GsonUtils;
import com.iejnnnmokkk.common.utils.ParamUtil;
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
        Map<String, String> map = new HashMap<>();
        map.put("is_vpn", ParamUtil.isVpn(context));
        map.put("gaid", SharedPreferencesUtil.getInstance(context).getValue("gaid"));
        map.put("channel", ParamUtil.getPlatform());
        map.put("randomUUID", SharedPreferencesUtil.getInstance(context).getValue("uuid"));
        map.put("version", ParamUtil.getVersionName(context));
        map.put("deviceId", ParamUtil.getDeviceId(context));
        map.put("versionCode", ParamUtil.getVersionCode(context) + "");
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

    public void buy(int pid, BaseNetworkCallback<ShopBean> callback) {
        String url = "https://api.keepad.xyz/MP/E_G_D_S";
        Map<String, String> map = new HashMap<>();
        map.put("is_vpn", ParamUtil.isVpn(context));
        map.put("gid", pid + "");
        map.put("gaid", SharedPreferencesUtil.getInstance(context).getValue("gaid"));
        map.put("channel", ParamUtil.getPlatform());
        map.put("randomUUID", SharedPreferencesUtil.getInstance(context).getValue("uuid"));
        map.put("version", ParamUtil.getVersionName(context));
        map.put("deviceId", ParamUtil.getDeviceId(context));
        map.put("versionCode", ParamUtil.getVersionCode(context) + "");
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
        map.put("is_vpn", ParamUtil.isVpn(context));
        map.put("gid", pid + "");
        map.put("gaid", SharedPreferencesUtil.getInstance(context).getValue("gaid"));
        map.put("channel", ParamUtil.getPlatform());
        map.put("randomUUID", SharedPreferencesUtil.getInstance(context).getValue("uuid"));
        map.put("version", ParamUtil.getVersionName(context));
        map.put("deviceId", ParamUtil.getDeviceId(context));
        map.put("versionCode", ParamUtil.getVersionCode(context) + "");
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
        Map<String, String> map = new HashMap<>();
        map.put("is_vpn", ParamUtil.isVpn(context));
        map.put("gaid", SharedPreferencesUtil.getInstance(context).getValue("gaid"));
        map.put("channel", ParamUtil.getPlatform());
        map.put("fields", "");
        map.put("version", ParamUtil.getVersionName(context));
        map.put("deviceId", ParamUtil.getDeviceId(context));
        map.put("versionCode", ParamUtil.getVersionCode(context) + "");

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
                        SharedPreferencesUtil.getInstance(context).saveValue("user", response);
                        callback.onSuccess(GsonUtils.fromJson(response, UserInfoBean.class));
                    }
                });
    }
}
