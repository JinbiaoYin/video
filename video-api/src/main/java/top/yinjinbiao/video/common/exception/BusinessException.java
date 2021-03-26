package top.yinjinbiao.video.common.exception;


import top.yinjinbiao.video.common.enums.ResponseCode;

/**
 * @Description 业务异常
 * @Author yin.jinbiao
 * @Date 2021/3/26 9:19
 * @Version 1.0
 */
public class BusinessException extends RuntimeException {
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BusinessException() {}

    public BusinessException(String message) {
        super(message);
        this.code = -1;
    }

    public BusinessException(ResponseCode status) {
        super(status.message());
        this.code = status.code();
    }
}
