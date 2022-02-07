package com.veitch;

import java.text.MessageFormat;

/**
 * @author zhengweichao  2021-06-15 11:57 上午
 **/
public interface BusinessExceptionAssert extends IResponseEnum, Assert {

    /**
     * 新建异常
     *
     * @param args message
     * @return 异常
     */
    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new BusinessException(this, args, msg);
    }

    /**
     * 新建异常
     *
     * @param t 异常
     * @param args message
     * @return 异常
     */
    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new BusinessException(this, args, msg, t);
    }

}
