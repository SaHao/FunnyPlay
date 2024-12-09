package com.iejnnnmokkk.common.mvp;

/**
 * @author Sun
 * @Demo class IPresenter
 * @Description TODO
 * @date 2024/12/5 11:09
 */
public interface IPresenter<V extends BaseView, M> {
    void attachView(V view);
    void detachView();
    M getModel();
}

