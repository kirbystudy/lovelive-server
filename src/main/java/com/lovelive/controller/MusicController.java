package com.lovelive.controller;

import com.lovelive.dto.music.MusicCreateRequest;
import com.lovelive.dto.music.MusicUpdateRequest;
import com.lovelive.mapper.MusicMapper;
import com.lovelive.service.MusicService;
import com.lovelive.vo.music.MusicVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @author 小埋
 * @version 1.0
 * @Description 音乐控制层
 * @Date 2022/3/30 13:07
 */
@RestController
@RequestMapping("/musics")
@Api(tags = "音乐模块")
public class MusicController {

    private MusicService musicService;

    private MusicMapper musicMapper;

    @ApiOperation("创建歌曲")
    @PostMapping
    @RolesAllowed("ROLE_ADMIN")
    public MusicVo create(@Validated @RequestBody MusicCreateRequest musicCreateRequest) {
        return musicMapper.toVo(musicService.create(musicMapper.toDto(musicCreateRequest)));
    }

    @ApiOperation("更新歌曲")
    @PutMapping("/{id}")
    @RolesAllowed("ROLE_ADMIN")
    public MusicVo update(@PathVariable String id, @Validated @RequestBody MusicUpdateRequest musicUpdateRequest) {
        return musicMapper.toVo(musicService.update(id, musicMapper.toDto(musicUpdateRequest)));
    }

    @ApiOperation("查询所有歌曲")
    @GetMapping
    @RolesAllowed("ROLE_ADMIN")
    public List<MusicVo> list() {
//        return musicService.list().stream().map(musicMapper::toVo).collect(Collectors.toList());
        return null;
    }

    @ApiOperation("上架歌曲")
    @PostMapping("/{id}/publish")
    @RolesAllowed("ROLE_ADMIN")
    public void publish(@PathVariable String id) {
        musicService.publish(id);
    }

    @ApiOperation("下架歌曲")
    @PostMapping("/{id}/close")
    @RolesAllowed("ROLE_ADMIN")
    public void close(@PathVariable String id) {
        musicService.close(id);
    }

    @Autowired

    public void setMusicService(MusicService musicService) {
        this.musicService = musicService;
    }

    @Autowired
    public void setMusicMapper(MusicMapper musicMapper) {
        this.musicMapper = musicMapper;
    }
}
