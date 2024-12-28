package com.iejnnnmokkk.funnyplay.play;

import android.webkit.JavascriptInterface;

import android.util.Log;

import com.iejnnnmokkk.funnyplay.play.eventBean.GamePlayData;
import com.iejnnnmokkk.funnyplay.play.eventBean.GamePlayVideoAds;

import org.greenrobot.eventbus.EventBus;


public class GameJsJavascript {
    //---------------------新游戏js方法------------------------
    @JavascriptInterface
    public boolean initGames(){ //TODO 初始化新游戏
        return true;
    }
    @JavascriptInterface
    public void showAds(String action, String adtype) {
        Log.e("TAG","action:" + action + "adtype:" + adtype);
        if(!"Fail".equals(adtype.toLowerCase())){
            EventBus.getDefault().post(new GamePlayVideoAds(action,false));
        }
    }
    @JavascriptInterface
    public void updateGameData(String json) {//游戏数据回调
        Log.e("TAG","updateGameData>>>>json:" + json);
        EventBus.getDefault().post(new GamePlayData(json));
    }

    //---------------------老游戏js方法------------------------
    @JavascriptInterface
    public void InitAd() {}
    @JavascriptInterface
    public void playVideo(String action, String adtype) {
        Log.e("TAG","playVideo = " + action);
        EventBus.getDefault().post(new GamePlayVideoAds(action,true));
    }

    @JavascriptInterface
    public void updateCTOD(String json) {//游戏返回数据
        Log.e("TAG","updateCTOD = " + json);
        EventBus.getDefault().post(new GamePlayData(json));
    }
    @JavascriptInterface
    public void updateCTOD(String action, int coin) {}




}
