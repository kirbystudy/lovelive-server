package com.lovelive.service;

import com.lovelive.dto.file.FileDto;
import com.lovelive.dto.file.FileUploadDto;
import com.lovelive.dto.file.FileUploadRequest;
import com.lovelive.enums.FileStatus;
import com.lovelive.enums.Storage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/2 1:04
 */
@SpringBootTest
@Slf4j
class FileServiceTest {

    private FileService fileService;

    @Test
    void initUpload() {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("flac");
        fileUploadRequest.setKey("835741aba850778a5b06bfd57f55c98c");
        fileUploadRequest.setSize(30000L);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);
        Assertions.assertNotNull(fileUploadDto.getSecretId());
        Assertions.assertNotNull(fileUploadDto.getSecretId());
        Assertions.assertNotNull(fileUploadDto.getSessionToken());
        Assertions.assertNotNull(fileUploadDto.getFileId());
        Assertions.assertEquals(fileUploadDto.getKey(), fileUploadRequest.getKey());
    }

    @Test
    void initUploadMaxSize() {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("flac");
        fileUploadRequest.setKey("835741aba850778a5b06bfd57f55c98c");
        fileUploadRequest.setSize(6082813636L);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);
        Assertions.assertNotNull(fileUploadDto.getSecretId());
        Assertions.assertNotNull(fileUploadDto.getSecretId());
        Assertions.assertNotNull(fileUploadDto.getSessionToken());
        Assertions.assertNotNull(fileUploadDto.getFileId());
        Assertions.assertEquals(fileUploadDto.getKey(), fileUploadRequest.getKey());
    }

    @Test
    void finishUpload() {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("flac");
        fileUploadRequest.setKey("835741aba850778a5b06bfd57f55c98c");
        fileUploadRequest.setSize(30000L);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);
        FileDto finishedFile = fileService.finishUpload(fileUploadDto.getFileId());
        Assertions.assertEquals(fileUploadDto.getFileId(), finishedFile.getId());
        Assertions.assertEquals(FileStatus.UPLOADED, finishedFile.getStatus());
    }

    @Test
    void getDefaultStorage() {
        Storage storage = fileService.getDefaultStorage();
        Assertions.assertEquals(Storage.COS, storage);
    }


    @Autowired
    private void setFileService(FileService fileService) {
        this.fileService = fileService;
    }


}