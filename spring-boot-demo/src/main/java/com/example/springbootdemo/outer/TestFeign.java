package com.example.springbootdemo.outer;

import feign.RequestLine;
import java.util.List;
import lombok.Data;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author zhengweichao  2022-02-15 10:40 下午
 **/
@FeignClient(name = "test", url = "http://jsonplaceholder.typicode.com")
public interface TestFeign {

    /**
     * 测试 posts
     *
     * @return
     */
    @RequestLine("GET /posts")
    List<User> posts();

    @Data
    class User {

        private Integer userId;
    }
}
