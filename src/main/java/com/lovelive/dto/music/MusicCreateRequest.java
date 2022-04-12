package com.lovelive.dto.music;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/30 13:13
 */
@Data
@ToString(callSuper = true)
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
    private String fileId;

    @NotNull(message = "歌手未选择")
    private List<String> artistIds;
}
