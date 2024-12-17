package com.iejnnnmokkk.funnyplay.personal;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iejnnnmokkk.common.base.BaseFragment;
import com.iejnnnmokkk.common.utils.ToastUtils;
import com.iejnnnmokkk.funnyplay.R;
import com.iejnnnmokkk.funnyplay.tools.LoadingUtil;

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
    ImageView ivPhoto;
    @BindView(R.id.iv_photoBack)
    ImageView ivPhotoBack;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.rv_task)
    RecyclerView rvTask;
    @BindView(R.id.cl_faq)
    ConstraintLayout clFaq;
    @BindView(R.id.cl_collect)
    ConstraintLayout clCollect;
    @BindView(R.id.cl_policy)
    ConstraintLayout clPolicy;

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
        presenter.getData();
    }

    @OnClick({R.id.cl_faq, R.id.cl_collect, R.id.cl_policy})
    public void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.cl_faq:
                break;
            case R.id.cl_collect:
                break;
            case R.id.cl_policy:
                break;
        }
    }

    @Override
    public void getData(PersonalBean bean) {
        LoadingUtil.hideLoading();
        if(bean != null) {

        }
    }

    @Override
    public void onFailed(String msg) {
        LoadingUtil.hideLoading();
        ToastUtils.showShort(context, msg);
    }
}
