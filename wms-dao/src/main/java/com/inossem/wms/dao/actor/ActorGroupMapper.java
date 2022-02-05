package com.inossem.wms.dao.actor;

import com.inossem.wms.co.actor.ActorGroupCo;
import com.inossem.wms.model.actor.ActorGroup;
import com.inossem.wms.vo.actor.ActorGroupVo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ActorGroupMapper {
    int deleteByPrimaryKey(String groupCode);

    int insert(ActorGroup record);

    int insertSelective(ActorGroup record);
    
    int insertOrUpdateBatchActorGroupPostCo(List<ActorGroup> list);

    ActorGroup selectByPrimaryKey(String groupCode);

    int updateByPrimaryKeySelective(ActorGroup record);

    int updateByPrimaryKey(ActorGroup record);

    /*************自定义方法*****************/
    int insertOrUpdate(ActorGroupCo actorGroupCo);

    List<ActorGroupVo> selectByParamsSelectiveOnPaging(ActorGroupCo actorGroupCo);

    void updateNoneDefaultByParam(ActorGroupCo actorGroupCo);

	int updateDefaultActorGroup(@Param(value="groupCode") String groupCode, @Param(value="isDefault") Byte value);
	
	List<ActorGroup> selectActorGroupByCorpCode(String corpCode);
}