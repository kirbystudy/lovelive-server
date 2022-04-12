package com.lovelive.service;

import com.lovelive.dto.artist.ArtistDto;
import com.lovelive.dto.artist.ArtistSearchFilter;
import com.lovelive.entity.Artist;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/8 12:43
 */
public interface ArtistService extends GeneralService<Artist, ArtistDto> {

    List<ArtistDto> list();

    Page<ArtistDto> search(ArtistSearchFilter artistSearchFilter);

    ArtistDto recommend(String id, Integer recommendFactor);

    ArtistDto cancelRecommendation(String id);
}
