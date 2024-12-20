package com.iejnnnmokkk.funnyplay.personal.history;

import android.content.Context;

import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.common.utils.GsonUtils;
import com.iejnnnmokkk.common.utils.SharedPreferencesUtil;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.HashMap;
import java.util.Map;

public class HistoryModel {

    public void getData(Context context, int pageNum, BaseNetworkCallback<HistoryBean> callback) {
        String url = "https://api.keepad.xyz/funny_play/well_balance_index";
        Map<String, String> formDataMap = new HashMap<>();
        formDataMap.put("is_vpn", "false");
        formDataMap.put("gaid", "");
        formDataMap.put("channel", "funny_play");
        formDataMap.put("page", pageNum + "");
        formDataMap.put("limit", "20");
        formDataMap.put("version", "1.0.0");
        formDataMap.put("versionCode", "1");
        EasyHttp.post(url)
                .headers("token", SharedPreferencesUtil.getInstance(context).getValue("token"))
                .params(formDataMap)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        callback.onFailure("获取失败");
                    }

                    @Override
                    public void onSuccess(String response) {
                        try {
                            callback.onSuccess(GsonUtils.fromJson(response, HistoryBean.class));
                        } catch (Exception e) {
                            callback.onSuccess(new HistoryBean());
                        }
                    }
                });
    }
}
