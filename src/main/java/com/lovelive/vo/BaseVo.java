package com.lovelive.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author 小埋
 * @version 1.0
 * @Description 公共基类
 * @Date 2022/4/2 15:24
 */
@Data
public abstract class BaseVo {

    private String id;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddhhmmss")
    private Date createdTime;

    /**
     * 更新时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddhhmmss")
    private Date updatedTime;
}
