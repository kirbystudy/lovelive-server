package com.lovelive.dto.music;

import com.lovelive.dto.BaseDto;
import com.lovelive.dto.artist.ArtistDto;
import com.lovelive.dto.file.FileDto;
import com.lovelive.enums.MusicStatus;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/30 11:47
 */
@Data
@ToString(callSuper = true)
public class MusicDto extends BaseDto {

    /**
     * 歌曲名
     */
    private String name;

    /**
     * 歌曲上架状态
     */
    private MusicStatus status = MusicStatus.DRAFT;

    /**
     * 歌曲简介
     */
    private String description;

    /**
     * 文件id
     */
    private FileDto file;

    private List<ArtistDto> artistList;
}
