package com.iejnnnmokkk.funnyplay.game;

import android.content.Context;

import com.google.gson.Gson;
import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.common.utils.GsonUtils;
import com.iejnnnmokkk.common.utils.ParamUtil;
import com.iejnnnmokkk.common.utils.SharedPreferencesUtil;
import com.iejnnnmokkk.funnyplay.R;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;
import com.iejnnnmokkk.funnyplay.game.bean.UserInfoBean;
import com.iejnnnmokkk.funnyplay.view.SignInBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.model.HttpParams;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author Sun
 * @Demo class SplModel
 * @Description TODO
 * @date 2024/12/10 14:58
 */
public class GameModel {

    private Context context;

    public GameModel(Context context) {
        this.context = context;
    }

    public void getData(int pageNum, int type, BaseNetworkCallback<GameBean> callback) {
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
                            callback.onSuccess(GsonUtils.fromJson(response, GameBean.class));
                        } catch (Exception e) {
                            callback.onSuccess(new GameBean());
                        }
                    }
                });
    }

    public void getUserInfo(Context context, BaseNetworkCallback<UserInfoBean> callback) {
        String url = "https://api.qnpt.xyz/funny_play/user_info";
        Map<String, String> map = new HashMap<>();
        map.put("is_vpn", ParamUtil.isVpn(context));
        map.put("gaid", SharedPreferencesUtil.getInstance(context).getValue("gaid"));
        map.put("channel", ParamUtil.getPlatform());
        map.put("fields", "");
        map.put("deviceId", ParamUtil.getDeviceId(context));
        map.put("version", ParamUtil.getVersionName(context));
        map.put("versionCode", ParamUtil.getVersionCode(context) + "");
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
                        SharedPreferencesUtil.getInstance(context).saveValue("user", response);
                        callback.onSuccess(GsonUtils.fromJson(response, UserInfoBean.class));
                    }
                });
    }

    public void getSignInData(BaseNetworkCallback<SignInBean> callback) {
        String url = "https://api.keepad.xyz/funny_play/daily_list";
        Map<String, String> map = new HashMap<>();
        map.put("is_vpn", ParamUtil.isVpn(context));
        map.put("gaid", SharedPreferencesUtil.getInstance(context).getValue("gaid"));
        map.put("channel", ParamUtil.getPlatform());
        map.put("version", ParamUtil.getVersionName(context));
        map.put("versionCode", ParamUtil.getVersionCode(context) + "");
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
                        callback.onSuccess(GsonUtils.fromJson(response, SignInBean.class));
                    }
                });
    }

    public void signIn(String id, BaseNetworkCallback<SignInBean> callback) {
        String url = "https://api.keepad.xyz/funny_play/new_daily";
        HttpParams params = new HttpParams();
        params.put("is_vpn", ParamUtil.isVpn(context));
        params.put("channel", ParamUtil.getPlatform());
        params.put("version", ParamUtil.getVersionName(context));
        params.put("versionCode", ParamUtil.getVersionCode(context) + "");
        params.put("gaid", SharedPreferencesUtil.getInstance(context).getValue("gaid"));
        params.put("deviceId", ParamUtil.getDeviceId(context));
        params.put("language", Locale.getDefault().getLanguage());
        EasyHttp.post(url)
                .params(params)
                .headers("token", SharedPreferencesUtil.getInstance(context).getValue("token"))
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        callback.onFailure(context.getResources().getString(R.string.error));
                    }

                    @Override
                    public void onSuccess(String response) {
                        callback.onSuccess(GsonUtils.fromJson(response, SignInBean.class));
                    }
                });
    }

}
