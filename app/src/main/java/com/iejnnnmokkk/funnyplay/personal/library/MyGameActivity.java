package com.iejnnnmokkk.funnyplay.personal.library;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.iejnnnmokkk.common.base.BaseActivity;
import com.iejnnnmokkk.common.utils.ToastUtils;
import com.iejnnnmokkk.funnyplay.R;
import com.iejnnnmokkk.funnyplay.tools.LoadingUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyGameActivity extends BaseActivity implements IMyGameView {

    @BindView(R.id.rv_game)
    RecyclerView rvGame;

    private MyGamePresenter presenter;
    private MyGameAdapter adapter;

    @Override
    protected void onInitView(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_my_ganme);
        ButterKnife.bind(this);

        presenter = new MyGamePresenter(context, this);
        adapter = new MyGameAdapter(context);
        rvGame.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        LoadingUtil.showLoading(activity);
        presenter.getData();
    }


    @OnClick({R.id.iv_back})
    public void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    @Override
    public void getData(MyGameBean bean) {
        LoadingUtil.hideLoading();
        if(bean != null && bean.getData() != null) {
            adapter.setData(bean.getData(), true);
        }
    }

    @Override
    public void onFailed(String error) {
        LoadingUtil.hideLoading();
        ToastUtils.showShort(context, error);
    }
}
