package com.lovelive.service;

import com.lovelive.dto.playlist.PlaylistDto;
import com.lovelive.dto.playlist.PlaylistSearchFilter;
import com.lovelive.entity.Playlist;
import org.springframework.data.domain.Page;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/4 18:11
 */
public interface PlaylistService extends GeneralService<Playlist, PlaylistDto> {

    Page<PlaylistDto> search(PlaylistSearchFilter playlistSearchFilter);

    PlaylistDto recommend(String id, Integer recommendFactor);

    PlaylistDto cancelRecommendation(String id);

    PlaylistDto makeSpecial(String id);

    PlaylistDto cancelSpecial(String id);
}
