package com.lovelive.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/8 12:54
 */
@Data
public abstract class BaseDto {

    protected String id;

    protected Date createdTime;

    protected Date updatedTime;
}
