package com.xlccc.controller;

import com.xlccc.service.FileService;
import com.xlccc.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Linker
 * @Date: 2023/4/24 9:18
 * @Description:
 */
@RestController
public class FileController {
    @Autowired
    private UploadService uploadService;
    @Autowired
    private FileService fileService;

    /**
     * 指定目录下所有图片
     *
     * @return
     */
    @PostMapping("/upload")
    public String uploadFile() {
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
        return "Ok";
    }

    @PostMapping("/delete")
    public void deleteTest() {
        String folder = "E:\\file_save_path";
        try {
            int count = fileService.deleteJpgFiles(folder);
            System.out.println(count);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
