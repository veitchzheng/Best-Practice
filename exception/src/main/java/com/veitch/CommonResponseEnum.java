package com.veitch;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhengweichao  2021-06-15 5:24 下午
 **/
@Getter
@AllArgsConstructor
public enum CommonResponseEnum implements IResponseEnum, Assert {

    /**
     * 业务处理成功
     */
    SUCCESS(0, "success"),

    /**
     * Bad licence type
     */
    SERVER_ERROR(50000, "server error."),
    ;


    /**
     * 返回码
     */
    private final int code;
    /**
     * 返回消息
     */
    private final String message;

    /**
     * 创建异常
     *
     * @param args message
     * @return 异常
     */
    @Override
    public BaseException newException(Object... args) {
        return newException(args);
    }

    /**
     * 创建异常
     *
     * @param t 异常
     * @param args message
     * @return 异常
     */
    @Override
    public BaseException newException(Throwable t, Object... args) {
        return newException(t, args);
    }
}
