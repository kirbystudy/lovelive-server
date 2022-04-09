package com.lovelive.service.impl;

import com.lovelive.dto.music.MusicDto;
import com.lovelive.entity.Music;
import com.lovelive.enums.ExceptionType;
import com.lovelive.enums.MusicStatus;
import com.lovelive.mapper.MusicMapper;
import com.lovelive.repository.MusicRepository;
import com.lovelive.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/30 13:37
 */
@Service
public class MusicServiceImpl extends GeneralServiceImpl<Music, MusicDto> implements MusicService {

    private MusicRepository repository;

    private MusicMapper mapper;

    @Override
    public MusicDto create(MusicDto musicDto) {
        return super.create(musicDto);
    }

    @Override
    public void publish(String id) {
        Music music = getEntity(id);
        music.setStatus(MusicStatus.PUBLISHED);
        repository.save(music);
    }

    @Override
    public void close(String id) {
        Music music = getEntity(id);
        music.setStatus(MusicStatus.CLOSED);
        repository.save(music);
    }

    @Override
    public JpaRepository<Music, String> getRepository() {
        return repository;
    }

    @Override
    public MusicMapper getMapper() {
        return mapper;
    }

    @Override
    public ExceptionType getNotFoundExceptionType() {
        return ExceptionType.MUSIC_NOT_FOUND;
    }

    @Override
    public Page<MusicDto> search(MusicDto searchDto, Pageable pageable) {
        return null;
    }

    @Autowired
    public void setRepository(MusicRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(MusicMapper mapper) {
        this.mapper = mapper;
    }
}
