package com.lovelive.mapper;

import com.lovelive.dto.music.MusicCreateRequest;
import com.lovelive.dto.music.MusicDto;
import com.lovelive.dto.music.MusicUpdateRequest;
import com.lovelive.entity.Music;
import com.lovelive.vo.music.MusicVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/30 13:23
 */
@Mapper(componentModel = "spring", uses = FileMapper.class)
public interface MusicMapper {

    /**
     * toDto 用来接收前端传过来的值
     *
     * @param music
     * @return
     */
    MusicDto toDto(Music music);

    /**
     * toVo 用来和前端传输数据
     *
     * @param musicDto
     * @return
     */
    MusicVo toVo(MusicDto musicDto);

    /**
     * 创建实体
     *
     * @param musicCreateRequest
     * @return
     */
    Music createEntity(MusicCreateRequest musicCreateRequest);

    /**
     * 更新实体
     *
     * @param musicUpdateRequest
     * @return
     */
    Music updateEntity(@MappingTarget Music music, MusicUpdateRequest musicUpdateRequest);
}
