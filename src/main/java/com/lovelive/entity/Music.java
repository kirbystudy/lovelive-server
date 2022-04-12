package com.lovelive.entity;

import com.lovelive.enums.MusicStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany
    @JoinTable(name = "artist_music",
            joinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"))
    private List<Artist> artists;

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
