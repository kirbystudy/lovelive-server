package com.lovelive.exception;

import com.lovelive.enums.ExceptionType;

/**
 * @author 小埋
 * @version 1.0
 * @Description 处理异常
 * @Date 2022/3/20 20:48
 */
public class BizException extends RuntimeException{

    private final Integer code;

    public BizException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.code = exceptionType.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
