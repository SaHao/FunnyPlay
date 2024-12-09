package com.iejnnnmokkk.common.http;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Sun
 * @Demo class TokenInterceptor
 * @Description TODO
 * @date 2024/12/5 16:29
 */
public class TokenInterceptor implements Interceptor {

    @NonNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        String url = chain.request().url().toString();
        if (!WhitelistManager.isInWhitelist(url)) {
            String token = TokenManager.getToken();
            if (token == null || token.isEmpty()) {
                throw new IOException("401: Token missing or expired.");
            }
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer " + token)
                    .build();
            return chain.proceed(newRequest);
        } else {
            return chain.proceed(chain.request());
        }
    }
}
