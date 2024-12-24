package com.iejnnnmokkk.funnyplay.spl;

import android.content.Context;

import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.common.utils.GsonUtils;
import com.iejnnnmokkk.common.utils.ParamUtil;
import com.iejnnnmokkk.common.utils.SharedPreferencesUtil;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.model.HttpParams;

import java.util.Locale;

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
}
