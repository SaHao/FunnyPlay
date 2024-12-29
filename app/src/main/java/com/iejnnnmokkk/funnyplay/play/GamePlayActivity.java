package com.iejnnnmokkk.funnyplay.play;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.work.impl.utils.PreferenceUtils;

import com.anythink.core.api.ATAdInfo;
import com.iejnnnmokkk.common.base.BaseActivity;
import com.iejnnnmokkk.common.utils.SharedPreferencesUtil;
import com.iejnnnmokkk.funnyplay.databinding.ActivityGamePlayBinding;
import com.iejnnnmokkk.funnyplay.play.eventBean.GamePlayData;
import com.iejnnnmokkk.funnyplay.play.eventBean.GamePlayVideoAds;
import com.iejnnnmokkk.funnyplay.tools.LanguageUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;
import java.util.Objects;

import io.iaa.topon.library.TopOnAds;
import io.iaa.topon.library.TopOnEvent;
import io.iaa.topon.library.TopOnRewardedAdsListener;


public class GamePlayActivity extends BaseActivity implements IGamePlayView {

    public static void playGame(Activity activity, String no, String gameUrl) {
        Intent intent = new Intent(activity, GamePlayActivity.class);
        intent.putExtra("no",no);
        intent.putExtra("gameUrl",gameUrl);
        activity.startActivity(intent);
    }
    private ActivityGamePlayBinding binding;
    private String no;
    private String gameUrl;
    private int targetAdsNumber;
    private GamePlayViewModel gamePlayViewModel;
    private GamePlayBean.DataBean details = new GamePlayBean.DataBean();

    @Override
    protected void onInitView(@Nullable Bundle savedInstanceState) {
        gamePlayViewModel = new ViewModelProvider(this).get(GamePlayViewModel.class);
        binding = ActivityGamePlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.close.setOnClickListener(view->{
            finish();
        });
    }

    @Override
    public void initData() {
        no = getIntent().getStringExtra("no");
        gameUrl = getIntent().getStringExtra("gameUrl");
        initWebView();
        gamePlayViewModel.gameInfo.observe(this, gameInfoDetails -> {
            if(null!=gameInfoDetails){
                details = gameInfoDetails;
                setDetailsData(gameInfoDetails);
            }
        });
        gamePlayViewModel.getGameInfoDetails(no);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        currAdsNum = (int) MiniPlayApp.getApplication().getValue(Constants.GAME_PLAY_ADS_NUMBER+no, 0);
        currentTime = System.currentTimeMillis() / 1000;
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {
        WebSettings settings = binding.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        settings.setLoadWithOverviewMode(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(false);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        binding.webView.addJavascriptInterface(new GameJsJavascript(), "kkxjs");
        binding.webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                binding.progress.setProgress(newProgress);
            }
        });
        binding.webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                binding.progress.setVisibility(View.GONE);
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                binding.progress.setVisibility(View.VISIBLE);
            }
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                String message = "SSL Certificate error.";
                AlertDialog dialog = new AlertDialog.Builder(activity)
                        .setCancelable(false)
                        .setTitle("Warning")
                        .setMessage(message)
                        .setPositiveButton("continue", (dialogInterface, i) -> {
                            sslErrorHandler.proceed();
                            dialogInterface.dismiss();
                        })
                        .setNegativeButton("cancel", (dialogInterface, i) -> {
                            sslErrorHandler.cancel();
                            webView.loadUrl("javascript:document.body.innerHtml=\" \"");
                            dialogInterface.dismiss();
                        }).create();
                dialog.show();
            }
        });
        binding.webView.loadUrl(gameUrl);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(GamePlayVideoAds event) { //视频开始播放回调
        TopOnAds.loadRewardAd(activity, "n675ba286f407f", "", new TopOnRewardedAdsListener() {
            @Override
            public void onAdLoadShow() {
                TopOnEvent.logEventADorFA(activity,"acloiyxa","ad_show");
                binding.webView.evaluateJavascript("showAdsStatus();", null);
            }
            @Override
            public void onAdHidden(ATAdInfo adInfo) {
                TopOnEvent.logEventADorFA(activity,"acloiyxa","ad_hidden");
                evaluateJavascript(0,event.getAction());
            }
            @Override
            public void onUserRewarded(ATAdInfo adInfo) {
                TopOnEvent.logEventADorFA(activity,"acloiyxa","ad_reward");
                receiveGameReward(event.getAction());
            }
            @Override
            public void onAdClicked(ATAdInfo adInfo) {
                TopOnEvent.logEventADorFA(activity,"acloiyxa","ads_click");
            }
            @Override
            public void onAdLoadFailed(String s) {
                TopOnEvent.logEventADorFA(activity,"acloiyxa","ad_failed");
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(GamePlayData event) { //游戏数据返回
//        String json = event.getJson();
//        String searchWord = details.getSearch_word();
//        if(TextUtils.isEmpty(searchWord))return;
//        String e1="",e2="";
//        long timeMillis = System.currentTimeMillis();
//        long endTime = timeMillis / 1000;
//        long timeD = endTime - currentTime + (long)MiniPlayApp.getApplication().getValue(Constants.GAME_PLAY_TIME_KEY + no, 0L);
//        currentTime = endTime;
//        MiniPlayApp.getApplication().setValue(Constants.GAME_PLAY_TIME_KEY + no, timeD);
//        if(details.getRed()==2){ //老游戏
//            OldGameData oldGameData = new Gson().fromJson(json, OldGameData.class);
//            String[] split = searchWord.split(",");
//            String checkpoint = oldGameData.getCheckpoint();
//            if("ad_callback".equals(split[0])){
//                e2 = getEventStr(split[0], checkpoint, timeD);
//            }else{
//                e1 = getEventStr(split[0], checkpoint, timeD);
//            }
//            if (split.length >= 2) {
//                e2 = getEventStr(split[1], checkpoint, timeD);
//            }
//            MiniLog.e("签名前sign = "+(no + e1 + e2 + timeMillis + Constants.OLD_KEY));
//            String sign = Tools.Companion.getMD5Sign(no + e1 + e2 + timeMillis + Constants.OLD_KEY);
//            MiniLog.e("签名后sign = "+sign);
//            if(isLevel||isDeposit||isAdCallback||isScore||isCoins){
//                MiniLog.e("达到目标>>>上报服务器>>>receiveOldGameReward");
//                gamePlayViewModel.receiveOldGameReward(no, timeMillis,e1,e2,sign);
//            }
//        }else{ //新游戏
//            NewGameData newGameData = new Gson().fromJson(json, NewGameData.class);
//            newGameData.setNo(no);
//            newGameData.setTime(currentTime);
//            newGameData.setTotal_time(timeD);
//            newGameData.setAds_num(currAdsNum);
//            long num = newGameData.getCoin() + newGameData.getLevel() + newGameData.getAds_num() + newGameData.getTotal_time();
//            String signature = Tools.Companion.getMD5Sign(newGameData.getNo() + num + Constants.TOKEN + Constants.NEW_KEY + newGameData.getTime());
//            newGameData.setSignature(signature);
//            gamePlayViewModel.receiveNewGameReward(newGameData);
//        }

    }

    public void setDetailsData(GamePlayBean.DataBean data) {
        List<GamePlayBean.AllDataBean> contentList = Objects.requireNonNull(data.getAll()).get(0).getData();
        GamePlayBean.AllDataBean taskTarget = getTargetCoin(contentList);
        if(null!=taskTarget){
            binding.tvTargetTitle.setText(taskTarget.getTitle());
            binding.tvTargetCoin.setText(String.valueOf(taskTarget.getReward()));
            targetAdsNumber = taskTarget.getCondition();
        }
        if(data.getTask_reward()>0){ //有奖励可以领取
            binding.tvReward.setText(String.valueOf(data.getTask_reward()));
            binding.llReward.setVisibility(View.VISIBLE);
            binding.llReward.postDelayed(()->{
                binding.llReward.setVisibility(View.GONE);
            },2500);
//            SoundTools.play(this);
            binding.llReward.postDelayed(()->{
                //延迟1秒去刷新用户信息
//                Net.INSTANCE.getUserData(true);//刷新用户信息
            },1000);
        }
    }
    private GamePlayBean.AllDataBean getTargetCoin(List<GamePlayBean.AllDataBean> contentList) {
        GamePlayBean.AllDataBean eventContent = null; //下一次领取的奖励
        for (GamePlayBean.AllDataBean dc: contentList) {
            if (dc.getStatus() == 0) {
                eventContent = dc;
                break;
            }
        }
        if(eventContent!=null){
//            MiniLog.e("getTargetCoin>>>>Reward = "+eventContent.getReward()+",Condition = "+eventContent.getCondition()+",Title = "+eventContent.getTitle());
        }
        return eventContent;
    }

    private boolean isLevel,isDeposit,isAdCallback,isScore,isCoins;
    private long currentTime;
    private String getEventStr(String eventStr, String checkpoint, long timeD) {
//        if ("add_level".equals(eventStr)) {//等级
//            List<GamePlayBean.AllDataBean> data = details.getStep().getAdd_level().get(0).getData();
//            GamePlayBean.AllDataBean targetCoin = getTargetCoin(data);
//            MiniLog.e("getEventStr>>>add_level = "+checkpoint+",scoreNum = "+targetCoin.getCondition());
//            isLevel = Integer.parseInt(checkpoint)>=targetCoin.getCondition();
//            return checkpoint;
//        }
//        if ("deposit".equals(eventStr)) {//deposit
//            List<GamePlayBean.AllDataBean> data = details.getStep().getDeposit().get(0).getData();
//            GamePlayBean.AllDataBean targetCoin = getTargetCoin(data);
//            MiniLog.e("getEventStr>>>deposit = "+timeD+",depositNum = "+targetCoin.getCondition());
//            isDeposit = timeD >= targetCoin.getCondition();
//            return String.valueOf(timeD);
//        }
//        if ("ad_callback".equals(eventStr)) {//ad_callback
//            List<GamePlayBean.AdCallbackData> data = details.getStep().getAd_callback().get(0).getData();
//            GamePlayBean.AllDataBean targetCoin = getTargetCoin(data);
//            MiniLog.e("getEventStr>>>ad_callback = "+currAdsNum+",adCallbackNum = "+targetCoin.getCondition());
//            isAdCallback = currAdsNum >= targetCoin.getCondition();
//            return String.valueOf(currAdsNum);
//        }
//        if ("score".equals(eventStr)) {//score
//            List<GamePlayBean.AllDataBean> data = details.getStep().getScore().get(0).getData();
//            GamePlayBean.AllDataBean targetCoin = getTargetCoin(data);
//            MiniLog.e("getEventStr>>>score = "+checkpoint+",scoreNum = "+targetCoin.getCondition());
//            isScore = Integer.parseInt(checkpoint)>=targetCoin.getCondition();
//            return checkpoint;
//        }
        if ("coins".equals(eventStr)) {//coins
//            List<GamePlayBean.AllDataBean> data = details.getStep().getCoins().get(0).getData();
//            GamePlayBean.AllDataBean targetCoin = getTargetCoin(data);
//            MiniLog.e("getEventStr>>>coins = "+checkpoint+",coinsNum = "+targetCoin.getCondition());
//            isCoins = Integer.parseInt(checkpoint)>=targetCoin.getCondition();
            return checkpoint;
        }
        return "";
    }

    private int currAdsNum;
    public void receiveGameReward(String action) { //视频播放完成回调
        evaluateJavascript(1,action);
        currAdsNum = SharedPreferencesUtil.getInstance(context).getInt("AdsNum"+no);
        currAdsNum = currAdsNum+1;
        SharedPreferencesUtil.getInstance(context).saveInt("AdsNum"+no,currAdsNum);
        if(currAdsNum>=targetAdsNumber){
            long timeMillis = System.currentTimeMillis();
            if(details.getRed()==2){
                String e1 = "";
                String e2 = String.valueOf(currAdsNum);
                String sign = LanguageUtils.getMD5(no + e1 + e2 + timeMillis + LanguageUtils.GAME_PLAY_TIME_KEY);
                gamePlayViewModel.receiveOldGameReward(no, timeMillis,e1,e2,sign);
            }else{
                String signature =  LanguageUtils.getMD5(no + currAdsNum + SharedPreferencesUtil.getInstance(context).getValue("token") + LanguageUtils.GAME_PLAY_TIME_KEY+ timeMillis);
                gamePlayViewModel.receiveNewGameReward(no,timeMillis,action,String.valueOf(currAdsNum),signature);
            }
        }
    }

    private void evaluateJavascript(int i,String action) {
        String js;
        if(details.getRed()==2){ //老游戏
            js = String.format("javascript:videofeedback(%d,'%s')", i, action);
        }else{ //新游戏
            js = String.format("javascript:showAdsStatus(%d,'%s')", i, action);
        }
        binding.webView.evaluateJavascript(js, null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void getData(GamePlayBean bean) {

    }

    @Override
    public void onFailed(String msg) {

    }
}
