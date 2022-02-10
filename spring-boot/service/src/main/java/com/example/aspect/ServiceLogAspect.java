package com.example.aspect;

import com.google.common.base.Stopwatch;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zhengweichao
 */
@Aspect
@Slf4j
@Order(0)
@Component
public class ServiceLogAspect {

    @Pointcut("execution(public * com.example.service..*ServiceImpl.*(..))")
    public void servicePoint() {
        // empty method
    }

    @Around("servicePoint()")
    public Object doServiceAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Object result = null;
        try {
            Object[] params = joinPoint.getArgs();
            log.info("Service层 className={}, methodName={}, params={}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), Arrays.toString(params));
            result = joinPoint.proceed();
        } finally {
            log.info("Service层 耗时={}(ms), className={}, methodName={}, result={}",
                stopwatch.elapsed(TimeUnit.MILLISECONDS), joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), result);
        }
        return result;
    }
}
