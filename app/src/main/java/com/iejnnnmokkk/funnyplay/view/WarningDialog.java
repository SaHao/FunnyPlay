package com.iejnnnmokkk.funnyplay.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.iejnnnmokkk.funnyplay.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Sun
 * @Demo class WarningDialog
 * @Description TODO
 * @date 2024/12/19 15:54
 */
public class WarningDialog extends Dialog {

    @BindView(R.id.tv_title)
    public TextView tvTitle;
    @BindView(R.id.tv_money)
    public TextView tvMoney;

    private Context context;
    private OnBtnClickListener listener;

    public WarningDialog(@NonNull Context context) {
        super(context);
    }

    public WarningDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected WarningDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_warning);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_leftBtn, R.id.tv_rightBtn})
    public void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.tv_leftBtn:
                dismiss();
                listener.onBtnClick(0);
                break;
            case R.id.tv_rightBtn:
                dismiss();
                listener.onBtnClick(1);
                break;
        }
    }

    public void setMoney(String money) {
        tvMoney.setText(money);
    }

    public void setListener(OnBtnClickListener listener) {
        this.listener = listener;
    }

    public interface OnBtnClickListener {
        void onBtnClick(int type);
    }
}
