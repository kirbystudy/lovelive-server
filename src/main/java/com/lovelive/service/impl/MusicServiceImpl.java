package com.lovelive.service.impl;

import com.lovelive.dto.music.MusicDto;
import com.lovelive.dto.music.MusicSearchFilter;
import com.lovelive.entity.Music;
import com.lovelive.enums.ExceptionType;
import com.lovelive.enums.MusicStatus;
import com.lovelive.mapper.MusicMapper;
import com.lovelive.repository.MusicRepository;
import com.lovelive.repository.specs.MusicSpecification;
import com.lovelive.repository.specs.SearchCriteria;
import com.lovelive.repository.specs.SearchOperation;
import com.lovelive.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Page<MusicDto> search(MusicSearchFilter musicSearchFilter) {
        if (musicSearchFilter == null) {
            musicSearchFilter = new MusicSearchFilter();
        }

        MusicSpecification specs = new MusicSpecification();
        specs.add(new SearchCriteria("name", musicSearchFilter.getName(), SearchOperation.MATCH));
        Sort sort = Sort.by(Sort.Direction.DESC, "createdTime");
        Pageable pageable = PageRequest.of(musicSearchFilter.getPage() - 1, musicSearchFilter.getSize(), sort);
        return repository.findAll(specs, pageable).map(mapper::toDto);
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

    @Autowired
    public void setRepository(MusicRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(MusicMapper mapper) {
        this.mapper = mapper;
    }
}
