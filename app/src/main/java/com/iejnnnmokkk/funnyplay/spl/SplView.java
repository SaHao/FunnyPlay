package com.iejnnnmokkk.funnyplay.spl;

/**
 * @author Sun
 * @Demo class SplView
 * @Description TODO
 * @date 2024/12/10 16:17
 */
public interface SplView {
    void onLogin(LoginBean bean);
    void onAchieve(SplBean bean);
    void onFailed(String msg);
}
