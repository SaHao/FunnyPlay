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

    public void getData(BaseNetworkCallback<GameBean> callback) {
        String url = "https://api.keepad.xyz/MP/G_D_S";
        EasyHttp.post(url)
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
