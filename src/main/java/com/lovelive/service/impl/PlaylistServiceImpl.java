package com.lovelive.service.impl;

import com.lovelive.dto.playlist.PlaylistDto;
import com.lovelive.entity.Playlist;
import com.lovelive.enums.ExceptionType;
import com.lovelive.exception.BizException;
import com.lovelive.mapper.PlaylistMapper;
import com.lovelive.repository.PlaylistRepository;
import com.lovelive.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/4 18:12
 */
@Service
public class PlaylistServiceImpl implements PlaylistService {

    private PlaylistRepository repository;

    private PlaylistMapper mapper;

    @Override
    public PlaylistDto get(String id) {
        Optional<Playlist> playlist = repository.findById(id);
        if (!playlist.isPresent()) {
            throw new BizException(ExceptionType.PLAYLIST_NOT_FOUND);
        }
        return mapper.toDto(playlist.get());
    }

    @Autowired
    public void setRepository(PlaylistRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(PlaylistMapper mapper) {
        this.mapper = mapper;
    }
}
