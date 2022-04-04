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
public class Playlist extends AbstractEntity {

    private String name;

    private String description;

    @OneToOne
    private FileEntity cover;

    @Enumerated(EnumType.STRING)
    private PlaylistStatus status = PlaylistStatus.DRAFT;

    @OneToOne
    private User creator;

    @ManyToMany
    @JoinTable(name = "playlist_music", joinColumns = @JoinColumn(name = "playlist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"))
    private List<Music> musicList;
}
