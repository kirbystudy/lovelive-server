package com.lovelive.controller;

import com.lovelive.dto.user.UserCreateRequest;
import com.lovelive.dto.user.UserUpdateRequest;
import com.lovelive.mapper.UserMapper;
import com.lovelive.service.UserService;
import com.lovelive.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

/**
 * @author 小埋
 * @version 1.0
 * @Description 用户控制层
 * @Date 2022/3/18 21:49
 */
@RestController
@RequestMapping("/users")
@Api(tags = "用户")
public class UserController {

    UserService userService;

    UserMapper userMapper;


    /**
     * 用户检索
     *
     * @param pageable
     * @return
     */
    @ApiOperation("用户检索")
    @GetMapping
    @RolesAllowed("ROLE_ADMIN")
    public Page<UserVo> search(@PageableDefault(sort = {"createdTime"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return userService.search(pageable).map(userMapper::toVo);

    }

    /**
     * 注册用户
     *
     * @param userCreateRequest
     * @return
     */
    @ApiOperation("注册用户")
    @PostMapping
    @RolesAllowed("ROLE_ADMIN")
    public UserVo create(@Validated @RequestBody UserCreateRequest userCreateRequest) {
        return userMapper.toVo(userService.create(userCreateRequest));
    }

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @ApiOperation("根据id查询用户")
    @GetMapping("/{id}")
    public UserVo get(@PathVariable String id) {
        return userMapper.toVo(userService.get(id));
    }

    /**
     * 根据id修改用户
     *
     * @param id
     * @param userUpdateRequest
     * @return
     */
    @ApiOperation("根据id修改用户")
    @PutMapping("/{id}")
    @RolesAllowed("ROLE_ADMIN")
    public UserVo update(@PathVariable String id,
                         @Validated @RequestBody UserUpdateRequest userUpdateRequest) {
        return userMapper.toVo(userService.update(id, userUpdateRequest));
    }

    /**
     * 根据id删除用户
     *
     * @param id
     */
    @ApiOperation("根据id删除用户")
    @DeleteMapping("/{id}")
    @RolesAllowed("ROLE_ADMIN")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }

    /**
     * 当前登录状态的用户信息
     *
     * @return
     */
    @ApiOperation("当前登录状态的用户信息")
    @GetMapping("/myLoginState")
    public UserVo myLoginState() {
        return userMapper.toVo(userService.getCurrentUser());
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
