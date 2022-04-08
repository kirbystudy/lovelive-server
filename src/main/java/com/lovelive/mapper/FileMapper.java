package com.lovelive.mapper;

import com.lovelive.dto.file.FileDto;
import com.lovelive.dto.file.FileUploadRequest;
import com.lovelive.entity.FileEntity;
import com.lovelive.vo.file.FileVo;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@DecoratedWith(FileMapperDecorator.class)
public interface FileMapper {

    FileEntity createEntity(FileUploadRequest fileUploadRequest);

    FileVo toVo(FileDto fileDto);

    FileDto toDto(FileEntity fileEntity);

    FileEntity toEntity(FileDto fileDto);

}
