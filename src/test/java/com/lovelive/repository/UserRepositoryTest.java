package com.lovelive.repository;

import com.lovelive.entity.User;
import com.lovelive.enums.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/18 20:51
 */
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    void findByUsername() {
        User user = new User();
        user.setUsername("小埋");
        user.setNickname("程序员小埋");
        user.setEnabled(true);
        user.setLocked(false);
        user.setPassword("123456");
        user.setGender(Gender.FEMALE);
        user.setLastLoginIp("127.0.0.1");
        user.setLastLoginTime(new Date());
        User save = repository.save(user);
        User byUsername = repository.getByUsername("小埋");
        System.out.println(byUsername);

    }


}