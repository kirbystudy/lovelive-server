package com.lovelive.utils;

import com.lovelive.enums.FileType;


/**
 * @author 小埋
 * @version 1.0
 * @Description 文件类型转换器
 * @Date 2022/4/3 11:31
 */
public class FileTypeTransformer {

    /**
     * 获取文件类型
     *
     * @param ext
     * @return
     */
    public static FileType getFileTypeFromExt(String ext) {

        if (isAudio(ext)) {
            return FileType.AUDIO;
        }

        if (isImage(ext)) {
            return FileType.IMAGE;
        }

        if (isVideo(ext)) {
            return FileType.VIDEO;
        }

        return FileType.OTHER;
    }


    private static Boolean isAudio(String ext) {
        String[] videoExt = {"mp3", "wav", "flac"};
        for (String perExt : videoExt) {
            if (perExt.equals(ext)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private static Boolean isImage(String ext) {
        String[] videoExt = {"png", "jpg", "jpeg"};
        for (String perExt : videoExt) {
            if (perExt.equals(ext)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private static Boolean isVideo(String ext) {
        String[] videoExt = {"vob", "mp4", "avi",
                "flv", "f4v", "wmv", "mov", "rmvb",
                "mkv", "mpg", "m4v", "webm", "rm",
                "mpeg", "asf", "ts", "mts"};
        for (String perExt : videoExt) {
            if (perExt.equals(ext)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

}
