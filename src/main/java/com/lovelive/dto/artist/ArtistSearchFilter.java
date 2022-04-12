package com.lovelive.dto.artist;

import com.lovelive.dto.BaseSearchFilter;
import lombok.Data;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/10 21:34
 */
@Data
public class ArtistSearchFilter extends BaseSearchFilter {

    private String name = "";

    private Boolean recommended;
}
