package com.lovelive.service;

import com.lovelive.dto.playlist.PlaylistDto;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/4 18:11
 */
public interface PlaylistService {

    PlaylistDto get(String id);
}
