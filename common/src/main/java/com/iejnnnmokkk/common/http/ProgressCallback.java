package com.iejnnnmokkk.common.http;

/**
 * @author Sun
 * @Demo class ProgressCallback
 * @Description TODO
 * @date 2024/12/6 10:45
 */
public interface ProgressCallback<T> extends RequestCallback<T> {

    void onProgress(int progress);
}
