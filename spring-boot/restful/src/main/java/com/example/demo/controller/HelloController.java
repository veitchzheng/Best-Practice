package com.example.demo.controller;

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

}
