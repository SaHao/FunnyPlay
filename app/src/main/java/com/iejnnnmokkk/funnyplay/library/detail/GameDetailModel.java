package com.iejnnnmokkk.funnyplay.library.detail;

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

public class GameDetailModel {

    private Context context;

    public GameDetailModel(Context context) {
        this.context = context;
    }

    public void getData(int pageNum, String id, BaseNetworkCallback<GameDetailBean> callback) {
        String url = "https://api.keepad.xyz/funny_play/daily_offer_info";
        Map<String, String> map = new HashMap<>();
        map.put("is_vpn", "false");
        map.put("channel", "funny_play");
        map.put("version", "1.0.11");
        map.put("limit", "20");
        map.put("gaid", "");
        map.put("versionCode", "11");
        map.put("page", pageNum + "");
        map.put("no", id);
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
                            callback.onSuccess(GsonUtils.fromJson(response, GameDetailBean.class));
                        } catch (Exception e) {
                            callback.onSuccess(new GameDetailBean());
                        }
                    }
                });
    }
}
