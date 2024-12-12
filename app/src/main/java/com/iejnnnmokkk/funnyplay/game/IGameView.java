package com.iejnnnmokkk.funnyplay.game;

import com.iejnnnmokkk.funnyplay.game.bean.GameBean;

/**
 * @author Sun
 * @Demo class IGameView
 * @Description TODO
 * @date 2024/12/12 17:35
 */
public interface IGameView {

    void getData(GameBean bean);
    void onFailed(String msg);
}
