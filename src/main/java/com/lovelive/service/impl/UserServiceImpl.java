package com.lovelive.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.lovelive.config.SecurityConfig;
import com.lovelive.dto.token.TokenCreateRequest;
import com.lovelive.dto.user.UserCreateRequest;
import com.lovelive.dto.user.UserDto;
import com.lovelive.dto.user.UserUpdateRequest;
import com.lovelive.entity.User;
import com.lovelive.enums.ExceptionType;
import com.lovelive.exception.BizException;
import com.lovelive.mapper.UserMapper;
import com.lovelive.repository.UserRepository;
import com.lovelive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author 小埋
 * @version 1.0
 * @Description 用户业务层实现类
 * @Date 2022/3/19 10:30
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

    UserRepository repository;

    UserMapper userMapper;

    PasswordEncoder passwordEncoder;


    @Override
    public List<UserDto> list() {
        return repository.findAll().
                stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto create(UserCreateRequest userCreateRequest) {
        checkUserName(userCreateRequest.getUsername());
        User user = userMapper.createEntity(userCreateRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.toDto(repository.save(user));
    }

    private void checkUserName(String username) {
        Optional<User> user = repository.findByUsername(username);
        // 如果user != null
        if (user.isPresent()) {
            throw new BizException(ExceptionType.USER_NAME_REPEAT);
        }
    }

    @Override
    public User loadUserByUsername(String username) {
        return super.loadUserByUsername(username);
    }

    @Override
    public UserDto get(String id) {
        return userMapper.toDto(getById(id));
    }

    @Override
    public UserDto update(String id, UserUpdateRequest userUpdateRequest) {
        return userMapper.toDto(repository.save(userMapper.updateEntity(getById(id), userUpdateRequest)));

    }

    @Override
    public void delete(String id) {
        repository.delete(getById(id));
    }

    @Override
    public Page<UserDto> search(Pageable pageable) {
        return repository.findAll(pageable).map(userMapper::toDto);
    }

    @Override
    public String createToken(TokenCreateRequest tokenCreateRequest) {
        User user = loadUserByUsername(tokenCreateRequest.getUsername());
        if (!passwordEncoder.matches(tokenCreateRequest.getPassword(), user.getPassword())) {
            throw new BizException(ExceptionType.USER_PASSWORD_NOT_MATCH);
        }
        if (!user.isEnabled()) {
            throw new BizException(ExceptionType.USER_NOT_ENABLED);
        }
        if (!user.isAccountNonLocked()) {
            throw new BizException(ExceptionType.USER_LOCKED);
        }
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SecurityConfig.SECRET.getBytes()));
    }

    private User getById(String id) {
        Optional<User> user = repository.findById(id);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return user.get();
    }

    @Override
    public UserDto getCurrentUser() {
        return userMapper.toDto(super.getCurrentUserEntity());
    }

    @Autowired
    private void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    private void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
