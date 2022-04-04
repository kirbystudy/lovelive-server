package com.lovelive.service.impl;

import com.lovelive.dto.file.FileDto;
import com.lovelive.dto.file.FileUploadDto;
import com.lovelive.dto.file.FileUploadRequest;
import com.lovelive.entity.FileEntity;
import com.lovelive.enums.ExceptionType;
import com.lovelive.enums.FileStatus;
import com.lovelive.enums.Storage;
import com.lovelive.exception.BizException;
import com.lovelive.mapper.FileMapper;
import com.lovelive.repository.FileRepository;
import com.lovelive.service.FileService;
import com.lovelive.service.StorageService;
import com.lovelive.utils.FileTypeTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/1 18:11
 */
@Service
public class FileServiceImpl implements FileService {

    private Map<String, StorageService> storageServices;

    private FileRepository repository;

    private FileMapper mapper;


    @Override
    @Transactional
    public FileUploadDto initUpload(FileUploadRequest fileUploadRequest) {
        // 创建File实体
        FileEntity file = mapper.createEntity(fileUploadRequest);
        file.setType(FileTypeTransformer.getFileTypeFromExt(fileUploadRequest.getExt()));
        file.setStorage(getDefaultStorage());
        FileEntity saveFile = repository.save(file);

        // 通过接口获取STS令牌
        FileUploadDto fileUploadDto =
                storageServices.get(getDefaultStorage().name()).initFileUpload();
        fileUploadDto.setKey(saveFile.getKey());
        fileUploadDto.setFileId(saveFile.getId());
        return fileUploadDto;
    }


    @Override
    public FileDto finishUpload(String id) {
        Optional<FileEntity> fileEntityOptional = repository.findById(id);
        // 判断文件id是否存在
        if (!fileEntityOptional.isPresent()) {
            throw new BizException(ExceptionType.FILE_NOT_FOUND);
        }
        // Todo: 只有上传者才能更新finish,权限判断

        // Todo: 验证远程文件是否存在

        FileEntity fileEntity = fileEntityOptional.get();
        fileEntity.setStatus(FileStatus.UPLOADED);
        return mapper.toDto(repository.save(fileEntity));
    }

    /**
     * todo: 后台设置当前Storage存储对象
     */
    @Override
    public Storage getDefaultStorage() {
        return Storage.COS;
    }

    @Autowired
    public void setStorageServices(Map<String, StorageService> storageServices) {
        this.storageServices = storageServices;
    }

    @Autowired
    public void setRepository(FileRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(FileMapper mapper) {
        this.mapper = mapper;
    }
}
