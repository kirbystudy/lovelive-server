package com.lovelive.service;

import com.lovelive.dto.file.FileUploadDto;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/1 19:05
 */
public interface StorageService {

    FileUploadDto initFileUpload();

    String getFileUri(String fileKey);
}
