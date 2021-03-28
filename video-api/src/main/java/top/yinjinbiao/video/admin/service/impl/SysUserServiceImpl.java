package top.yinjinbiao.video.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yinjinbiao.video.admin.mapper.SysUserMapper;
import top.yinjinbiao.video.admin.service.SysUserService;
import top.yinjinbiao.video.domain.SysPermission;
import top.yinjinbiao.video.domain.SysUser;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

//	@Autowired
//	private UploadService uploadService;

    @Autowired
    private SysUserMapper sysUserMapper;

	@Override
	public int save(SysUser sysUser) {
		return sysUserMapper.insert(sysUser);
	}

	public List<SysPermission> listSysPermissionByUsername(String username) {
        return sysUserMapper.listSysPermissionByUsername(username);
    }

    @Override
    public SysUser findByUsername(String username) {
        return sysUserMapper.selectOne(new QueryWrapper<SysUser>().eq("username", username));
    }

	@Override
	public SysUser findByUserId(Long id) {
		return sysUserMapper.selectById(id);
	}

/*	@Override
	@Transactional
	public SysUserVO uploadFaceImg(Long id, MultipartFile file) {
		String faceImgUrl = null;
		try {
			faceImgUrl = uploadService.upload(file.getOriginalFilename(), file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SysUser sysUser = sysUserMapper.selectById(id);
		sysUser.setFaceImg(faceImgUrl);
		sysUserMapper.updateById(sysUser);
		return new SysUserVO(sysUser.getId(),sysUser.getNickname(),sysUser.getUsername(),faceImgUrl);
	}*/
}
