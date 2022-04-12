package com.lovelive.dto.playlist;

import com.lovelive.dto.TraceableBaseDto;
import com.lovelive.dto.music.MusicDto;
import com.lovelive.entity.FileEntity;
import com.lovelive.enums.PlaylistStatus;
import lombok.Data;

import java.util.List;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/4 18:02
 */
@Data
public class PlaylistDto extends TraceableBaseDto {

    private String id;

    private String name;

    private String description;

    private FileEntity cover;

    private PlaylistStatus status;

    private List<MusicDto> musicList;

    private Boolean recommended;

    private Integer recommendFactor;

    private Boolean special;

}
