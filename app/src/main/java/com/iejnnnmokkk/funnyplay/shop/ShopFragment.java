package com.iejnnnmokkk.funnyplay.shop;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.iejnnnmokkk.common.base.BaseFragment;
import com.iejnnnmokkk.funnyplay.R;

import butterknife.ButterKnife;

/**
 * @author Sun
 * @Demo class HomeFragment
 * @Description TODO
 * @date 2024/12/9 13:52
 */
public class ShopFragment extends BaseFragment {

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
