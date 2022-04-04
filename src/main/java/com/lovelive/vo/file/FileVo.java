package com.lovelive.vo.file;

import com.lovelive.enums.FileStatus;
import com.lovelive.enums.FileType;
import com.lovelive.vo.BaseVo;
import lombok.Data;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/2 15:54
 */
@Data
public class FileVo extends BaseVo {

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件hash值
     */
    private String key;

    /**
     * 文件后缀名
     */
    private String ext;

    /**
     * 文件大小：单位byte
     */
    private Long size;

    /**
     * 文件类型：AUDIO-音频, IMAGE-图片, VIDEO-视频, OTHER-其他
     */
    private FileType type;

    /**
     * 文件状态：UPLOADING-上传中, UPLOADED-已上传, CANCEL-已取消
     */
    private FileStatus status;

}
