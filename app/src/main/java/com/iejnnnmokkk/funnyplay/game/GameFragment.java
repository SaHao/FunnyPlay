package com.iejnnnmokkk.funnyplay.game;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.iejnnnmokkk.common.base.BaseFragment;
import com.iejnnnmokkk.funnyplay.R;
import com.iejnnnmokkk.funnyplay.view.CircleWaveProgressView;

import butterknife.ButterKnife;

/**
 * @author Sun
 * @Demo class HomeFragment
 * @Description TODO
 * @date 2024/12/9 13:52
 */
public class GameFragment extends BaseFragment {

    @Override
    protected View onInitView(@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        fragment_game
        View view = inflater.inflate(R.layout.header_game, null);
        ButterKnife.bind(this, view);
        CircleWaveProgressView progressView = view.findViewById(R.id.cp_task);
        progressView.setCircleColor(Color.RED)
                .setWaveColor(Color.BLUE)
                .setTextColor(Color.WHITE)
                .setTextSize(40f)
                .setProgress(50)
                .startAnimation();
        return view;
    }

    @Override
    protected void initData() {
//        refreshLayout = rl;
//        rv.setLayoutManager(new LinearLayoutManager(context));
//        rv.setAdapter(adapter);
//
//        refreshData(true);
//        initSmartRefreshLayout();
//        setLoadingListener(new OnLoadingClickListener() {
//            @Override
//            public void onRefreshData() {
//                refreshData(true);
//                refreshLayout.finishRefresh(true);
//            }
//
//            @Override
//            public void onLoadMoreData() {
//                refreshData(false);
//                refreshLayout.finishLoadMoreWithNoMoreData();
//            }
//        });
    }
}
