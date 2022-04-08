package com.lovelive.service.impl;

import com.lovelive.dto.artist.ArtistCreateRequest;
import com.lovelive.dto.artist.ArtistDto;
import com.lovelive.dto.artist.ArtistUpdateRequest;
import com.lovelive.entity.Artist;
import com.lovelive.enums.ArtistStatus;
import com.lovelive.enums.ExceptionType;
import com.lovelive.exception.BizException;
import com.lovelive.mapper.ArtistMapper;
import com.lovelive.repository.ArtistRepository;
import com.lovelive.service.ArtistService;
import com.lovelive.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/8 13:09
 */
@Service
@Slf4j
public class ArtistServiceImpl extends BaseService implements ArtistService {

    private ArtistMapper mapper;

    private ArtistRepository repository;

    private FileService fileService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ArtistDto create(ArtistCreateRequest artistCreateRequest) {
        Artist artist = mapper.createEntity(artistCreateRequest);
        artist.setPhoto(fileService.getFileEntity(artistCreateRequest.getPhotoId()));
        artist.setStatus(ArtistStatus.DRAFT);
        artist.setCreatedBy(getCurrentUserEntity());
        artist.setUpdatedBy(getCurrentUserEntity());
        return mapper.toDto(repository.save(artist));
    }

    @Override
    public ArtistDto update(String id, ArtistUpdateRequest artistUpdateRequest) {
        Optional<Artist> artistOptional = repository.findById(id);
        if (!artistOptional.isPresent()) {
            throw new BizException(ExceptionType.ARTIST_NOT_FOUND);
        }
        Artist artist = mapper.updateEntity(artistOptional.get(), artistUpdateRequest);
        artist.setPhoto(fileService.getFileEntity(artistUpdateRequest.getPhotoId()));
        return mapper.toDto(repository.save(artist));
    }

    @Override
    public List<ArtistDto> list() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Autowired
    public void setMapper(ArtistMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setRepository(ArtistRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

}
