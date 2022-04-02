package com.lovelive.mapper;

import com.lovelive.dto.file.FileUploadDto;
import com.lovelive.vo.file.FileUploadVo;
import org.mapstruct.Mapper;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/1 18:48
 */
@Mapper(componentModel = "spring")
public interface FileUploadMapper {

    FileUploadVo toVo(FileUploadDto fileUploadDto);
}
