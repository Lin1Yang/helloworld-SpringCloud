package com.inossem.wms.service.stocktake;

import java.util.List;

import com.inossem.wms.co.biz.BizStockTakeCo;
import com.inossem.wms.co.dic.DicWhStorageBinListCo;
import com.inossem.wms.co.sys.SysUserInfoCo;
import com.inossem.wms.common.auth.CurrentUser;
import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.vo.sys.SysUserVo;
import com.inossem.wms.vo.take.BizStockTakeDataVo;
import com.inossem.wms.vo.take.BizStockTakeHeadVo;
import com.inossem.wms.vo.take.BizStockTakeItemVo;
import com.inossem.wms.vo.take.BizStockTakeMatDataVo;
import com.inossem.wms.vo.take.BizStockTakeMatItemVo;

public interface IBizStockTakeService {

	/**
	 * 查询盘点列表
	 * 
	 * @return
	 * @throws WMSException
	 */
	List<BizStockTakeHeadVo> getStockTakeList(CurrentUser cUser, BizStockTakeCo bCo, String langCode);
	
	/**
	 * 查询盘点 内容
	 * 
	 * @return
	 * @throws WMSException
	 */
	List<BizStockTakeItemVo> getStockTakeInfo(String stockTakeCode);
	
	/**
	 * 查询存储类型列表
	 * 
	 * @return
	 * @throws WMSException
	 * @author yuely
	 */
	List<BizStockTakeItemVo> getStorageBinList(DicWhStorageBinListCo dicWhStorageBinListCo);
	
	/**
	 * 保存仓位信息
	 * 
	 * @return
	 * @throws WMSException
	 * @author yuely
	 */
	String saveOrUpdateStockTakeData(BizStockTakeDataVo bizStockTakeDataVo, CurrentUser user);
	
	
	/**
	 * 删除盘点单
	 * 
	 * @return
	 * @throws WMSException
	 */
	void delete(String stockTakeCode, CurrentUser user) throws WMSException;
	

	/**
	 * 查询盘点内容
	 * 
	 * @return
	 * @throws WMSException
	 */
	List<BizStockTakeMatItemVo> getStockTakeMatInfo(String stockTakeCode,String count,CurrentUser user);
	
	/**
	 * 保存仓位信息
	 * 
	 * @return
	 * @throws WMSException
	 * @author yuely
	 */
	void saveOrUpdateStockTakeMatData(BizStockTakeMatDataVo bizStockTakeMatDataVo, CurrentUser user);
	
	/**
	 * 保存物料信息
	 * 
	 * @return
	 * @throws WMSException
	 * @author yuely
	 */
	void initInsertStockTakeMat(BizStockTakeDataVo bizStockTakeDataVo, int userId,String stockTaskCode);
	

	/**
	 * 校验是否所有的行项目都是计数状态
	 * 
	 * @return
	 * @throws WMSException
	 * @author yuely
	 */
	boolean checkAllDataStatus(String stockTakeCode);
	
	/**
	 * 全部重新盘点
	 * 
	 * @return
	 * @throws WMSException
	 * @author yuely
	 */
	void reInventory(String stockTakeCode, CurrentUser user);
	
	/**
	 * 查看差异列表
	 * 
	 * @return
	 * @throws WMSException
	 * @author yuely
	 */
	List<BizStockTakeMatItemVo> getDifferenceList(BizStockTakeMatDataVo bizStockTakeMatDataVo,String langCode);
	

	/**
	 * 差异重新盘点
	 * 
	 * @return
	 * @throws WMSException
	 * @author yuely
	 */
	void differenceReInventory(BizStockTakeMatDataVo bizStockTakeMatDataVo, CurrentUser user);
	
	/**
	 * 仓位差异处理
	 * 
	 * @return
	 * @throws WMSException
	 * @author yuely
	 */
	BizStockTakeMatDataVo binDifferenceHandle(BizStockTakeMatDataVo bizStockTakeMatDataVo, CurrentUser user) throws Exception;


	/**
	 * 查询盘点人列表
	 * 
	 * @return
	 * @throws WMSException
	 * @author yuely
	 */
	List<SysUserVo> selectUserByWhCode(SysUserInfoCo infoCo);
	

	/**
	 * 判断是否冻结仓位
	 * 
	 * @return
	 * @throws WMSException
	 * @author yuely
	 */
	void freezeBin(BizStockTakeDataVo bizStockTakeDataVo, int userId);
	
	/**
	 * 校验仓位是否冻结
	 * 
	 * @return
	 * @throws WMSException
	 * @author yuely
	 */
	boolean checkBinFreeze(BizStockTakeDataVo bizStockTakeDataVo);
	
	/**
	 * 校验盘点人是否为空
	 * 
	 * @return
	 * @throws WMSException
	 * @author yuely
	 */
	boolean checkStockTakeUser(BizStockTakeDataVo bizStockTakeDataVo);

	
	/**
	 * 修改盘点状态
	 * 
	 * @return
	 * @throws WMSException
	 * @author yuely
	 */
	void updateStockTakeStatus(String stockTakeCode);


	/**
	 * 更新主表状态为待计数
	 * 
	 * @return
	 * @throws WMSException
	 * @author yuely
	 */
	void updateStockTakeData(String stockTakeCode, CurrentUser user, byte status);

	
	List<BizStockTakeMatItemVo> getStockTakeMatListByStockTakeCode(String stockTakeCode);

	List<BizStockTakeMatItemVo> getStockTakeMatInfoForReport( 
			String stockTakeCode, 
			String sapDocNumber, 
			String typeCode, 
			String binCode, 
			String matCode,
			String sData,
			String eData,
			String count, 
			CurrentUser user);
	List<BizStockTakeMatItemVo> getStockTakeMatInfoFromWMSCountForReport( 
			String stockTakeCode, 
			String sapDocNumber, 
			String typeCode, 
			String binCode, 
			String matCode,
			String sData,
			String eData,
			String count, 
			CurrentUser user);
	
}
