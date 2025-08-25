package com.syllable.framework.jackson.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author syl
 */@Slf4j
public class JsonUtils {

    private static ObjectMapper objectMapper;
    private static volatile boolean initialized = false;

    /**
     * 初始化ObjectMapper
     * 该方法由Spring通过配置类调用，确保ObjectMapper被正确初始化
     * @param mapper Spring配置的ObjectMapper实例
     */
    public static synchronized void init(ObjectMapper mapper) {
        if (initialized) {
            log.warn("JsonUtils已经初始化，忽略重复初始化");
            return;
        }
        if (mapper == null) {
            throw new IllegalArgumentException("ObjectMapper不能为空");
        }
        objectMapper = mapper;
        initialized = true;
        log.info("JsonUtils初始化成功");
    }

    /**
     * 将对象转换为 JSON 字符串
     *
     * @param obj 要转换的对象
     * @return JSON 字符串
     */
    public static String toJsonString(Object obj) {
        try {
            checkObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (IOException e) {
            log.error("将对象转换为 JSON 字符串失败", e);
            throw new RuntimeException("Failed to convert object to JSON string", e);
        }
    }

    /**
     * 将 JSON 字符串转换为指定类型的对象
     *
     * @param json  JSON 字符串
     * @param clazz 目标对象的 Class
     * @param <T>   目标对象的类型
     * @return 转换后的对象
     */
    public static <T> T stringToObject(String json, Class<T> clazz) {
        try {
            checkObjectMapper();
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            log.error("将 JSON 字符串转换为对象失败", e);
            throw new RuntimeException("Failed to convert JSON string to object", e);
        }
    }

    /**
     * 检查ObjectMapper是否已初始化
     */
    private static void checkObjectMapper() {
        if (!initialized || objectMapper == null) {
            throw new IllegalStateException("JsonUtils未初始化，请确保已正确配置Spring环境");
        }
    }
}