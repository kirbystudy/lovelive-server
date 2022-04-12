package com.lovelive.dto.artist;

import com.lovelive.dto.TraceableBaseDto;
import com.lovelive.dto.file.FileDto;
import com.lovelive.dto.music.MusicDto;
import com.lovelive.enums.ArtistStatus;
import lombok.Data;

import java.util.List;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/8 12:54
 */
@Data
public class ArtistDto extends TraceableBaseDto {

    private String name;

    private String remark;

    private FileDto photo;

    private List<MusicDto> musicDtoList;

    private ArtistStatus status;

    private Boolean recommended;

    private Integer recommendFactor;
}
