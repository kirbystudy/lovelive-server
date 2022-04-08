package com.lovelive.mapper;

import com.lovelive.dto.artist.ArtistCreateRequest;
import com.lovelive.dto.artist.ArtistDto;
import com.lovelive.dto.artist.ArtistUpdateRequest;
import com.lovelive.entity.Artist;
import com.lovelive.vo.artist.ArtistVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/8 13:17
 */
@Mapper(componentModel = "spring", uses = {FileMapper.class, MusicMapper.class})
public interface ArtistMapper {

    Artist createEntity(ArtistCreateRequest artistCreateRequest);

    Artist updateEntity(@MappingTarget Artist artist, ArtistUpdateRequest artistUpdateRequest);

    ArtistDto toDto(Artist artist);

    ArtistVo toVo(ArtistDto artistDto);
}
