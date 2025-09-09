package com.syllable.xiaohashu.oss.biz.service.impl;

import com.syllable.framework.common.response.Response;
import com.syllable.xiaohashu.oss.biz.factory.FileStrategyFactory;
import com.syllable.xiaohashu.oss.biz.service.FileService;
import com.syllable.xiaohashu.oss.biz.strategy.FileStrategy;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: 犬小哈
 * @date: 2024/4/11 17:12
 * @version: v1.0.0
 * @description: 文件上传业务实现类
 **/
@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Autowired
    private FileStrategyFactory fileStrategyFactory;

    private static final String BUCKET_NAME = "xiaohashu";

    @Override
    public Response<?> uploadFile(MultipartFile file) {
        // 上传文件
        String url =  fileStrategyFactory.getFileStrategy().uploadFile(file, BUCKET_NAME);
        return Response.success(url);
    }
}

