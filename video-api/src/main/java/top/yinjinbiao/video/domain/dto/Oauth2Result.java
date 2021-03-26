package top.yinjinbiao.video.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description Oauth2请求结果
 * @Author yin.jinbiao
 * @Date 2021/3/26 13:32
 * @Version 1.0
 */
@Data
public class Oauth2Result implements Serializable {

    private String access_token;

    private String token_type;

    private String expires_in;

    private String scope;

    private String error;

    private String error_description;
}
