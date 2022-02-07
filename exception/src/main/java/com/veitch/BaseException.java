package com.veitch;

import lombok.Getter;

/**
 * @author zhengweichao  2021-06-15 11:42 上午
 **/
@Getter
public class BaseException extends Exception {

    private int code;

    private String message;

    private IResponseEnum responseEnum;

    public BaseException(IResponseEnum responseEnum, Object[] args, String message) {
        super();
        this.code = responseEnum.getCode();

    }

    public BaseException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {

    }

    public BaseException(CommonResponseEnum serverError) {

    }
}
