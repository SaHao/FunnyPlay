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

/**
 * @author Sun
 * @Demo class ShopModel
 * @Description TODO
 * @date 2024/12/18 16:06
 */
public class ShopModel {

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
}
