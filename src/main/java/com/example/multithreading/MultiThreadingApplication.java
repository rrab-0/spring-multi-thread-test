package com.example.multithreading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class MultiThreadingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiThreadingApplication.class, args);
    }

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(100_000_000);
        executor.setMaxPoolSize(100_000_000);
        executor.setQueueCapacity(50);
        executor.setThreadNamePrefix("LookupTest-");
        executor.initialize();
        return executor;
    }
}
