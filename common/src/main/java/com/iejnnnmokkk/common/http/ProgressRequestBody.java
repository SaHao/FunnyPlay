package com.iejnnnmokkk.common.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/**
 * @author Sun
 * @Demo class ProgressRequestBody
 * @Description TODO
 * @date 2024/12/6 10:55
 */
public class ProgressRequestBody extends RequestBody {

    private final File file;
    private final ProgressCallback progressCallback;
    private final RequestBody requestBody;

    public ProgressRequestBody(File file, ProgressCallback progressCallback) {
        this.file = file;
        this.progressCallback = progressCallback;
        this.requestBody = RequestBody.create(file, MediaType.parse("application/octet-stream"));
    }

    @Override
    public MediaType contentType() {
        return requestBody.contentType();
    }

    @Override
    public long contentLength() throws IOException {
        return requestBody.contentLength();
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] buffer = new byte[2048];
            long totalBytesRead = 0;
            long totalBytes = contentLength();
            int bytesRead;

            // 读取文件并写入到sink，同时更新进度
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                sink.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;

                // 计算进度
                int progress = (int) ((totalBytesRead * 100) / totalBytes);
                if (progressCallback != null) {
                    progressCallback.onProgress(progress);  // 传递进度
                }
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
