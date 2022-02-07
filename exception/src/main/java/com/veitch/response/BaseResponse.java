package com.veitch.response;

import com.veitch.IResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhengweichao  2021-06-16 8:54 下午
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {

    private Integer code;

    private String message;

    public BaseResponse(IResponseEnum responseEnum) {
        this(responseEnum.getCode(), responseEnum.getMessage());
    }
}
