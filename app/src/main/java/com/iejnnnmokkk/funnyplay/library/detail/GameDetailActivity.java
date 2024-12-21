package com.iejnnnmokkk.funnyplay.library.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.iejnnnmokkk.common.base.BaseActivity;
import com.iejnnnmokkk.common.utils.ToastUtils;
import com.iejnnnmokkk.funnyplay.R;
import com.iejnnnmokkk.funnyplay.tools.LoadingUtil;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameDetailActivity extends BaseActivity implements IGameDetailView {

    @BindView(R.id.rv_task)
    RecyclerView rvTask;
    @BindView(R.id.rl_task)
    SmartRefreshLayout rlTask;
    @BindView(R.id.tv_play)
    TextView tvPlay;

    private String id;
    private int pageNum = 1;
    private GameDetailPresenter presenter;
    private GameDetailAdapter adapter;

    @Override
    protected void onInitView(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_ganme_detail);
        ButterKnife.bind(this);

        presenter = new GameDetailPresenter(context, this);
        id = getIntent().getStringExtra("id");
        initRefreshLayout(rlTask);
        adapter = new GameDetailAdapter(context);
        rvTask.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        pageNum = 1;
        presenter.getData(pageNum, id);

        setLoadingListener(new OnLoadingClickListener() {
            @Override
            public void onRefreshData() {
                refreshLayout.finishRefresh(true);
                pageNum = 1;
                presenter.getData(pageNum, id);
            }

            @Override
            public void onLoadMoreData() {
                pageNum += 1;
                presenter.getData(pageNum, id);
            }
        });
    }

    @Override
    public void getData(GameDetailBean bean) {
        LoadingUtil.hideLoading();
        if (refreshLayout != null) {
            if (pageNum == 1) {
                refreshLayout.finishRefresh(true);
            } else {
                refreshLayout.finishLoadMoreWithNoMoreData();
            }
        }
//        if (bean != null && bean.getData() != null) {
//            adapter.setData(bean.getData(), pageNum == 1);
//        }
    }

    @Override
    public void onFailed(String msg) {
        ToastUtils.showShort(context, msg);
        LoadingUtil.hideLoading();
        if (refreshLayout != null) {
            if (pageNum == 1) {
                refreshLayout.finishRefresh(true);
            } else {
                refreshLayout.finishLoadMoreWithNoMoreData();
            }
        }
    }

    @OnClick({R.id.iv_back})
    public void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
