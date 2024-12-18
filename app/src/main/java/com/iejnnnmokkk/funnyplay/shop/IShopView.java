package com.iejnnnmokkk.funnyplay.shop;

import com.iejnnnmokkk.funnyplay.game.bean.GameBean;

/**
 * @author Sun
 * @Demo class IShopView
 * @Description TODO
 * @date 2024/12/18 16:05
 */
public interface IShopView {

    void getData(GameBean bean);

    void onFailed(String msg);
}
