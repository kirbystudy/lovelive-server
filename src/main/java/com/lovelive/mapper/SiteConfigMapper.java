package com.lovelive.mapper;

import com.lovelive.dto.site.SiteConfigDto;
import com.lovelive.vo.site.SiteConfigVo;
import org.mapstruct.Mapper;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/3 20:08
 */
@Mapper(componentModel = "spring")
public interface SiteConfigMapper {

    SiteConfigVo toVo(SiteConfigDto siteConfigDto);
}
