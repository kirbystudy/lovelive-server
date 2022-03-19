package com.lovelive.repository;

import com.lovelive.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 太好听了吧
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/18 20:39
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User getByUsername(String username);

    User getByUsernameAndNickname(String username,String nickname);
}
