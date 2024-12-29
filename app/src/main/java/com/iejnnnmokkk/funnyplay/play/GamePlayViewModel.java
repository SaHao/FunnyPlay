package com.iejnnnmokkk.funnyplay.play;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.iejnnnmokkk.common.utils.AppContext;
import com.iejnnnmokkk.common.utils.GsonUtils;
import com.iejnnnmokkk.common.utils.ParamUtil;
import com.iejnnnmokkk.common.utils.SharedPreferencesUtil;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.HashMap;
import java.util.Map;


public class GamePlayViewModel extends ViewModel {

    public final MutableLiveData<GamePlayBean.DataBean> gameInfo;
    public final MutableLiveData<String> receiveSuccess;

    public GamePlayViewModel() {
        gameInfo = new MutableLiveData<>();
        receiveSuccess = new MutableLiveData<>();
    }

    public void getGameInfoDetails(String no){
        String url = "https://api.keepad.xyz/daily_reward/daily_gamecpl_task_info";
        Map<String, String> map = new HashMap<>();
        map.put("is_vpn", ParamUtil.isVpn(AppContext.getContext()));
        map.put("channel", ParamUtil.getPlatform());
        map.put("version", ParamUtil.getVersionName(AppContext.getContext()));
        map.put("gaid", SharedPreferencesUtil.getInstance(AppContext.getContext()).getValue("gaid"));
        map.put("versionCode", ParamUtil.getVersionCode(AppContext.getContext()) + "");
        map.put("no", no);

        EasyHttp.post(url)
                .params(map)
                .headers("token", SharedPreferencesUtil.getInstance(AppContext.getContext()).getValue("token"))
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                    }

                    @Override
                    public void onSuccess(String response) {
                        try {
                            GamePlayBean.DataBean data = GsonUtils.fromJson(response, GamePlayBean.class).getData();
                            gameInfo.setValue(data);
                        } catch (Exception e) {
                        }
                    }
                });
    }

//    public void receiveOldGameReward(String no, long timeMillis, String e1,String e2, String sign) {
//        Net.INSTANCE.receiveOldGameReward(no, e1, e2, timeMillis, sign, result -> {
//            MiniLog.e("receiveOldGameReward>>>code = "+result.getCode()+",message = "+result.getMsg());
//            receiveSuccess.setValue("");
//            getGameInfoDetails(no);
//            return null;
//        });
//    }
//
//    public void receiveNewGameReward(String no, long timeMillis, String action, String adsNum, String signature) {
//        Net.INSTANCE.receiveNewGameReward(no, action, adsNum, timeMillis, signature, result -> {
//            MiniLog.e("receiveNewGameReward>>>code = "+result.getCode()+",message = "+result.getMsg());
//            receiveSuccess.setValue("");
//            getGameInfoDetails(no);
//            return null;
//        });
//    }
//
//    public void receiveNewGameReward(NewGameData newGameData) {
//        Net.INSTANCE.receiveNewGameReward(newGameData, result -> {
//            MiniLog.e("receiveNewGameReward>>>code = "+result.getCode()+",message = "+result.getMsg());
//            receiveSuccess.setValue("");
//            getGameInfoDetails(newGameData.getNo());
//            return null;
//        });
//    }
}