package com.example.springbootdemo.common.response;

import com.google.common.collect.Maps;
import java.util.Arrays;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.annotation.Description;

/**
 * Api返回状态码
 *
 * @author zhengweichao
 * @since 2018/12/17
 */
@Getter
@Description("Api返回状态码信息和相关描述，前端可根据状态码定位问题")
@AllArgsConstructor
public enum ResultStatusEnum {

    /****************************** (100+)数据库异常 ******************************/
    DB_ERROR_INSERT(10001, "数据更新失败"),
    DB_ERROR_SELECT(10002, "数据查询失败"),
    DB_ERROR_DELETE(10003, "数据删除失败"),
    DB_ERROR_UPDATE(10004, "数据更新失败"),
    DB_ERROR_TX(10005, "数据库事务异常"),
    DB_ERROR_MULTI_RECORD(10006, "查询到多条记录"),
    DB_ERROR_UPDATE_HOPEFUL_VERSION(10007, "多次更新数据"),

    /****************************** (0+)执行成功 ******************************/
    SUCCESS(0, "执行成功"),
    SUCCESS_ACCEPTED(20002, "数据正在被处理"),

    /****************************** (300+)请求资源异常 ******************************/
    RESOURCE_ERROR(30000, "请求资源异常"),

    /****************************** (400+)请求错误，可能是权限问题, 参数校验 ******************************/
    REQUEST_ERROR(40000, "请求异常"),
    REQUEST_ERROR_AUTHENTICATION(40001, "权限不合法"),
    REQUEST_ERROR_PARAM_ILLEGAL(40002, "参数不合法"),
    REQUEST_ERROR_PARAM_CHECK(40004, "访问未授权"),
    REQUEST_ERROR_NOT_ALLOW_OPTION(40005, "不允许的操作"),
    REQUEST_ERROR_CONFLICT_PARAM(40006, "与现有配置冲突"),
    /** 移动端需要重新验证 */
    REQUEST_ERROR_MOBILE_NO_LOGIN(41003, "身份验证失效，请重新验证"),

    /****************************** (500+)服务端异常 ******************************/
    FAILURE(50000, "执行失败"),
    FAILURE_SYSTEM(50001, "系统异常"),
    FAILURE_RPC(50002, "系统RPC异常"),
    FAILURE_PUBLIC_PERMISSION(50003, "请求公共组权限服务异常"),

    /****************************** (600+)业务异常 ******************************/
    BIZ_ERROR(60000, "业务异常"),
    USER_NOT_EXIST(60003,"access denied!"),
    ;

    private final int code;
    private final String message;

    private static final Map<Integer, ResultStatusEnum> CODE_ENUM_MAP = Maps.uniqueIndex(Arrays.asList(values()),
        ResultStatusEnum::getCode);

    public static ResultStatusEnum codeOf(int code) {
        return CODE_ENUM_MAP.get(code);
    }

}