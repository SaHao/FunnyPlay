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

public class TaskCompleteDialog extends Dialog {

    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_otherMoney)
    TextView tvOtherMoney;

    private Context context;
    private OnVideoClickListener listener;

    public TaskCompleteDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public TaskCompleteDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    protected TaskCompleteDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_sign_in_success);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_ok, R.id.ll_video})
    public void onBindClick(View view) {
        switch (view.getId()) {
            case R.id.tv_ok:
                dismiss();
                break;
            case R.id.ll_video:
//                看视频
//                完成视频回调
                listener.onVideoClick();
                break;
        }
    }

    public void setListener(OnVideoClickListener listener) {
        this.listener = listener;
    }

    public void setMoney(int money, int otherMoney) {
        tvMoney.setText(money + "");
        tvOtherMoney.setText(otherMoney + "");
    }

    public interface OnVideoClickListener {
        void onVideoClick();
    }
}
