package com.lovelive.controller;

import com.lovelive.dto.token.TokenCreateRequest;
import com.lovelive.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/26 20:57
 */
@RestController
@RequestMapping("/tokens")
@Api(tags = "token模块")
public class TokenController {

    private UserService userService;

    @ApiOperation("创建token")
    @PostMapping
    public String create(@RequestBody TokenCreateRequest token) {
        return userService.createToken(token);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
