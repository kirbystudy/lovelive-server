package com.lovelive.entity;

import com.lovelive.enums.PlaylistStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author 小埋
 * @version 1.0
 * @Description 歌单实体类
 * @Date 2022/4/4 16:16
 */
@Entity
@Data
public class Playlist extends TraceableBaseEntity {

    /**
     * 歌单名字
     */
    private String name;

    /**
     * 歌单简介
     */
    private String description;

    /**
     * 歌单封面ID
     */
    @OneToOne
    private FileEntity cover;

    /**
     * 歌曲上架状态(DRAFT-草稿，PUBLISHED-已上架，CLOSED-已下架)
     */
    @Enumerated(EnumType.STRING)
    private PlaylistStatus status = PlaylistStatus.DRAFT;

    @ManyToMany
    @JoinTable(name = "playlist_music", joinColumns = @JoinColumn(name = "playlist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"))
    private List<Music> musicList;

    /**
     * 是否推荐：推荐：1, 不推荐：0, 默认：0
     */
    private Boolean recommended = false;

    /**
     * 推荐因数：越高越在上面
     */
    private Integer recommendFactor = 0;

    /**
     * 是否特色歌单：特色歌单：1, 否则：0, 默认：0
     */
    private Boolean special = false;
}
