package com.iejnnnmokkk.funnyplay.personal.library;

import android.content.Context;

import com.google.gson.Gson;
import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.common.utils.GsonUtils;
import com.iejnnnmokkk.common.utils.SharedPreferencesUtil;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.HashMap;
import java.util.Map;

public class MyGameModel {

    private Context context;

    public MyGameModel(Context context) {
        this.context = context;
    }

    public void getData(BaseNetworkCallback<MyGameBean> callback) {
        String url = "https://api.keepad.xyz/daily_reward/daily_my_task_list_v1";
        Map<String, String> map = new HashMap<>();
        map.put("is_vpn", "false");
        map.put("channel", "jfq_2_offer");
        map.put("version", "1.0.11");
        map.put("versionCode", "");
        map.put("gaid", "");
        String json = new Gson().toJson(map);
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
                        try {
                            callback.onSuccess(GsonUtils.fromJson(response, MyGameBean.class));
                        } catch (Exception e) {
                            callback.onSuccess(new MyGameBean());
                        }
                    }
                });
    }
}
