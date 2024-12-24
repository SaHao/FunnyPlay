package com.iejnnnmokkk.funnyplay.personal;

import android.content.Context;

import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.common.utils.GsonUtils;
import com.iejnnnmokkk.common.utils.ParamUtil;
import com.iejnnnmokkk.common.utils.SharedPreferencesUtil;
import com.iejnnnmokkk.funnyplay.game.bean.UserInfoBean;
import com.iejnnnmokkk.funnyplay.library.GameLibraryBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.HashMap;
import java.util.Map;

public class PersonalModel {

    public void getData(Context context, BaseNetworkCallback<PersonalBean> callback) {
        String url = "https://api.keepad.xyz/daily_reward/daily_my_task_list_v1";
        Map<String, String> map = new HashMap<>();
        map.put("is_vpn", ParamUtil.isVpn(context));
        map.put("channel", ParamUtil.getPlatform());
        map.put("version", ParamUtil.getVersionName(context));
        map.put("gaid", SharedPreferencesUtil.getInstance(context).getValue("gaid"));
        map.put("versionCode", ParamUtil.getVersionCode(context) + "");

        EasyHttp.post(url)
                .headers("token", SharedPreferencesUtil.getInstance(context).getValue("token"))
                .params(map)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        callback.onFailure("获取失败");
                    }

                    @Override
                    public void onSuccess(String response) {
                        try {
                            callback.onSuccess(GsonUtils.fromJson(response, PersonalBean.class));
                        } catch (Exception e) {
                            callback.onSuccess(new PersonalBean());
                        }
                    }
                });
    }
}
