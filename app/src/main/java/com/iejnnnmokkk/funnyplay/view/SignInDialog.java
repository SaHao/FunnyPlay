package com.iejnnnmokkk.funnyplay.view;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.anythink.core.api.ATAdInfo;
import com.iejnnnmokkk.common.utils.SharedPreferencesUtil;
import com.iejnnnmokkk.common.utils.ToastUtils;
import com.iejnnnmokkk.funnyplay.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.iaa.topon.library.TopOnAds;
import io.iaa.topon.library.TopOnEvent;
import io.iaa.topon.library.TopOnRewardedAdsListener;

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
    @BindView(R.id.iv_day1)
    ImageView ivDay1;
    @BindView(R.id.iv_day2)
    ImageView ivDay2;
    @BindView(R.id.iv_day3)
    ImageView ivDay3;
    @BindView(R.id.iv_day4)
    ImageView ivDay4;
    @BindView(R.id.iv_day5)
    ImageView ivDay5;
    @BindView(R.id.iv_day6)
    ImageView ivDay6;
    @BindView(R.id.iv_day7)
    ImageView ivDay7;
    @BindView(R.id.iv_signLogo1)
    ImageView ivSignLogo1;
    @BindView(R.id.iv_signLogo2)
    ImageView ivSignLogo2;
    @BindView(R.id.iv_signLogo3)
    ImageView ivSignLogo3;
    @BindView(R.id.iv_signLogo4)
    ImageView ivSignLogo4;
    @BindView(R.id.iv_signLogo5)
    ImageView ivSignLogo5;
    @BindView(R.id.iv_signLogo6)
    ImageView ivSignLogo6;
    @BindView(R.id.iv_signLogo7)
    ImageView ivSignLogo7;

    private String id;
    private Activity context;
    private OnSignInClickListener listener;
    private SignInBean.DataBean bean = new SignInBean.DataBean();
    private TextView[] textViews;
    private ImageView[] imageViews;
    private ImageView[] logos;

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

        textViews = new TextView[]{tvDay1Num, tvDay2Num, tvDay4Num, tvDay4Num, tvDay5Num, tvDay6Num, tvDay7Num};
        imageViews = new ImageView[]{ivDay1, ivDay2, ivDay3, ivDay4, ivDay5, ivDay6, ivDay7};
        logos = new ImageView[]{ivSignLogo1, ivSignLogo2, ivSignLogo3, ivSignLogo4, ivSignLogo5, ivSignLogo6, ivSignLogo7};

    }

    @Override
    protected void onStart() {
        super.onStart();
        tvWatch.setVisibility(SharedPreferencesUtil.getInstance(context).getValue("isSignInFirst").equals("1") ? View.GONE : View.VISIBLE);
    }

    @OnClick({R.id.cl_day1, R.id.cl_day2, R.id.cl_day3, R.id.cl_day5, R.id.cl_day6, R.id.cl_day7, R.id.tv_Watch, R.id.cl_day4})
    public void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.cl_day1:
                if (bean.getDayli_num() == 1 && bean.getDayli_flag() == 0) {
                    if (SharedPreferencesUtil.getInstance(context).getValue("isSignInFirst").equals("1")) {
                        listener.onSignInClick(id, bean.getRes().getReward_1());
                    }
                }
                break;
            case R.id.cl_day2:
                ToastUtils.showShort(context,"Please click the button below");
//                if(bean.getDayli_num() == 2 && bean.getDayli_flag() == 0) {
//                    listener.onSignInClick(id,bean.getRes().getReward_2());
//                }
                break;
            case R.id.cl_day3:
                ToastUtils.showShort(context,"Please click the button below");
//                if(bean.getDayli_num() == 3 && bean.getDayli_flag() == 0) {
//                    listener.onSignInClick(id,bean.getRes().getReward_3());
//                }
                break;
            case R.id.cl_day4:
                ToastUtils.showShort(context,"Please click the button below");
//                if(bean.getDayli_num() == 4 && bean.getDayli_flag() == 0) {
//                    listener.onSignInClick(id,bean.getRes().getReward_4());
//                }
                break;
            case R.id.cl_day5:
                ToastUtils.showShort(context,"Please click the button below");
//                if(bean.getDayli_num() == 5 && bean.getDayli_flag() == 0) {
//                    listener.onSignInClick(id,bean.getRes().getReward_5());
//                }
                break;
            case R.id.cl_day6:
                ToastUtils.showShort(context,"Please click the button below");
//                if(bean.getDayli_num() == 6 && bean.getDayli_flag() == 0) {
//                    listener.onSignInClick(id,bean.getRes().getReward_6());
//                }
                break;
            case R.id.cl_day7:
                ToastUtils.showShort(context,"Please click the button below");
//                if(bean.getDayli_num() == 7 && bean.getDayli_flag() == 0) {
//                    listener.onSignInClick(id,bean.getRes().getReward_7());
//                }
                break;
            case R.id.tv_Watch:
                if (bean.getDayli_flag() == 0) {
                    TopOnAds.loadRewardAd(context, "n675ba286f407f", "n676a5e9419689", new TopOnRewardedAdsListener() {
                        @Override
                        public void onAdLoadShow() {
                            TopOnEvent.logEventADorFA(context, "acloiyxa", "ad_show");
                        }

                        @Override
                        public void onAdHidden(ATAdInfo adInfo) {
                            TopOnEvent.logEventADorFA(context, "acloiyxa", "ad_hidden");
                        }

                        @Override
                        public void onUserRewarded(ATAdInfo adInfo) {
                            onClickListener();
                            TopOnEvent.logEventADorFA(context, "acloiyxa", "ad_reward");
                        }

                        @Override
                        public void onAdClicked(ATAdInfo adInfo) {
                            TopOnEvent.logEventADorFA(context, "acloiyxa", "ads_click");
                        }

                        @Override
                        public void onAdLoadFailed(String s) {
                            TopOnEvent.logEventADorFA(context, "acloiyxa", "ad_failed");
                        }
                    });
                }else {
                    ToastUtils.showShort(context,context.getResources().getString(R.string.checked));
                }
                break;
        }
    }

    public void setListener(OnSignInClickListener listener) {
        this.listener = listener;
    }

    public void setData(SignInBean.DataBean bean) {
        this.bean = bean;
        if (bean.getRes() != null) {
            tvDay1Num.setText(bean.getRes().getReward_1() + "");
            tvDay2Num.setText(bean.getRes().getReward_2() + "");
            tvDay3Num.setText(bean.getRes().getReward_3() + "");
            tvDay4Num.setText(bean.getRes().getReward_4() + "");
            tvDay5Num.setText(bean.getRes().getReward_5() + "");
            tvDay6Num.setText(bean.getRes().getReward_6() + "");
            tvDay7Num.setText(bean.getRes().getReward_7() + "");
        }
        if (bean.getDayli_num() == 1 && bean.getDayli_flag() == 0) {
            updateViews(0);
        } else if (bean.getDayli_num() > 1 && bean.getDayli_flag() == 0) {
            updateViews(bean.getDayli_num() - 1);
        } else {
            updateViews(bean.getDayli_num());
        }
    }

    public void onClickListener() {
        if (bean.getDayli_num() == 2) {
            listener.onSignInClick(id, bean.getRes().getReward_2());
        } else if (bean.getDayli_num() == 3) {
            listener.onSignInClick(id, bean.getRes().getReward_3());
        } else if (bean.getDayli_num() == 4) {
            listener.onSignInClick(id, bean.getRes().getReward_4());
        } else if (bean.getDayli_num() == 5) {
            listener.onSignInClick(id, bean.getRes().getReward_5());
        } else if (bean.getDayli_num() == 6) {
            listener.onSignInClick(id, bean.getRes().getReward_6());
        } else if (bean.getDayli_num() == 7) {
            listener.onSignInClick(id, bean.getRes().getReward_7());
        }
    }

    private void updateViews(int num) {
        num = Math.min(num, textViews.length);

        for (int i = 0; i < textViews.length; i++) {
            if (i < num) {
                changeTextColors(textViews[i]);
                changeImages(imageViews[i]);
                changeLogos(logos[i]);
            } else {
                resetTextColors(textViews[i]);
                resetImages(imageViews[i]);
                resetLogos(logos[i]);
            }
        }
    }

    private void changeTextColors(TextView view) {
        view.setTextColor(context.getResources().getColor(R.color.signIn));
    }

    private void changeImages(ImageView view) {
        view.setImageResource(R.mipmap.icon_sign_in_success_back);
    }

    private void changeLogos(ImageView view) {
        view.setImageResource(R.mipmap.icon_sign_in_success);
    }

    private void resetTextColors(TextView view) {
        view.setTextColor(context.getResources().getColor(R.color.notSignIn));
    }

    private void resetImages(ImageView view) {
        view.setImageResource(R.mipmap.icon_sign_in_back);
    }

    private void resetLogos(ImageView view) {
        view.setImageResource(R.mipmap.icon_sign_in_not);
    }

    public interface OnSignInClickListener {
        void onSignInClick(String id, int money);
    }
}
