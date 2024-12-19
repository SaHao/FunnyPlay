package com.iejnnnmokkk.funnyplay.shop;

import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;

/**
 * @author Sun
 * @Demo class ShopPresenter
 * @Description TODO
 * @date 2024/12/19 09:30
 */
public class ShopPresenter {

    private IShopView view;
    private ShopModel model = new ShopModel();

    public ShopPresenter(IShopView view) {
        this.view = view;
    }

    public void getData() {
        model.getData(new BaseNetworkCallback<ShopBean>() {
            @Override
            public void onSuccess(ShopBean bean) {
                view.getData(bean);
            }

            @Override
            public void onFailure(String error) {
                view.onFailed(error);
            }
        });
    }

    public void buy(int pid) {
        model.buy(pid, new BaseNetworkCallback<ShopBean>() {
            @Override
            public void onSuccess(ShopBean bean) {
                view.buy(bean);
            }

            @Override
            public void onFailure(String error) {
                view.onFailed(error);
            }
        });
    }

    public void use(int pid) {
        model.use(pid, new BaseNetworkCallback<ShopBean>() {
            @Override
            public void onSuccess(ShopBean bean) {
                view.use(bean);
            }

            @Override
            public void onFailure(String error) {
                view.onFailed(error);
            }
        });
    }
}
