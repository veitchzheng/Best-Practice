package com.example.config;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhengweichao  2022-02-08 3:11 下午
 **/
@Slf4j
@SpringBootTest
class ThreadConfigTest {

    @Resource
    private ThreadConfig threadConfig;

    @Test
    void test(){
        System.out.println(123);
    }


}