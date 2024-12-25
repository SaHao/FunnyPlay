package com.iejnnnmokkk.funnyplay.play;

import static android.app.ProgressDialog.show;

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

import com.iejnnnmokkk.common.base.BaseActivity;
import com.iejnnnmokkk.funnyplay.databinding.ActivityGamePlayBinding;

import java.util.List;


public class GamePlayActivity extends BaseActivity {

    public static void playGame(Activity activity, String no, String gameUrl) {
        Intent intent = new Intent(activity, GamePlayActivity.class);
        intent.putExtra("no",no);
        intent.putExtra("gameUrl",gameUrl);
        activity.startActivity(intent);
    }
    private ActivityGamePlayBinding binding;
//    private GamePlayViewModel gamePlayViewModel;
    private String no;
    private String gameUrl;
    private int targetAdsNumber;
    private GameInfoDetails details;

    @Override
    protected void onInitView(@Nullable Bundle savedInstanceState) {
//        gamePlayViewModel = new ViewModelProvider(this).get(GamePlayViewModel.class);
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
//        gamePlayViewModel.gameInfo.observe(this, gameInfoDetails -> {
//            if(null!=gameInfoDetails){
//                details = gameInfoDetails;
//                setDetailsData(gameInfoDetails);
//            }
//        });
//        gamePlayViewModel.getGameInfoDetails(no);
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

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onEvent(GamePlayVideoAds event) { //视频开始播放回调
//        TapOnManager.loadVideoAds(activity, status -> {
//            if(status==1){
//                dismiss();
//                binding.webView.evaluateJavascript("showAdsStatus();", null);
//            }else if(status==2){
//                dismiss();
//                receiveGameReward(event.getAction());
//            }else if(status==-1){
//                dismiss();
//                evaluateJavascript(0,event.getAction());
//            }
//        });
//    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onEvent(GamePlayData event) { //游戏数据返回
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
////            MiniLog.e("签名前sign = "+(no + e1 + e2 + timeMillis + Constants.OLD_KEY));
//            String sign = Tools.Companion.getMD5Sign(no + e1 + e2 + timeMillis + Constants.OLD_KEY);
////            MiniLog.e("签名后sign = "+sign);
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
//
//    }

//    public void setDetailsData(GameInfoDetails data) {
//        List<DetailsContent> contentList = Objects.requireNonNull(data.getAll()).get(0).getData();
//        DetailsContent taskTarget = getTargetCoin(contentList);
//        if(null!=taskTarget){
//            binding.tvTargetTitle.setText(taskTarget.getTitle());
//            binding.tvTargetCoin.setText(String.valueOf(taskTarget.getReward()));
//            targetAdsNumber = taskTarget.getCondition();
//        }
//        if(data.getTask_reward()>0){ //有奖励可以领取
//            binding.tvReward.setText(String.valueOf(data.getTask_reward()));
//            binding.llReward.setVisibility(View.VISIBLE);
//            binding.llReward.postDelayed(()->{
//                binding.llReward.setVisibility(View.GONE);
//            },2500);
////            SoundTools.play(this);
//            EventBus.getDefault().post(new GamePlayRewardNotify(data.getTask_reward()));//通知详情页面弹窗
//            binding.llReward.postDelayed(()->{
//                //延迟1秒去刷新用户信息
//                Net.INSTANCE.getUserData(true);//刷新用户信息
//            },1000);
//        }
//    }
    private DetailsContent getTargetCoin(List<DetailsContent> contentList) {
        DetailsContent eventContent = null; //下一次领取的奖励
        for (DetailsContent dc: contentList) {
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
//    private String getEventStr(String eventStr, String checkpoint, long timeD) {
//        if ("add_level".equals(eventStr)) {//等级
//            List<DetailsContent> data = details.getStep().getAdd_level().get(0).getData();
//            DetailsContent targetCoin = getTargetCoin(data);
//            MiniLog.e("getEventStr>>>add_level = "+checkpoint+",scoreNum = "+targetCoin.getCondition());
//            isLevel = Integer.parseInt(checkpoint)>=targetCoin.getCondition();
//            return checkpoint;
//        }
//        if ("deposit".equals(eventStr)) {//deposit
//            List<DetailsContent> data = details.getStep().getDeposit().get(0).getData();
//            DetailsContent targetCoin = getTargetCoin(data);
//            MiniLog.e("getEventStr>>>deposit = "+timeD+",depositNum = "+targetCoin.getCondition());
//            isDeposit = timeD >= targetCoin.getCondition();
//            return String.valueOf(timeD);
//        }
//        if ("ad_callback".equals(eventStr)) {//ad_callback
//            List<DetailsContent> data = details.getStep().getAd_callback().get(0).getData();
//            DetailsContent targetCoin = getTargetCoin(data);
//            MiniLog.e("getEventStr>>>ad_callback = "+currAdsNum+",adCallbackNum = "+targetCoin.getCondition());
//            isAdCallback = currAdsNum >= targetCoin.getCondition();
//            return String.valueOf(currAdsNum);
//        }
//        if ("score".equals(eventStr)) {//score
//            List<DetailsContent> data = details.getStep().getScore().get(0).getData();
//            DetailsContent targetCoin = getTargetCoin(data);
//            MiniLog.e("getEventStr>>>score = "+checkpoint+",scoreNum = "+targetCoin.getCondition());
//            isScore = Integer.parseInt(checkpoint)>=targetCoin.getCondition();
//            return checkpoint;
//        }
//        if ("coins".equals(eventStr)) {//coins
////            List<DetailsContent> data = details.getStep().getCoins().get(0).getData();
////            DetailsContent targetCoin = getTargetCoin(data);
////            MiniLog.e("getEventStr>>>coins = "+checkpoint+",coinsNum = "+targetCoin.getCondition());
////            isCoins = Integer.parseInt(checkpoint)>=targetCoin.getCondition();
//            return checkpoint;
//        }
//        return "";
//    }

    private int currAdsNum;
//    public void receiveGameReward(String action) { //视频播放完成回调
//        evaluateJavascript(1,action);
//        currAdsNum = (int) MiniPlayApp.getApplication().getValue(Constants.GAME_PLAY_ADS_NUMBER+no, 0);
//        currAdsNum = currAdsNum+1;
//        MiniPlayApp.getApplication().setValue(Constants.GAME_PLAY_ADS_NUMBER+no,currAdsNum);
//        if(currAdsNum>=targetAdsNumber){
//            long timeMillis = System.currentTimeMillis();
//            if(details.getRed()==2){
//                String e1 = "";
//                String e2 = String.valueOf(currAdsNum);
//                String sign = Tools.Companion.getMD5Sign(no + e1 + e2 + timeMillis + Constants.OLD_KEY);
//                MiniLog.e("准备上报老游戏广告数据："+sign);
//                gamePlayViewModel.receiveOldGameReward(no, timeMillis,e1,e2,sign);
//            }else{
//                String signature = Tools.Companion.getMD5Sign(no + currAdsNum + Constants.TOKEN + Constants.NEW_KEY + timeMillis);
//                MiniLog.e("准备上报新游戏广告数据："+signature);
//                gamePlayViewModel.receiveNewGameReward(no,timeMillis,action,String.valueOf(currAdsNum),signature);
//            }
//        }
//    }

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
}
