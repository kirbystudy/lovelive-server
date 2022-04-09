package com.lovelive.mapper;

import com.lovelive.dto.music.MusicCreateRequest;
import com.lovelive.dto.music.MusicDto;
import com.lovelive.dto.music.MusicUpdateRequest;
import com.lovelive.entity.Music;
import com.lovelive.vo.music.MusicVo;
import org.mapstruct.Mapper;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/30 13:23
 */
@Mapper(componentModel = "spring", uses = FileMapper.class)
public interface MusicMapper extends MapperInterface<Music, MusicDto> {

    MusicDto toDto(MusicCreateRequest musicCreateRequest);

    MusicDto toDto(MusicUpdateRequest musicUpdateRequest);

    MusicVo toVo(MusicDto musicDto);
}
