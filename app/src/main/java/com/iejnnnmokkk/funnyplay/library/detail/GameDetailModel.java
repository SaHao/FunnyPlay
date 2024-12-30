package com.iejnnnmokkk.funnyplay.library.detail;

import android.content.Context;

import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.common.utils.GsonUtils;
import com.iejnnnmokkk.common.utils.ParamUtil;
import com.iejnnnmokkk.common.utils.SharedPreferencesUtil;
import com.iejnnnmokkk.funnyplay.R;
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
        String url = "https://api.keepad.xyz/daily_reward/daily_gamecpl_task_info";
        Map<String, String> map = new HashMap<>();
        map.put("is_vpn", ParamUtil.isVpn(context));
        map.put("channel", ParamUtil.getPlatform());
        map.put("version", ParamUtil.getVersionName(context));
        map.put("limit", "2000");
        map.put("gaid", SharedPreferencesUtil.getInstance(context).getValue("gaid"));
        map.put("versionCode", ParamUtil.getVersionCode(context) + "");
        map.put("page", pageNum + "");
        map.put("no", id);

        EasyHttp.post(url)
                .params(map)
                .headers("token", SharedPreferencesUtil.getInstance(context).getValue("token"))
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        callback.onFailure(context.getResources().getString(R.string.error));
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

    public void getTask(String id, BaseNetworkCallback<GameDetailBean> callback) {
        String url = "https://api.keepad.xyz/daily_reward/daily_task_start";
        Map<String, String> map = new HashMap<>();
        map.put("is_vpn", ParamUtil.isVpn(context));
        map.put("channel", ParamUtil.getPlatform());
        map.put("version", ParamUtil.getVersionName(context));
        map.put("gaid", SharedPreferencesUtil.getInstance(context).getValue("gaid"));
        map.put("versionCode", ParamUtil.getVersionCode(context) + "");
        map.put("no", id);

        EasyHttp.post(url)
                .params(map)
                .headers("token", SharedPreferencesUtil.getInstance(context).getValue("token"))
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        callback.onFailure(context.getResources().getString(R.string.error));
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

    public void getTaskPrize(String id, BaseNetworkCallback<TaskPrizeBean> callback) {
        String url = "https://api.keepad.xyz/funny_play/daily_welfare_reward";
        Map<String, String> map = new HashMap<>();
        map.put("is_vpn", ParamUtil.isVpn(context));
        map.put("channel", ParamUtil.getPlatform());
        map.put("version", ParamUtil.getVersionName(context));
        map.put("gaid", SharedPreferencesUtil.getInstance(context).getValue("gaid"));
        map.put("versionCode", ParamUtil.getVersionCode(context) + "");
        map.put("id", id);

        EasyHttp.post(url)
                .params(map)
                .headers("token", SharedPreferencesUtil.getInstance(context).getValue("token"))
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        callback.onFailure(context.getResources().getString(R.string.error));
                    }

                    @Override
                    public void onSuccess(String response) {
                        callback.onSuccess(GsonUtils.fromJson(response, TaskPrizeBean.class));
                    }
                });
    }
}
