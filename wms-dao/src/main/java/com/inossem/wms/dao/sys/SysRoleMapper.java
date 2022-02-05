package com.inossem.wms.dao.sys;

import java.util.List;

import com.inossem.wms.co.sys.SysRoleCo;
import com.inossem.wms.model.sys.SysRole;
import com.inossem.wms.vo.sys.SysRoleInfoVo;
import com.inossem.wms.vo.sys.SysRoleVo;

public interface SysRoleMapper {
    int deleteByPrimaryKey(String roleCode);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(String roleCode);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record); 
    /**
     * 用户可分配的角色  
     * @param userId
     * @author 刘宇 2018年12月24日11:16:35
     * @return
     */
    List<SysRoleVo> selectRoleNotYetOfUserByUserId(Integer userId); 
    
    /**
     * 所有角色
     * @author 刘宇 2018年12月27日20:29:32
     * @return
     */
    List<SysRoleVo> selectAllRoleList(); 
    
    /**
	 * 分页查询角色信息
	 * 分页查询角色信息，根据角色创建时间create_time降序排列，如果传参数condition，根据角色编码role_code或者角色描述role_name模糊查询
	 * 
	 * @param sysUserCo
	 *            查询条件condition
	 * @return
	 * 
	 * @author 刘宇 2018年12月29日10:23:51
	 */
	List<SysRoleVo> selectByRoleCodeAndRoleNameOnPaging(SysRoleCo roleCo);
	
	/**
	 * 角色信息
	 * 
	 * @param roleCode
	 * @return
	 * 
	 * @author 刘宇 2018年12月29日16:06:13
	 */
	SysRoleInfoVo selectByRoleCode(String roleCode);
	
	/**
	 * 通过角色编码查询该角色是否存在
	 * 
	 * @param roleCode
	 * @return
	 * 
	 * @author 刘宇2019年1月2日14:21:48
	 */
	SysRole selectExistedSysRoleByRoleCode(String roleCode);   
	

	/**
	 * 通过角色描述查询该角色是否存在
	 * 
	 * @param roleName
	 * @return
	 * 
	 * @author 刘宇2019年1月2日14:21:48
	 */
	SysRole selectExistedSysRoleByRoleName(String roleName);
    
    
    
}