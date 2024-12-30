package com.iejnnnmokkk.funnyplay.library.detail;

public interface IGameDetailView {

    void getData(GameDetailBean bean);

    void getTask(GameDetailBean bean);

    void getTaskPrize(TaskPrizeBean bean);

    void onFailed(String msg);
}
