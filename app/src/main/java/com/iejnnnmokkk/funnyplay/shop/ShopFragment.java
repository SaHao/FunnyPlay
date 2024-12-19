package com.iejnnnmokkk.funnyplay.shop;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.iejnnnmokkk.common.base.BaseFragment;
import com.iejnnnmokkk.common.utils.ToastUtils;
import com.iejnnnmokkk.funnyplay.R;
import com.iejnnnmokkk.funnyplay.game.GameAdapter;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;
import com.iejnnnmokkk.funnyplay.game.bean.UserInfoBean;
import com.iejnnnmokkk.funnyplay.tools.LoadingUtil;
import com.iejnnnmokkk.funnyplay.view.CircleWaveProgressView;
import com.iejnnnmokkk.funnyplay.view.WarningDialog;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Sun
 * @Demo class HomeFragment
 * @Description TODO
 * @date 2024/12/9 13:52
 */
public class ShopFragment extends BaseFragment implements IShopView {

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

    private ShopPresenter presenter;
    private AvatarAdapter avatarAdapter;
    private FrameAdapter frameAdapter;

    private WarningDialog dialog;

    @Override
    protected View onInitView(@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping, null);
        ButterKnife.bind(this, view);

        dialog = new WarningDialog(context, R.style.myDialog);
        presenter = new ShopPresenter(this);
        avatarAdapter = new AvatarAdapter(context);
        rvAvatar.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        rvAvatar.setAdapter(avatarAdapter);
        frameAdapter = new FrameAdapter(context);
        rvFrame.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        rvFrame.setAdapter(frameAdapter);

        initData();
        return view;
    }

    @Override
    protected void initData() {
        LoadingUtil.showLoading(activity);
        presenter.getData();

        String user = sharedPreferencesUtil.getValue("user");
        if (!TextUtils.isEmpty(user)) {
            UserInfoBean bean = new Gson().fromJson(user, UserInfoBean.class);
            if (bean != null && bean.getData() != null) {
                setProgressBar(cpTask, bean.getData().getWelfare_5_star_reward(), bean.getData().getWelfare_5_star_reward() + bean.getData().getWelfare_complete_sum());
                tvTaskNum.setText(setPercent(bean.getData().getWelfare_5_star_reward(), bean.getData().getWelfare_5_star_reward() + bean.getData().getWelfare_complete_sum()));
                Glide.with(context).load(getNull(bean.getData().getTouxiang())).into(ivPhoto);
                Glide.with(context).load(getNull(bean.getData().getAvatar())).into(ivPhotoBack);
            }
        }

        frameAdapter.setListener((bean, type) -> {
            if(type.equals("use")) {
                presenter.use(bean.getGid());
            } else if(type.equals("buy")) {
                dialog.show();
                dialog.setMoney(bean.getCoins() + "");
                dialog.setListener(index -> {
                    if(index == 1) {
                        presenter.buy(bean.getGid());
                    }
                });
            }
        });

        avatarAdapter.setListener((bean, type) -> {
            if(type.equals("use")) {
                presenter.use(bean.getGid());
            } else if(type.equals("buy")) {
                dialog.show();
                dialog.setMoney(bean.getCoins() + "");
                dialog.setListener(index -> {
                    if(index == 1) {
                        presenter.buy(bean.getGid());
                    }
                });
            }
        });
    }

    @Override
    public void getData(ShopBean bean) {
        LoadingUtil.hideLoading();
        if(bean != null && bean.getData() != null) {
            if(bean.getData().getAvatar_goods() != null) {
                avatarAdapter.setData(bean.getData().getAvatar_goods(), true);
            }
            if(bean.getData().getFrame_goods() != null) {
                frameAdapter.setData(bean.getData().getFrame_goods(), true);
            }
        }
    }

    @Override
    public void buy(ShopBean bean) {
        if(bean.getCode() == 200) {
            presenter.getData();
        } else {
            LoadingUtil.hideLoading();
            ToastUtils.showShort(context, bean.getMsg());
        }
    }

    @Override
    public void use(ShopBean bean) {
        if(bean.getCode() == 200) {
            presenter.getData();
        } else {
            LoadingUtil.hideLoading();
            ToastUtils.showShort(context, bean.getMsg());
        }
    }

    @Override
    public void onFailed(String msg) {
        LoadingUtil.hideLoading();
        ToastUtils.showShort(context, msg);
    }

    private void setProgressBar(CircleWaveProgressView progressView, int progress, int max) {
        progressView.setCircleColor(context.getResources().getColor(R.color.progressCircle))
                .setWaveColor(context.getResources().getColor(R.color.progressCircle))
                .setTextColor(Color.WHITE)
                .setTextSize(40f)
                .setProgress(progress, max)
                .startAnimation();
    }

    private String setPercent(int numerator, int denominator) {
        if (denominator == 0) {
            return "0%";
        }
        int percentage = numerator * 100 / denominator;
        return percentage + "%";
    }
}
