package com.lovelive.service;

import com.lovelive.dto.music.MusicDto;
import com.lovelive.entity.Music;

/**
 * @author 小埋
 * @version 1.0
 * @Description 音乐业务层接口
 * @Date 2022/3/30 13:23
 */
public interface MusicService extends GeneralService<Music, MusicDto> {

    void publish(String id);

    void close(String id);
}
