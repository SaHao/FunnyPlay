package com.iejnnnmokkk.funnyplay.spl;

import android.content.Context;

import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.common.utils.GsonUtils;
import com.iejnnnmokkk.common.utils.ParamUtil;
import com.iejnnnmokkk.common.utils.SharedPreferencesUtil;
import com.iejnnnmokkk.funnyplay.game.bean.UserInfoBean;
import com.iejnnnmokkk.funnyplay.view.SignInBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.model.HttpParams;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author Sun
 * @Demo class SplModel
 * @Description TODO
 * @date 2024/12/10 14:58
 */
public class SplModel {

    public void achieve(Context context, BaseNetworkCallback<SplBean> callback) {
        String url = "https://api.keepad.xyz/daily_reward/daily_send_new_user_coins";
        HttpParams params = new HttpParams();
        params.put("is_vpn", ParamUtil.isVpn(context));
        params.put("channel", ParamUtil.getPlatform());
        params.put("version", ParamUtil.getVersionName(context));
        params.put("gaid", SharedPreferencesUtil.getInstance(context).getValue("gaid"));
        params.put("versionCode", ParamUtil.getVersionCode(context) + "");
        EasyHttp.post(url)
                .params(params)
                .headers("token", SharedPreferencesUtil.getInstance(context).getValue("token"))
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        callback.onFailure("获取失败");
                    }

                    @Override
                    public void onSuccess(String response) {
                        callback.onSuccess(GsonUtils.fromJson(response, SplBean.class));
                    }
                });
    }

    public void login(Context context, BaseNetworkCallback<LoginBean> callback) {
        String url = "https://api.keepad.xyz/funny_play/daily_login";
        HttpParams params = new HttpParams();
        params.put("is_vpn", ParamUtil.isVpn(context));
        params.put("channel", ParamUtil.getPlatform());
        params.put("version", ParamUtil.getVersionName(context));
        params.put("gaid", SharedPreferencesUtil.getInstance(context).getValue("gaid"));
        params.put("versionCode", ParamUtil.getVersionCode(context) + "");
        params.put("deviceId", ParamUtil.getDeviceId(context));
        params.put("language", Locale.getDefault().getLanguage());
        EasyHttp.post(url)
                .params(params)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        callback.onFailure("获取失败");
                    }

                    @Override
                    public void onSuccess(String response) {
                        callback.onSuccess(GsonUtils.fromJson(response, LoginBean.class));
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
        map.put("deviceId", ParamUtil.getDeviceId(context));
        map.put("version", ParamUtil.getVersionName(context));
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
