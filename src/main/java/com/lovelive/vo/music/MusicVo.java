package com.lovelive.vo.music;

import com.lovelive.enums.MusicStatus;
import com.lovelive.vo.BaseVo;
import com.lovelive.vo.artist.ArtistVo;
import com.lovelive.vo.file.FileVo;
import lombok.Data;

import java.util.List;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/30 13:00
 */
@Data
public class MusicVo extends BaseVo {

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
    private FileVo file;

    private List<ArtistVo> artistsList;

}
