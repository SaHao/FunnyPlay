package com.iejnnnmokkk.funnyplay.library.detail;

import android.content.Context;

import com.iejnnnmokkk.common.http.BaseNetworkCallback;

public class GameDetailPresenter {

    private IGameDetailView view;
    private GameDetailModel model;

    public GameDetailPresenter(Context context, IGameDetailView view) {
        this.view = view;
        model = new GameDetailModel(context);
    }

    public void getData(int pageNum, String id) {
        model.getData(pageNum, id, new BaseNetworkCallback<GameDetailBean>() {
            @Override
            public void onSuccess(GameDetailBean bean) {
                view.getData(bean);
            }

            @Override
            public void onFailure(String error) {
                view.onFailed(error);
            }
        });
    }

    public void getTask(String id) {
        model.getTask(id, new BaseNetworkCallback<GameDetailBean>() {
            @Override
            public void onSuccess(GameDetailBean bean) {
                view.getTask(bean);
            }

            @Override
            public void onFailure(String error) {
                view.onFailed(error);
            }
        });
    }

    public void getTaskPrize(String id) {
        model.getTaskPrize(id, new BaseNetworkCallback<TaskPrizeBean>() {
            @Override
            public void onSuccess(TaskPrizeBean bean) {
                view.getTaskPrize(bean);
            }

            @Override
            public void onFailure(String error) {
                view.onFailed(error);
            }
        });
    }
}
