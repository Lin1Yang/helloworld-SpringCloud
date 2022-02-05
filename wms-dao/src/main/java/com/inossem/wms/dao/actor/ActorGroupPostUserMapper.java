package com.inossem.wms.dao.actor;

import com.inossem.wms.co.actor.ActorGroupPostUserCo;
import com.inossem.wms.model.actor.ActorGroupPostUser;
import com.inossem.wms.model.actor.ActorGroupPostUserKey;
import com.inossem.wms.vo.actor.ActorGroupPostUserVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ActorGroupPostUserMapper {
    int deleteByPrimaryKey(ActorGroupPostUserKey key);

    int insert(ActorGroupPostUser record);

    int insertSelective(ActorGroupPostUser record);

    ActorGroupPostUser selectByPrimaryKey(ActorGroupPostUserKey key);

    int updateByPrimaryKeySelective(ActorGroupPostUser record);

    int updateByPrimaryKey(ActorGroupPostUser record);

    void insertOrUpdate(ActorGroupPostUserCo actorGroupPostUserCo);
    
    int insertOrUpdateBatchActorGroupPostUserCo(List<ActorGroupPostUserCo> list);

    List<ActorGroupPostUserVo> selectByParamsSelective(ActorGroupPostUserCo actorGroupPostUserCo);
    
    int logicDeleteByGroupCode(String groupCode);
}