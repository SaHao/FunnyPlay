package com.iejnnnmokkk.common.http;

import android.os.Handler;
import android.os.Looper;


import com.iejnnnmokkk.common.utils.LogUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Sun
 * @Demo class DownloadFileRequest
 * @Description TODO
 * @date 2024/12/6 11:16
 */
public class DownloadFileRequest implements RequestStrategy {

    private final String url;
    private final Map<String, String> params;
    private final String destFilePath;
    private final ProgressCallback<Void> callback;
    private final Handler handler;

    public DownloadFileRequest(String url, Map<String, String> params, String destFilePath, ProgressCallback<Void> callback) {
        this.url = url;
        this.params = params;
        this.destFilePath = destFilePath;
        this.callback = callback;
        this.handler = new Handler(Looper.getMainLooper());
    }

    /**
     * 下载文件
     */
    @Override
    public void execute(OkHttpClient client) {
        Request.Builder requestBuilder = new Request.Builder().url(url);

        // 添加请求参数（如果有）
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                requestBuilder.addHeader(entry.getKey(), entry.getValue());
            }
        }

        // 构建请求
        Request request = requestBuilder.build();

        // 异步请求
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String errorMessage = "下载失败: " + e.getMessage();
                LogUtils.e(errorMessage, e);
                handler.post(() -> callback.onFailure(errorMessage));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful() && response.code() == 200) {
                    try (InputStream inputStream = response.body().byteStream();
                         FileOutputStream fileOutputStream = new FileOutputStream(new File(destFilePath))) {

                        long totalBytes = response.body().contentLength();
                        long downloadedBytes = 0;

                        byte[] buffer = new byte[8192];
                        int bytesRead;

                        // 读取并写入文件，同时更新进度
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            fileOutputStream.write(buffer, 0, bytesRead);
                            downloadedBytes += bytesRead;

                            // 更新进度
                            int progress = (int) ((downloadedBytes * 100) / totalBytes);
                            handler.post(() -> callback.onProgress(progress));
                        }

                        // 下载成功，回调文件保存路径
                        handler.post(() -> callback.onSuccess(null, destFilePath));
                    } catch (IOException e) {
                        handler.post(() -> callback.onFailure("下载失败，写入文件时发生错误：" + e.getMessage()));
                    }
                } else {
                    handler.post(() -> callback.onFailure("下载失败，返回错误码：" + response.code()));
                }
            }
        });
    }
}


