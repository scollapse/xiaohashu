package com.syllable.xiaohashu.oss.biz.factory;

import com.syllable.xiaohashu.oss.biz.strategy.FileStrategy;
import com.syllable.xiaohashu.oss.biz.strategy.impl.AliyunOSSFileStrategy;
import com.syllable.xiaohashu.oss.biz.strategy.impl.MinioFileStrategy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 犬小哈
 * @date: 2024/6/27 19:44
 * @version: v1.0.0
 * @description: 文件策略工厂
 **/
@Configuration
public class FileStrategyFactory {

    @Value("${storage.type}")
    private String strategyType;

    @Bean
    public FileStrategy getFileStrategy() {
        if (StringUtils.equals(strategyType, "minio")) {
            return new MinioFileStrategy();
        } else if (StringUtils.equals(strategyType, "aliyun")) {
            return new AliyunOSSFileStrategy();
        }

        throw new IllegalArgumentException("不可用的存储类型");
    }

}

