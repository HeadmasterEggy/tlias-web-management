package com.tliasweb.controller;

import com.tliasweb.pojo.Result;
import com.tliasweb.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;
//    @PostMapping
//    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
//        log.info("文件上传: {}, {}, {}", username, age, image);
//
//        //获取原始文件名
//        String originalFilename = image.getOriginalFilename();
//
//        //构造唯一的文件名
//        int index = originalFilename.lastIndexOf(".");
//        String extname = originalFilename.substring(index);
//        String newFileName = UUID.randomUUID().toString() + extname;
//        log.info("新的文件名: {}", newFileName);
//
//        //将文件存储中服务器的磁盘目录中
//        image.transferTo(new File("/Users/joey/Desktop/" + newFileName));
//        return Result.success();
//    }

    @PostMapping
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传, 文件名：{}", image.getOriginalFilename());
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成, 文件访问的url: {}", url);
        return Result.success(url);
    }
}
