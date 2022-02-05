
package com.inossem.wms.service.impl.common;

import com.inossem.wms.common.exception.SystemConfigException;
import com.inossem.wms.common.util.UtilConst;
import com.inossem.wms.common.util.UtilLocalDateTime;
import com.inossem.wms.dao.conf.*;
import com.inossem.wms.enums.EnumConfWhCode;
import com.inossem.wms.enums.EnumEnable;
import com.inossem.wms.model.conf.ConfSys;
import com.inossem.wms.model.conf.ConfWh;
import com.inossem.wms.service.common.IConstService;
import com.inossem.wms.service.common.IDictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
// @ConfigurationProperties(prefix = "const") // 接收application.yml中的const下面的属性
public class ConstServiceImpl implements IConstService {
	
	protected static final Logger logger = LoggerFactory.getLogger(ConstServiceImpl.class);
	
	@Autowired
	protected ConfWhMapper confWhDao;
	
	@Autowired
	protected ConfWhAutoPostMapper confWhAutoPostDao;
	
	@Autowired
	protected ConfWhAutoTaskMapper confWhAutoTaskDao;
	
	@Autowired
	protected ConfSysMapper confSysDao;
	
	@Autowired
	protected ConfReceiptTypeMapper confReceiptTypeDao;

	

	@Value("${scc.ip}")
	private String instockIp;
	@Value("${scc.port}")
	private String portStr;

	@Value("${scc.prefix}")
	private String prefix;

	@Autowired
	protected IDictionaryService dictionaryServiceSubImpl;
	
//	static {
//		java.net.Authenticator.setDefault(new java.net.Authenticator() {
//			@Override
//			protected java.net.PasswordAuthentication getPasswordAuthentication() {
//				return new java.net.PasswordAuthentication("I0017", "1qaz2wsx".toCharArray());
//
//			}
//		});
//	}
	@PostConstruct
	public void init() {
		try {
			UtilConst.getInstance().setSccPortIp("http://"+instockIp+":"+portStr+prefix);
			//系统级配置
			ConfSys confSys = confSysDao.selectLimit1();
			UtilConst.getInstance().setFilePath(confSys.getFilePath());
			UtilConst.getInstance().setImgPath(confSys.getImgPath());
			UtilConst.getInstance().setAppUpgradeFilePath(confSys.getAppUpgradeFilePath());
			UtilConst.getInstance().setCreateInsBatch(confSys.getInspectInsBatch() > 0);
			UtilConst.getInstance().setErpUrl(confSys.getErpUrl());
			UtilConst.getInstance().setOtherInputPost(confSys.getOtherInputPost() > 0);
			UtilConst.getInstance().setOtherOutputPost(confSys.getOtherOutputPost() > 0);
			UtilConst.getInstance().setErpSyncMode(confSys.getErpSyncMode() > 0);
			UtilConst.getInstance().setTimeout(confSys.getTimeout());			
			UtilConst.getInstance().setInterfaceType(confSys.getInterfaceType());
			UtilConst.getInstance().setStrategyShelfUnLoad(confSys.getStrategyShelfUnLoad());
			UtilConst.getInstance().setStrategyShelfLoad(confSys.getStrategyShelfLoad());
			
			//初始化最大公司和最大仓库数量
			ConfSys maxCorp = confSysDao.selectMaxCorp();
			if(maxCorp != null) {
				if(maxCorp.getConfSysExt1().length() == 0) {
					UtilConst.getInstance().setMaxCorp("1");
				}else {
					UtilConst.getInstance().setMaxCorp(maxCorp.getConfSysExt1());
				}
			}else {
				UtilConst.getInstance().setMaxCorp("1");
			}
			ConfSys maxwh = confSysDao.selectMaxWh();
			if(maxwh != null) {
				if(maxwh.getConfSysExt1().length() == 0) {
					UtilConst.getInstance().setMaxWh("1");
				}else {
					UtilConst.getInstance().setMaxWh(maxwh.getConfSysExt1());
				}
			}else {
				UtilConst.getInstance().setMaxWh("1");	
			}
			
			//临时存储类型 ，临时仓位配置
			ConfWh confWh = confWhDao.selectByPrimaryKey(EnumConfWhCode.ENUM_CONF_WH_CODE_INPUT.getCode());
			UtilConst.getInstance().setInputDefaultType(confWh.getDefaultTypeCode());
			UtilConst.getInstance().setInputDefaultBin(confWh.getDefaultBinCode());
			setOutputEnabledType(confWh);
			
			
			
			confWh = confWhDao.selectByPrimaryKey(EnumConfWhCode.ENUM_CONF_WH_CODE_PICKING.getCode());
			UtilConst.getInstance().setPickingDefaultType(confWh.getDefaultTypeCode());
			UtilConst.getInstance().setPickingDefaultBin(confWh.getDefaultBinCode());
			setOutputEnabledType(confWh);


			if(UtilConst.getInstance().getStrategyShelfLoad()==1) {
				confWh = confWhDao.selectByPrimaryKey(EnumConfWhCode.ENUM_CONF_WH_CODE.getCode());
				UtilConst.getInstance().setDefaultWhCode(confWh.getDefaultTypeCode());
			}

			UtilConst.getInstance().setTemporaryAreaType(Arrays.asList(UtilConst.getInstance().getInputDefaultType(),UtilConst.getInstance().getPickingDefaultType()));
			

			
			
			
			
			
			
			
			//经办单据 审批单据配置
			/* Sinobec不起用经办与审批
			List<ConfReceiptType> actorList = confReceiptTypeDao.selectByCode(Const.CONF_ACTOR_RECEIPT_TYPE);
			List<Integer> actorReceiptTypeList = actorList.stream().map(p -> p.getReceiptType()).collect(Collectors.toList());
			UtilConst.getInstance().setActorReceiptTypeList(actorReceiptTypeList);
			List<ConfReceiptType> wfList = confReceiptTypeDao.selectByCode(Const.CONF_WF_RECEIPT_TYPE);
			// 添加审批 yuely start
			List<Integer> wfReceiptTypeList = wfList.stream().map(p -> p.getReceiptType()).collect(Collectors.toList());
			UtilConst.getInstance().setWfReceiptTypeList(wfReceiptTypeList);
			// 添加审批 yuely end
			for (ConfReceiptType confReceiptType : wfList) {
				UtilConst.getInstance().setWfReceiptType(confReceiptType.getReceiptType(), confReceiptType.getProcId());
			}
			*/
			
			
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new SystemConfigException();
		}
		try {
			//redis缓存
			System.out.println(UtilLocalDateTime.getStringDateTimeForLocalDateTime(UtilLocalDateTime.getNow()) + " 加载缓存信息..");

			dictionaryServiceSubImpl.initMatI18nNameCache();
			dictionaryServiceSubImpl.initCorpCache();
			dictionaryServiceSubImpl.initLanguageCache();
			dictionaryServiceSubImpl.initUnitCache();
			dictionaryServiceSubImpl.initRelUnitCache();
			dictionaryServiceSubImpl.initWhCache();
			dictionaryServiceSubImpl.initStorageTypeCache();
			dictionaryServiceSubImpl.initBinCache();

			/* Sinobec不启用
			dictionaryServiceSubImpl.initDicMaterialFactoryCache();
			dictionaryServiceSubImpl.initFtyCache();
			dictionaryServiceSubImpl.initLocationCache();
			dictionaryServiceSubImpl.initStorageSectionCache();
			*/
			
			System.out.println(UtilLocalDateTime.getStringDateTimeForLocalDateTime(UtilLocalDateTime.getNow()) + " 缓存信息加载完成");
		} catch (Exception e) {
			System.err.println(UtilLocalDateTime.getStringDateTimeForLocalDateTime(UtilLocalDateTime.getNow()) + " 系统默认配置加载失败");
			e.printStackTrace();
			throw new SystemConfigException();
		}
		System.out.println(UtilLocalDateTime.getStringDateTimeForLocalDateTime(UtilLocalDateTime.getNow()) + " 系统默认配置加载完成");
	}
	
	private void setOutputEnabledType(ConfWh confWh) {
		if (confWh != null && EnumEnable.ENABLE.getValue().equals(confWh.getOutputEnabled())) {
			UtilConst.getInstance().setOutputEnabledTypeSet(confWh.getDefaultTypeCode());
		}
	}
}
