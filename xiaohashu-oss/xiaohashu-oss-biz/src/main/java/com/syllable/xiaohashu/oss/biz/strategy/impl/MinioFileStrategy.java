package com.syllable.xiaohashu.oss.biz.strategy.impl;

import com.syllable.xiaohashu.oss.biz.strategy.FileStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: 犬小哈
 * @date: 2024/6/27 19:47
 * @version: v1.0.0
 * @description: Minio文件上传策略
 **/
@Slf4j
@Component("minio")
public class MinioFileStrategy implements FileStrategy {

    @Override
    public String uploadFile(MultipartFile file, String bucketName) {
        log.info("## 上传文件至 Minio ...");
        return null;
    }
}

