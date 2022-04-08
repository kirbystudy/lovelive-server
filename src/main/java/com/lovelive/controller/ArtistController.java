package com.lovelive.controller;

import com.lovelive.dto.artist.ArtistCreateRequest;
import com.lovelive.dto.artist.ArtistUpdateRequest;
import com.lovelive.mapper.ArtistMapper;
import com.lovelive.service.ArtistService;
import com.lovelive.vo.artist.ArtistVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public ArtistVo create(@Validated @RequestBody ArtistCreateRequest artistCreateRequest) {
        return artistMapper.toVo(artistService.create(artistCreateRequest));
    }

    @ApiOperation("更新歌手")
    @PutMapping("/{id}")
    public ArtistVo update(@PathVariable String id, @Validated @RequestBody ArtistUpdateRequest artistUpdateRequest) {
        return artistMapper.toVo(artistService.update(id, artistUpdateRequest));
    }

    @ApiOperation("查询所有歌手")
    @GetMapping
    public List<ArtistVo> list() {
        return artistService.list().stream().map(artistMapper::toVo).collect(Collectors.toList());
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
