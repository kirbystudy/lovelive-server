package com.lovelive.controller;

import com.lovelive.dto.artist.ArtistCreateRequest;
import com.lovelive.dto.artist.ArtistSearchFilter;
import com.lovelive.dto.artist.ArtistUpdateRequest;
import com.lovelive.dto.artist.RecommendRequest;
import com.lovelive.mapper.ArtistMapper;
import com.lovelive.service.ArtistService;
import com.lovelive.vo.artist.ArtistVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/8 12:43
 */
@RestController
@RequestMapping("/artists")
@Api(tags = "歌手模块")
public class ArtistController {

    private ArtistService artistService;

    private ArtistMapper artistMapper;

    @ApiOperation("创建歌手")
    @PostMapping
    @RolesAllowed("ROLE_ADMIN")
    public ArtistVo create(@Validated @RequestBody ArtistCreateRequest artistCreateRequest) {
        return artistMapper.toVo(artistService.create(artistMapper.toDto(artistCreateRequest)));
    }

    @ApiOperation("更新歌手")
    @PutMapping("/{id}")
    @RolesAllowed("ROLE_ADMIN")
    public ArtistVo update(@PathVariable String id, @Validated @RequestBody ArtistUpdateRequest artistUpdateRequest) {
        return artistMapper.toVo(artistService.update(id, artistMapper.toDto(artistUpdateRequest)));
    }

    @ApiOperation("查询所有歌手分页和检索")
    @GetMapping
    @RolesAllowed("ROLE_ADMIN")
    public Page<ArtistVo> search(@Validated ArtistSearchFilter artistSearchFilter) {
        return artistService.search(artistSearchFilter).map(artistMapper::toVo);
    }

    @ApiOperation("推荐歌手")
    @PostMapping("/{id}/recommend")
    @RolesAllowed("ROLE_ADMIN")
    public ArtistVo recommend(@PathVariable String id, @Validated @RequestBody RecommendRequest recommendRequest) {
        return artistMapper.toVo(artistService.recommend(id, recommendRequest.getRecommendFactor()));
    }

    @ApiOperation("取消推荐歌手")
    @PostMapping("/{id}/cancel_recommendation")
    @RolesAllowed("ROLE_ADMIN")
    public ArtistVo cancelRecommendation(@PathVariable String id) {
        return artistMapper.toVo(artistService.cancelRecommendation(id));
    }

    @Autowired
    public void setArtistService(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Autowired
    public void setArtistMapper(ArtistMapper artistMapper) {
        this.artistMapper = artistMapper;
    }
}
