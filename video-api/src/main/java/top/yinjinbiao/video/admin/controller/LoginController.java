package top.yinjinbiao.video.admin.controller;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yinjinbiao.video.common.dto.ResponseResult;
import top.yinjinbiao.video.common.enums.ResponseCode;
import top.yinjinbiao.video.domain.bo.LoginParam;

import java.util.Map;

/**
 * @Description 登录
 * @Author yin.jinbiao
 * @Date 2021/3/26 8:51
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class LoginController {

    @Value("${business.oauth2.grant_type}")
    public String oauth2GrantType;

    @Value("${business.oauth2.client_id}")
    public String oauth2ClientId;

    @Value("${business.oauth2.client_secret}")
    public String clientSecret;

    @Value("${business.oauth2.access_token_uri}")
    private String accessTokenURI;

    /**
     * 登录
     * @param loginParam
     * @return
     */
    @PostMapping(value = "/login")
    public ResponseResult login(@RequestBody LoginParam loginParam){
        // 封装返回的结果集
        Map<String, Object> result = Maps.newHashMap();
        // 通过 HTTP 客户端请求登录接口
        Map<String, String> params = Maps.newHashMap();
        params.put("username", loginParam.getUsername());
        params.put("password", loginParam.getPassword());
        params.put("grant_type", oauth2GrantType);
        params.put("client_id", oauth2ClientId);
        params.put("client_secret", clientSecret);

        try {
            // 解析响应结果封装并返回
//            Response response = OkHttpClientUtil.getInstance().postData(accessTokenURI, params);
//            String jsonString = Objects.requireNonNull(response.body()).string();
//            Token token = MapperUtils.json2pojo(jsonString, Token.class);
//            result.put("token", token.getAccess_token());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult<Map<String, Object>>(ResponseCode.USER_LOGIN_ERROR.code(), ResponseCode.USER_LOGIN_ERROR.message());
        }
        return new ResponseResult<Map<String, Object>>(ResponseCode.SUCCESS.code(), ResponseCode.SUCCESS.message(), result);
    }





}
