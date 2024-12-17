package com.iejnnnmokkk.funnyplay.personal;

import com.iejnnnmokkk.common.http.BaseNetworkCallback;
import com.iejnnnmokkk.funnyplay.game.GameModel;
import com.iejnnnmokkk.funnyplay.game.IGameView;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;

public class PersonalPresenter {

    private IPersonalView view;

    public PersonalPresenter(IPersonalView view) {
        this.view = view;
    }

    private PersonalModel model = new PersonalModel();

    public void getData() {
        model.getData(new BaseNetworkCallback<PersonalBean>() {
            @Override
            public void onSuccess(PersonalBean bean) {
                view.getData(bean);
            }

            @Override
            public void onFailure(String error) {
                view.onFailed(error);
            }
        });
    }

}
