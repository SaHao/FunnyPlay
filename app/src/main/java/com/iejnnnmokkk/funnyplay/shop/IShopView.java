package com.iejnnnmokkk.funnyplay.shop;

import com.iejnnnmokkk.funnyplay.game.bean.UserInfoBean;

/**
 * @author Sun
 * @Demo class IShopView
 * @Description TODO
 * @date 2024/12/18 16:05
 */
public interface IShopView {

    void getData(ShopBean bean);

    void buy(ShopBean bean);

    void use(ShopBean bean);

    void getUserInfo(UserInfoBean bean);

    void onFailed(String msg);
}
