package com.syllable.xiaohashu.oss.biz.service.impl;

import com.syllable.framework.common.response.Response;
import com.syllable.xiaohashu.oss.biz.service.FileService;
import com.syllable.xiaohashu.oss.biz.strategy.FileStrategy;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
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

    // 文件上传策略 实现类没有加上注解，而是在工厂类中使用@bean注解注入，实现通过配置来注入不同的策略实现类
    @Resource
    private FileStrategy fileStrategy;

    @Override
    public Response<?> uploadFile(MultipartFile file) {
        // 上传文件到
        fileStrategy.uploadFile(file, "xiaohashu");

        return Response.success();
    }
}

