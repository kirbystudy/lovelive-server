package com.lovelive.service;

import com.lovelive.dto.artist.ArtistCreateRequest;
import com.lovelive.dto.artist.ArtistDto;
import com.lovelive.dto.file.FileDto;
import com.lovelive.dto.file.FileUploadDto;
import com.lovelive.dto.file.FileUploadRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/8 13:12
 */
@SpringBootTest
@Slf4j
class ArtistServiceTest extends BaseTest {

    @Autowired
    ArtistService artistService;

    @Autowired
    FileService fileService;

    private String photoId;

    @Test
    @WithMockUser(username = "admin")
    void create() {
        ArtistCreateRequest artistCreateRequest = new ArtistCreateRequest();
        artistCreateRequest.setName("陈奕迅");
        artistCreateRequest.setRemark("孤勇者");
        ArtistDto artistDto = artistService.create(artistCreateRequest);
        Assertions.assertEquals(artistCreateRequest.getName(), artistDto.getName());
        log.info(artistDto.toString());
    }

    void setDefaultPhoto() {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("flac");
        fileUploadRequest.setKey("835741aba850778a5b06bfd57f55c98c");
        fileUploadRequest.setSize(30000L);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);
        FileDto finishedFile = fileService.finishUpload(fileUploadDto.getFileId());
        photoId = finishedFile.getId();

    }
}