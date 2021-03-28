package top.yinjinbiao.video.admin.service;

import org.springframework.web.multipart.MultipartFile;
import top.yinjinbiao.video.domain.SysPermission;
import top.yinjinbiao.video.domain.SysUser;
import top.yinjinbiao.video.domain.vo.SysUserVO;

import java.util.List;

public interface SysUserService {

    /**
     * 增加用户
     * @param sysUser
     * @return
     */
    int save(SysUser sysUser);

    /**
     * 根据登录名（账号）查询所有授权
     * @param username
     * @return
     */
    List<SysPermission> listSysPermissionByUsername(String username);

    /**
     * 根据登录账号查询用户
     * @param username
     * @return
     */
    SysUser findByUsername(String username);
    
    /**
     * 根据id查询用户
     * @return
     */
    SysUser findByUserId(Long id);

    /**
     * 上传头像
     * @param file
     */
    //SysUserVO uploadFaceImg(Long id,MultipartFile file);
}