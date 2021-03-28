package top.yinjinbiao.video.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class SysFile extends BaseDomain {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private String originalName;

    private String currentName;

    private String url;

}