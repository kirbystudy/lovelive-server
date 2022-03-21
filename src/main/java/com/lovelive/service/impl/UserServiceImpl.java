package com.lovelive.service.impl;

import com.lovelive.dto.user.UserCreateDto;
import com.lovelive.dto.user.UserDto;
import com.lovelive.entity.User;
import com.lovelive.enums.ExceptionType;
import com.lovelive.exception.BizException;
import com.lovelive.mapper.UserMapper;
import com.lovelive.repository.UserRepository;
import com.lovelive.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/19 10:30
 */
@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    UserMapper userMapper;

    PasswordEncoder passwordEncoder;



    @Override
    public List<UserDto> list() {
        return userRepository.findAll().
                stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto create(UserCreateDto userCreateDto) {
        checkUserName(userCreateDto.getUsername());
        User user = userMapper.createEntity(userCreateDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.toDto(userRepository.save(user));
    }

    private void checkUserName(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        // 如果user != null
        if (user.isPresent()) {
            throw new BizException(ExceptionType.USER_NAME_REPEAT);
        }
    }

    @Override
    public User loadUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return user.get();
    }


    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
