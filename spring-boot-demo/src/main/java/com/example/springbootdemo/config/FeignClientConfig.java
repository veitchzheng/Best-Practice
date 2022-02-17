package com.example.springbootdemo.config;

import static java.util.concurrent.TimeUnit.SECONDS;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Contract;
import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Retryer;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import io.micrometer.core.instrument.util.StringUtils;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author zhengweichao  2022-02-16 7:11 下午
 **/
@Slf4j
@Configuration
public class FeignClientConfig {

    @Resource
    private ObjectMapper objectMapper;

    /**
     * 使用feign的注解方式
     *
     * @return
     */
    @Bean
    public Contract useFeignAnnotations() {
        return new Contract.Default();
    }


    @Bean
    public Encoder feignEncoder() {
        return new JacksonEncoder();
    }

    @Bean
    public Decoder feignDecoder() {
        return new JacksonDecoder(objectMapper);
    }

    @Bean
    public Request.Options feignOptions() {
        return new Request.Options(5000, TimeUnit.MILLISECONDS, 15000, TimeUnit.MILLISECONDS, true);
    }

    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(100, SECONDS.toMillis(1), 3);
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return (s, response) -> {
            log.info("==================================");
            log.info("feign error {}", s);
            return null;
        };
    }


}

/**
 * feign 请求的签名拦截器
 */
@Setter
@Component
@ConfigurationProperties(prefix = "sign")
class FeignRequestSignInterceptor implements RequestInterceptor {

    private Map<String, String> configs;

    /**
     * Called for every request. Add data using methods on the supplied {@link RequestTemplate}.
     *
     * @param template
     */
    @SneakyThrows
    @Override
    public void apply(RequestTemplate template) {
        URL url = new URL(template.feignTarget().url());
        String signKey = url.getHost().replace("\\.", "-");
        String secret = configs.get(signKey);
        if (StringUtils.isBlank(secret)) {
            return;
        }

        template.query("appKey", signKey);
        template.query("sign", secret);
    }
}
