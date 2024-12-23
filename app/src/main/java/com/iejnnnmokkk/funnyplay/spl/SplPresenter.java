package com.iejnnnmokkk.funnyplay.spl;

import android.content.Context;

import com.iejnnnmokkk.common.http.BaseNetworkCallback;

/**
 * @author Sun
 * @Demo class SplPresenter
 * @Description TODO
 * @date 2024/12/10 15:00
 */
public class SplPresenter {

    private SplView view;

    public SplPresenter(SplView view) {
        this.view = view;
    }

    private SplModel model = new SplModel();

    public void achieve(Context context) {
        model.achieve(context, new BaseNetworkCallback<SplBean>() {
            @Override
            public void onSuccess(SplBean bean) {
                view.onAchieve(bean);
            }

            @Override
            public void onFailure(String error) {
                view.onFailed(error);
            }
        });
    }

    public void login(Context context) {
        model.login(context,new BaseNetworkCallback<LoginBean>() {
            @Override
            public void onSuccess(LoginBean bean) {
                view.onLogin(bean);
            }

            @Override
            public void onFailure(String error) {
                view.onFailed(error);
            }
        });
    }
}
