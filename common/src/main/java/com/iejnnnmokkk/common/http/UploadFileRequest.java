package com.iejnnnmokkk.common.http;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.iejnnnmokkk.common.utils.GsonUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Sun
 * @Demo class UploadFileRequest
 * @Description TODO
 * @date 2024/12/6 11:14
 */
public class UploadFileRequest implements RequestStrategy {

    private final String url;
    private final Map<String, String> params;
    private final File file;
    private final String fileKey;
    private final ProgressCallback<Void> callback;

    public UploadFileRequest(String url, Map<String, String> params, File file, String fileKey, ProgressCallback<Void> callback) {
        this.url = url;
        this.params = params;
        this.file = file;
        this.fileKey = fileKey;
        this.callback = callback;
    }

    /**
     * 上传文件
     */
    @Override
    public void execute(OkHttpClient client) {
        // 构造文件的RequestBody，包含进度回调
        ProgressRequestBody progressRequestBody = new ProgressRequestBody(file, callback);

        // 构造Multipart请求体
        MultipartBody.Builder requestBodyBuilder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(fileKey, file.getName(), progressRequestBody);

        // 添加额外的params
        for (Map.Entry<String, String> entry : params.entrySet()) {
            requestBodyBuilder.addFormDataPart(entry.getKey(), entry.getValue());
        }

        Request request = new Request.Builder()
                .url(url)
                .post(requestBodyBuilder.build())
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure("上传失败: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful() && response.code() == 200) {
                    String jsonResponse = response.body().string();
                    try {
                        JsonObject jsonObject = new JsonParser().parse(jsonResponse).getAsJsonObject();
                        int responseCode = jsonObject.get("code").getAsInt();
                        if (responseCode == 200) {
                            callback.onSuccess(null, response.body().string());
                        } else {
                            callback.onFailure("请求失败，返回的 code 是：" + responseCode + "，错误信息：" + jsonObject.get("message").getAsString());
                        }
                    } catch (JsonSyntaxException e) {
                        callback.onFailure("响应解析错误: " + e.getMessage());
                    }
                } else {
                    callback.onFailure("上传失败，返回错误码：" + response.code());
                }
            }
        });
    }

}

