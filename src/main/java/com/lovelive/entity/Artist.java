package com.lovelive.entity;

import com.lovelive.enums.ArtistStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author 小埋
 * @version 1.0
 * @Description 歌手实体类
 * @Date 2022/4/7 21:43
 */
@Entity
@Data
public class Artist extends TraceableBaseEntity {

    /**
     * 歌手名字
     */
    private String name;

    /**
     * 歌手备注
     */
    private String remark;

    /**
     * 歌手照片ID
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    private FileEntity photo;

    @ManyToMany
    @JoinTable(name = "artist_music",
            joinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"))
    private List<Music> musicList;

    /**
     * 歌手上架状态(DRAFT-草稿，PUBLISHED-已上架，BLOCKED-已封禁)
     */
    private ArtistStatus status;


}

