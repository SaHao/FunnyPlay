package com.iejnnnmokkk.common.http;

import java.io.File;
import java.util.Map;

import okhttp3.OkHttpClient;

/**
 * @author Sun
 * @Demo class HttpUtils
 * @Description TODO
 * @date 2024/12/5 16:31
 */
public class HttpUtils {

    private static final OkHttpClient client = new OkHttpClient();

    private HttpUtils() {
    }

    /**
     * 单例获取 HttpUtils 实例
     *
     * @return
     */
    public static HttpUtils getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 单例模式的实现
     */
    private static class SingletonHolder {
        private static final HttpUtils INSTANCE = new HttpUtils();
    }

    /**
     * GET 请求
     */
    public <T> void get(String url, Map<String, String> params, final Class<T> clazz, final RequestCallback<T> callback) {
        executeRequest(new GetRequest(url, params, clazz, callback));
    }

    /**
     * POST 请求
     */
    public <T> void post(String url, Map<String, String> params, final Class<T> clazz, final RequestCallback<T> callback) {
        executeRequest(new PostRequest(url, params, clazz, callback));
    }

    /**
     * 文件上传请求
     */
    public void uploadFile(String url, Map<String, String> params, String fileKey, File file, final ProgressCallback<Void> callback) {
        executeRequest(new UploadFileRequest(url, params, file, fileKey, callback));
    }

    /**
     * 文件下载请求
     */
    public void downloadFile(String url, Map<String, String> params, String destFilePath, final ProgressCallback<Void> callback) {
        executeRequest(new DownloadFileRequest(url, params, destFilePath, callback));
    }

    /**
     * 执行请求的公共方法，策略模式
     */
    private void executeRequest(RequestStrategy requestStrategy) {
        requestStrategy.execute(client);
    }
}

