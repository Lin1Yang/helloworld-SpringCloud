package com.inossem.wms.dao.sys;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.inossem.wms.model.sys.SysResources;
import com.inossem.wms.vo.auth.SysResourcesRoleVo;
import com.inossem.wms.vo.auth.SysResourcesVo;

public interface SysResourcesMapper {
    int deleteByPrimaryKey(String resourcesCode);

    int insert(SysResources record);

    int insertSelective(SysResources record);

    SysResources selectByPrimaryKey(String resourcesCode);

    int updateByPrimaryKeySelective(SysResources record);

    int updateByPrimaryKey(SysResources record);
    
    List<SysResources> selectByUserCode(String userCode);
    
    List<SysResourcesVo> selectResourcesByUserId(Map<String,Object> param);  
    
    List<SysResources> selectAllPermission();
    
    /**
     * 查询角色已经分配的权限
     * @author 刘宇 2018年12月29日16:37:10
     * @param roleCode
     * @return
     */
    List<SysResourcesRoleVo> selectResourcesRoleHave(String roleCode);
    
    /**
     * 查询角色还没有分配的权限
     * @author 刘宇 2018年12月29日16:37:10
     * @param roleCode
     * @return
     */
    List<SysResourcesRoleVo> selectResourcesRoleNotHave(String roleCode);  
    
    /**
     * 查询所有权限
     * @author 刘宇 2018年12月29日17:24:54
     * @return
     */
    List<SysResourcesRoleVo> selectAllResources();

	List<SysResourcesVo> selectByResourceCodes(Set<String> set);

	/**
	 * 查询资源信息与角色关联信息，并按照给定的permissionType筛选
	 * 
	 * @param permissionType
	 * @return
	 * @author libin
	 */
	List<SysResources> selectResourcesByPermissionType(Integer permissionType); 
}