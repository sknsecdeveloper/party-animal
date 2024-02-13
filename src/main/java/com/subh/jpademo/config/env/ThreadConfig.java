package com.subh.jpademo.config.env;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@EnableAsync
public class ThreadConfig {


    @Bean(value = "executorService")
    public Executor executorService(){
        return Executors.newFixedThreadPool(6);
    }
}
