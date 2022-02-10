package com.example.springbootdemo.service;

import java.util.concurrent.Executor;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author zhengweichao  2022-02-10 2:48 下午
 **/
@Slf4j
@Service
public class ThreadPoolService {

    @Async
    public void asyncExecutor() {

        log.info("async executor service log");
    }

    @Async("taskExecutor")
    public void asyncWithCustomExecutor() {
        log.info("async with custom executor service log");
    }

    @Resource(name = "taskExecutor")
    private Executor executor;

    public void customExecutor() {
        executor.execute(() -> log.info("custom executor service log"));
    }

    // TODO  有返回的异步调用


}
