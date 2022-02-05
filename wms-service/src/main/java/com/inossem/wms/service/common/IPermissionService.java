package com.inossem.wms.service.common;

import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

public interface IPermissionService {
	
	/**
	 * 获取系统中的权限配置。
	 * @return Key：资源url   value:role_id列表
	 *         
	 */
	public Map<String, String> getPermissions();
	
	/**
     * 在对角色进行增删改操作时，需要调用此方法进行动态刷新
     * @param shiroFilterFactoryBean
     */
	public void updatePermission(ShiroFilterFactoryBean myShiroFilterFactoryBean);
	
}
