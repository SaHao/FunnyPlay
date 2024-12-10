package com.iejnnnmokkk.common.base;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.iejnnnmokkk.common.utils.PermissionUtils;
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
public abstract class BaseActivity extends AppCompatActivity {

    protected Context context;
    protected Activity activity;
    protected SmartRefreshLayout refreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = activity = this;
        EdgeToEdge.enable(this);
        onInitView(savedInstanceState);
        initData();
    }

    protected abstract void onInitView(@Nullable Bundle savedInstanceState);

    protected abstract void initData();

    protected void initPermission(String... params) {
        PermissionUtils.requestPermissions(this, params, new PermissionUtils.PermissionCallback() {
            @Override
            public void onPermissionGranted(String permission) {
                ToastUtils.showShort(context, "权限被授予");
            }

            @Override
            public void onPermissionDenied(String permission) {
                ToastUtils.showShort(context, "权限已被拒绝");
            }

            @Override
            public void onPermissionDeniedForever(String permission) {
                ToastUtils.showShort(context, "权限被拒绝，请到设置页面进行操作");
            }
        });
    }

    protected void initSmartRefreshLayout() {
        refreshLayout.setDisableContentWhenRefresh(true);
        refreshLayout.setDisableContentWhenLoading(true);
        refreshLayout.setRefreshHeader(new MaterialHeader(this));
        refreshLayout.setRefreshFooter(new ClassicsFooter(this).setSpinnerStyle(SpinnerStyle.Scale));
        refreshLayout.setNoMoreData(false);
    }

    protected void setLoadingListener(OnLoadingClickListener listener) {
        refreshLayout.setOnRefreshListener(refreshLayout -> {
            listener.onRefreshData();
//            if (refreshLayout != null) {
//                refreshLayout.finishRefresh(true);
//            }
        });

        refreshLayout.setOnLoadMoreListener(refreshLayout -> {
            listener.onLoadMoreData();
//            if (refreshLayout != null) {
//                refreshLayout.finishLoadMoreWithNoMoreData();
//            }
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
