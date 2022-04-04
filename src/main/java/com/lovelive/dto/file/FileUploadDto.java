package com.lovelive.dto.file;

import lombok.Data;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/1 18:14
 */
@Data
public class FileUploadDto {

    /**
     * 云 API 密钥 Id
     */
    private String secretId;

    /**
     * 云 API 密钥 key
     */
    private String secretKey;

    /**
     * 请求时需要用的 token 字符串，最终请求 COS API 时，需要放在 Header 的 x-cos-security-token 字段
     */
    private String sessionToken;

    /**
     * 临时密钥 key
     */
    private String key;

    /**
     * 文件标识
     */
    private String fileId;
    
    /**
     * 创建时间(时间戳)
     */
    private Long startTime;

    /**
     * 过期时间(时间戳)
     */
    private Long expiredTime;
}
