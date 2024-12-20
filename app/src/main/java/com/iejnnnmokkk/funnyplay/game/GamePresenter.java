package com.iejnnnmokkk.funnyplay.game;

import android.content.Context;

import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;
import com.iejnnnmokkk.funnyplay.game.bean.UserInfoBean;
import com.iejnnnmokkk.funnyplay.spl.LoginBean;
import com.iejnnnmokkk.funnyplay.spl.SplBean;
import com.iejnnnmokkk.funnyplay.spl.SplModel;
import com.iejnnnmokkk.funnyplay.spl.SplView;

/**
 * @author Sun
 * @Demo class SplPresenter
 * @Description TODO
 * @date 2024/12/10 15:00
 */
public class GamePresenter {

    private IGameView view;
    private GameModel model;

    public GamePresenter(Context context, IGameView view) {
        this.view = view;
        model = new GameModel(context);
    }

    public void getFavourite(int pageNum, int type) {
        model.getData(pageNum, type, new BaseNetworkCallback<GameBean>() {
            @Override
            public void onSuccess(GameBean bean) {
                view.getFavourite(bean);
            }

            @Override
            public void onFailure(String error) {
                view.onFailed(error);
            }
        });
    }

    public void getMost(int pageNum, int type) {
        model.getData(pageNum, type, new BaseNetworkCallback<GameBean>() {
            @Override
            public void onSuccess(GameBean bean) {
                view.getMost(bean);
            }

            @Override
            public void onFailure(String error) {
                view.onFailed(error);
            }
        });
    }

    public void getNew(int pageNum, int type) {
        model.getData(pageNum, type, new BaseNetworkCallback<GameBean>() {
            @Override
            public void onSuccess(GameBean bean) {
                view.getNew(bean);
            }

            @Override
            public void onFailure(String error) {
                view.onFailed(error);
            }
        });
    }

    public void getUserInfo(Context context) {
        model.getUserInfo(context, new BaseNetworkCallback<UserInfoBean>() {
            @Override
            public void onSuccess(UserInfoBean bean) {
                view.getUserInfo(bean);
            }

            @Override
            public void onFailure(String error) {
                view.onFailed(error);
            }
        });
    }
}
