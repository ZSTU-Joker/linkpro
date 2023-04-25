package com.xlccc.sftp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
/**
 * @author: Linker
 * @create: 2023-04-21 14:32
 * @description:
 **/

@RestController
public class UploadController {

    @RequestMapping("file")
    public void upload( MultipartFile file) throws Exception {
        byte[] bytes = file.getBytes();
        FtpUtils.sshSftp(bytes, "1111.jpg");
    }

}
