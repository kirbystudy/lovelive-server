package com.lovelive.mapper;

import com.lovelive.dto.playlist.PlaylistDto;
import com.lovelive.entity.Playlist;
import com.lovelive.vo.playlist.PlaylistVo;
import org.mapstruct.Mapper;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/4 18:09
 */
@Mapper(componentModel = "spring", uses = MusicMapper.class)
public interface PlaylistMapper {

    PlaylistDto toDto(Playlist playlist);

    PlaylistVo toVo(PlaylistDto playlistDto);
}
