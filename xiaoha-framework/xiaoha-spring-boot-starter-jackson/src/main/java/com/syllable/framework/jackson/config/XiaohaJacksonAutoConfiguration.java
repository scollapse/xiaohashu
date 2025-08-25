package com.syllable.framework.jackson.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.YearMonthDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.YearMonthSerializer;
import com.syllable.framework.common.constant.DateConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.TimeZone;

/**
 * 小哈 Jackson 自动配置类
 * <p>
 * 应用通用的 Jackson 配置，包括时区、特性和基于 DateConstants 的日期时间格式。
 * </p>
 */// 对于 Spring Boot 3.x, 推荐使用 @AutoConfiguration 注解
@AutoConfiguration
@ConditionalOnClass({ObjectMapper.class, JavaTimeModule.class}) // 确保 Jackson 核心和 JSR310 模块存在
@AutoConfigureAfter(JacksonAutoConfiguration.class) // 在 Spring Boot 默认 Jackson 配置之后应用
@Slf4j
public class XiaohaJacksonAutoConfiguration {


    /**
     * 定义 Jackson2ObjectMapperBuilderCustomizer Bean 来定制由 Spring Boot 管理的 ObjectMapper。
     * 这是 Spring Boot 推荐的定制方式。
     * @return Jackson2ObjectMapperBuilderCustomizer 实例
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer xiaohaJacksonCustomizer() {
        log.info("应用[小哈]自定义 Jackson 配置...");

        return builder -> {
            log.debug("禁用特性: FAIL_ON_UNKNOWN_PROPERTIES, FAIL_ON_EMPTY_BEANS");
            // 1. 配置特性 (与原 JacksonConfig 一致)
            builder.featuresToDisable(
                    DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                    SerializationFeature.FAIL_ON_EMPTY_BEANS
            );

            // 2. 配置时区 (与原 JacksonConfig 一致)
            final String timeZoneId = "Asia/Shanghai";
            log.debug("设置时区为: {}", timeZoneId);
            builder.timeZone(TimeZone.getTimeZone(timeZoneId));

            // 3. 配置 JavaTimeModule 及自定义格式化器 (与原 JacksonConfig 一致)
            log.debug("使用 DateConstants 配置 Java 时间 API (JSR310) 的序列化/反序列化格式");
            JavaTimeModule javaTimeModule = new JavaTimeModule();

            // 使用 DateConstants 中的 DateTimeFormatter            javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateConstants.DATE_FORMAT_Y_M_D_H_M_S));
            javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateConstants.DATE_FORMAT_Y_M_D_H_M_S));

            javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateConstants.DATE_FORMAT_Y_M_D));
            javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateConstants.DATE_FORMAT_Y_M_D));

            javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateConstants.DATE_FORMAT_H_M_S));
            javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateConstants.DATE_FORMAT_H_M_S));

            javaTimeModule.addSerializer(YearMonth.class, new YearMonthSerializer(DateConstants.DATE_FORMAT_Y_M));
            javaTimeModule.addDeserializer(YearMonth.class, new YearMonthDeserializer(DateConstants.DATE_FORMAT_Y_M));

            // 注册配置好的 JavaTimeModule            builder.modules(javaTimeModule);
            log.info("[小哈]自定义 Jackson 配置应用完成。");
            // 注意：这里绝对不能再调用 JsonUtils.init()            // Starter 的目的就是通过 Spring Boot 的机制配置 ObjectMapper Bean，
            // 而不是去初始化一个外部的静态工具类。
        };
    }
}