package com.iejnnnmokkk.funnyplay.library;

import android.content.Context;

import com.google.gson.Gson;
import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.common.utils.GsonUtils;
import com.iejnnnmokkk.common.utils.ParamUtil;
import com.iejnnnmokkk.common.utils.SharedPreferencesUtil;
import com.iejnnnmokkk.funnyplay.R;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;
import com.iejnnnmokkk.funnyplay.shop.ShopBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sun
 * @Demo class GameLibraryModel
 * @Description TODO
 * @date 2024/12/20 17:16
 */
public class GameLibraryModel {

    private Context context;

    public GameLibraryModel(Context context) {
        this.context = context;
    }

    public void getData(int pageNum, int type, BaseNetworkCallback<GameLibraryBean> callback) {
        String url = "https://api.keepad.xyz/daily_reward/daily_task_list";
        Map<String, Object> map = new HashMap<>();
        map.put("gaid", SharedPreferencesUtil.getInstance(context).getValue("gaid"));
        map.put("version", ParamUtil.getVersionName(context));
        map.put("versionCode", ParamUtil.getVersionCode(context) + "");
        map.put("channel", ParamUtil.getPlatform());
        map.put("deviceId", ParamUtil.getDeviceId(context));
        map.put("task_type_conf_id", type);
        map.put("is_vpn", ParamUtil.isVpn(context));
        map.put("task_type_id", "10,18,22");
        map.put("limit", "20");
        map.put("randomUUID", SharedPreferencesUtil.getInstance(context).getValue("uuid"));
        map.put("page", pageNum);
        map.put("game_flag", "4");
        map.put("API_URI", "ht.jbtls.xyz");
        String json = new Gson().toJson(map);
        EasyHttp.post(url)
                .upJson(json)
                .headers("token", SharedPreferencesUtil.getInstance(context).getValue("token"))
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        callback.onFailure(context.getResources().getString(R.string.error));
                    }

                    @Override
                    public void onSuccess(String response) {
                        try {
                            callback.onSuccess(GsonUtils.fromJson(response, GameLibraryBean.class));
                        } catch (Exception e) {
                            callback.onSuccess(new GameLibraryBean());
                        }
                    }
                });
    }
}
