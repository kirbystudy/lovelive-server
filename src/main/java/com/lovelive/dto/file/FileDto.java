package com.lovelive.dto.file;

import com.lovelive.enums.FileStatus;
import com.lovelive.enums.FileType;
import com.lovelive.enums.Storage;
import lombok.Data;

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

    private String uri;

    private String ext;

    private Long size;

    private FileType type;

    private Storage storage;

    private FileStatus status;

    private Date createdTime;

    private Date updatedTime;
}
