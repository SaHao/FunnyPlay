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
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.iejnnnmokkk.common.utils.PermissionUtils;
import com.iejnnnmokkk.common.utils.SharedPreferencesUtil;
import com.iejnnnmokkk.common.utils.ToastUtils;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.SpinnerStyle;

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
    protected SmartRefreshLayout refreshLayout;

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
        this.inflater = LayoutInflater.from(context);
        sharedPreferencesUtil = SharedPreferencesUtil.getInstance(context);
        return onInitView(container, savedInstanceState);
    }

    protected abstract View onInitView(@Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    protected abstract void initData();

    protected void initRefreshLayout(SmartRefreshLayout refreshLayout) {
        this.refreshLayout = refreshLayout;
        initSmartRefreshLayout();
    }

    private void initSmartRefreshLayout() {
        refreshLayout.setDisableContentWhenRefresh(true);
        refreshLayout.setDisableContentWhenLoading(true);
        refreshLayout.setRefreshHeader(new MaterialHeader(context));
        refreshLayout.setRefreshFooter(new ClassicsFooter(context).setSpinnerStyle(SpinnerStyle.Scale));
        refreshLayout.setNoMoreData(false);
    }

    protected void setLoadingListener(OnLoadingClickListener listener) {
        refreshLayout.setOnRefreshListener(refreshLayout -> {
            listener.onRefreshData();
        });

        refreshLayout.setOnLoadMoreListener(refreshLayout -> {
            listener.onLoadMoreData();
        });
    }

    protected String getNull(String content) {
        return !TextUtils.isEmpty(content) ? content : "";
    }

    protected interface OnLoadingClickListener {
        void onRefreshData();

        void onLoadMoreData();
    }

}
