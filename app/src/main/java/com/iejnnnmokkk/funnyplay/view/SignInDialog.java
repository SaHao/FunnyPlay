package com.iejnnnmokkk.funnyplay.view;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.iejnnnmokkk.common.utils.SharedPreferencesUtil;
import com.iejnnnmokkk.funnyplay.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Sun
 * @Demo class SignInDialog
 * @Description TODO
 * @date 2024/12/20 16:03
 */
public class SignInDialog extends Dialog {

    @BindView(R.id.tv_day1Num)
    TextView tvDay1Num;
    @BindView(R.id.cl_day1)
    ConstraintLayout clDay1;
    @BindView(R.id.tv_day2Num)
    TextView tvDay2Num;
    @BindView(R.id.cl_day2)
    ConstraintLayout clDay2;
    @BindView(R.id.tv_day3Num)
    TextView tvDay3Num;
    @BindView(R.id.cl_day3)
    ConstraintLayout clDay3;
    @BindView(R.id.tv_day4Num)
    TextView tvDay4Num;
    @BindView(R.id.tv_day5Num)
    TextView tvDay5Num;
    @BindView(R.id.cl_day5)
    ConstraintLayout clDay5;
    @BindView(R.id.tv_day6Num)
    TextView tvDay6Num;
    @BindView(R.id.cl_day6)
    ConstraintLayout clDay6;
    @BindView(R.id.tv_day7Num)
    TextView tvDay7Num;
    @BindView(R.id.cl_day7)
    ConstraintLayout clDay7;
    @BindView(R.id.tv_Watch)
    TextView tvWatch;

    private String id;
    private Activity context;
    private OnSignInClickListener listener;
    private SignInBean.DataBean bean = new SignInBean.DataBean();

    public SignInDialog(@NonNull Activity context) {
        super(context);
        this.context = context;
    }

    public SignInDialog(@NonNull Activity context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    protected SignInDialog(@NonNull Activity context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_sign_in);
        ButterKnife.bind(this);

        tvWatch.setVisibility(SharedPreferencesUtil.getInstance(context).getValue("isSignInFirst").equals("1") ? View.GONE : View.VISIBLE);
    }

    @OnClick({R.id.cl_day1, R.id.cl_day2, R.id.cl_day3, R.id.cl_day5, R.id.cl_day6, R.id.cl_day7, R.id.tv_Watch, R.id.cl_day4})
    public void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.cl_day1:
                if(bean.getDayli_num() == 1 && bean.getDayli_flag() == 0) {
                    if(SharedPreferencesUtil.getInstance(context).getValue("isSignInFirst").equals("1")) {
                        listener.onSignInClick(id, bean.getRes().getReward_1());
                    }
                }
                break;
            case R.id.cl_day2:
//                if(bean.getDayli_num() == 2 && bean.getDayli_flag() == 0) {
//                    listener.onSignInClick(id);
//                }
                break;
            case R.id.cl_day3:
//                if(bean.getDayli_num() == 3 && bean.getDayli_flag() == 0) {
//                    listener.onSignInClick(id);
//                }
                break;
            case R.id.cl_day4:
//                if(bean.getDayli_num() == 4 && bean.getDayli_flag() == 0) {
//                    listener.onSignInClick(id);
//                }
                break;
            case R.id.cl_day5:
//                if(bean.getDayli_num() == 5 && bean.getDayli_flag() == 0) {
//                    listener.onSignInClick(id);
//                }
                break;
            case R.id.cl_day6:
//                if(bean.getDayli_num() == 6 && bean.getDayli_flag() == 0) {
//                    listener.onSignInClick(id);
//                }
                break;
            case R.id.cl_day7:
//                if(bean.getDayli_num() == 7 && bean.getDayli_flag() == 0) {
//                    listener.onSignInClick(id);
//                }
                break;
            case R.id.tv_Watch:
//                看广告
                break;
        }
    }

    public void setListener(OnSignInClickListener listener) {
        this.listener = listener;
    }

    public void setData(SignInBean.DataBean bean) {
        this.bean = bean;
        if(bean.getRes() != null) {
            tvDay1Num.setText(bean.getRes().getReward_1() + "");
            tvDay2Num.setText(bean.getRes().getReward_2() + "");
            tvDay3Num.setText(bean.getRes().getReward_3() + "");
            tvDay4Num.setText(bean.getRes().getReward_4() + "");
            tvDay5Num.setText(bean.getRes().getReward_5() + "");
            tvDay6Num.setText(bean.getRes().getReward_6() + "");
            tvDay7Num.setText(bean.getRes().getReward_7() + "");
        }
    }

    public interface OnSignInClickListener {
        void onSignInClick(String id, int money);
    }
}
