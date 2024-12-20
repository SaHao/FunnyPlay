package com.iejnnnmokkk.funnyplay.personal.history;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.iejnnnmokkk.common.base.BaseActivity;
import com.iejnnnmokkk.common.base.BaseFragment;
import com.iejnnnmokkk.common.utils.ToastUtils;
import com.iejnnnmokkk.funnyplay.R;
import com.iejnnnmokkk.funnyplay.tools.LoadingUtil;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryActivity extends BaseActivity implements IHistoryView {

    @BindView(R.id.imageView0)
    ImageView imageView0;
    @BindView(R.id.imageView1)
    ImageView imageView1;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.textView0)
    TextView textView0;
    @BindView(R.id.rv_history)
    RecyclerView rvHistory;
    @BindView(R.id.rl_history)
    SmartRefreshLayout rlHistory;

    private int pageNum = 1;
    private HistoryPresenter presenter;
    private HistoryAdapter adapter;

    @Override
    protected void onInitView(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
        presenter = new HistoryPresenter(this);
        adapter = new HistoryAdapter(context);
        rvHistory.setAdapter(adapter);

        initRefreshLayout(rlHistory);
    }

    @Override
    protected void initData() {
        LoadingUtil.showLoading(activity);
        presenter.getData(context, pageNum);

        setLoadingListener(new OnLoadingClickListener() {
            @Override
            public void onRefreshData() {
                refreshLayout.finishRefresh(true);
                pageNum = 1;
                presenter.getData(context, pageNum);
            }

            @Override
            public void onLoadMoreData() {
                refreshLayout.finishLoadMoreWithNoMoreData();
            }
        });

        pageNum = 1;
        presenter.getData(context, pageNum);
    }

    @Override
    public void getData(HistoryBean bean) {
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
}
