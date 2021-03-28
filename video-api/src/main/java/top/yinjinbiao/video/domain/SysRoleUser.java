package top.yinjinbiao.video.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* @author yin.jinbiao
* @date 2020-03-12
*/
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class SysRoleUser extends BaseDomain {

	private static final long serialVersionUID = 1L;

	private Long id;	
	private Long roleId;
	private Long userId;
    
}