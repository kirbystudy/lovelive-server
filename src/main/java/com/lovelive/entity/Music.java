package com.lovelive.entity;

import com.lovelive.enums.MusicStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

/**
 * @author 小埋
 * @version 1.0
 * @Description 音乐实体类
 * @Date 2022/3/30 1:00
 */
@Entity
@Data
public class Music extends BaseEntity {

    /**
     * 歌曲名
     */
    private String name;

    /**
     * 歌曲上架状态
     */
    @Enumerated(EnumType.STRING)
    private MusicStatus status;

    /**
     * 歌曲简介
     */
    private String description;

    /**
     * 一对一关系 关联文件表
     */
    @OneToOne
    private FileEntity file;
}
