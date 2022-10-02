package com.plf.tool.common.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.SimplifiedObjectMeta;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class OssUtils {

    /*
    // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
    static  String endpoint = "";
    //阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
    static String accessKeyId = "";
    static String accessKeySecret = "";
    //填写Bucket名称，例如examplebucket。
    static String bucketName = "";
    */

    public static void upFile(String endpoint,String accessKeyId,String accessKeySecret,String bucketName,String path,String fileName) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 创建PutObjectRequest对象。
        // 依次填写Bucket名称（例如examplebucket）、Object完整路径（例如exampledir/exampleobject.txt）和本地文件的完整路径。Object完整路径中不能包含Bucket名称。
        // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,fileName,
                new File(path));

        // 如果需要上传时设置存储类型和访问权限，请参考以下示例代码。
        // ObjectMetadata metadata = new ObjectMetadata();
        // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
        // metadata.setObjectAcl(CannedAccessControlList.Private);
        // putObjectRequest.setMetadata(metadata);

        // 上传文件。
        ossClient.putObject(putObjectRequest);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    public static void deleteFile(String endpoint,String accessKeyId,String accessKeySecret,String bucketName,String path) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 删除文件或目录。如果要删除目录，目录必须为空。
        ossClient.deleteObject(bucketName, path);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    public static void downloadFile(String endpoint,String accessKeyId,String accessKeySecret,String bucketName,String objectName,String filePath) throws IOException {

        // 创建OSSClient实例。
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 下载Object到本地文件，并保存到指定的本地路径中。如果指定的本地文件存在会覆盖，不存在则新建。
        // 如果未指定本地路径，则下载后的文件默认保存到示例程序所属项目对应本地路径中。
        ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File(filePath+"\\"+objectName));

        // 关闭OSSClient。
        ossClient.shutdown();
    }


    public static void searchFile(String endpoint,String accessKeyId,String accessKeySecret,String bucketName,String prerfix) {

        // 指定前缀，例如exampledir/object。
        // String keyPrefix = "exampledir/object";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 列举文件。如果不设置keyPrefix，则列举存储空间下的所有文件。如果设置keyPrefix，则列举包含指定前缀的文件。
        ObjectListing objectListing = ossClient.listObjects(bucketName,prerfix+"/");
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        for (OSSObjectSummary s : sums) {
            System.out.println("\t" + s.getKey());
        }

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    public static void getMetaData(String endpoint,String accessKeyId,String accessKeySecret,String bucketName,String objectName) throws ParseException {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 获取文件的部分元信息。
        SimplifiedObjectMeta objectMeta = ossClient.getSimplifiedObjectMeta(bucketName, objectName);
        System.out.println(objectMeta.getSize());
        System.out.println(objectMeta.getETag());
        System.out.println(objectMeta.getLastModified());

        // 获取文件的全部元信息。
        ObjectMetadata metadata = ossClient.getObjectMetadata(bucketName, objectName);
        System.out.println(metadata.getContentType());
        System.out.println(metadata.getLastModified());
        System.out.println(metadata.getExpirationTime());
        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
