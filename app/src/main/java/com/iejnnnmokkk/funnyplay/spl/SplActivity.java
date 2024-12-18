package com.iejnnnmokkk.funnyplay.spl;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.iejnnnmokkk.common.base.BaseActivity;
import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.common.utils.ToastUtils;
import com.iejnnnmokkk.funnyplay.MainActivity;
import com.iejnnnmokkk.funnyplay.R;
import com.iejnnnmokkk.funnyplay.tools.LoadingUtil;

import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
            presenter.login();
        }
    }

    @OnClick({R.id.tv_achieve})
    public void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.tv_achieve:
                if (TextUtils.isEmpty(sharedPreferencesUtil.getValue("token"))) {
                    ToastUtils.showShort(context, "登录失败，正在重新登录...");
                    LoadingUtil.showLoading(activity);
                    presenter.login();
                } else {
                    startActivity(new Intent(context, MainActivity.class));
                    finish();
                }
                break;
        }
    }

    @Override
    public void onLogin(LoginBean bean) {
        LoadingUtil.hideLoading();
        if (bean != null && bean.getData() != null) {
            sharedPreferencesUtil.saveValue("token", getNull(bean.getData().getToken()));
            LoadingUtil.showLoading(activity);
            presenter.achieve();
        }
    }

    @Override
    public void onAchieve(SplBean bean) {
        LoadingUtil.hideLoading();
        ToastUtils.showShort(context, "领取成功");
        sharedPreferencesUtil.saveValue("agree", "1");

    }

    @Override
    public void onFailed(String msg) {
        LoadingUtil.hideLoading();
        ToastUtils.showShort(context, msg);
    }
}
