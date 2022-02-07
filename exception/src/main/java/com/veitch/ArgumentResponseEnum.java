package com.veitch;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhengweichao  2021-06-15 7:11 下午
 **/
@Getter
@AllArgsConstructor
public enum ArgumentResponseEnum  implements BusinessExceptionAssert {
    /**
     * Bad licence type
     */
    VALID_ERROR(50000, "valid error."),
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
        return null;
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
        return null;
    }
}
