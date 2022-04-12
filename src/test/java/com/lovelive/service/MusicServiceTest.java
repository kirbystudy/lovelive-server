package com.lovelive.service;

import com.lovelive.dto.BaseDto;
import com.lovelive.dto.artist.ArtistCreateRequest;
import com.lovelive.dto.artist.ArtistDto;
import com.lovelive.dto.file.FileDto;
import com.lovelive.dto.file.FileUploadDto;
import com.lovelive.dto.file.FileUploadRequest;
import com.lovelive.dto.music.MusicCreateRequest;
import com.lovelive.dto.music.MusicDto;
import com.lovelive.enums.MusicStatus;
import com.lovelive.mapper.ArtistMapper;
import com.lovelive.mapper.FileMapper;
import com.lovelive.mapper.MusicMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/9 14:39
 */
@SpringBootTest
@Slf4j
class MusicServiceTest extends BaseTest {

    @Autowired
    MusicService musicService;

    @Autowired
    MusicMapper musicMapper;

    @Autowired
    FileService fileService;

    @Autowired
    FileMapper fileMapper;

    @Autowired
    ArtistService artistService;

    @Autowired
    ArtistMapper artistMapper;

    String fileId;

    List<String> artistIds = new ArrayList<>();

    @Test
    @WithMockUser(username = "admin")
    void create() {
        MusicCreateRequest musicCreateRequest = new MusicCreateRequest();
        musicCreateRequest.setName("孤勇者");
        musicCreateRequest.setFileId(fileId);
        musicCreateRequest.setArtistIds(artistIds);
        MusicDto saveMusicDto = musicService.create(musicMapper.toDto(musicCreateRequest));
        Assertions.assertEquals(musicCreateRequest.getName(), saveMusicDto.getName());
        Assertions.assertEquals(musicCreateRequest.getDescription(), saveMusicDto.getDescription());
        Assertions.assertEquals(MusicStatus.DRAFT, saveMusicDto.getStatus());
        Assertions.assertEquals(musicCreateRequest.getFileId(), saveMusicDto.getFile().getId());
        Assertions.assertEquals(musicCreateRequest.getArtistIds(),
                saveMusicDto.getArtistList().stream().map(BaseDto::getId).collect(Collectors.toList()));
        log.info(saveMusicDto.toString());
    }

    @BeforeEach
    void setDefaultFileIds() {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("flac");
        fileUploadRequest.setKey("835741aba850778a5b06bfd57f55c98c");
        fileUploadRequest.setSize(30000L);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);
        FileDto finishedFile = fileService.finishUpload(fileUploadDto.getFileId());
        fileId = finishedFile.getId();
    }

    @BeforeEach
    void setDefaultAristId() {
        ArtistCreateRequest artistCreateRequest = new ArtistCreateRequest();
        artistCreateRequest.setName("陈奕迅");
        artistCreateRequest.setPhotoId(fileId);
        ArtistDto artistDto = artistService.create(artistMapper.toDto(artistCreateRequest));
        artistIds.add(artistDto.getId());
    }

    @Test
    void publish() {
    }

    @Test
    void close() {
    }
}