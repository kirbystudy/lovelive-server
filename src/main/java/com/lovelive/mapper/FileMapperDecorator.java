package com.lovelive.mapper;


import com.lovelive.dto.file.FileDto;
import com.lovelive.entity.FileEntity;
import com.lovelive.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/7 15:57
 */
public abstract class FileMapperDecorator implements FileMapper {

    @Autowired
    @Qualifier("delegate")
    private FileMapper delegate;

    @Autowired
    private Map<String, StorageService> storageServices;


    @Override

    public FileDto toDto(FileEntity fileEntity) {
        FileDto fileDto = delegate.toDto(fileEntity);

        if (fileDto == null) {
            return null;
        }

        if (fileDto.getStorage() == null) {
            return null;
        }

        // 从cos获取临时uri
        fileDto.setUri(storageServices.get(fileDto.getStorage().name()).getFileUri(fileDto.getKey()));
        return fileDto;
    }
}
