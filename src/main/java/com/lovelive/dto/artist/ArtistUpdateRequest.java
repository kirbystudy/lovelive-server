package com.lovelive.dto.artist;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/8 14:17
 */
@Data
public class ArtistUpdateRequest {

    @NotBlank(message = "歌手名字不能为空")
    private String name;

    private String remark;

    @NotBlank(message = "歌手图片必须上传")
    private String photoId;
}

