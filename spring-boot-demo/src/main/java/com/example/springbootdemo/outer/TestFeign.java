package com.example.springbootdemo.outer;

import java.util.List;
import lombok.Data;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhengweichao  2022-02-15 10:40 下午
 **/
@FeignClient(name= "test", url = "http://jsonplaceholder.typicode.com")
public interface TestFeign {

    @GetMapping("/posts")
    List<User> posts();

    @Data
    class User{
        private Integer userId;
    }
}
