package com.iejnnnmokkk.funnyplay.play;

import android.content.Context;

import com.iejnnnmokkk.common.http.BaseNetworkCallback;

public class GamePlayPresenter {

    private IGamePlayView view;
    private GamePlayModel model;

    public GamePlayPresenter(Context context, IGamePlayView view) {
        this.view = view;
        model = new GamePlayModel(context);
    }

    public void getData(int pageNum, String id) {
        model.getData(pageNum, id, new BaseNetworkCallback<GamePlayBean>() {
            @Override
            public void onSuccess(GamePlayBean bean) {
                view.getData(bean);
            }

            @Override
            public void onFailure(String error) {
                view.onFailed(error);
            }
        });
    }
    public void getTask(String id) {
        model.getTask(id, new BaseNetworkCallback<GamePlayBean>() {
            @Override
            public void onSuccess(GamePlayBean bean) {
                view.getData(bean);
            }

            @Override
            public void onFailure(String error) {
                view.onFailed(error);
            }
        });
    }
}
