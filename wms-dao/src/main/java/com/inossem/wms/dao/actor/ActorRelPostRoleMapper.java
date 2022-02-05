package com.inossem.wms.dao.actor;

import java.util.List;

import org.springframework.stereotype.Component;

import com.inossem.wms.co.actor.ActorPostCo;
import com.inossem.wms.model.actor.ActorRelPostRole;
import com.inossem.wms.model.actor.ActorRelPostRoleKey;
import com.inossem.wms.vo.actor.ActorRelPostRoleVo;
import com.inossem.wms.vo.sys.SysUserVo;

@Component
public interface ActorRelPostRoleMapper {
    int deleteByPrimaryKey(ActorRelPostRoleKey key);

    int insert(ActorRelPostRole record);

    int insertSelective(ActorRelPostRole record);

    int insertOrUpdate(ActorRelPostRole record);
    
    int insertOrUpdateBatchActorRelPostRole(List<ActorRelPostRole> list);

    ActorRelPostRole selectByPrimaryKey(ActorRelPostRoleKey key);

    int updateByPrimaryKeySelective(ActorRelPostRole record);

    int updateByPrimaryKey(ActorRelPostRole record); 
    
    /**
     * 根据角色编码修改岗位角色删除标识 
     * @author 刘宇 2019年1月2日16:53:41
     * @param roleCode
     * @return
     */
    int updateByRoleCode(String roleCode);
    
    List<ActorRelPostRoleVo> selectRoleListByPostCode(String postCode);
    
    /**
     * 岗位对应角色下的所有人员 condition用户编码描述
     * @author lys
     * @param postCode
     * @return
     */
    List<SysUserVo> selectUserListByPostCode(ActorPostCo actorPostCo);
    
    /**
     * 逻辑删除岗位对应角色
     * @author 
     * @param postCode
     * @return
     */
    int updateRoleToDeleteByPostCode(String postCode);
    
    
}