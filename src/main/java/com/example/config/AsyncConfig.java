package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author Zenglin.Fang
 * @ClassName AsyncConfig
 * @Description:
 * @Data: 2021/3/13 14:58
 **/
@SuppressWarnings("all")
@Configuration
public class AsyncConfig {

    private static final int MAX_POOL_SIZE = 50;
    private static final int CORE_POOL_SIZE = 20;

    @Bean("asyncPostFix")
    public AsyncTaskExecutor asyncPostFix() {
        ThreadPoolTaskExecutor asyncPostFix = new ThreadPoolTaskExecutor();
        asyncPostFix.setMaxPoolSize(MAX_POOL_SIZE);
        asyncPostFix.setCorePoolSize(CORE_POOL_SIZE);
        asyncPostFix.setThreadNamePrefix("async-task-thread-pool-");
        asyncPostFix.initialize();
        return asyncPostFix;
    }

}
