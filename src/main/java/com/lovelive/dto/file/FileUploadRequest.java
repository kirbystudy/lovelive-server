package com.lovelive.dto.file;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/1 18:38
 */
@Data
public class FileUploadRequest {

    @NotBlank(message = "文件名不能为空")
    private String name;

    private Long size;

    @NotBlank(message = "后缀名不能为空")
    private String ext;

    @NotBlank(message = "key不能为空")
    private String key;
}
