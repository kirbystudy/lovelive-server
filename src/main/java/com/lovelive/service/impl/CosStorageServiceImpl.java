package com.lovelive.service.impl;

import com.lovelive.dto.file.FileUploadDto;
import com.lovelive.enums.ExceptionType;
import com.lovelive.exception.BizException;
import com.lovelive.service.StorageService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.region.Region;
import com.tencent.cloud.CosStsClient;
import com.tencent.cloud.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
            fileUploadDto.setSecretId(response.credentials.tmpSecretId);
            fileUploadDto.setSecretKey(response.credentials.tmpSecretKey);
            fileUploadDto.setSessionToken(response.credentials.sessionToken);
            fileUploadDto.setStartTime(response.startTime);
            fileUploadDto.setExpiredTime(response.expiredTime);
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

    @Override
    public String getFileUri(String fileKey) {
        // 调用 COS 接口之前必须保证本进程存在一个 COSClient 实例，如果没有则创建
        COSClient cosClient = createCOSClient();

        // 存储桶的命名格式为 BucketName-APPID，此处填写的存储桶名称必须为此格式
        // String bucketName = "examplebucket-1250000000";
        // 对象键(Key)是对象在存储桶中的唯一标识。详情请参见 [对象键](https://cloud.tencent.com/document/product/436/13324)
        // String key = "exampleobject";

        // 设置签名过期时间(可选), 若未进行设置则默认使用 ClientConfig 中的签名过期时间(1小时)
        // 这里设置签名在半个小时后过期
        Date expirationDate = new Date(System.currentTimeMillis() + 30 * 60 * 1000);

        // 填写本次请求的参数，需与实际请求相同，能够防止用户篡改此签名的 HTTP 请求的参数
        Map<String, String> params = new HashMap<String, String>();

        // 填写本次请求的头部，需与实际请求相同，能够防止用户篡改此签名的 HTTP 请求的头部
        Map<String, String> headers = new HashMap<String, String>();

        // 请求的 HTTP 方法，上传请求用 PUT，下载请求用 GET，删除请求用 DELETE
        HttpMethodName method = HttpMethodName.GET;

        URL url = cosClient.generatePresignedUrl(bucket, fileKey, expirationDate, method, headers, params);
        System.out.println(url.toString());

        // 确认本进程不再使用 cosClient 实例之后，关闭之
        cosClient.shutdown();
        return url.toString();
    }

    /**
     * 创建 COSClient 实例，这个实例用来后续调用请求
     *
     * @return
     */
    public COSClient createCOSClient() {

        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);

        // ClientConfig 中包含了后续请求 COS 的客户端设置：
        ClientConfig clientConfig = new ClientConfig();

        // 设置 bucket 的地域
        // COS_REGION 请参照 https://cloud.tencent.com/document/product/436/6224
        clientConfig.setRegion(new Region(region));

        // 设置请求协议, http 或者 https
        // 5.6.53 及更低的版本，建议设置使用 https 协议
        // 5.6.54 及更高版本，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);

        // 以下的设置，是可选的：

        // 设置 socket 读取超时，默认 30s
        clientConfig.setSocketTimeout(30 * 1000);
        // 设置建立连接超时，默认 30s
        clientConfig.setConnectionTimeout(30 * 1000);

        // 生成 cos 客户端。
        return new COSClient(cred, clientConfig);
    }
}
