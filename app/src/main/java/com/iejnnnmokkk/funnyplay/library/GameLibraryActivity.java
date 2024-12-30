package com.iejnnnmokkk.funnyplay.library;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iejnnnmokkk.common.base.BaseActivity;
import com.iejnnnmokkk.common.utils.ToastUtils;
import com.iejnnnmokkk.funnyplay.R;
import com.iejnnnmokkk.funnyplay.tools.LoadingUtil;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Sun
 * @Demo class GameLibraryActivity
 * @Description TODO
 * @date 2024/12/20 17:06
 */
public class GameLibraryActivity extends BaseActivity implements IGameLibraryView {
    
    @BindView(R.id.rv_game)
    RecyclerView rvGame;
    @BindView(R.id.rl_game)
    SmartRefreshLayout rlGame;

    private int pageNum = 1;
    private int type;
    private GameLibraryPresenter presenter;
    private GameLibraryAdapter adapter;

    @Override
    protected void onInitView(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_game_library);
        ButterKnife.bind(this);

        presenter = new GameLibraryPresenter(context, this);
        initRefreshLayout(rlGame);
        type = getIntent().getIntExtra("type", 0);

        adapter = new GameLibraryAdapter(context);
        rvGame.setLayoutManager(new GridLayoutManager(context, 3));
        rvGame.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        setLoadingListener(new OnLoadingClickListener() {
            @Override
            public void onRefreshData() {
                refreshLayout.finishRefresh(true);
                pageNum = 1;
                presenter.getData(pageNum, type);
            }

            @Override
            public void onLoadMoreData() {
                pageNum += 1;
                presenter.getData(pageNum, type);
            }
        });

        LoadingUtil.showLoading(activity);
        pageNum = 1;
        presenter.getData(pageNum, type);
    }

    @Override
    public void getData(GameLibraryBean bean) {
        LoadingUtil.hideLoading();
        if (refreshLayout != null) {
            if (pageNum == 1) {
                refreshLayout.finishRefresh(true);
            } else {
                refreshLayout.finishLoadMoreWithNoMoreData();
            }
        }
        if (bean != null && bean.getData() != null) {
            adapter.setData(bean.getData(), pageNum == 1);
        }
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
