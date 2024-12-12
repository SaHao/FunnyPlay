package com.iejnnnmokkk.funnyplay.game;

import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;
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

    public GamePresenter(IGameView view) {
        this.view = view;
    }

    private GameModel model = new GameModel();

    public void achieve(int pageNum) {
        model.getData(pageNum, new BaseNetworkCallback<GameBean>() {
            @Override
            public void onSuccess(GameBean bean) {
                view.getData(bean);
            }

            @Override
            public void onFailure(String error) {
                view.onFailed(error);
            }
        });
    }
}
