package com.iejnnnmokkk.funnyplay.tools;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.iejnnnmokkk.funnyplay.R;

/**
 * @author Sun
 * @Demo class LoadingUtil
 * @Description TODO
 * @date 2024/12/10 15:10
 */
public class LoadingUtil {

    private static AlertDialog loadingDialog;

    /**
     * 显示加载框
     *
     * @param activity 当前活动
     */
    public static void showLoading(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }

        if (loadingDialog == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            View layout = inflater.inflate(R.layout.view_loading, null);
            loadingDialog = new AlertDialog.Builder(activity)
                    .setCancelable(true)
                    .setView(layout)
                    .create();
        }

        if (!loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    public static void hideLoading() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }
}

