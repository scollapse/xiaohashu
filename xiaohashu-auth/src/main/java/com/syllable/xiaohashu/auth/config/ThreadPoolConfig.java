package com.syllable.xiaohashu.auth.config;


import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.util.concurrent.ThreadPerTaskExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description: 线程池配置
 * @author: syl
 * @create: 2025-08-26 16:53
 **/
@Configuration
@Slf4j
public class ThreadPoolConfig {

    //线程池配置常量
    //cpu核心数
    private static final int CPU_CORES = Runtime.getRuntime().availableProcessors();
    //核心线程数
    private static final int CORE_POOL_SIZE = CPU_CORES + 1;
    //最大线程数
    private static final int MAXIMUM_POOL_SIZE = CPU_CORES * 2;
    //队列容量
    private static final int  QUEUE_CAPACITY = 100;
    //线程名称前缀
    private static final String THREAD_NAME_PREFIX = "AuthExecutor-";
    // 线程存活时间
    private static final int KEEP_ALIVE_TIME = 60;
    private static final int WAIT_TIME_OUT = 60;


    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数
        executor.setCorePoolSize(CORE_POOL_SIZE);
        // 最大线程数
        executor.setMaxPoolSize(MAXIMUM_POOL_SIZE);
        // 队列容量
        executor.setQueueCapacity(QUEUE_CAPACITY);
        // 线程活跃时间（秒）
        executor.setKeepAliveSeconds(KEEP_ALIVE_TIME);
        // 线程名前缀
        executor.setThreadNamePrefix(THREAD_NAME_PREFIX);

        // 拒绝策略：由调用线程处理（一般为主线程）
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 设置等待时间，如果超过这个时间还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是被没有完成的任务阻塞
        executor.setAwaitTerminationSeconds(WAIT_TIME_OUT);

        executor.initialize();
        return executor;
    }
}
