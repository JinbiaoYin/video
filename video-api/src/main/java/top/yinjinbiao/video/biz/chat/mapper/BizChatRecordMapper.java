package top.yinjinbiao.video.biz.chat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.yinjinbiao.video.domain.BizChatRecord;

import java.util.List;

public interface BizChatRecordMapper extends BaseMapper<BizChatRecord> {

    int deleteByPrimaryKey(Long id);
   
    int insert(BizChatRecord record);
   
    int insertSelective(BizChatRecord record);

    BizChatRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BizChatRecord record);

    int updateByPrimaryKey(BizChatRecord record);

    /**
     * 批量设置消息为已读
     * @param msgIdList
     */
	void updateMsgSignedById(List<Long> msgIdList);

	/**
	 * 根据当前登陆人查询未读消息
	 * @param currentUserId
	 * @return
	 */
	List<BizChatRecord> listUnReadChatRecord(Long acceptUserId);
}