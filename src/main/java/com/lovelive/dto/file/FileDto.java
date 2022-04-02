package com.lovelive.dto.file;

import com.lovelive.enums.FileStatus;
import com.lovelive.enums.FileType;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/1 18:01
 */
@Data
public class FileDto {

    private String id;

    private String name;

    private String key;

    private String ext;

    private Integer size;

    @Enumerated(EnumType.STRING)
    private FileType type;

    @Enumerated(EnumType.STRING)
    private FileStatus status;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;
}
