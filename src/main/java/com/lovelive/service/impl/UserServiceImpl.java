package com.lovelive.service.impl;

import com.lovelive.dto.UserDto;
import com.lovelive.mapper.UserMapper;
import com.lovelive.repository.UserRepository;
import com.lovelive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 太好听了吧
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/19 10:30
 */
@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    UserMapper userMapper;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> list() {
        return userRepository.findAll().
                stream().map(userMapper::toDto).collect(Collectors.toList());
    }
}
