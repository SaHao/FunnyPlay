package com.iejnnnmokkk.funnyplay.spl;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.iejnnnmokkk.common.base.BaseActivity;
import com.iejnnnmokkk.common.utils.SharedPreferencesUtil;
import com.iejnnnmokkk.common.utils.ToastUtils;
import com.iejnnnmokkk.funnyplay.MainActivity;
import com.iejnnnmokkk.funnyplay.R;
import com.iejnnnmokkk.funnyplay.tools.LoadingUtil;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Sun
 * @Demo class SplActivity
 * @Description TODO
 * @date 2024/12/10 13:52
 */
public class SplActivity extends BaseActivity implements SplView {

    @BindView(R.id.tv_achieve)
    TextView tv_achieve;

    private SplPresenter presenter;

    @Override
    protected void onInitView(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_spl);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        presenter = new SplPresenter(this);
        if (getNull(sharedPreferencesUtil.getValue("agree")).equals("1")) {
            startActivity(new Intent(context, MainActivity.class));
            finish();
        } else {
            LoadingUtil.showLoading(activity);
            Observable.create(new ObservableOnSubscribe<String>() {
                        @Override
                        public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                            String gaid = fetchAndStoreGAID();
                            emitter.onNext(gaid);
                        }
                    }).observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Consumer<String>() {
                        @Override
                        public void accept(String s) throws Exception {
                            LoadingUtil.showLoading(activity);
                            presenter.login(activity);
                        }
                    });
        }
    }

    @OnClick({R.id.tv_achieve})
    public void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.tv_achieve:
                if (TextUtils.isEmpty(sharedPreferencesUtil.getValue("token"))) {
                    ToastUtils.showShort(context, "登录失败，正在重新登录...");
                    LoadingUtil.showLoading(activity);
                    presenter.login(activity);
                } else {
                    LoadingUtil.showLoading(activity);
                    presenter.achieve(context);
                }
                break;
        }
    }

    @Override
    public void onLogin(LoginBean bean) {
        LoadingUtil.hideLoading();
        if (bean != null && bean.getData() != null) {
            sharedPreferencesUtil.saveValue("uuid", bean.getData().getUuid());
            sharedPreferencesUtil.saveValue("isSignInFirst", "1");
            sharedPreferencesUtil.saveValue("token", getNull(bean.getData().getToken()));
        }
    }

    @Override
    public void onAchieve(SplBean bean) {
        LoadingUtil.hideLoading();
        if (bean.getCode() == 200) {
            ToastUtils.showShort(context, "领取成功");
            sharedPreferencesUtil.saveValue("agree", "1");
            startActivity(new Intent(context, MainActivity.class));
            finish();
        }
    }

    @Override
    public void onFailed(String msg) {
        LoadingUtil.hideLoading();
        ToastUtils.showShort(context, msg);
    }

    private String fetchAndStoreGAID() {
        while (true) {
            try {
                AdvertisingIdClient.Info adInfo = AdvertisingIdClient.getAdvertisingIdInfo(this);
                String gaid = adInfo.getId();
                if (gaid != null && !gaid.isEmpty()) {
                    SharedPreferencesUtil.getInstance(getApplicationContext()).saveValue("gaid", gaid);
                    return gaid;
                }
            } catch (IOException | GooglePlayServicesNotAvailableException |
                     GooglePlayServicesRepairableException e) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
