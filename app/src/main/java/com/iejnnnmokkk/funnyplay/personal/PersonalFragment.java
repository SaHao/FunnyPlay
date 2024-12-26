package com.iejnnnmokkk.funnyplay.personal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.iejnnnmokkk.common.base.BaseFragment;
import com.iejnnnmokkk.common.utils.ToastUtils;
import com.iejnnnmokkk.funnyplay.R;
import com.iejnnnmokkk.funnyplay.game.bean.UserInfoBean;
import com.iejnnnmokkk.funnyplay.tools.LoadingUtil;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Sun
 * @Demo class HomeFragment
 * @Description TODO
 * @date 2024/12/9 13:52
 */
public class PersonalFragment extends BaseFragment implements IPersonalView {

    @BindView(R.id.iv_photo)
    RoundedImageView ivPhoto;
    @BindView(R.id.iv_photoBack)
    ImageView ivPhotoBack;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.rv_task)
    RecyclerView rvTask;
    @BindView(R.id.ll_task)
    LinearLayout llTask;

    private PersonalPresenter presenter;
    private PersonalAdapter adapter;

    @Override
    protected View onInitView(@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal, null);
        ButterKnife.bind(this, view);

        adapter = new PersonalAdapter(context);
        rvTask.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        rvTask.setAdapter(adapter);
        initData();
        return view;
    }

    @Override
    protected void initData() {
        presenter = new PersonalPresenter(this);
        LoadingUtil.showLoading(activity);
        presenter.getData(context);

        String user = sharedPreferencesUtil.getValue("user");
        if (!TextUtils.isEmpty(user)) {
            UserInfoBean bean = new Gson().fromJson(user, UserInfoBean.class);
            if (bean != null && bean.getData() != null) {
                Glide.with(context).load(getNull(bean.getData().getTouxiang())).into(ivPhoto);
                Glide.with(context).load(getNull(bean.getData().getFrame())).into(ivPhotoBack);
                tvName.setText(getNull(bean.getData().getNickname()));
            }
        }
    }

    @OnClick({R.id.cl_faq, R.id.cl_score, R.id.cl_policy})
    public void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.cl_faq:
                break;
            case R.id.cl_score:
                openGooglePlay();
                break;
            case R.id.cl_policy:
                break;
        }
    }

    @Override
    public void getData(PersonalBean bean) {
        LoadingUtil.hideLoading();
        if (bean != null && bean.getData() != null) {
            adapter.setData(bean.getData(), true);
        } else {
            llTask.setVisibility(View.GONE);
        }
    }

    @Override
    public void onFailed(String msg) {
        LoadingUtil.hideLoading();
        ToastUtils.showShort(context, msg);
    }

    public void openGooglePlay() {
        try {
            Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.android.vending");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (Exception e) {
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=" + context.getPackageName());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

}
