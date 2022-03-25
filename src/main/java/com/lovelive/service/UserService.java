package com.lovelive.service;

import com.lovelive.dto.user.UserCreateRequest;
import com.lovelive.dto.user.UserDto;
import com.lovelive.dto.user.UserUpdateRequest;
import com.lovelive.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Arrays;
import java.util.List;

/**
 * @author 小埋
 * @version 1.0
 * @Description 用户业务层接口
 * @Date 2022/3/19 10:29
 */
public interface UserService extends UserDetailsService {
    List<UserDto> list();

    UserDto create(UserCreateRequest userCreateRequest);

    @Override
    User loadUserByUsername(String username);

    UserDto get(String id);

    UserDto update(String id, UserUpdateRequest userUpdateRequest);

    void delete(String id);

    Page<UserDto> search(Pageable pageable);
}
