package com.lovelive.repository;

import com.lovelive.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/8 11:53
 */
public interface ArtistRepository extends JpaRepository<Artist, String> {

    Optional<Artist> findById(String id);
}
