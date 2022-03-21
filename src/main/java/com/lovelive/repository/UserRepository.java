package com.lovelive.repository;

import com.lovelive.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/18 20:39
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User getByUsername(String username);

    Optional<User> findByUsername(String username);

}
