package com.lovelive.controller;

import com.lovelive.mapper.SiteConfigMapper;
import com.lovelive.service.SiteConfigService;
import com.lovelive.vo.site.SiteConfigVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小埋
 * @version 1.0
 * @Description 站点配置信息
 * @Date 2022/4/3 19:54
 */
@RestController
@RequestMapping("/site")
@Api(tags = "站点信息模块")
public class SiteConfigController {

    private SiteConfigService siteConfigService;

    private SiteConfigMapper siteConfigMapper;


    @ApiOperation("获取站点配置信息")
    @GetMapping("/config")
    public SiteConfigVo getSiteConfig() {
        return siteConfigMapper.toVo(siteConfigService.getSiteConfig());
    }

    @Autowired
    public void setSiteConfigService(SiteConfigService siteConfigService) {
        this.siteConfigService = siteConfigService;
    }

    @Autowired
    public void setSiteConfigMapper(SiteConfigMapper siteConfigMapper) {
        this.siteConfigMapper = siteConfigMapper;
    }
}
