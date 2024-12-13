package com.iejnnnmokkk.funnyplay.game;

import com.iejnnnmokkk.funnyplay.game.bean.GameBean;
import com.iejnnnmokkk.funnyplay.game.bean.UserInfoBean;

/**
 * @author Sun
 * @Demo class IGameView
 * @Description TODO
 * @date 2024/12/12 17:35
 */
public interface IGameView {

    void getFavourite(GameBean bean);
    void getMost(GameBean bean);
    void getNew(GameBean bean);
    void getUserInfo(UserInfoBean bean);
    void onFailed(String msg);
}
