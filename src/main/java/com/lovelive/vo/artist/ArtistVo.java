package com.lovelive.vo.artist;

import com.lovelive.enums.ArtistStatus;
import com.lovelive.vo.BaseVo;
import com.lovelive.vo.file.FileVo;
import com.lovelive.vo.music.MusicVo;
import lombok.Data;

import java.util.List;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/8 14:39
 */
@Data
public class ArtistVo extends BaseVo {

    private String name;

    private String remark;

    private FileVo photo;

    private List<MusicVo> musicVoList;

    private ArtistStatus status;
}
