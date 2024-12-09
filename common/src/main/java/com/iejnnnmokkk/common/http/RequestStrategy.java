package com.iejnnnmokkk.common.http;

import okhttp3.OkHttpClient;

/**
 * @author Sun
 * @Demo class RequestStrategy
 * @Description TODO
 * @date 2024/12/6 11:12
 */
public interface RequestStrategy {

    void execute(OkHttpClient client);
}
