package com.iejnnnmokkk.funnyplay.personal;

import android.content.Context;

import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.common.utils.GsonUtils;
import com.iejnnnmokkk.common.utils.SharedPreferencesUtil;
import com.iejnnnmokkk.funnyplay.game.bean.UserInfoBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.HashMap;
import java.util.Map;

public class PersonalModel {

    public void getData(Context context, BaseNetworkCallback<PersonalBean> callback) {
        String url = "https://api.keepad.xyz/daily_reward/daily_my_task_list_v1";
        Map<String, String> map = new HashMap<>();
        map.put("is_vpn", "false");
        map.put("channel", "jfq_2_offer");
        map.put("version", "1.0.0");
        map.put("gaid", "");
        map.put("versionCode", "");
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
                        callback.onSuccess(GsonUtils.fromJson(response, PersonalBean.class));
                    }
                });
    }
}
