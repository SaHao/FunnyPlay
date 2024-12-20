package com.iejnnnmokkk.funnyplay.spl;

import android.content.Context;

import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.common.http.HttpUtils;
import com.iejnnnmokkk.common.http.RequestCallback;
import com.iejnnnmokkk.common.utils.GsonUtils;
import com.iejnnnmokkk.common.utils.SharedPreferencesUtil;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.HashMap;
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
        EasyHttp.post(url)
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

    public void login(BaseNetworkCallback<LoginBean> callback) {
        String url = "https://api.keepad.xyz/funny_play/daily_login";
        EasyHttp.post(url)
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
