package com.xlccc.controller;

import com.xlccc.receive.ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: Linker
 * @Date: 2023/4/24 9:14
 * @Description:
 */
@RestController
public class FileController {
    @Autowired
    private ReceiveService receiveService;

    @PostMapping("/receive")
    public String receiveFile(@RequestParam String id,
                              @RequestParam(value = "file") MultipartFile file
    ) {
        receiveService.saveToLocal(file);
        return "Ok";
    }
}
