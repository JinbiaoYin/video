package top.yinjinbiao.video.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import top.yinjinbiao.video.domain.SysPermission;
import top.yinjinbiao.video.domain.SysUser;

import java.util.List;

public interface SysUserMapper extends BaseMapper<SysUser> {


    List<SysPermission> listSysPermissionByUsername(@Param("username") String username);

}