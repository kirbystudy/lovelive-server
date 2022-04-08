package com.lovelive.service;

import com.lovelive.dto.file.FileDto;
import com.lovelive.dto.file.FileUploadDto;
import com.lovelive.dto.file.FileUploadRequest;
import com.lovelive.entity.FileEntity;
import com.lovelive.enums.Storage;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/1 18:11
 */
public interface FileService {

    FileUploadDto initUpload(FileUploadRequest fileUploadRequest);

    FileDto finishUpload(String id);

    Storage getDefaultStorage();

    FileEntity getFileEntity(String id);
}
