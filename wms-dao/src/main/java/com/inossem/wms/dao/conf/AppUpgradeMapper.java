package com.inossem.wms.dao.conf;

import java.util.List;

import com.inossem.wms.co.conf.AppUpgradeCo;
import com.inossem.wms.co.conf.AppUpgradeFileCo;
import com.inossem.wms.co.conf.AppUpgradeListCo;
import com.inossem.wms.vo.conf.AppUpgradeDescriptionVo;
import com.inossem.wms.vo.conf.AppUpgradeFileVo;
import com.inossem.wms.vo.conf.AppUpgradeVo;

public interface AppUpgradeMapper {

	int insert(AppUpgradeVo vo);

	int updateEffectStatus(AppUpgradeFileCo co);

	List<AppUpgradeVo> selectByCo(AppUpgradeCo co);

	int deleteByPrimaryKey(long id);
	
	int deleteDesciptionByUpgradeId(long id);

	List<AppUpgradeVo> selectOnPaging(AppUpgradeListCo co);

	int insertDescription(List<AppUpgradeDescriptionVo> descList);

	AppUpgradeFileVo selectFileInfoByPrimaryKey(long id);
	
	Integer getMaxVersionCode();

}
