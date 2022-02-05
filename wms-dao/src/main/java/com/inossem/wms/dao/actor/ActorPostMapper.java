package com.inossem.wms.dao.actor;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.inossem.wms.co.actor.ActorPostCo;
import com.inossem.wms.model.actor.ActorPost;
import com.inossem.wms.model.sys.SysUser;
import com.inossem.wms.vo.actor.ActorPostVo;
import com.inossem.wms.vo.sys.SysUserVo;

@Component
public interface ActorPostMapper {
    int deleteByPrimaryKey(String postCode);

    int insert(ActorPost record);

    int insertSelective(ActorPost record);

    ActorPost selectByPrimaryKey(String postCode);

    int updateByPrimaryKeySelective(ActorPost record);

    int updateByPrimaryKey(ActorPost record);
/////////////自定义方法////////////////////////////////////////////////////////////////////////
    /**
     * 插入或者更新
     * @param actorPostCo
     * @return
     */
    int insertOrUpdate(ActorPostCo actorPostCo);

    /**
     * 按照条件检索列表
     * @param actorPostCo
     * @return
     */
    List<ActorPostVo> selectByParamsSelectiveOnPaging(ActorPostCo actorPostCo);


    List<ActorPost> selectByList(List<ActorPostCo> actorPostVoList);
    
    List<SysUser> getUserList(ActorPostCo actorPostCo);
    
    List<SysUserVo> getUserVoList(ActorPostCo actorPostCo);
	/**
	 * 根据岗位代码查询岗位对应公司代码列表
	 * 
	 * @param postCodeList
	 * @return
	 * @author libin
	 */
	List<String> selectCorpCodeByPostCodeList(@Param(value="postCodeList") List<String> postCodeList);
	
	List<ActorPost> selectActorPostByCorpCode(String corpCode);

	/**
	 * 根据岗位代码查询岗位会签标识
	 * 
	 * @param postCode
	 * @return
	 * @author libin
	 */
	Byte getCountersignByPostCode(@Param(value="postCode") String postCode);
    
}