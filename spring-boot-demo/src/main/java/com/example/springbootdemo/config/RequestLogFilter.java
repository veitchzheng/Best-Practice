package com.example.springbootdemo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

/**
 * @author zhengweichao  2022-02-10 4:50 下午
 **/
@Slf4j
@Configuration
public class RequestLogFilter extends AbstractRequestLoggingFilter {

    ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        RequestLogFilter loggingFilter = new RequestLogFilter();
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setMaxPayloadLength(64000);
        objectMapper = new ObjectMapper();
    }

    /**
     * Concrete subclasses should implement this method to write a log message
     * <i>before</i> the request is processed.
     *
     * @param request current HTTP request
     * @param message the message to log
     */
    @SneakyThrows
    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        log.info("{}, params:{}", message, objectMapper.writeValueAsString(request.getParameterMap()));
    }

    /**
     * Concrete subclasses should implement this method to write a log message
     * <i>after</i> the request is processed.
     *
     * @param request current HTTP request
     * @param message the message to log
     */
    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        log.info(message);
    }
}
