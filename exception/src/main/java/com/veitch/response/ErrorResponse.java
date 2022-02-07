package com.veitch.response;

import com.veitch.IResponseEnum;
import com.veitch.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zhengweichao  2021-06-15 5:22 下午
 **/
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ErrorResponse extends BaseResponse {


    public ErrorResponse(int code, String message) {
        super(code, message);
    }

    public ErrorResponse(IResponseEnum responseEnum){
        super(responseEnum);
    }
}
