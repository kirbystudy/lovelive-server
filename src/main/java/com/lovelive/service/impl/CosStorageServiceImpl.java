package com.lovelive.service.impl;

import com.lovelive.dto.file.FileUploadDto;
import com.lovelive.enums.ExceptionType;
import com.lovelive.exception.BizException;
import com.lovelive.service.StorageService;
import com.tencent.cloud.CosStsClient;
import com.tencent.cloud.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.TreeMap;

/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/1 19:06
 */
@Service("COS")
public class CosStorageServiceImpl implements StorageService {

    /**
     * todo: 存储桶名称
     */
    @Value("${cos.bucket}")
    private String bucket;

    /**
     * todo: 密钥id
     */
    @Value("${cos.secret-id}")
    private String secretId;

    /**
     * todo: 密钥key
     */
    @Value("${cos.secret-key}")
    private String secretKey;

    /**
     * todo: 所属地域
     */
    @Value("${cos.region}")
    private String region;

    /**
     * todo:初始化文件上传
     */
    @Override
    public FileUploadDto initFileUpload() {

        try {
            Response response = CosStsClient.getCredential(getCosStsConfig());

            FileUploadDto fileUploadDto = new FileUploadDto();
            fileUploadDto.setBucket(bucket);
            fileUploadDto.setRegion(region);
            fileUploadDto.setSecretId(response.credentials.tmpSecretId);
            fileUploadDto.setSecretKey(response.credentials.tmpSecretKey);
            fileUploadDto.setSessionToken(response.credentials.sessionToken);
            return fileUploadDto;
        } catch (IOException e) {
            e.printStackTrace();
            throw new BizException(ExceptionType.INTERNAL_ERROR);
        }
    }

    /**
     * todo:基本的临时密钥申请示例，适合对一个桶内的一批对象路径，统一授予一批操作权限
     */
    private TreeMap<String, Object> getCosStsConfig() {
        TreeMap<String, Object> config = new TreeMap<String, Object>();


        // 云 api 密钥 SecretId
        config.put("secretId", secretId);
        // 云 api 密钥 SecretKey
        config.put("secretKey", secretKey);

        // 设置域名
        //config.put("host", "sts.internal.tencentcloudapi.com");

        // 临时密钥有效时长，单位是秒
        config.put("durationSeconds", 1800);

        // 换成你的 bucket
        config.put("bucket", bucket);
        // 换成 bucket 所在地区
        config.put("region", region);

        // 可以通过 allowPrefixes 指定前缀数组, 例子： a.jpg 或者 a/* 或者 * (使用通配符*存在重大安全风险, 请谨慎评估使用)
        config.put("allowPrefixes", new String[]{
                "*"
        });

        // 密钥的权限列表。简单上传和分片需要以下的权限，其他权限列表请看 https://cloud.tencent.com/document/product/436/31923
        String[] allowActions = new String[]{
                // 简单上传
                "name/cos:PutObject",
                "name/cos:PostObject",
                // 分片上传
                "name/cos:InitiateMultipartUpload",
                "name/cos:ListMultipartUploads",
                "name/cos:ListParts",
                "name/cos:UploadPart",
                "name/cos:CompleteMultipartUpload"
        };
        config.put("allowActions", allowActions);
        return config;
    }
}
