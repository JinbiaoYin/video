package top.yinjinbiao.video.domain.query;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Description 登录参数
 * @Author yin.jinbiao
 * @Date 2021/3/26 8:59
 * @Version 1.0
 */
@Data
public class LoginParam {

    @NotBlank
    String username;

    @NotBlank
    String password;
}
