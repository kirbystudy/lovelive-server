package com.lovelive.dto.playlist;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/12 23:38
 */
@Data
public class PlaylistCreateRequest {

    @NotBlank(message = "歌单名不能为空")
    private String name;

    private String description;

    @NotNull(message = "请上传封面")
    private String coverId;

}
