package top.yinjinbiao.video.sso.server.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import top.yinjinbiao.video.admin.service.SysUserService;
import top.yinjinbiao.video.common.dto.VideoUser;
import top.yinjinbiao.video.domain.SysPermission;
import top.yinjinbiao.video.domain.SysUser;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    /**
     * TODO 跨包调用
     */
    @Autowired
    private SysUserService sysUserService;

    /**
     * 根据用户名查找用户，如果用户不存在抛出异常。
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.findByUsername(username);
        if(sysUser == null){
            throw new UsernameNotFoundException(username);
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        // 根据账号查询权限列表
        List<SysPermission> sysPermissionList = sysUserService.listSysPermissionByUsername(username);
        for (SysPermission sysPermission : sysPermissionList) {
            authorities.add(new SimpleGrantedAuthority(sysPermission.getCode()));
        }
        return new VideoUser(sysUser.getId(),sysUser.getNickname(),sysUser.getUsername(),sysUser.getPassword(),authorities);
    }
}

