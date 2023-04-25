package com.xlccc.receive;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @Author: Linker
 * @Date: 2023/4/24 9:13
 * @Description:
 */
@Slf4j
@Service
public class ReceiveService {
    /**
     * Example: fileSavePath = "E:\\file_save_path\\";
     */
    public static String fileSavePath = "E:\\file_save_path\\";

    public void saveToLocal(MultipartFile file){//上传到本地
        log.info(file.getOriginalFilename());
        try {
            InputStream input = file.getInputStream();
            System.out.println(fileSavePath + File.separator + file.getOriginalFilename()+".jpg");
            OutputStream outputStream = new FileOutputStream(fileSavePath + File.separator + file.getOriginalFilename()+".jpg");
            byte[] b = new byte[4096];
            int count = input.read(b);
            while (count != -1) {
                for(int i = 0; i < count; i++){
                    outputStream.write(b[i]);
                }
                count = input.read(b);
            }
            input.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
