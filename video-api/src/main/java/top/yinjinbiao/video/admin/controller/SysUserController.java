package top.yinjinbiao.video.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.yinjinbiao.video.admin.service.SysUserService;
import top.yinjinbiao.video.common.dto.ResponseResult;
import top.yinjinbiao.video.common.enums.ResponseCode;
import top.yinjinbiao.video.domain.SysUser;

/**
 * @Description 用户相关
 * @Author yin.jinbiao
 * @Date 2021/3/28 10:05
 * @Version 1.0
 */
@RestController
@RequestMapping("/sysuser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping
    public ResponseResult<SysUser> add(@Validated @RequestBody SysUser sysUser){
        return new ResponseResult(ResponseCode.SUCCESS.code(),ResponseCode.SUCCESS.message(),sysUserService.save(sysUser));
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult<SysUser> get(@PathVariable(value="id") Long id){
        return new ResponseResult(ResponseCode.SUCCESS.code(),ResponseCode.SUCCESS.message(),sysUserService.findByUserId(id));
    }

}
