package com.lovelive.config;

import com.lovelive.exception.RestAuthenticationEntryPoint;
import com.lovelive.filter.JwtAuthorizationFilter;
import com.lovelive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * @author 小埋
 * @version 1.0
 * @Description Security配置类
 * @Date 2022/3/20 23:18
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 实例自定义登录校验接口 【内部有 数据库查询】
     */
    UserService userService;

    RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    /**
     * 拦截规则设置
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(CREATE_TOKEN_URL).permitAll()
                .antMatchers(SITE_CONFIG_URL).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), userService))
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /**
     * 忽略拦截的静态文件路径(白名单机制)
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/swagger**/**")
                .antMatchers("/webjars/**")
                .antMatchers("/v3/**")
                .antMatchers("/doc.html")
                .antMatchers("/weixin/**");
    }

    /**
     * 添加 UserDetailsService， 实现自定义登录校验，数据库查询
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 注入用户信息，每次登录都会来这查询一次信息
        auth.userDetailsService(userService);
    }


    /**
     * 密钥
     */
    public static final String SECRET = "LoveLiveMusic";

    /**
     * 过期时间设置为10天
     */
    public static final long EXPIRATION_TIME = 864000000;

    /**
     * TOKEN前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 鉴权头部信息
     */
    public static final String HEADER_STRING = "Authorization";

    /**
     * 白名单接口
     */
    public static final String CREATE_TOKEN_URL = "/tokens";
    public static final String SITE_CONFIG_URL = "/site/config";

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRestAuthenticationEntryPoint(RestAuthenticationEntryPoint restAuthenticationEntryPoint) {
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
    }
}
