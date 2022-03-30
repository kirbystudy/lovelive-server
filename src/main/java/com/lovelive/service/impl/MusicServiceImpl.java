package com.lovelive.service.impl;

import com.lovelive.dto.music.MusicCreateRequest;
import com.lovelive.dto.music.MusicDto;
import com.lovelive.dto.music.MusicUpdateRequest;
import com.lovelive.entity.Music;
import com.lovelive.enums.ExceptionType;
import com.lovelive.enums.MusicStatus;
import com.lovelive.exception.BizException;
import com.lovelive.mapper.MusicMapper;
import com.lovelive.repository.MusicRepository;
import com.lovelive.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/30 13:37
 */
@Service
public class MusicServiceImpl implements MusicService {

    private MusicRepository musicRepository;

    private MusicMapper musicMapper;

    @Override
    public MusicDto create(MusicCreateRequest musicCreateRequest) {
        Music music = musicMapper.createEntity(musicCreateRequest);
        music.setStatus(MusicStatus.DRAFT);
        return musicMapper.toDto(musicRepository.save(music));
    }

    @Override
    public MusicDto update(String id, MusicUpdateRequest musicUpdateRequest) {
        Music existMusic = getMusic(id);
        Music music = musicMapper.updateEntity(existMusic, musicUpdateRequest);
        return musicMapper.toDto(musicRepository.save(music));
    }

    private Music getMusic(String id) {
        Optional<Music> musicOptional = musicRepository.findById(id);
        if (!musicOptional.isPresent()) {
            throw new BizException(ExceptionType.MUSIC_NOT_FOUND);
        }
        return musicOptional.get();
    }

    @Override
    public List<MusicDto> list() {
        return musicRepository.findAll().stream().map(musicMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void publish(String id) {
        Music music = getMusic(id);
        music.setStatus(MusicStatus.PUBLISHED);
        musicRepository.save(music);
    }

    @Override
    public void close(String id) {
        Music music = getMusic(id);
        music.setStatus(MusicStatus.CLOSED);
        musicRepository.save(music);
    }

    @Autowired
    public void setMusicRepository(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Autowired
    public void setMusicMapper(MusicMapper musicMapper) {
        this.musicMapper = musicMapper;
    }
}
