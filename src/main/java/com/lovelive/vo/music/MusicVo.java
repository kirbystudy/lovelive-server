package com.lovelive.vo.music;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lovelive.enums.MusicStatus;
import lombok.Data;

import java.util.Date;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/30 13:00
 */
@Data
public class MusicVo {

    /**
     * 歌曲id
     */
    private String id;

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
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createdTime;

    /**
     * 更新时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updatedTime;
}
