package com.lovelive.vo.playlist;

import com.lovelive.enums.PlaylistStatus;
import com.lovelive.vo.BaseVo;
import com.lovelive.vo.file.FileVo;
import com.lovelive.vo.music.MusicVo;
import com.lovelive.vo.user.UserVo;
import lombok.Data;

import java.util.List;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/4 18:06
 */
@Data
public class PlaylistVo extends BaseVo {

    private String name;

    private String description;

    private FileVo cover;

    private PlaylistStatus status;

    private UserVo creator;

    private List<MusicVo> musicList;

}
