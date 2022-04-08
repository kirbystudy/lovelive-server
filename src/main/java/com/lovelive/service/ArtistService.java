package com.lovelive.service;

import com.lovelive.dto.artist.ArtistCreateRequest;
import com.lovelive.dto.artist.ArtistDto;
import com.lovelive.dto.artist.ArtistUpdateRequest;

import java.util.List;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/8 12:43
 */
public interface ArtistService {

    ArtistDto create(ArtistCreateRequest artistCreateRequest);

    ArtistDto update(String id, ArtistUpdateRequest artistUpdateRequest);

    List<ArtistDto> list();
}
