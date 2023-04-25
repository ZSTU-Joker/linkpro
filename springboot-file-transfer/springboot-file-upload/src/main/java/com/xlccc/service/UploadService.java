package com.xlccc.service;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * @Author: Linker
 * @Date: 2023/4/24 9:19
 * @Description:
 */
@Slf4j
@Service
public class UploadService {
    public void upload(File file) throws Exception {
        log.info("fileAbsolutePath = " + file.getAbsolutePath());

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(),
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File(file.getAbsolutePath())))
                .addFormDataPart("id", "name-tik")
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:8011/receive")
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();
        log.info(response.toString());
        if (response.code()!=200){
            log.error("Transfer Error  "+response);
        }
    }
}
