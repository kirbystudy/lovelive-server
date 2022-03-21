package com.lovelive.exception;

import lombok.Data;

/**
 * @author 小埋
 * @version 1.0
 * @Description 错误响应
 * @Date 2022/3/20 21:30
 */
@Data
public class ErrorResponse {

   private Integer code;

   private String message;

   private Object trace;

}
