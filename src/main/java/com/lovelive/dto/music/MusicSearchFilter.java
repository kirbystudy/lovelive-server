package com.lovelive.dto.music;

import lombok.Data;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/9 16:42
 */
@Data
public class MusicSearchFilter {


    private String name = "";

    /**
     * 页数
     */
    private Integer page = 1;

    /**
     * 每页显示的条数
     */
    private Integer size = 10;
}
