package com.lovelive.repository;

import com.lovelive.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/4 18:14
 */
public interface PlaylistRepository extends JpaRepository<Playlist, String> {


}
