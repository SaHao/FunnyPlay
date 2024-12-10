package com.iejnnnmokkk.funnyplay.game;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.iejnnnmokkk.common.base.BaseFragment;
import com.iejnnnmokkk.funnyplay.R;

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
        View view = inflater.inflate(R.layout.fragment_game, null);
        ButterKnife.bind(this, view);
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
