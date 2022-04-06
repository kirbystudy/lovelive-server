package com.lovelive.service.impl;

import com.lovelive.entity.User;
import com.lovelive.enums.ExceptionType;
import com.lovelive.exception.BizException;
import com.lovelive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/5 21:45
 */
public abstract class BaseService {

    private UserRepository userRepository;

    protected User getCurrentUserEntity() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return loadUserByUsername(authentication.getName());
    }

    protected User loadUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return user.get();
    }

    @Autowired
    private void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
