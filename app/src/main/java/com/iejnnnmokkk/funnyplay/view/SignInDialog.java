package com.iejnnnmokkk.funnyplay.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.iejnnnmokkk.funnyplay.R;

import butterknife.ButterKnife;

/**
 * @author Sun
 * @Demo class SignInDialog
 * @Description TODO
 * @date 2024/12/20 16:03
 */
public class SignInDialog extends Dialog {

    public SignInDialog(@NonNull Context context) {
        super(context);
    }

    public SignInDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected SignInDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_sign_in);
        ButterKnife.bind(this);
    }
}
