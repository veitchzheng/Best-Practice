package com.veitch.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分页 response
 *
 * @author zhengweichao  2021-06-16 8:56 下午
 **/
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QR extends R {

    private QueryDdata data;

    public static void main(String[] args) {
        new QR(new QueryDdata());
    }
}

/**
 * @author zhengweichao  2021-06-16 8:57 下午
 **/
@Data
class QueryDdata {

    private int totalCount;

    private int pageNo;

    private int pageSize;

    private List<Object> records;

}
