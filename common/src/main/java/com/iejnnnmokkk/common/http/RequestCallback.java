package com.iejnnnmokkk.common.http;

/**
 * @author Sun
 * @Demo class BaseNetworkCallback
 * @Description TODO
 * @date 2024/12/5 16:27
 */
public interface RequestCallback<T> {

    void onSuccess(T bean, String json);

    void onFailure(String error);
}
