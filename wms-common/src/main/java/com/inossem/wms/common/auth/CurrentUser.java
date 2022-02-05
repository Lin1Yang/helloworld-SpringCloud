package com.inossem.wms.common.auth;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inossem.wms.model.sys.SysUser;
import com.inossem.wms.vo.auth.UserAccountPeriod;

public class CurrentUser extends SysUser implements Serializable {
	
	private static final Logger logger = LoggerFactory.getLogger(CurrentUser.class);

	/**
	 *
	 */
	private static final long serialVersionUID = -4134366907905395316L;

	// 库存地点格式为 工厂编码- 库存地点编码  Sinobec不启用
	//private List<DicStockLocationVo> locationList = new ArrayList<DicStockLocationVo>();
	//private List<DicFactoryTreeVo> locationTree;

	private List<String> roleCode;
	private List<String> resourceCode;
	private UserAccountPeriod userAccountPeriod;

	public CurrentUser() {
	}
	/*
	public List<DicStockLocationVo> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<DicStockLocationVo> locationList) {
		this.locationList = locationList;
	}

	public List<DicFactoryTreeVo> getFactoryTree() {
		//树形结构，调用一次后，不再新建
		if (locationTree == null) {
			HashMap<String, List<DicStockLocationVo>> map = new HashMap<String, List<DicStockLocationVo>>();
			if (locationList != null && locationList.size() > 0) {
				for (DicStockLocationVo dicStockLocationVo : locationList) {
					//每个工厂简历一个库存地点列表
					if (!map.containsKey(dicStockLocationVo.getFtyCode())) {
						map.put(dicStockLocationVo.getFtyCode(), new ArrayList<DicStockLocationVo>());
					}

					List<DicStockLocationVo> list = map.get(dicStockLocationVo.getFtyCode());
					list.add(dicStockLocationVo);
				}
			}
			try {
				locationTree = new ArrayList<DicFactoryTreeVo>();
				for (String ftyCode : map.keySet()) {
					DicFactoryTreeVo vo = new DicFactoryTreeVo();
					List<DicStockLocationVo> list = map.get(ftyCode);
					DicStockLocationVo dicStockLocationVo = list.get(0);

					UtilBean.getBean(dicStockLocationVo, vo);

					vo.setLocationList(list.stream().map((DicStockLocationVo p) -> {
						DicStockLocationTreeVo c = new DicStockLocationTreeVo();
						try {
							UtilBean.getBean(p, c);
						} catch (WMSException e) {
							logger.error(e.getMessage());
						}
						return c;
					}).collect(Collectors.toList()));
					locationTree.add(vo);
				}
				
				Collections.sort(locationTree);
				
			} catch (WMSException e) {
				
				logger.error(e.getMessage());
			}
		}
		return locationTree;
	}

	public List<DicFactoryTreeVo> getLocationTree() {
		return locationTree;
	}

	public void setLocationTree(List<DicFactoryTreeVo> locationTree) {
		this.locationTree = locationTree;
	}

	*/


	public List<String> getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(List<String> roleCode) {
		this.roleCode = roleCode;
	}

	public List<String> getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(List<String> resourceCode) {
		this.resourceCode = resourceCode;
	}

	public UserAccountPeriod getUserAccountPeriod() {
		return userAccountPeriod;
	}

	public void setUserAccountPeriod(UserAccountPeriod userAccountPeriod) {
		this.userAccountPeriod = userAccountPeriod;
	}
}
