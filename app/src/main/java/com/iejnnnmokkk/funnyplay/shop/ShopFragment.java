package com.iejnnnmokkk.funnyplay.shop;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.iejnnnmokkk.common.base.BaseFragment;
import com.iejnnnmokkk.funnyplay.R;
import com.iejnnnmokkk.funnyplay.view.CircleWaveProgressView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Sun
 * @Demo class HomeFragment
 * @Description TODO
 * @date 2024/12/9 13:52
 */
public class ShopFragment extends BaseFragment {

    @BindView(R.id.cp_task)
    public CircleWaveProgressView cpTask;
    @BindView(R.id.tv_taskNum)
    public TextView tvTaskNum;
    @BindView(R.id.ll_task)
    public LinearLayout llTask;
    @BindView(R.id.iv_photo)
    public ImageView ivPhoto;
    @BindView(R.id.iv_photoBack)
    public ImageView ivPhotoBack;
    @BindView(R.id.tv_money)
    public TextView tvMoney;
    @BindView(R.id.rv_avatar)
    public RecyclerView rvAvatar;
    @BindView(R.id.rv_frame)
    public RecyclerView rvFrame;

    private AvatarAdapter avatarAdapter;
    private FrameAdapter frameAdapter;

    @Override
    protected View onInitView(@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping, null);
        ButterKnife.bind(this, view);

        initData();
        return view;
    }

    @Override
    protected void initData() {

    }
}
