package com.lovelive.controller;

import com.lovelive.dto.user.UserCreateDto;
import com.lovelive.mapper.UserMapper;
import com.lovelive.repository.UserRepository;
import com.lovelive.service.UserService;
import com.lovelive.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 小埋
 * @version 1.0
 * @Description 用户控制层
 * @Date 2022/3/18 21:49
 */
@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    UserMapper userMapper;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<UserVo> list() {
        return userService.list()
                .stream().map(userMapper::toVo).collect(Collectors.toList());
    }

    @PostMapping
    public UserVo create(@RequestBody UserCreateDto userCreateDto) {
        return userMapper.toVo(userService.create(userCreateDto));
    }
}
