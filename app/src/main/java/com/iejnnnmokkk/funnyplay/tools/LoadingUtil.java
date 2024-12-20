package com.iejnnnmokkk.funnyplay.tools;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.iejnnnmokkk.funnyplay.R;

import java.lang.ref.WeakReference;

/**
 * @author Sun
 * @Demo class LoadingUtil
 * @Description TODO
 * @date 2024/12/10 15:10
 */
public class LoadingUtil {

    private static WeakReference<Activity> activityReference;
    private static AlertDialog loadingDialog;

    public static void showLoading(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }

        activityReference = new WeakReference<>(activity);
        Activity currentActivity = activityReference.get();

        if (currentActivity == null || currentActivity.isFinishing()) {
            return;
        }

        currentActivity.runOnUiThread(() -> {
            if (loadingDialog == null) {
                LayoutInflater inflater = currentActivity.getLayoutInflater();
                View layout = inflater.inflate(R.layout.view_loading, null);
                loadingDialog = new AlertDialog.Builder(currentActivity)
                        .setCancelable(true)
                        .setView(layout)
                        .create();
            }

            if (!loadingDialog.isShowing()) {
                loadingDialog.show();
            }
        });
    }

    public static void hideLoading() {
        if (activityReference != null) {
            Activity activity = activityReference.get();
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                loadingDialog = null;
                activityReference = null;
                return;
            }

            activity.runOnUiThread(() -> {
                if (loadingDialog != null && loadingDialog.isShowing()) {
                    loadingDialog.dismiss();
                }
                loadingDialog = null;
                activityReference = null;
            });
        }
    }
}

