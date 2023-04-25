package com.xlccc.job;

import com.xlccc.service.FileService;
import com.xlccc.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Linker
 * @Date: 2023/4/25 13:35
 * @Description:
 */
@Component
@Slf4j
public class UploadTask {
    @Resource
    private UploadService uploadService;
    @Resource
    private FileService fileService;
    /**
     * @Scheduled(fixedRate = 1000)
     * @Scheduled(fixedRate = 500)
     */

    @Scheduled(cron = "* 0/1 * * * ? ")
    private void UploadTask() {
        try {
            String folder = "E:\\pic_save_all";
            List<String> filePaths = fileService.getJpgFilePaths(folder);
            for (String f : filePaths) {
                File tempFile = new File(f);
                uploadService.upload(tempFile);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Async
    @Scheduled(fixedRate = 2000)
    public void AsyncTask() {
        log.info("AsyncTask -- Hello ");
    }

}