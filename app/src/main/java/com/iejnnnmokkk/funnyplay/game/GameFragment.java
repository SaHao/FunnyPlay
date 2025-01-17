package com.iejnnnmokkk.funnyplay.game;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iejnnnmokkk.common.base.BaseFragment;
import com.iejnnnmokkk.common.utils.ToastUtils;
import com.iejnnnmokkk.funnyplay.R;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;
import com.iejnnnmokkk.funnyplay.game.bean.UserInfoBean;
import com.iejnnnmokkk.funnyplay.personal.PersonalBean;
import com.iejnnnmokkk.funnyplay.tools.LoadingUtil;
import com.iejnnnmokkk.funnyplay.view.SignInBean;
import com.iejnnnmokkk.funnyplay.view.SignInDialog;
import com.iejnnnmokkk.funnyplay.view.SignInSuccessDialog;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Sun
 * @Demo class HomeFragment
 * @Description TODO
 * @date 2024/12/9 13:52
 */
public class GameFragment extends BaseFragment implements IGameView {

    @BindView(R.id.rv_game)
    public RecyclerView rvGame;
    @BindView(R.id.rl_game)
    public SmartRefreshLayout rlGame;

    private GameAdapter adapter;
    private GamePresenter presenter;
    private int pageNum = 1;
    private int mMoney;

    private SignInDialog dialog;
    private SignInSuccessDialog successDialog;
    private OnShoppingClickListener listener;
    private SignInBean.DataBean signData = new SignInBean.DataBean();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnShoppingClickListener) {
            listener = (OnShoppingClickListener) context;
        }
    }

    @Override
    protected View onInitView(@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, null);
        ButterKnife.bind(this, view);

        dialog = new SignInDialog(activity, R.style.myDialog);
        successDialog = new SignInSuccessDialog(activity, R.style.myDialog);
        presenter = new GamePresenter(context, this);
        initRefreshLayout(rlGame);
        adapter = new GameAdapter(activity);
        GridLayoutManager layoutManager = new GridLayoutManager(context, 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == 0 ? 2 : 1;
            }
        });
        rvGame.setLayoutManager(layoutManager);
        rvGame.setAdapter(adapter);
        adapter.setListener(new GameAdapter.OnShopClickListener() {
            @Override
            public void onShopClick() {
                listener.onShoppingClick();
            }

            @Override
            public void onSignInClick() {
                dialog.show();
                dialog.setData(signData);
                dialog.setListener((id, money) -> {
                    mMoney = money;
                    LoadingUtil.showLoading(activity);
                    presenter.signIn(id);
                });
            }
        });
        initData();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        LoadingUtil.showLoading(activity);
        pageNum = 1;
//        presenter.getFavourite(pageNum, 26);
//        presenter.getMost(pageNum, 27);
        presenter.getNew(pageNum, 28);
        presenter.getUserInfo(context);
        presenter.getRecentlyData();
    }

    @Override
    protected void initData() {
        presenter.getSignInData();
        setLoadingListener(new OnLoadingClickListener() {
            @Override
            public void onRefreshData() {
                refreshLayout.finishRefresh(true);
                pageNum = 1;
//                presenter.getFavourite(pageNum, 26);
//                presenter.getMost(pageNum, 27);
                presenter.getNew(pageNum, 28);
                presenter.getUserInfo(context);
                presenter.getRecentlyData();
                presenter.getSignInData();
            }

            @Override
            public void onLoadMoreData() {
                pageNum += 1;
                presenter.getNew(pageNum, 28);
            }
        });
    }

    @Override
    public void getFavourite(GameBean bean) {
        LoadingUtil.hideLoading();
        if (bean != null && bean.getData() != null) {
            adapter.setFavouriteData(bean.getData());
        }
    }

    @Override
    public void getMost(GameBean bean) {
        LoadingUtil.hideLoading();
        if (bean != null && bean.getData() != null) {
            adapter.setMostData(bean.getData());
        }
    }

    @Override
    public void getNew(GameBean bean) {
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
    public void getUserInfo(UserInfoBean bean) {
        LoadingUtil.hideLoading();
        if (bean != null) {
            adapter.setUserInfo(bean.getData());
        }
    }

    /**
     * 签到数据
     *
     * @param bean
     */
    @Override
    public void getSignInData(SignInBean bean) {
        LoadingUtil.hideLoading();
        if (bean != null && bean.getData() != null) {
            this.signData = bean.getData();
            adapter.setSignInData(bean.getData());
        }
    }

    /**
     * 签到
     *
     * @param bean
     */
    @Override
    public void signIn(SignInBean bean) {
        LoadingUtil.hideLoading();
        if (bean.getCode() == 200) {
            presenter.getUserInfo(context);
            sharedPreferencesUtil.saveValue("isSignInFirst", "0");
            successDialog.show();
            successDialog.setMoney(mMoney);
            dialog.dismiss();
            signData.setDayli_flag(1);
            adapter.notifyDataSetChanged();
        } else {
            ToastUtils.showShort(context, bean.getMsg());
        }
    }

    /**
     * 最近试玩
     *
     * @param bean
     */
    @Override
    public void getRecentlyData(PersonalBean bean) {
        if (bean != null && bean.getData() != null) {
            adapter.setPersonalBean(bean.getData());
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

    public interface OnShoppingClickListener {
        void onShoppingClick();
    }
}
