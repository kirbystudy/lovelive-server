package com.lovelive.config;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 小埋
 * @version 1.0
 * @Description 微信登录配置类
 * @Date 2022/3/28 22:40
 */
@Configuration
public class WeChatConfig {

    @Value("${weixin.mp.app-id}")
    private String appId;

    @Value("${weixin.mp.app-secret}")
    private String appSecret;

    @Bean
    WxMpService wxMpService() {
        WxMpService wxMpService = new WxMpServiceImpl();
        WxMpDefaultConfigImpl config = new WxMpDefaultConfigImpl();
        config.setAppId(appId);
        config.setSecret(appSecret);
        wxMpService.setWxMpConfigStorage(config);
        return wxMpService;
    }
}
