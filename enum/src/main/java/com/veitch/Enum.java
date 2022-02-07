package com.veitch;

import com.google.common.collect.Maps;
import java.util.Arrays;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhengweichao  2021-06-15 4:44 下午
 **/
@AllArgsConstructor
public enum Enum {

    /**
     * 附件类型
     */
    CLAIM_EXAMPLE(1, "理赔样例"),
    ;
    /**
     * 代码
     */
    @Getter
    private final Integer type;
    /**
     * 描述
     */
    @Getter
    private final String desc;

    public static final Map<Integer, Enum> CODE_ENUM_MAP = Maps.uniqueIndex(Arrays.asList(values()), Enum::getType);

    public static Enum typeOf(Integer code) {
        return CODE_ENUM_MAP.get(code);
    }
}
