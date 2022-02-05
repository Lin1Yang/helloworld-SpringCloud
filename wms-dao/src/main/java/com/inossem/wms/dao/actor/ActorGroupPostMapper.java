package com.inossem.wms.dao.actor;

import com.inossem.wms.co.actor.ActorGroupPostCo;
import com.inossem.wms.co.biz.BizReceiptActorCo;
import com.inossem.wms.model.actor.ActorGroupPost;
import com.inossem.wms.model.actor.ActorGroupPostKey;
import com.inossem.wms.vo.actor.ActorGroupPostVo;
import com.inossem.wms.vo.actor.ActorGroupUserMo;
import com.inossem.wms.vo.actor.BizReceiptActorVo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ActorGroupPostMapper {
    int deleteByPrimaryKey(ActorGroupPostKey key);

    int insert(ActorGroupPost record);

    int insertSelective(ActorGroupPost record);

    ActorGroupPost selectByPrimaryKey(ActorGroupPostKey key);

    int updateByPrimaryKeySelective(ActorGroupPost record);

    int updateByPrimaryKey(ActorGroupPost record);

    int insertOrUpdate(ActorGroupPostCo actorGroupPostCo);
    
    int insertOrUpdateBatchActorGroupPostCo(List<ActorGroupPostCo> list);

    List<ActorGroupPostVo> selectJoinedInfoByParamsSelective(ActorGroupPostCo actorGroupPostCo);

    List<ActorGroupUserMo> selectJoinedGroupAndUserByGroupCode(String groupCode);

    List<ActorGroupUserMo> selectJoinedGroupAndUserByOwnGroupCode(String groupCode);
    
    List<ActorGroupPost> selectByGroupCodeList(List<String> groupCodeList);
    
    List<ActorGroupPost> selectRequiredByGroupCodeList(@Param("list")List<String> groupCodeList,@Param("required")Byte required);

    List<BizReceiptActorVo> getReceiptListOnPaging(BizReceiptActorCo bizReceiptActorCo);

    List<BizReceiptActorVo> getAllReceiptByDoneAndToBeDone(BizReceiptActorCo bizReceiptActorCo);
    
    int logicDeleteByGroupCode(String groupCode);
    
    List<BizReceiptActorVo> getAgencyList(BizReceiptActorCo bizReceiptActorCo);
}