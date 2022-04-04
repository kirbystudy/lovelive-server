package com.lovelive.controller;

import com.lovelive.mapper.PlaylistMapper;
import com.lovelive.service.PlaylistService;
import com.lovelive.vo.playlist.PlaylistVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    public void setPlaylistMapper(PlaylistMapper playlistMapper) {
        this.playlistMapper = playlistMapper;
    }

    @Autowired
    public void setPlaylistService(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }
}
