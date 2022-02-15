package com.example.springbootdemo.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * FileName : PageInfo
 * <p>
 * ProjectName : xinche-after-mdcs
 * <p>
 * PackageName : com.maodou.scm.monitor.response
 * <p>
 * Description : 分页信息
 *
 * @author : daisenrong
 * @version : 1.0.0
 * @date : 2018/11/16 21:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageInfo<T> implements Serializable {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalCount;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<T> data;

}
