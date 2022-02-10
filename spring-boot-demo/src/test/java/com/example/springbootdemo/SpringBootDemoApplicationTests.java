package com.example.springbootdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class SpringBootDemoApplicationTests {

    @Test
    void contextLoads() {
        log.info("unit test");
    }

}
