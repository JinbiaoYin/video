package top.yinjinbiao.video.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseDomain implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@CreatedBy
    private Date createTime;

    private Date updateTime;

    private Long createBy;

    private Long updateBy;

    @TableField("is_deleted")
    private Boolean deleted;
}
