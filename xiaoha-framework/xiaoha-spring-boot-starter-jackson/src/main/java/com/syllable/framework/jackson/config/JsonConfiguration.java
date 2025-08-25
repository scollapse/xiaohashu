package com.syllable.framework.jackson.config;  
  
import com.fasterxml.jackson.databind.ObjectMapper;
import com.syllable.framework.jackson.util.JsonUtils;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.AutoConfiguration;  
import org.springframework.boot.autoconfigure.AutoConfigureAfter;  
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;  
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;  
import org.springframework.context.annotation.Configuration;  
import lombok.extern.slf4j.Slf4j;  
   
@Slf4j  
@Configuration  
@AutoConfiguration  
@AutoConfigureAfter(JacksonAutoConfiguration.class)  
public class JsonConfiguration {  
  
    private final ObjectMapper objectMapper;  
  
    public JsonConfiguration(ObjectMapper objectMapper) {  
        this.objectMapper = objectMapper;  
    }  
  
    @PostConstruct  
    public void init() {  
        log.info("初始化 JsonUtils...");  
        JsonUtils.init(objectMapper);
        log.info("JsonUtils 初始化完成");  
    }  
}