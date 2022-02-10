package com.example.springbootdemo.controller;

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
}
