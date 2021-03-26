package top.yinjinbiao.video.domain.dto;

import lombok.Data;

/**
 * @Description token
 * @Author yin.jinbiao
 * @Date 2021/3/26 13:32
 * @Version 1.0
 */
@Data
public class Token {

    private String access_token;

    private String token_type;

    private String expires_in;

    private String scope;
}
