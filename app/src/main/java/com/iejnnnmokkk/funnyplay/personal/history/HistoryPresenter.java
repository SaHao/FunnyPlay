package com.iejnnnmokkk.funnyplay.personal.history;

import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;

public class HistoryPresenter {

    private IHistoryView view;
    private HistoryModel model = new HistoryModel();

    public HistoryPresenter(IHistoryView view) {
        this.view = view;
    }

    public void getData(int pageNum) {
        model.getData(pageNum, new BaseNetworkCallback<HistoryBean>() {
            @Override
            public void onSuccess(HistoryBean bean) {
                view.getData(bean);
            }

            @Override
            public void onFailure(String error) {
                view.onFailed(error);
            }
        });
    }
}
