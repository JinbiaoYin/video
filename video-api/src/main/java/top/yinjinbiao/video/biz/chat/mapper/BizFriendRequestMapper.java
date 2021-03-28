package top.yinjinbiao.video.biz.chat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import top.yinjinbiao.video.domain.BizFriendRequest;
import top.yinjinbiao.video.domain.vo.SysUserVO;

import java.util.List;

public interface BizFriendRequestMapper extends BaseMapper<BizFriendRequest> {

    int deleteByPrimaryKey(Long id);


    int insert(BizFriendRequest record);


    int insertSelective(BizFriendRequest record);


    BizFriendRequest selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(BizFriendRequest record);


    int updateByPrimaryKey(BizFriendRequest record);


	List<SysUserVO> findByAcceptUserId(Long acceptUserId);


	BizFriendRequest findBySendUserIdAndAcceptUserId(@Param("sendUserId")Long sendUserId,@Param("acceptUserId") Long acceptUserId);
}