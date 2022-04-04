package com.lovelive.dto.music;

import com.lovelive.dto.file.FileDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/30 13:13
 */
@Data
public class MusicCreateRequest {

    /**
     * 歌曲名
     */
    @NotBlank(message = "歌曲名不能为空")
    private String name;

    /**
     * 歌曲简介
     */
    private String description;

    /**
     * 文件id
     */
    private FileDto file;
}
