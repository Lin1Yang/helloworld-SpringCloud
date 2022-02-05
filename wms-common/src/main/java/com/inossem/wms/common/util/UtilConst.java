package com.inossem.wms.common.util;

import com.inossem.wms.constant.Const;
import com.inossem.wms.enums.EnumEnable;
import com.inossem.wms.enums.EnumReceiptType;
import com.inossem.wms.model.conf.ConfWhAutoPost;
import com.inossem.wms.model.conf.ConfWhAutoPostKey;
import com.inossem.wms.model.conf.ConfWhAutoTask;
import com.inossem.wms.model.conf.ConfWhAutoTaskKey;

import java.util.*;

public class UtilConst {

	private static volatile UtilConst instance;

	private UtilConst() {
	}

	public static UtilConst getInstance() {
		if (instance == null) {
			synchronized (UtilConst.class) {
				if (instance == null) {
					instance = new UtilConst();
				}
			}
		}

		return instance;
	}

	private String unrealDefaultType;
	private String inputDefaultType;
	private String setupCellDefaultType;
	private String pickingDefaultType;
	private String outputDefaultType;
	private String maxWh;
	private String maxCorp;
	/**
	 * 临时库存集合
	 */
	private List<String> temporaryAreaType;
	private String transportDefaultType;
	private String inputReturnDefaultType;
	private String stocktakeDefaultType;
	private String writeOffDefaultType;
	private String outputReturnDefaultType;
	private String wcsLoadDefaultType;
	private String wcsUnLoadDefaultType;
	private String unrealDefaultBin;
	private String inputDefaultBin;
	private String setupCellDefaultBin;
	private String pickingDefaultBin;
	private String outputDefaultBin;
	private String transportDefaultBin;
	private String inputReturnDefaultBin;
	private String stocktakeDefaultBin;
	private String writeOffDefaultBin;
	private String outputReturnDefaultBin;
	private String wcsLoadDefaultBin;
	private String wcsUnLoadDefaultBin;
	private String filePath;
	private String imgPath;
	private String appUpgradeFilePath;
	private String erpUrl;
	private boolean otherInputPost;
	private boolean otherOutputPost;
	/** sap同步模式，false不同步sap，true同步sap */
	private boolean erpSyncMode;
	private int timeout;
	private Byte interfaceType;
	
	private String defaultWhCode;
	/**
	 * 自动上架策略是否开启
	 */
	private Byte strategyShelfLoad;
	/**
	 * 自动下架策略是否开启
	 */
	private Byte strategyShelfUnLoad;

	private String sccPortIp;

	private Set<String> nonnegativeTypeSet;
	private Set<String> nonnegativeBinSet;

	private Set<String> outputEnabledTypeSet;

	private Set<String> typeSet;
	private Set<String> binSet;

	private Map<ConfWhAutoPostKey, ConfWhAutoPost> autoPostMap;
	
	private Map<ConfWhAutoTaskKey, ConfWhAutoTask> autoTaskMap;

	private boolean createInsBatch = false;

	private List<Integer> actorReceiptTypeList;
	private Set<Integer> actorReceiptTypeSet;
	private List<Integer> wfReceiptTypeList;
	private Map<Integer, String> wfReceiptTypeMap;

	public String getSccPortIp() {
		return sccPortIp;
	}

	public void setSccPortIp(String sccPortIp) {
		this.sccPortIp = sccPortIp;
	}

	public static void setInstance(UtilConst instance) {
		UtilConst.instance = instance;
	}

	public void setUnrealDefaultType(String unrealDefaultType) {
		this.unrealDefaultType = unrealDefaultType;
	}

	public void setInputDefaultType(String inputDefaultType) {
		this.inputDefaultType = inputDefaultType;
	}

	public void setSetupCellDefaultType(String setupCellDefaultType) {
		this.setupCellDefaultType = setupCellDefaultType;
	}

	public void setPickingDefaultType(String pickingDefaultType) {
		this.pickingDefaultType = pickingDefaultType;
	}

	public void setOutputDefaultType(String outputDefaultType) {
		this.outputDefaultType = outputDefaultType;
	}

	public List<String> getTemporaryAreaType() {
		return temporaryAreaType;
	}

	public void setTemporaryAreaType(List<String> temporaryAreaType) {
		this.temporaryAreaType = temporaryAreaType;
	}

	public void setTransportDefaultType(String transportDefaultType) {
		this.transportDefaultType = transportDefaultType;
	}

	public void setInputReturnDefaultType(String inputReturnDefaultType) {
		this.inputReturnDefaultType = inputReturnDefaultType;
	}

	public void setOutputReturnDefaultType(String outputReturnDefaultType) {
		this.outputReturnDefaultType = outputReturnDefaultType;
	}

	public String getWcsLoadDefaultType() {
		return wcsLoadDefaultType;
	}

	public void setWcsLoadDefaultType(String wcsLoadDefaultType) {
		this.wcsLoadDefaultType = wcsLoadDefaultType;
	}

	public String getWcsUnLoadDefaultType() {
		return wcsUnLoadDefaultType;
	}

	public void setWcsUnLoadDefaultType(String wcsUnLoadDefaultType) {
		this.wcsUnLoadDefaultType = wcsUnLoadDefaultType;
	}

	public void setStocktakeDefaultType(String stocktakeDefaultType) {
		this.stocktakeDefaultType = stocktakeDefaultType;
	}

	public void setWriteOffDefaultType(String writeOffDefaultType) {
		this.writeOffDefaultType = writeOffDefaultType;
	}

	public void setUnrealDefaultBin(String unrealDefaultBin) {
		this.unrealDefaultBin = unrealDefaultBin;
	}

	public void setInputDefaultBin(String inputDefaultBin) {
		this.inputDefaultBin = inputDefaultBin;
	}

	public void setSetupCellDefaultBin(String setupCellDefaultBin) {
		this.setupCellDefaultBin = setupCellDefaultBin;
	}

	public void setPickingDefaultBin(String pickingDefaultBin) {
		this.pickingDefaultBin = pickingDefaultBin;
	}

	public void setOutputDefaultBin(String outputDefaultBin) {
		this.outputDefaultBin = outputDefaultBin;
	}

	public void setTransportDefaultBin(String transportDefaultBin) {
		this.transportDefaultBin = transportDefaultBin;
	}

	public void setInputReturnDefaultBin(String inputReturnDefaultBin) {
		this.inputReturnDefaultBin = inputReturnDefaultBin;
	}

	public void setOutputReturnDefaultBin(String outputReturnDefaultBin) {
		this.outputReturnDefaultBin = outputReturnDefaultBin;
	}

	public void setStocktakeDefaultBin(String stocktakeDefaultBin) {
		this.stocktakeDefaultBin = stocktakeDefaultBin;
	}

	public void setWriteOffDefaultBin(String writeOffDefaultBin) {
		this.writeOffDefaultBin = writeOffDefaultBin;
	}

	public String getWcsLoadDefaultBin() {
		return wcsLoadDefaultBin;
	}

	public void setWcsLoadDefaultBin(String wcsLoadDefaultBin) {
		this.wcsLoadDefaultBin = wcsLoadDefaultBin;
	}

	public String getWcsUnLoadDefaultBin() {
		return wcsUnLoadDefaultBin;
	}

	public void setWcsUnLoadDefaultBin(String wcsUnLoadDefaultBin) {
		this.wcsUnLoadDefaultBin = wcsUnLoadDefaultBin;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setCreateInsBatch(boolean createInsBatch) {
		this.createInsBatch = createInsBatch;
	}

	public String getUnrealDefaultType() {
		return unrealDefaultType;
	}

	public String getInputDefaultType() {
		return inputDefaultType;
	}

	public String getSetupCellDefaultType() {
		return setupCellDefaultType;
	}

	public String getPickingDefaultType() {
		return pickingDefaultType;
	}

	public String getOutputDefaultType() {
		return outputDefaultType;
	}

	public String getTransportDefaultType() {
		return transportDefaultType;
	}

	public String getInputReturnDefaultType() {
		return inputReturnDefaultType;
	}

	public String getOutputReturnDefaultType() {
		return outputReturnDefaultType;
	}

	public String getStocktakeDefaultType() {
		return stocktakeDefaultType;
	}

	public String getWriteOffDefaultType() {
		return writeOffDefaultType;
	}

	public String getUnrealDefaultBin() {
		return unrealDefaultBin;
	}

	public String getInputDefaultBin() {
		return inputDefaultBin;
	}

	public String getSetupCellDefaultBin() {
		return setupCellDefaultBin;
	}

	public String getPickingDefaultBin() {
		return pickingDefaultBin;
	}

	public String getOutputDefaultBin() {
		return outputDefaultBin;
	}

	public String getTransportDefaultBin() {
		return transportDefaultBin;
	}

	public String getInputReturnDefaultBin() {
		return inputReturnDefaultBin;
	}

	public String getOutputReturnDefaultBin() {
		return outputReturnDefaultBin;
	}

	public String getStocktakeDefaultBin() {
		return stocktakeDefaultBin;
	}

	public String getWriteOffDefaultBin() {
		return writeOffDefaultBin;
	}

	public String getErpUrl() {
		return erpUrl;
	}

	public boolean isOtherInputPost() {
		return otherInputPost;
	}

	public void setOtherInputPost(boolean otherInputPost) {
		this.otherInputPost = otherInputPost;
	}

	public boolean isOtherOutputPost() {
		return otherOutputPost;
	}

	public void setOtherOutputPost(boolean otherOutputPost) {
		this.otherOutputPost = otherOutputPost;
	}

	public boolean isErpSyncMode() {
		return erpSyncMode;
	}

	public void setErpSyncMode(boolean erpSyncMode) {
		this.erpSyncMode = erpSyncMode;
	}		

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}	

	public Byte getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(Byte interfaceType) {
		this.interfaceType = interfaceType;
	}

	public void setErpUrl(String erpUrl) {
		this.erpUrl = erpUrl;
	}

	public Set<String> getNonnegativeTypeSet() {
		if (this.nonnegativeTypeSet == null) {
			HashSet<String> nonnegativeTypeSet = new HashSet<String>();
			nonnegativeTypeSet.add(this.unrealDefaultType);
			this.nonnegativeTypeSet = nonnegativeTypeSet;
		}
		return this.nonnegativeTypeSet;
	}

	public Set<String> getNonnegativeBinSet() {
		if (this.nonnegativeBinSet == null) {
			HashSet<String> nonnegativeBinSet = new HashSet<String>();
			nonnegativeBinSet.add(this.unrealDefaultBin);
			this.nonnegativeBinSet = nonnegativeBinSet;
		}
		return nonnegativeBinSet;
	}

	public Set<String> getTypeSet() {
		if (this.typeSet == null) {
			HashSet<String> typeSet = new HashSet<String>();
			typeSet.add(this.unrealDefaultType);
			typeSet.add(this.inputDefaultType);
			typeSet.add(this.setupCellDefaultType);
			typeSet.add(this.pickingDefaultType);
			typeSet.add(this.outputDefaultType);
			typeSet.add(this.transportDefaultType);
			typeSet.add(this.inputReturnDefaultType);
			typeSet.add(this.stocktakeDefaultType);
			typeSet.add(this.writeOffDefaultType);
			typeSet.add(this.outputReturnDefaultType);
			this.typeSet = typeSet;
		}
		return typeSet;
	}

	public Set<String> getBinSet() {
		if (this.binSet == null) {
			HashSet<String> binSet = new HashSet<String>();
			binSet.add(this.unrealDefaultBin);
			binSet.add(this.inputDefaultBin);
			binSet.add(this.setupCellDefaultBin);
			binSet.add(this.pickingDefaultBin);
			binSet.add(this.outputDefaultBin);
			binSet.add(this.transportDefaultBin);
			binSet.add(this.inputReturnDefaultBin);
			binSet.add(this.stocktakeDefaultBin);
			binSet.add(this.writeOffDefaultBin);
			binSet.add(this.outputReturnDefaultBin);
			this.binSet = binSet;
		}
		return binSet;
	}

	public Set<String> getOutputEnabledTypeSet() {
		return outputEnabledTypeSet;
	}

	public void setOutputEnabledTypeSet(String type) {
		if (this.outputEnabledTypeSet == null) {
			this.outputEnabledTypeSet = new HashSet<String>();
		}

		this.outputEnabledTypeSet.add(type);
	}

	public boolean isCreateInsBatch() {
		return createInsBatch;
	}

	public String getFilePath() {
		return filePath;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getAppUpgradeFilePath() {
		return appUpgradeFilePath;
	}

	public void setAppUpgradeFilePath(String appUpgradeFilePath) {
		this.appUpgradeFilePath = appUpgradeFilePath;
	}

	/**
	 * 返回值为真 自动过账，假 不自动过账
	 * 
	 * @param whCode
	 * @param receiptType
	 * @return
	 */
	public boolean getAutoPost(String whCode, Integer receiptType) {
		ConfWhAutoPostKey confWhAutoPostKey = new ConfWhAutoPostKey(whCode, receiptType);
		return this.getAutoPost(confWhAutoPostKey);
	}

	/**
	 * 返回值为真 自动过账，假 不自动过账
	 * 
	 * @param confWhAutoPostKey
	 * @return
	 */
	public boolean getAutoPost(ConfWhAutoPostKey confWhAutoPostKey) {
		boolean autoPost = true;
		if (autoPostMap != null && autoPostMap.containsKey(confWhAutoPostKey)) {
			ConfWhAutoPost confWhAutoPost = autoPostMap.get(confWhAutoPostKey);
			if (confWhAutoPost != null) {
				if (EnumEnable.UNABLE.getValue().equals(confWhAutoPost.getAutoPost())) {
					autoPost = false;
				}
			}
		}
		return autoPost;
	}

	public void setAutoPost(ConfWhAutoPostKey confWhAutoPostKey, ConfWhAutoPost confWhAutoPost) {
		if (autoPostMap == null) {
			autoPostMap = new HashMap<ConfWhAutoPostKey, ConfWhAutoPost>();
		}
		autoPostMap.put(confWhAutoPostKey, confWhAutoPost);
	}
	
	/**
	 * 返回自动作业配置
	 * 
	 * @param confWhAutoTaskKey
	 * @return
	 */
	public ConfWhAutoTask getAutoTask(ConfWhAutoTaskKey confWhAutoTaskKey) {
		ConfWhAutoTask confWhAutoTask = null;
		if (autoTaskMap != null && autoTaskMap.containsKey(confWhAutoTaskKey)) {
			confWhAutoTask = autoTaskMap.get(confWhAutoTaskKey);
		}
		return confWhAutoTask;
	}
	
	public void setAutoTask(ConfWhAutoTaskKey confWhAutoTaskKey, ConfWhAutoTask confWhAutoTask) {
		if (autoTaskMap == null) {
			autoTaskMap = new HashMap<ConfWhAutoTaskKey, ConfWhAutoTask>();
		}
		autoTaskMap.put(confWhAutoTaskKey, confWhAutoTask);
	}

	public List<Integer> getActorReceiptTypeList() {
		return actorReceiptTypeList;
	}

	public void setActorReceiptTypeList(List<Integer> actorReceiptTypeList) {
		this.actorReceiptTypeList = actorReceiptTypeList;
	}
	
	public List<Integer> getWfReceiptTypeList() {
		return wfReceiptTypeList;
	}

	public void setWfReceiptTypeList(List<Integer> wfReceiptTypeList) {
		this.wfReceiptTypeList = wfReceiptTypeList;
	}

	public boolean getActorByReceiptType(EnumReceiptType receiptType) {
		if (actorReceiptTypeSet == null) {
			actorReceiptTypeSet = new HashSet<Integer>();
			for (Integer type : actorReceiptTypeList) {
				actorReceiptTypeSet.add(type);
			}
		}

		return actorReceiptTypeSet.contains(receiptType.getValue());
	}

	public boolean getActorByReceiptType(Integer receiptType) {
		if (actorReceiptTypeSet == null) {
			actorReceiptTypeSet = new HashSet<Integer>();
			for (Integer type : actorReceiptTypeList) {
				actorReceiptTypeSet.add(type);
			}
		}

		return actorReceiptTypeSet.contains(receiptType);
	}

	public void setWfReceiptType(Integer receiptType, String procId) {
		if (wfReceiptTypeMap == null) {
			wfReceiptTypeMap = new HashMap<Integer, String>();
		}

		if (wfReceiptTypeMap.containsKey(receiptType)) {
			if (UtilString.isNullOrEmpty(wfReceiptTypeMap.get(receiptType))) {
				wfReceiptTypeMap.put(receiptType, procId);
			}
		} else {
			wfReceiptTypeMap.put(receiptType, procId);
		}
	}

	public String getWfProcIdByReceiptType(EnumReceiptType receiptType) {

		if (wfReceiptTypeMap.containsKey(receiptType.getValue())) {
			return wfReceiptTypeMap.get(receiptType.getValue());
		}

		return Const.STRING_EMPTY;
	}

	public String getWfProcIdByReceiptType(Integer receiptType) {

		if (wfReceiptTypeMap.containsKey(receiptType)) {
			return wfReceiptTypeMap.get(receiptType);
		}

		return Const.STRING_EMPTY;
	}

	public boolean getWfByReceiptType(EnumReceiptType receiptType) {
		return !UtilString.isNullOrEmpty(getWfProcIdByReceiptType(receiptType));
	}

	public boolean getWfByReceiptType(Integer receiptType) {
		return !UtilString.isNullOrEmpty(getWfProcIdByReceiptType(receiptType));
	}

	public Byte getStrategyShelfLoad() {
		return strategyShelfLoad;
	}

	public void setStrategyShelfLoad(Byte strategyShelfLoad) {
		this.strategyShelfLoad = strategyShelfLoad;
	}

	public Byte getStrategyShelfUnLoad() {
		return strategyShelfUnLoad;
	}

	public void setStrategyShelfUnLoad(Byte strategyShelfUnLoad) {
		this.strategyShelfUnLoad = strategyShelfUnLoad;
	}

	public String getDefaultWhCode() {
		return defaultWhCode;
	}

	public void setDefaultWhCode(String defaultWhCode) {
		this.defaultWhCode = defaultWhCode;
	}

	public String getMaxWh() {
		return maxWh;
	}

	public void setMaxWh(String maxWh) {
		this.maxWh = maxWh;
	}

	public String getMaxCorp() {
		return maxCorp;
	}

	public void setMaxCorp(String maxCorp) {
		this.maxCorp = maxCorp;
	}
	
}
