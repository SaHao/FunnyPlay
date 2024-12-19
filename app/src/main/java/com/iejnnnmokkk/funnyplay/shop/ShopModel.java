package com.iejnnnmokkk.funnyplay.shop;

import com.google.gson.Gson;
import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.common.utils.GsonUtils;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;
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

    public void getData(BaseNetworkCallback<ShopBean> callback) {
        String url = "https://api.keepad.xyz/MP/G_D_S";
        EasyHttp.post(url)
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
}
