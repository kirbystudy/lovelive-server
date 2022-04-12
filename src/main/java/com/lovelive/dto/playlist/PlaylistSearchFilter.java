package com.lovelive.dto.playlist;

import com.lovelive.dto.BaseSearchFilter;
import lombok.Data;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/13 0:21
 */
@Data
public class PlaylistSearchFilter extends BaseSearchFilter {

    private String name = "";

    private Boolean recommended;
}
