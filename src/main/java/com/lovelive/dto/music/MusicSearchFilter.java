package com.lovelive.dto.music;

import com.lovelive.dto.BaseSearchFilter;
import lombok.Data;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/9 16:42
 */
@Data
public class MusicSearchFilter extends BaseSearchFilter {

    private String name = "";

}
