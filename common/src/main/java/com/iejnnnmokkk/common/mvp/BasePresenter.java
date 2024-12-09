package com.iejnnnmokkk.common.mvp;

/**
 * @author Sun
 * @Demo class BasePresenter
 * @Description TODO
 * @date 2024/12/5 11:10
 */
public abstract class BasePresenter<V extends BaseView, M> implements IPresenter<V, M> {
    protected V view;
    protected M model;

    public BasePresenter() {
        this.model = createModel();
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public M getModel() {
        return model;
    }

    protected abstract M createModel();
}

