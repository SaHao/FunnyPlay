package com.iejnnnmokkk.common.http;

import androidx.annotation.NonNull;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.iejnnnmokkk.common.utils.GsonUtils;
import com.iejnnnmokkk.common.utils.LogUtils;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Sun
 * @Demo class GetRequest
 * @Description TODO
 * @date 2024/12/6 11:12
 */
public class GetRequest<T> implements RequestStrategy {

    private final String url;
    private final Map<String, String> params;
    private final Class<T> clazz;
    private final RequestCallback<T> callback;

    public GetRequest(String url, Map<String, String> params, Class<T> clazz, RequestCallback<T> callback) {
        this.url = url;
        this.params = params;
        this.clazz = clazz;
        this.callback = callback;
    }

    @Override
    public void execute(OkHttpClient client) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            urlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
        }

        Request request = new Request.Builder()
                .url(urlBuilder.build())
                .get()
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                String errorMessage = "请求失败: " + e.getMessage();
                LogUtils.e(errorMessage, e);
                callback.onFailure(errorMessage);
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful() && response.code() == 200) {
                    String jsonResponse = response.body().string();
                    try {
                        JsonObject jsonObject = new JsonParser().parse(jsonResponse).getAsJsonObject();
                        int responseCode = jsonObject.get("code").getAsInt();
                        if (responseCode == 200) {
                            T parsedResponse = GsonUtils.fromJson(jsonResponse, clazz);
                            callback.onSuccess(parsedResponse, jsonResponse);
                        } else {
                            callback.onFailure("请求失败，返回的 code 是：" + responseCode + "，错误信息：" + jsonObject.get("message").getAsString());
                        }
                    } catch (JsonSyntaxException e) {
                        callback.onFailure("响应解析错误: " + e.getMessage());
                    }
                } else {
                    callback.onFailure("请求失败，返回错误码：" + response.code() + "，错误信息：" + response.message());
                }
            }
        });
    }
}

