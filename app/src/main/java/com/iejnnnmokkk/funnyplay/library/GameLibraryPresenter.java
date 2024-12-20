package com.iejnnnmokkk.funnyplay.library;

import android.content.Context;

import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;

/**
 * @author Sun
 * @Demo class GameLibraryPresenter
 * @Description TODO
 * @date 2024/12/20 17:21
 */
public class GameLibraryPresenter {

    private IGameLibraryView view;
    private GameLibraryModel model;

    public GameLibraryPresenter(Context context, IGameLibraryView view) {
        this.view = view;

        model = new GameLibraryModel(context);
    }

    public void getData(int pageNum, int type) {
        model.getData(pageNum, type, new BaseNetworkCallback<GameLibraryBean>() {
            @Override
            public void onSuccess(GameLibraryBean bean) {
                view.getData(bean);
            }

            @Override
            public void onFailure(String error) {
                view.onFailed(error);
            }
        });
    }
}
