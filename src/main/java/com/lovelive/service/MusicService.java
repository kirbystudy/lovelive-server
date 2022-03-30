package com.lovelive.service;

import com.lovelive.dto.music.MusicCreateRequest;
import com.lovelive.dto.music.MusicDto;
import com.lovelive.dto.music.MusicUpdateRequest;

import java.util.List;

/**
 * @author 小埋
 * @version 1.0
 * @Description 音乐业务层接口
 * @Date 2022/3/30 13:23
 */
public interface MusicService {

    MusicDto create(MusicCreateRequest musicCreateRequest);

    MusicDto update(String id, MusicUpdateRequest musicUpdateRequest);

    List<MusicDto> list();

    void publish(String id);

    void close(String id);
}
