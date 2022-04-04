package com.lovelive.dto.music;

import com.lovelive.dto.file.FileDto;
import com.lovelive.enums.MusicStatus;
import lombok.Data;

import java.util.Date;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/30 11:47
 */
@Data
public class MusicDto {

    /**
     * 歌曲id
     */
    private String id;

    /**
     * 歌曲名
     */
    private String name;

    /**
     * 歌曲上架状态
     */
    private MusicStatus status;

    /**
     * 歌曲简介
     */
    private String description;

    /**
     * 文件id
     */
    private FileDto file;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;

}
