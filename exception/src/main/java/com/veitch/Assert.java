package com.veitch;

/**
 * @author zhengweichao  2021-06-15 11:41 上午
 **/
public interface Assert {

    /**
     * 创建异常
     *
     * @param args message
     * @return 异常
     */
    BaseException newException(Object... args);

    /**
     * 创建异常
     *
     * @param t 异常
     * @param args message
     * @return 异常
     */
    BaseException newException(Throwable t, Object... args);

    /**
     * <p>断言对象<code>obj</code>非空。如果对象<code>obj</code>为空，则抛出异常
     *
     * @param obj 待判断对象
     * @throws BaseException 异常
     */
    default void assertNotNull(Object obj) throws BaseException {
        if (obj == null) {
            throw newException(obj);
        }
    }

    /**
     * <p>断言对象<code>obj</code>非空。如果对象<code>obj</code>为空，则抛出异常
     * <p>异常信息<code>message</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param obj 待判断对象
     * @param args message占位符对应的参数列表
     * @throws BaseException 异常
     */
    default void assertNotNull(Object obj, Object... args) throws BaseException {
        if (obj == null) {
            throw newException(args);
        }
    }
}
