package com.example.springbootdemo.common.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Objects;
import lombok.Data;

/**
 * @author zhengweichao
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse<T> implements Serializable {

    public static final Integer SUCCESS = 0;
    private Integer code;
    private String message;
    private T data;
    private PageInfo<T> pageInfo;
    private boolean isSuccess;

    public BaseResponse(ResultStatusEnum responseCodeEnum) {
        this(responseCodeEnum.getCode(), responseCodeEnum.getMessage());
    }

    public BaseResponse(ResultStatusEnum responseCodeEnum, T data) {
        this(responseCodeEnum.getCode(), responseCodeEnum.getMessage(), data);
    }

    public BaseResponse() {
        this(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());
    }

    public BaseResponse(T data) {
        this(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage(), data);
    }

    public BaseResponse(PageInfo<T> pageInfo) {
        this(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage(), pageInfo);
    }

    public BaseResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.isSuccess = Objects.equals(SUCCESS, code);
    }

    public BaseResponse(Integer code, String message, T data) {
        this(code, message);
        this.data = data;
        this.isSuccess = Objects.equals(SUCCESS, code);
    }

    public BaseResponse(Integer code, String message, PageInfo<T> pageInfo) {
        this(code, message);
        this.pageInfo = pageInfo;
        this.isSuccess = Objects.equals(SUCCESS, code);
    }

    /****************************** 执行成功 ******************************/

    public static <R> BaseResponse<R> success() {
        return new BaseResponse<>(ResultStatusEnum.SUCCESS);
    }

    public static <R> BaseResponse<R> success(R data) {
        return new BaseResponse<>(ResultStatusEnum.SUCCESS, data);
    }

    public static <R> BaseResponse<R> success(PageInfo<R> pageInfo) {
        return new BaseResponse<>(pageInfo);
    }

    public static <R> BaseResponse<R> success(ResultStatusEnum resultStatusEnum) {
        return new BaseResponse<>(resultStatusEnum);
    }

    public static <R> BaseResponse<R> success(ResultStatusEnum resultStatusEnum, R data) {
        return new BaseResponse<>(resultStatusEnum, data);
    }

    /****************************** 执行失败 ******************************/

    public static <R> BaseResponse<R> fail() {
        return new BaseResponse<>(ResultStatusEnum.FAILURE);
    }

    public static <R> BaseResponse<R> fail(R data) {
        return new BaseResponse<>(ResultStatusEnum.FAILURE, data);
    }

    public static <R> BaseResponse<R> fail(ResultStatusEnum resultStatusEnum) {
        return new BaseResponse<>(resultStatusEnum);
    }

    public static <R> BaseResponse<R> fail(ResultStatusEnum resultStatusEnum, R data) {
        return new BaseResponse<>(resultStatusEnum, data);
    }

    public static <R> BaseResponse<R> fail(ResultStatusEnum resultStatusEnum, String resultMsg) {
        BaseResponse<R> res = new BaseResponse<>(resultStatusEnum);
        res.setMessage(resultMsg);
        return res;
    }
}
