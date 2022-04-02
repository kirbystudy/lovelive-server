package com.lovelive.vo.file;

import lombok.Data;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/1 18:36
 */
@Data
public class FileUploadVo {

    private String secretId;

    private String secretKey;

    private String sessionToken;

    private String key;

    private String fileId;

    private String bucket;

    private String region;
}
