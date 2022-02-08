package com.example.controller;

import com.example.config.ThreadConfig;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengweichao  2022-02-07 7:37 下午
 **/
@Slf4j
@RestController
public class HelloController {

    @GetMapping("/hello")
    private String hello(){
        log.info("hello");
        log.warn("hello warn");
        log.error("hello error");
        return "hello";
    }

    @Resource
    private ThreadConfig threadConfig;

    @GetMapping("/helloThread")
    private String helloThread(){
        log.info("hello");
        threadConfig.executor().execute(() -> {
            log.info("hello thread");
            log.warn("hello thread warn");
            log.error("hello thread error");
        });
        return "hello thread";
    }

}
