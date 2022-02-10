package com.example.springbootdemo.controller;

import com.example.springbootdemo.service.ThreadPoolService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengweichao  2022-02-10 12:56 下午
 **/
@Slf4j
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(String world){
        log.info("hello");
        log.warn("hello warn");
        log.error("hello error");
        return "hello " + world;
    }

    @Resource
    private ThreadPoolService threadPoolService;

    @GetMapping("helloThreadPool")
    public String helloThreadPool() {
        log.info("main thread log");
        threadPoolService.asyncExecutor();
        threadPoolService.asyncWithCustomExecutor();
        threadPoolService.customExecutor();
        return "hello thread pool!";
    }
}
