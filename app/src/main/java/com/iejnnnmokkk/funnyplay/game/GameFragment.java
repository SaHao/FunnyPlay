package com.iejnnnmokkk.funnyplay.game;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iejnnnmokkk.common.base.BaseFragment;
import com.iejnnnmokkk.funnyplay.R;
import com.iejnnnmokkk.funnyplay.game.bean.GameBean;
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

    @Override
    protected View onInitView(@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        fragment_game
        View view = inflater.inflate(R.layout.fragment_game, null);
        ButterKnife.bind(this, view);
        presenter = new GamePresenter(this);
        initRefreshLayout(rlGame);
        adapter = new GameAdapter(context);
        rvGame.setLayoutManager(new GridLayoutManager(context, 2));
        rvGame.setAdapter(adapter);
        return view;
    }

    @Override
    protected void initData() {

        setLoadingListener(new OnLoadingClickListener() {
            @Override
            public void onRefreshData() {
                refreshLayout.finishRefresh(true);
            }

            @Override
            public void onLoadMoreData() {
                refreshLayout.finishLoadMoreWithNoMoreData();
            }
        });
    }

    @Override
    public void getData(GameBean bean) {
        if(refreshLayout != null) {
            if(pageNum == 1) {
                refreshLayout.finishRefresh(true);
            } else {
                refreshLayout.finishLoadMoreWithNoMoreData();
            }
        }
    }

    @Override
    public void onFailed(String msg) {
        if(refreshLayout != null) {
            if(pageNum == 1) {
                refreshLayout.finishRefresh(true);
            } else {
                refreshLayout.finishLoadMoreWithNoMoreData();
            }
        }
    }
}
