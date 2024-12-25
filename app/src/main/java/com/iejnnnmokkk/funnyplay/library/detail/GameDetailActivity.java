package com.iejnnnmokkk.funnyplay.library.detail;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
    private GameDetailBean.DataBean bean = new GameDetailBean.DataBean();

    private boolean isGet = true;

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
    protected void onResume() {
        super.onResume();
        if (isGet) {
            pageNum = 1;
            presenter.getData(pageNum, id);
        }
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
        if (bean != null && bean.getData() != null) {
            this.bean = bean.getData();
            if (bean.getData().getAll() != null && !bean.getData().getAll().isEmpty()) {
                adapter.setData(bean.getData().getAll().get(0).getData(), pageNum == 1);
            }
            adapter.setHeaderBean(bean.getData());
            isGet = bean.getData().getIs_get() == 1;
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

    @OnClick({R.id.iv_back, R.id.tv_play})
    public void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_play:
                if (!TextUtils.isEmpty(bean.getPackage_name())) {
                    if (bean.getPackage_name().equalsIgnoreCase("h5")) {

                    } else {
                        launchAppByPackageName(context, getNull(bean.getApp_url()));
                    }
                }
                break;
        }
    }

    public static void launchAppByPackageName(Context context, String packageName) {
        if (context == null || packageName == null || packageName.isEmpty()) {
            Toast.makeText(context, "无效的包名或上下文", Toast.LENGTH_SHORT).show();
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage(packageName);

        if (intent != null) {
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "未安装目标应用", Toast.LENGTH_SHORT).show();
            openAppInPlayStore(context, packageName);
        }
    }

    private static void openAppInPlayStore(Context context, String packageName) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
