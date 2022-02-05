package com.inossem.wms.insmovetype.stocktake;

import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.common.insmovetype.sinobec.ISinobecInsMoveType;
import com.inossem.wms.common.util.UtilBean;
import com.inossem.wms.common.util.UtilObject;
import com.inossem.wms.enums.EnumReceiptType;
import com.inossem.wms.enums.EnumSequenceCode;
import com.inossem.wms.model.sinobec.SinobecInsDocBin;
import com.inossem.wms.service.common.ICommonService;
import com.inossem.wms.vo.sinobec.SinobecInsMoveTypeVo;
import com.inossem.wms.vo.take.BizStockTakeMatItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SinobecInsTakeMoveType implements ISinobecInsMoveType {
	@Autowired
	private ICommonService commonService;

	@Override
	public SinobecInsMoveTypeVo generateInsDoc(Object object) throws WMSException {

		SinobecInsMoveTypeVo moveType = new SinobecInsMoveTypeVo();
		if (object != null && object instanceof List) {
			List<?> taskListObj = (List<?>) object;
			String insDocCode = commonService.getNextSequenceValue(EnumSequenceCode.SEQUENCE_DOC.getValue());
			List<SinobecInsDocBin> docBinList = new ArrayList<SinobecInsDocBin>();
			int insDocRid = 1;
			for (Object taskObj : taskListObj) {

				if (taskObj != null && taskObj instanceof BizStockTakeMatItemVo) {
					BizStockTakeMatItemVo  take = (BizStockTakeMatItemVo) taskObj;

					SinobecInsDocBin sinobecInsDocBin = new SinobecInsDocBin();
					UtilBean.getBean(take, sinobecInsDocBin);

					sinobecInsDocBin.setInsDocCode(insDocCode);
					sinobecInsDocBin.setInsDocRid(UtilObject.getStringOrEmpty(insDocRid));

					sinobecInsDocBin.setIsDelete((byte) 0);
					/** 逆向操作标识 删除修改库存时 传1 正常传0 冲销的话 传1 */
					sinobecInsDocBin.setWriteOff((byte) 0);
					sinobecInsDocBin.setReceiptUnitCode(take.getUnitCode());
					sinobecInsDocBin.setItemNumb(take.getMatCode());
					sinobecInsDocBin.setReferReceiptCode(take.getStockTakeCode());
					sinobecInsDocBin.setReferReceiptRid(take.getStockTakeRid());
					sinobecInsDocBin.setReferReceiptBid(take.getStockTakeBid().toString());
					sinobecInsDocBin.setReferReceiptType(EnumReceiptType.SINOBEC_STOCK_TAKE.getValue());
					docBinList.add(sinobecInsDocBin);
					insDocRid++;
				}

			}
			moveType.setInsDocBinList(docBinList);
		}
		return moveType;

	}

}
