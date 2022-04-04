package com.lovelive.service;

import com.lovelive.dto.site.SiteConfigDto;
import com.lovelive.enums.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/3 20:42
 */
@SpringBootTest
class SiteConfigServiceTest {

    private SiteConfigService siteConfigService;

    @Test
    void getSiteConfig() {
        SiteConfigDto siteConfig = siteConfigService.getSiteConfig();
        Assertions.assertNotNull(siteConfig.getBucket());
        Assertions.assertNotNull(siteConfig.getRegion());
        Assertions.assertInstanceOf(Storage.class, siteConfig.getStorage());
    }

    @Autowired
    private void setSiteConfigService(SiteConfigService siteConfigService) {
        this.siteConfigService = siteConfigService;
    }
}