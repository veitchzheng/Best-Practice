package com.veitch.response;

import com.veitch.CommonResponseEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * ιη¨ response
 *
 * @author zhengweichao  2021-06-16 8:54 δΈε
 **/
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class R extends BaseResponse {

    private Object data;

    public R(Object data) {
        super(CommonResponseEnum.SUCCESS);
        this.data = data;
    }

}
