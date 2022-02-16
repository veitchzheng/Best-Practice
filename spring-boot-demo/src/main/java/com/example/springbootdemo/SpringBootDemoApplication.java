package com.example.springbootdemo;

import com.example.springbootdemo.config.FeignClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhengweichao
 */
@SpringBootApplication
@EnableFeignClients(defaultConfiguration = FeignClientConfig.class)
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

}
