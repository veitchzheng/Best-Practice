package com.example.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author zhengweichao  2022-02-22 7:14 下午
 **/
@Configuration
@EnableJpaRepositories("com.example.springbootdemo.repositories")
public class JpaConfig {

}
