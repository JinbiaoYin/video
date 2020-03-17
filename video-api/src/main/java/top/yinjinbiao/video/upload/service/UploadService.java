package top.yinjinbiao.video.upload.service;

/**
 * 文件上传/下载接口
 */
public interface UploadService {

    /**
     * 文件上传
     * @param name 文件名称
     * @param data 文件二进制数据
     */
    public String upload(String name,byte[] data);


    /**
     * 文件删除接口
     * @param id 文件标识符
     * @return
     */
    public String delete(String id);


}
