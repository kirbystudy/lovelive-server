package com.lovelive.service;

import com.lovelive.dto.user.UserCreateRequest;
import com.lovelive.enums.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/7 16:28
 */
@SpringBootTest
public abstract class BaseTest {

    @Autowired
    UserService userService;

    @BeforeEach
    void setDefaultUser() {
        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setUsername("admin");
        userCreateRequest.setPassword("admin");
        userCreateRequest.setNickname("程序员小埋");
        userCreateRequest.setGender(Gender.MALE);
        userService.create(userCreateRequest);
    }
}
