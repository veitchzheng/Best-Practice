package com.example.springbootdemo.aspect;

import com.example.springbootdemo.common.response.BaseResponse;
import com.example.springbootdemo.common.response.ResultStatusEnum;
import java.util.StringJoiner;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * rest 异常拦截
 *
 * @author zhengweichao  2022-02-14 7:10 下午
 **/
@Slf4j
@RestControllerAdvice
public class ControllerExceptionAdvice {


    /**
     * 方法参数校验
     *
     * @param e MethodArgumentNotValidException
     * @return response
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse<Void> handleException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        return BaseResponse.fail(ResultStatusEnum.REQUEST_ERROR_PARAM_ILLEGAL);
    }

    /**
     * validationException
     *
     * @param e ValidationException
     * @return response
     */
    @ExceptionHandler(ValidationException.class)
    public BaseResponse<Void> handleException(ValidationException e) {
        log.error(e.getMessage(), e);
        return BaseResponse.fail(ResultStatusEnum.REQUEST_ERROR_PARAM_ILLEGAL, e.getCause().getMessage());
    }

    /**
     * ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public BaseResponse<Void> handleConstraintViolationException(ConstraintViolationException e) {
        log.error(e.getMessage(), e);
        StringJoiner sj = new StringJoiner(";");
        e.getConstraintViolations().forEach(x -> sj.add(x.getMessageTemplate()));
        return BaseResponse.fail(ResultStatusEnum.REQUEST_ERROR_PARAM_ILLEGAL, sj.toString());
    }
    
    @ExceptionHandler(Exception.class)
    public BaseResponse<Void> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return BaseResponse.fail(ResultStatusEnum.FAILURE);
    }
}
