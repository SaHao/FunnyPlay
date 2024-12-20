package com.iejnnnmokkk.funnyplay.shop;

import android.content.Context;

import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;
import com.iejnnnmokkk.funnyplay.game.bean.UserInfoBean;

/**
 * @author Sun
 * @Demo class ShopPresenter
 * @Description TODO
 * @date 2024/12/19 09:30
 */
public class ShopPresenter {

    private IShopView view;
    private ShopModel model;

    public ShopPresenter(IShopView view, Context context) {
        this.view = view;
        model = new ShopModel(context);
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
