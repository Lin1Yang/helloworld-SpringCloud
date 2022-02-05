package com.inossem.wms.service.impl.common;


import com.alibaba.fastjson.JSON;
import com.inossem.wms.common.util.UtilLocalDateTime;
import com.inossem.wms.constant.Const;
import com.inossem.wms.dao.sys.SysResourcesMapper;
import com.inossem.wms.model.sys.SysResources;
import com.inossem.wms.service.common.IPermissionService;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PermissionServiceImpl implements IPermissionService {
	
	protected static final Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);

	@Resource
	protected SysResourcesMapper resourcesDao;

	enum PERMISSION_TYPE {
		/** 需要授权访问 value=0 */
		AUTH(0), 
		/** 登录就可以访问的资源 value=1 */
		LOGIN(1), 
		/** 可以匿名访问的资源 value=3 */
		ANON(3);
		private int value;
		private PERMISSION_TYPE(int value) {
			this.value = value;
		}
		public Integer getValue() {
			return this.value;
		}
	}
	
	enum RESOURCES_TYPE {
		WEB(0),
		PAD(1);
		private int value;
		private RESOURCES_TYPE(int value) {
			this.value = value;
		}
		public Integer getValue() {
			return this.value;
		}
	}

	@Override
	public Map<String, String> getPermissions() {
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		List<SysResources> permissionList = resourcesDao.selectAllPermission();

		//注意过滤器配置顺序 不能颠倒
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了，登出后跳转配置的loginUrl
        filterChainDefinitionMap.put("/logout", "logout");
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/page/**", "anon");
        filterChainDefinitionMap.put("/META-INF/resources/**", "anon");
        filterChainDefinitionMap.put("/resources/**", "anon");
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/html/**", "anon");
        filterChainDefinitionMap.put("/swagger*/**", "anon");
        
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/v2/**", "anon");
        filterChainDefinitionMap.put("/scc/**", "anon");
        filterChainDefinitionMap.put("/pre/get_all_corp", "anon");
        // 修改密码权限
        filterChainDefinitionMap.put("/sys_user/update_sys_users_password", "anon");
        
        // 文件下载和图片暂时不做拦截处理
        filterChainDefinitionMap.put("/file/download/**", "anon");
        filterChainDefinitionMap.put("/images/img/**", "anon");
        filterChainDefinitionMap.put("/favicon.ico", "anon");
        // 文档接口
        filterChainDefinitionMap.put("/doc.html", "anon");
        
        Map<String, String> annoMap = new LinkedHashMap<>();
        Map<String, String> authcMap = new LinkedHashMap<>();
		for (SysResources r : permissionList) {
			if (PERMISSION_TYPE.ANON.getValue().equals(r.getPermissionType())) {
				//可以匿名访问的资源
				String path = r.getResourcesPath();
				String permission = "anon";
				if (!"".equals(path)) {
					annoMap.put(path, permission);
				}
			} else if (PERMISSION_TYPE.LOGIN.getValue().equals(r.getPermissionType())) {
				// 登录就可以访问的资源
				String path = r.getResourcesPath();
				String permission = "authc";
				if (!"".equals(path)) {
					authcMap.put(path, permission);
				}
			}
        }
		filterChainDefinitionMap.putAll(annoMap); // 先合并匿名权限
		filterChainDefinitionMap.putAll(authcMap); // 后合并认证权限，保证匿名拦截始终在认证拦截之前
		filterChainDefinitionMap.put("/current_user/**", "authc");
		
		/* ************* 处理rolesOr角色拦截部分 *************** */
		List<SysResources> rolePermissionList = resourcesDao.selectResourcesByPermissionType(PERMISSION_TYPE.AUTH.getValue());
        Map<String, Set<String>> pathRoleListMap = this.getPathRoleListMap(rolePermissionList);
		Set<String> pathSet = pathRoleListMap.keySet();
		for (String path : pathSet) {
			if (Const.STRING_EMPTY.equals(path)) {
				// 2020-02-26 libin 过滤掉访问路径为空字符串的权限配置，不输出警告信息
				// System.err.println("资源路径存在无效配置，请检查资源表数据");
				// System.err.println("ResourcesPath字段存在空字符串，对应资源将被忽略加载，请检查资源表数据");
				continue;
			}
        	//登录并且拥有某些角色的可以访问资源
			String permission = "authc, rolesOrFilter[" + String.join(",", pathRoleListMap.get(path)) + "]";
    		filterChainDefinitionMap.put(path, permission);
        }

		// 添加默认全路径登录权限访问拦截
		filterChainDefinitionMap.put("/**", "authc");
		
		String json = JSON.toJSONString(filterChainDefinitionMap);
        logger.debug("filterChainDefinitionMap keySet size :" + filterChainDefinitionMap.keySet().size());
		logger.debug("filterChainDefinitionMap keySet is :" + json);
		System.out.println(UtilLocalDateTime.getStringDateTimeForLocalDateTime(UtilLocalDateTime.getNow()) + " 权限过滤器加载完毕，共" + filterChainDefinitionMap.keySet().size() + "项");
		return filterChainDefinitionMap;
	}
	/**
	 * 获取各个路径对应的角色集合 map
	 * 
	 * @param permissionList
	 * @return
	 * @author libin
	 */
	private Map<String, Set<String>> getPathRoleListMap(List<SysResources> permissionList) {
		// 按照资源路径进行分组，每组的元素为对应路径的角色编码列表
		Map<String, Set<String>> pathRoleListMap = permissionList.stream().collect(Collectors.groupingBy(
				SysResources::getResourcesPath, Collectors.mapping(SysResources::getRoleCode, Collectors.toSet())));
		return pathRoleListMap;
	}
	
	/**
     * 在对角色进行增删改操作时，需要调用此方法进行动态刷新
     * @param shiroFilterFactoryBean
     */
    @Override
    public void updatePermission(ShiroFilterFactoryBean myShiroFilterFactoryBean) {
        synchronized (this) {
            AbstractShiroFilter shiroFilter;
            try {
                shiroFilter = (AbstractShiroFilter) myShiroFilterFactoryBean.getObject();
            } catch (Exception e) {
                throw new RuntimeException("get ShiroFilter from shiroFilterFactoryBean error!");
            }

            PathMatchingFilterChainResolver filterChainResolver = null;
            if(shiroFilter!=null){
            	filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
            }
            DefaultFilterChainManager manager = null;
            if(filterChainResolver!=null){
            	manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();
            }
            // 清空老的权限控制
            if(manager!=null){
            	manager.getFilterChains().clear();
            }
            
            myShiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
            myShiroFilterFactoryBean.setFilterChainDefinitionMap(getPermissions());
            //setRedirect(myShiroFilterFactoryBean);

            // 重新构建生成
            Map<String, String> chains = myShiroFilterFactoryBean.getFilterChainDefinitionMap();
            for (Map.Entry<String, String> entry : chains.entrySet()) {
                String url = entry.getKey();
                String chainDefinition = entry.getValue().trim()
                        .replace(" ", "");
                if(manager!=null){                	
                	manager.createChain(url, chainDefinition);
                }
            }
        }
    }

}
