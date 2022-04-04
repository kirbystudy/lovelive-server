package com.lovelive.dto.site;

import com.lovelive.enums.Storage;
import lombok.Data;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/3 20:05
 */
@Data
public class SiteConfigDto {

    /**
     * 存储桶
     */
    private String bucket;

    /**
     * 所属地域
     */
    private String region;

    /**
     * 存储对象
     */
    private Storage storage;
}
