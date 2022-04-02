package com.lovelive.enums;

/**
 * @author 小埋
 * @version 1.0
 * @Description 返回状态码枚举类
 * @Date 2022/3/20 20:50
 */
public enum ExceptionType {

    /**
     * 异常状态码
     */
    INTERNAL_ERROR(500, "系统内部错误"),
    UNAUTHORIZED(401, "未登录"),
    BAD_REQUEST(400, "请求错误"),
    FORBIDDEN(403, "无权限操作"),
    NOT_FOUND(404, "未找到"),
    USER_NAME_REPEAT(40001001, "用户名重复"),
    USER_NOT_FOUND(40401002, "用户不存在"),
    USER_PASSWORD_NOT_MATCH(40001003, "用户名或密码错误"),
    USER_NOT_ENABLED(50001001, "用户未启用"),
    USER_LOCKED(50001002, "用户被锁定"),
    MUSIC_NOT_FOUND(40402001, "歌曲不存在"),
    FILE_NOT_FOUND(40403001, "文件不存在");


    private final Integer code;
    private final String message;

    ExceptionType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
