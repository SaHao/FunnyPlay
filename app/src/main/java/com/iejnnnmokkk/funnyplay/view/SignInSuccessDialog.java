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

public class SignInSuccessDialog extends Dialog {

    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_ok)
    TextView tvOk;

    private Context context;

    public SignInSuccessDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public SignInSuccessDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    protected SignInSuccessDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_sign_in_success);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_ok})
    public void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.tv_ok:
                dismiss();
                break;
        }
    }

    public void setMoney(int money) {
        tvMoney.setText(money + "");
    }
}
