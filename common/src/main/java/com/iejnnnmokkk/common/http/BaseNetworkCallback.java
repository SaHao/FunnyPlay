package com.iejnnnmokkk.common.http;

/**
 * @author Sun
 * @Demo class BaseNetworkCallback
 * @Description TODO
 * @date 2024/12/6 14:11
 */
public interface BaseNetworkCallback<T> {

    void onSuccess(T bean);

    void onFailure(String error);
}
