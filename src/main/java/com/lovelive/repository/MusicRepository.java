package com.lovelive.repository;

import com.lovelive.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/30 13:43
 */
public interface MusicRepository extends JpaRepository<Music, String>, JpaSpecificationExecutor<Music> {
    Optional<Music> findById(String id);
}
