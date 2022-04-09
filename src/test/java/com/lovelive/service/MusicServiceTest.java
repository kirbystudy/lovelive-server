package com.lovelive.service;

import com.lovelive.dto.music.MusicDto;
import com.lovelive.enums.MusicStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/9 14:39
 */
@SpringBootTest
@Slf4j
class MusicServiceTest {

    @Autowired
    MusicService musicService;

    @Test
    void create() {
        MusicDto musicDto = new MusicDto();
        musicDto.setName("测试音乐");
        musicDto.setDescription("描述");
        MusicDto saveMusicDto = musicService.create(musicDto);
        Assertions.assertEquals(musicDto.getName(), saveMusicDto.getName());
        Assertions.assertEquals(musicDto.getDescription(), saveMusicDto.getDescription());
        Assertions.assertEquals(MusicStatus.DRAFT, saveMusicDto.getStatus());
        log.info(saveMusicDto.toString());
    }

    @Test
    void publish() {
    }

    @Test
    void close() {
    }
}