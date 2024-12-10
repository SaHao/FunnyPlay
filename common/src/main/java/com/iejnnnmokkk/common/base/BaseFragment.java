package com.iejnnnmokkk.common.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.iejnnnmokkk.common.utils.SharedPreferencesUtil;

/**
 * @author Sun
 * @Demo class BaseActivity
 * @Description TODO
 * @date 2024/12/5 11:15
 */
public abstract class BaseFragment extends Fragment {

    protected Context context;
    protected Activity activity;
    protected LayoutInflater inflater;
    protected SharedPreferencesUtil sharedPreferencesUtil;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflater = LayoutInflater.from(context);
        sharedPreferencesUtil = SharedPreferencesUtil.getInstance(context);
        return onInitView(container, savedInstanceState);
    }

    protected abstract View onInitView(@Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    protected abstract void initData();

    protected String getNull(String content) {
        if (!TextUtils.isEmpty(content)) {
            return content;
        }
        return "";
    }

}
