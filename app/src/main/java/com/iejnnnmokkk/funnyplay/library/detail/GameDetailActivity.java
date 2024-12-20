package com.iejnnnmokkk.funnyplay.library.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.iejnnnmokkk.common.base.BaseActivity;
import com.iejnnnmokkk.funnyplay.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameDetailActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.iv_background)
    ImageView ivBackground;
    @BindView(R.id.iv_logo)
    RoundedImageView ivLogo;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_score)
    TextView tvScore;
    @BindView(R.id.view0)
    View view0;
    @BindView(R.id.tv_author)
    TextView tvAuthor;
    @BindView(R.id.ll_light)
    LinearLayout llLight;
    @BindView(R.id.rv_task)
    RecyclerView rvTask;
    @BindView(R.id.rl_task)
    SmartRefreshLayout rlTask;
    @BindView(R.id.tv_play)
    TextView tvPlay;

    @Override
    protected void onInitView(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_ganme_detail);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {

    }
}
