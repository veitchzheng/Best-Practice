package com.example.springbootdemo.controller;

import com.example.springbootdemo.outer.TestFeign;
import com.example.springbootdemo.outer.TestFeign.User;
import com.example.springbootdemo.service.ThreadPoolService;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengweichao  2022-02-10 12:56 下午
 **/
@Slf4j
@Validated
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@NotNull(message = "world 不能为空") String world, @NotNull(message = "world1 不能为空") String world1){
        log.info("hello");
        log.warn("hello warn");
        log.error("hello error");
        return "hello " + world;
    }

    @Resource
    private ThreadPoolService threadPoolService;

    @GetMapping("/helloThreadPool")
    public String helloThreadPool() throws ExecutionException, InterruptedException {
        log.info("main thread log");
        threadPoolService.asyncExecutor();
        threadPoolService.asyncWithCustomExecutor();
        Future<String> future = threadPoolService.asyncWithReturn();
        log.info("async result:{}", future.get());
        threadPoolService.customExecutor();
        Thread.sleep(5000);
        return "hello thread pool!";
    }

    @Resource
    private TestFeign testFeign;

    @GetMapping("/helloFeign")
    public List<User> helloFeign(){
        List<User> posts = testFeign.posts();
        return posts;
    }

    @GetMapping("/helloDate")
    public String helloDate(){
        return "hello " + new Date();
    }
}
