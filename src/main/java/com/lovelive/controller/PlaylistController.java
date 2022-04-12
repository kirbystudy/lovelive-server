package com.lovelive.controller;

import com.lovelive.dto.artist.RecommendRequest;
import com.lovelive.dto.playlist.PlaylistCreateRequest;
import com.lovelive.dto.playlist.PlaylistSearchFilter;
import com.lovelive.mapper.PlaylistMapper;
import com.lovelive.service.PlaylistService;
import com.lovelive.vo.playlist.PlaylistVo;
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
 * @Date 2022/4/4 18:22
 */
@RestController
@RequestMapping("/playlists")
@Api(tags = "歌单模块")
public class PlaylistController {

    private PlaylistService playlistService;

    private PlaylistMapper playlistMapper;

    @ApiOperation("获取歌单id")
    @GetMapping("/{id}")
    public PlaylistVo get(@PathVariable String id) {
        return playlistMapper.toVo(playlistService.get(id));
    }

    @ApiOperation("新增歌单")
    @PostMapping
    @RolesAllowed("ROLE_ADMIN")
    public PlaylistVo create(@Validated @RequestBody PlaylistCreateRequest playlistCreateRequest) {
        return playlistMapper.toVo(playlistService.create(playlistMapper.toDto(playlistCreateRequest)));
    }

    @ApiOperation("查询所有歌单(分页和检索)")
    @GetMapping
    @RolesAllowed("ROLE_ADMIN")
    public Page<PlaylistVo> search(@Validated PlaylistSearchFilter playlistSearchFilter) {
        return playlistService.search(playlistSearchFilter).map(playlistMapper::toVo);
    }

    @ApiOperation("推荐歌单")
    @PostMapping("/{id}/recommend")
    @RolesAllowed("ROLE_ADMIN")
    public PlaylistVo recommend(@PathVariable String id, @Validated @RequestBody RecommendRequest recommendRequest) {
        return playlistMapper.toVo(playlistService.recommend(id, recommendRequest.getRecommendFactor()));
    }

    @ApiOperation("取消推荐歌单")
    @PostMapping("/{id}/cancel_recommendation")
    @RolesAllowed("ROLE_ADMIN")
    public PlaylistVo cancelRecommendation(@PathVariable String id) {
        return playlistMapper.toVo(playlistService.cancelRecommendation(id));
    }

    @ApiOperation("特色歌单")
    @PostMapping("/{id}/makeSpecial")
    @RolesAllowed("ROLE_ADMIN")
    public PlaylistVo makeSpecial(@PathVariable String id) {
        return playlistMapper.toVo(playlistService.makeSpecial(id));
    }

    @ApiOperation("取消特色歌单")
    @PostMapping("/{id}/cancelSpecial")
    @RolesAllowed("ROLE_ADMIN")
    public PlaylistVo cancelSpecial(@PathVariable String id) {
        return playlistMapper.toVo(playlistService.cancelSpecial(id));
    }

    @Autowired

    public void setPlaylistMapper(PlaylistMapper playlistMapper) {
        this.playlistMapper = playlistMapper;
    }

    @Autowired
    public void setPlaylistService(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }
}
