package com.inossem.wms.service.sinobec.impl.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.inossem.wms.common.util.UtilConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.common.exception.sinobec.SinobecStockQtyNotEnoughException;
import com.inossem.wms.constant.Const;
import com.inossem.wms.dao.dic.DicWhStorageBinMapper;
import com.inossem.wms.dao.sinobec.SinobecInsDocBinMapper;
import com.inossem.wms.dao.sinobec.SinobecStockMapper;
import com.inossem.wms.enums.EnumDebitCredit;
import com.inossem.wms.enums.EnumReturnCode;
import com.inossem.wms.model.dic.DicWhStorageBin;
import com.inossem.wms.model.dic.DicWhStorageBinKey;
import com.inossem.wms.model.sinobec.SinobecInsDocBin;
import com.inossem.wms.model.sinobec.SinobecStock;
import com.inossem.wms.model.sinobec.stock.SinobecStockVo;
import com.inossem.wms.model.sinobec.task.SinobecTaskVo;
import com.inossem.wms.service.common.ICommonService;
import com.inossem.wms.service.sinobec.common.ISinobecStockCommonService;
import com.inossem.wms.vo.dic.DicWhStorageBinVo;
import com.inossem.wms.vo.sinobec.SinobecInsMoveTypeVo;

@Service
public class SinobecStockCommonServiceImpl implements ISinobecStockCommonService {

	@Autowired
	private SinobecInsDocBinMapper insDocBinDao;

	@Autowired
	private DicWhStorageBinMapper dicBinDao;

	@Autowired
	private ICommonService commonServiceImpl;
	
	@Autowired
	protected SinobecStockMapper sinobecStockDao;// 库存方法
	
	@Transactional
	public void sortStock(String whCode, String typeCode, String binCode, String bundleCode) throws WMSException {
		BigDecimal wQty = new BigDecimal(0);
		List<SinobecStockVo> stockList = sinobecStockDao.selectStockByKey(whCode, typeCode, binCode, bundleCode);
		if (!CollectionUtils.isEmpty(stockList)) {
			for (SinobecStockVo stock : stockList) {
				wQty = wQty.add(stock.getWeightQty());
				if(stockList.size() - 1 != stockList.indexOf(stock)){
					sinobecStockDao.deleteStockByKey(stock.getStockId());
				}else {
					sinobecStockDao.updateStockByKey(wQty, stock.getStockId());
				}
			}
		}
	}

	@Override
	@Transactional
	public void modifyStock(SinobecInsMoveTypeVo insMoveType) throws WMSException {

		List<SinobecInsDocBin> insDocBinList = this.checkMoveType(insMoveType);

		if (insDocBinList.size() > 0) {
			insDocBinDao.insertOrUpdateList(insDocBinList);

			// insDocBinDao.modifyStock(insDocBinList.get(0).getInsDocCode());
			List<SinobecInsDocBin> HList = new ArrayList<SinobecInsDocBin>();
			List<SinobecInsDocBin> SList = new ArrayList<SinobecInsDocBin>();
			HList = insDocBinList.stream()
					.filter(e -> e.getDebitCredit().equals(EnumDebitCredit.CREDIT_H_SUBTRACT.getValue()))
					.collect(Collectors.toList());
			SList = insDocBinList.stream()
					.filter(e -> e.getDebitCredit().equals(EnumDebitCredit.DEBIT_S_ADD.getValue()))
					.collect(Collectors.toList());
			if (!CollectionUtils.isEmpty(HList)) {
				insDocBinDao.modifyStockByList(HList);
			}
			if (!CollectionUtils.isEmpty(SList)) {
				SList.forEach(e -> e.setStockId(null));
				insDocBinDao.addStockByBatch(SList);
			}

			insDocBinDao.deleteStock(insDocBinList.get(0).getInsDocCode());
//			非负校验暂时取消一段时间，等pad调整好在打开。
//			List<SinobecStock> negativeStockList = insDocBinDao
//					.selectNegativeStockAfterModifyStock(insDocBinList.get(0).getInsDocCode());
//			for (SinobecStock stockBin : negativeStockList) {
//				// 校验非负
//				if (stockBin.getWeightQty().compareTo(BigDecimal.ZERO) < 0) {
//					throw new SinobecStockQtyNotEnoughException(stockBin);
//				}
//
//			}
			if(UtilConst.getInstance().getStrategyShelfLoad()==1) {
				/** 修改仓位当前载重 */
				insDocBinDao.modifyBinWeightQty(insDocBinList.get(0).getInsDocCode());
			}
			// 记录超重记录
			if(!CollectionUtils.isEmpty(SList)){
				List<SinobecTaskVo> taskList = new ArrayList<SinobecTaskVo>();
				for(SinobecInsDocBin doc : SList){
					SinobecTaskVo task = new  SinobecTaskVo();
					task.setWhCode(doc.getWhCode());
					task.setTargetTypeCode(doc.getTypeCode());
					task.setTargetBinCode(doc.getBinCode());
					task.setBinWeightQty(doc.getBinWeightQty());
					taskList.add(task);
				}
				
				List<DicWhStorageBinVo> overList  = dicBinDao.checkBinWeight(taskList);
				if(!CollectionUtils.isEmpty(overList)){
					// 根据仓位修改凭证超重记录
					insDocBinDao.modifyOverWeightLog(insDocBinList.get(0).getInsDocCode(), overList, "overload");
				}
				
			}
			
			
			
		}

	}

	/**
	 * 校验存储类型 并设置仓位重量
	 * 
	 * @param insMoveType
	 * @return
	 * @throws WMSException
	 */
	private List<SinobecInsDocBin> checkMoveType(SinobecInsMoveTypeVo insMoveType) throws WMSException {
		List<SinobecInsDocBin> insDocBinList = new ArrayList<SinobecInsDocBin>();

		for (SinobecInsDocBin insDocBin : insMoveType.getInsDocBinList()) {
			if (insDocBin.getWeightQty() == null) {
				throw new WMSException(EnumReturnCode.RETURN_CODE_SINOBEC_STOCK_PARAMTER_REQUIRE_WEIGHT_QTY,
						insDocBin.getBundleCode());
			}
			if (insDocBin.getReceiptQty() == null) {
				throw new WMSException(EnumReturnCode.RETURN_CODE_SINOBEC_STOCK_PARAMTER_REQUIRE_RECEIPT_QTY,
						insDocBin.getBundleCode());
			}
			if (insDocBin.getStockId() == null) {
				insDocBin.setStockId(0);
			}

			if (EnumDebitCredit.CREDIT_H_SUBTRACT.getValue().equals(insDocBin.getDebitCredit())
					&& insDocBin.getStockId() == 0) {
				throw new WMSException(EnumReturnCode.RETURN_CODE_SINOBEC_STOCK_PARAMTER_REQUIRE_STOCK_ID,
						insDocBin.getBundleCode());
			}
			insDocBinList.add(insDocBin);
		}
		if(UtilConst.getInstance().getStrategyShelfLoad()==1) {
			// 仓位对应的重量单位
			Map<DicWhStorageBinKey, String> binUnitMap = new HashMap<DicWhStorageBinKey, String>();
			// 查询 仓位对应的重量单位
			List<DicWhStorageBin> binList = dicBinDao.selectBinByInsDocBin(insDocBinList);
			if (CollectionUtils.isEmpty(binList)) {
				throw new WMSException(EnumReturnCode.RETURN_CODE_SINOBEC_INS_REQUIRE_BIN);
			}
			for (DicWhStorageBin bin : binList) {
				binUnitMap.put(bin, bin.getWeightUnitCode());
			}
			for (SinobecInsDocBin insDocBin : insMoveType.getInsDocBinList()) {
				String binUnitCode = binUnitMap.get(
						new DicWhStorageBinKey(insDocBin.getWhCode(), insDocBin.getTypeCode(), insDocBin.getBinCode()));
				BigDecimal binWeightQty = commonServiceImpl.getActualQty(Const.STRING_EMPTY, insDocBin.getMatCode(),
						insDocBin.getWeightUnitCode(), binUnitCode, insDocBin.getWeightQty());
				insDocBin.setBinWeightQty(binWeightQty);
				insDocBin.setBinWeightUnitCode(binUnitCode);
			}
		}

		return insDocBinList;
	}

	@Override
	@Transactional
	public void modifyStockByStockTake(SinobecInsMoveTypeVo insMoveType) throws WMSException {


		List<SinobecInsDocBin> insDocBinList = this.checkMoveType(insMoveType);

		if (insDocBinList.size() > 0) {
			insDocBinDao.insertOrUpdateList(insDocBinList);

			insDocBinDao.modifyStock(insDocBinList.get(0).getInsDocCode());

			insDocBinDao.deleteStock(insDocBinList.get(0).getInsDocCode());

			List<SinobecStock> negativeStockList = insDocBinDao
					.selectNegativeStockAfterModifyStock(insDocBinList.get(0).getInsDocCode());
			for (SinobecStock stockBin : negativeStockList) {
				// 校验非负
				if (stockBin.getWeightQty().compareTo(BigDecimal.ZERO) < 0) {
					throw new SinobecStockQtyNotEnoughException(stockBin);
				}

			}
			if(UtilConst.getInstance().getStrategyShelfLoad()==1) {
				/** 修改仓位当前载重 */
				insDocBinDao.modifyBinWeightQty(insDocBinList.get(0).getInsDocCode());
			}
		}
	}

	

}
