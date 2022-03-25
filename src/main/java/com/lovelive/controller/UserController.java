package com.lovelive.controller;

import com.lovelive.dto.user.UserCreateRequest;
import com.lovelive.dto.user.UserUpdateRequest;
import com.lovelive.mapper.UserMapper;
import com.lovelive.service.UserService;
import com.lovelive.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
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


    /**
     * 分页查询用户
     * @param pageable
     * @return
     */
    @GetMapping
    public Page<UserVo> search(@PageableDefault(sort = {"createdTime"},direction = Sort.Direction.ASC) Pageable pageable) {
        return userService.search(pageable).map(userMapper::toVo);

    }

    /**
     * 注册用户
     * @param userCreateRequest
     * @return
     */
    @PostMapping
    public UserVo create(@Validated @RequestBody UserCreateRequest userCreateRequest) {
        return userMapper.toVo(userService.create(userCreateRequest));
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public UserVo get(@PathVariable String id) {
        return userMapper.toVo(userService.get(id));
    }

    /**
     * 根据id修改用户
     * @param id
     * @param userUpdateRequest
     * @return
     */
    @PutMapping("/{id}")
    public UserVo update(@PathVariable String id,
                         @Validated @RequestBody UserUpdateRequest userUpdateRequest) {
        return userMapper.toVo(userService.update(id,userUpdateRequest));
    }

    /**
     * 根据id删除用户
     * @param id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
