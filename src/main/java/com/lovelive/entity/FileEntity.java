package com.lovelive.entity;

import com.lovelive.enums.FileStatus;
import com.lovelive.enums.FileType;
import com.lovelive.enums.Storage;
import lombok.Data;

import javax.persistence.*;

/**
 * @author 小埋
 * @version 1.0
 * @Description 文件实体类
 * @Date 2022/4/1 17:48
 */
@Entity
@Table(name = "file")
@Data
public class FileEntity extends TraceableBaseEntity {

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件hash值,即ObjectKey
     */
    @Column(name = "file_key")
    private String key;

    /**
     * 文件后缀名
     */
    private String ext;

    /**
     * 文件大小：单位byte
     */
    private Integer size;

    /**
     * 文件类型：AUDIO-音频, IMAGE-图片, VIDEO-视频, OTHER-其他
     */
    @Enumerated(EnumType.STRING)
    private FileType type;

    /**
     * 存储供应商：COS-腾讯云存储, OSS-阿里云存储
     */
    @Enumerated(EnumType.STRING)
    private Storage storage;

    /**
     * 文件状态：UPLOADING-上传中, UPLOADED-已上传, CANCEL-已取消
     */
    @Enumerated(EnumType.STRING)
    private FileStatus status = FileStatus.UPLOADING;
}
