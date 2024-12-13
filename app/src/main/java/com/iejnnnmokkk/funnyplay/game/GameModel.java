package com.iejnnnmokkk.funnyplay.game;

import android.content.Context;

import com.google.gson.Gson;
import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.common.utils.GsonUtils;
import com.iejnnnmokkk.common.utils.SharedPreferencesUtil;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;
import com.iejnnnmokkk.funnyplay.game.bean.UserInfoBean;
import com.iejnnnmokkk.funnyplay.spl.LoginBean;
import com.iejnnnmokkk.funnyplay.spl.SplBean;
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
public class GameModel {

    public void getData(int pageNum, int type, BaseNetworkCallback<GameBean> callback) {
        String url = "https://api.keepad.xyz/daily_reward/daily_task_list";
        Map<String, Object> map = new HashMap<>();
        map.put("gaid", "123");
        map.put("channel", "funny_play");
        map.put("version", "1.0.11");
        map.put("deviceId", "123");
        map.put("versionCode", 11);
        map.put("token", "");
        map.put("task_type_conf_id", type);
        map.put("is_vpn", false);
        map.put("task_type_id", "10,18,22");
        map.put("limit", "20");
        map.put("randomUUID", "e4b43db5-ddb6-4a09-9447-5beb7f5b73e5");
        map.put("page", pageNum);
        map.put("game_flag", "4");
        map.put("API_URI", "ht.jbtls.xyz");
        String json = new Gson().toJson(map);
        EasyHttp.post(url)
                .upJson(json)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        callback.onFailure("获取失败");
                    }

                    @Override
                    public void onSuccess(String response) {
                        callback.onSuccess(GsonUtils.fromJson(response, GameBean.class));
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
