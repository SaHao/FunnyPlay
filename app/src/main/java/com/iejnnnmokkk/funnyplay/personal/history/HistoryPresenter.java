package com.iejnnnmokkk.funnyplay.personal.history;

import android.content.Context;

import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;

public class HistoryPresenter {

    private IHistoryView view;
    private HistoryModel model = new HistoryModel();

    public HistoryPresenter(IHistoryView view) {
        this.view = view;
    }

    public void getData(Context context, int pageNum) {
        model.getData(context, pageNum, new BaseNetworkCallback<HistoryBean>() {
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
