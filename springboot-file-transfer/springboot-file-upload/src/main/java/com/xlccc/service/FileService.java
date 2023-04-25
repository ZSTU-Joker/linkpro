package com.xlccc.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Linker
 * @Date: 2023/4/24 10:46
 * @Description:
 */
@Service
public class FileService {
    /**
     * 获取该文件夹下的所有图片
     *
     * @param folderPath
     * @return
     */
    public List<String> getJpgFilePaths(String folderPath) throws Exception {
        List<String> filePaths = new ArrayList<>();
        File folder = new File(folderPath);
        if (!folder.isDirectory()) {
            throw new Exception("文件类型错误");
        }
        File[] files = folder.listFiles();

        for (File f : files) {
            //判断文件是否是图片
            if (f.getName().endsWith(".jpg")) {
                filePaths.add(f.getAbsolutePath());
            }
        }
        return filePaths;
    }

    public int deleteJpgFiles(String folderPath) throws FileNotFoundException {
        int deleteCount = 0;
        File folder = new File(folderPath);
        if (!folder.isDirectory()) {
            throw new FileNotFoundException("文件类型错误");
        }
        File[] files = folder.listFiles();

        for (File f : files) {
            if (f.getName().endsWith(".jpg")) {
                f.delete();
                deleteCount++;
            }
        }

        return deleteCount;
    }
}
