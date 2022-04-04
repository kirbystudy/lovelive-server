package com.lovelive.service.impl;

import com.lovelive.dto.site.SiteConfigDto;
import com.lovelive.service.FileService;
import com.lovelive.service.SiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/3 20:13
 */
@Service
public class SiteConfigServiceImpl implements SiteConfigService {

    @Value("${cos.bucket}")
    private String bucket;

    @Value("${cos.region}")
    private String region;

    private FileService fileService;


    @Override
    public SiteConfigDto getSiteConfig() {
        SiteConfigDto siteConfigDto = new SiteConfigDto();
        siteConfigDto.setBucket(bucket);
        siteConfigDto.setRegion(region);
        siteConfigDto.setStorage(fileService.getDefaultStorage());
        return siteConfigDto;
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }
}
