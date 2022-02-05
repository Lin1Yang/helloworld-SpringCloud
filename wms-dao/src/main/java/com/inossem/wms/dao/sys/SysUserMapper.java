package com.inossem.wms.dao.sys;


import java.util.List;

import com.inossem.wms.co.sys.SysUserCo;
import com.inossem.wms.co.sys.SysUserDeleteAndLockStatusCo;
import com.inossem.wms.co.sys.SysUserFreezeStatusCo;
import com.inossem.wms.co.sys.SysUserNewPassWordCo;
import com.inossem.wms.co.sys.SysUserPasswordCo;
import com.inossem.wms.co.sys.SysUserRoleCo;
import com.inossem.wms.model.sys.SysUser;
import com.inossem.wms.vo.sys.SysUserInfoVo;
import com.inossem.wms.vo.sys.SysUserVo;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    SysUser selectByUserCode(String userCode);
    
	/**
	 * 分页查询用户信息
	 * 根据用户名user_code正序排列
	 * 如果传参数condition，根据用户名user_code或者用户描述user_name模糊查询
	 * 如果传参数corpCCode,登录用户只能查看自己所属公司下的用户信息
	 * 
	 * @param sysUserCo
	 *            查询条件condition
	 * @return
	 * 
	 * @author 刘宇 2018年12月21日15:46:23
	 */
	List<SysUserVo> selectByUserCodeAndUserNameOnPaging(SysUserCo sysUserCo);
	
	/**
	 * 用户详情信息查询 根据用户id查询 
	 * @param  userId 
	 * @author 刘宇 2018年12月24日09:11:25
	 * @return
	 */
	SysUserInfoVo selectUserVoInfoByUserId(Integer userId);
	
	/**
	 * 查询同一用户编码的用户数量
	 * @param userCode用户编码
	 * @author 刘宇 2018年12月25日10:04:19
	 * @return
	 */
	SysUser selectSysUserCountByUserCode(String userCode);
	
	/**
	 * 批量修改用户冻结状态
	 * @author 刘宇 2018年12月26日19:52:52
	 * @param record
	 * @return
	 */
	int updateFreezeStatusByUserId(List<SysUserFreezeStatusCo> record);
	
	/**
	 * 批量修改用户锁定状态
	 * @author 刘宇 2018年12月26日20:39:42
	 * @param record
	 * @return
	 */
	int updateIsLockedStatusByUserId(List<SysUserDeleteAndLockStatusCo> record);  
	
	/**
	 * 批量修改用户删除状态
	 * @author 刘宇 2018年12月27日09:17:22
	 * @param record
	 * @return
	 */
	int updateIsDeleteStatusByUserId(List<SysUserDeleteAndLockStatusCo> record); 
	
	/**
	 * 批量修改用户密码
	 * @author 刘宇 2018年12月27日11:06:33
	 * @param record
	 * @return
	 */
	int updatePasswordByUserIds(List<SysUserPasswordCo> record);
	
	/**
	 * 修改用户密码
	 * @author 刘宇 2018年12月27日12:20:31
	 * @param record
	 * @return
	 */
	int updatePasswordByUserId(SysUserNewPassWordCo record); 
	
	/**
	 * 角色已经分配的用户信息
	 * @param roleCode
	 * @return
	 * 
	 * @author 刘宇 2018年12月29日16:29:01
	 */
	List<SysUserVo> selectSysUserOfRoleHave(String roleCode);  
	
	/**
	 * 角色还没有分配的用户信息
	 * @param roleCode
	 * @return
	 * 
	 * @author 刘宇 2018年12月29日16:29:01
	 */
	List<SysUserVo> selectSysUserOfRoleNotHave(String roleCode);  
	
	/**
	 * 查询所有用户
	 * @param condition
	 * @return
	 * 
	 * @author 刘宇 2018年12月29日16:29:01
	 */
	List<SysUserVo> selectAllUser(String condition); 
	
	/**
	 * 按用户编号或者姓名模糊搜索用户  最多50条
	 * @param condition
	 * @return
	 */
	List<SysUserVo> selectUserByConditionLimit(String condition); 
	/**
	 * 查询所有用户
	 * @param condition
	 * @return
	 * 
	 * @author ylyun
	 */
	List<SysUserVo> selectAllUserList();    
	
	/**
	 * 查询角色还没有分配的用户信息
	 * 
	 * @param oCo       
	 * @return
	 * 
	 * @author 刘宇 2018年12月21日15:46:23
	 */
	List<SysUserVo> selectSysUserOfRoleNotHaveByUser(SysUserRoleCo co);
	
	
	/**
	 * 查询公司是否分配用户信息
	 * 
	 * @param String       
	 * @return
	 * 
	 * @author 
	 */
	List<SysUser> selectSysUserByCorpCode(String corpCode);
	
	/**
	 * 按仓库号下的工厂和库存地点查询符合权限的用户
	 * @param condition
	 * @return
	 * 
	 * @author yuely 2019年3月25日
	 */
	List<SysUserVo> selectUserByWhCode(String whCode);  
}