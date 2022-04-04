package com.lovelive.controller;

import com.lovelive.dto.file.FileUploadRequest;
import com.lovelive.mapper.FileMapper;
import com.lovelive.mapper.FileUploadMapper;
import com.lovelive.service.FileService;
import com.lovelive.vo.file.FileUploadVo;
import com.lovelive.vo.file.FileVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/1 18:34
 */
@RolesAllowed("ROLE_ADMIN")
@RestController
@RequestMapping("/files")
@Api(tags = "文件模块")
public class FileController {

    private FileService fileService;

    private FileMapper fileMapper;

    private FileUploadMapper fileUploadMapper;


    @ApiOperation("初始化上传")
    @PostMapping("/upload_init")
    public FileUploadVo initUpload(@Validated @RequestBody FileUploadRequest fileUploadRequest) {
        return fileUploadMapper.toVo(fileService.initUpload(fileUploadRequest));
    }

    @ApiOperation("完成上传")
    @PostMapping("/{id}/upload_finish")
    public FileVo finishUpload(@PathVariable String id) {
        return fileMapper.toVo(fileService.finishUpload(id));
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @Autowired
    public void setFileMapper(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @Autowired
    public void setFileUploadMapper(FileUploadMapper fileUploadMapper) {
        this.fileUploadMapper = fileUploadMapper;
    }
}
