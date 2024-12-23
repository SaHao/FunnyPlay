package com.iejnnnmokkk.funnyplay.personal.library;

import android.content.Context;

import com.iejnnnmokkk.common.http.BaseNetworkCallback;

public class MyGamePresenter {

    private IMyGameView view;
    private MyGameModel model;

    public MyGamePresenter(Context context, IMyGameView view) {
        this.view = view;
        model = new MyGameModel(context);
    }

    public void getData() {
        model.getData(new BaseNetworkCallback<MyGameBean>() {
            @Override
            public void onSuccess(MyGameBean bean) {
                view.getData(bean);
            }

            @Override
            public void onFailure(String error) {
                view.onFailed(error);
            }
        });
    }

}
