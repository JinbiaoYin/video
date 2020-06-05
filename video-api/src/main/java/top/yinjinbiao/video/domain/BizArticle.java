package top.yinjinbiao.video.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.yinjinbiao.video.common.domain.BaseDomain;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)//equals和hashcode方法也使用父类的属性进行重写
public class BizArticle extends BaseDomain {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    /**
    * 作者
    */
    private String author;

    /**
    * 审核人
    */
    private String reviewer;

    /**
    * 标题
    */
    private String title;

    /**
    * 内容
    */
    private String content;

    /**
    * 发布时间
    */
    private Date publishTime;

    /**
     * 状态
     */
    private Short status;
}