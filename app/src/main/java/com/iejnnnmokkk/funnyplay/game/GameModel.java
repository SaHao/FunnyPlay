package com.iejnnnmokkk.funnyplay.game;

import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.common.utils.GsonUtils;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;
import com.iejnnnmokkk.funnyplay.spl.LoginBean;
import com.iejnnnmokkk.funnyplay.spl.SplBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

/**
 * @author Sun
 * @Demo class SplModel
 * @Description TODO
 * @date 2024/12/10 14:58
 */
public class GameModel {

    public void getData(int pageNum, BaseNetworkCallback<GameBean> callback) {
        String url = "https://api.keepad.xyz/daily_reward/daily_send_new_user_coins";
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
