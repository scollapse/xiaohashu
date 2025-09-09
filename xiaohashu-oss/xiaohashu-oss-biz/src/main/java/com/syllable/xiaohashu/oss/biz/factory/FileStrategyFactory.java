package com.syllable.xiaohashu.oss.biz.factory;

import com.syllable.xiaohashu.oss.biz.strategy.FileStrategy;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author: 犬小哈
 * @date: 2024/6/27 19:44
 * @version: v1.0.0
 * @description: 文件策略工厂
 **/
@Component
@RefreshScope
public class FileStrategyFactory {

    private final String strategyType;

    private final Map<String, FileStrategy> strategyMap;

    public FileStrategyFactory(
            @Value("${storage.type}") String strategyType,
            Map<String, FileStrategy> strategyMap) {
        this.strategyType = strategyType;
        this.strategyMap = strategyMap;
    }

    public FileStrategy getFileStrategy() {
        FileStrategy strategy = strategyMap.get(strategyType);
        if (strategy == null) {
            throw new IllegalArgumentException("不可用的存储类型: " + strategyType);
        }
        return strategy;
    }
}