package com.lovelive.service;

import com.lovelive.dto.user.UserCreateDto;
import com.lovelive.dto.user.UserDto;
import com.lovelive.entity.User;
import com.lovelive.vo.UserVo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/19 10:29
 */
public interface UserService extends UserDetailsService {
    List<UserDto> list();

    UserDto create(UserCreateDto userCreateDto);

    @Override
    User loadUserByUsername(String username);
}
