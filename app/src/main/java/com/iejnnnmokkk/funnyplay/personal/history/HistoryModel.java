package com.iejnnnmokkk.funnyplay.personal.history;

import android.content.Context;

import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.common.utils.GsonUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.HashMap;
import java.util.Map;

public class HistoryModel {

    public void getData(int pageNum, BaseNetworkCallback<HistoryBean> callback) {
        String url = "https://api.keepad.xyz/daily_reward/daily_pay_my_bank_request";
        Map<String, String> formDataMap = new HashMap<>();
        formDataMap.put("is_vpn", "false");
        formDataMap.put("gaid", "");
        formDataMap.put("channel", "funny_play");
        formDataMap.put("page", pageNum + "");
        formDataMap.put("limit", "20");
        formDataMap.put("version", "1.0.0");
        formDataMap.put("versionCode", "1");
        EasyHttp.post(url)
                .params(formDataMap)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        callback.onFailure("获取失败");
                    }

                    @Override
                    public void onSuccess(String response) {
                        callback.onSuccess(GsonUtils.fromJson(response, HistoryBean.class));
                    }
                });
    }
}
