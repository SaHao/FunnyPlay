package com.iejnnnmokkk.funnyplay.personal;

import com.iejnnnmokkk.funnyplay.game.bean.GameBean;
import com.iejnnnmokkk.funnyplay.game.bean.UserInfoBean;

public interface IPersonalView {

    void getData(PersonalBean bean);
    void onFailed(String msg);
}
