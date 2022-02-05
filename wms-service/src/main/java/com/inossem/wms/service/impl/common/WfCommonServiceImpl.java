package com.inossem.wms.service.impl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inossem.wms.co.wf.WfReceiptCo;
import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.common.util.UtilConst;
import com.inossem.wms.constant.Const;
import com.inossem.wms.dao.wf.WfReceiptMapper;
import com.inossem.wms.enums.EnumEnable;
import com.inossem.wms.model.wf.WfReceipt;
import com.inossem.wms.model.wf.WfReceiptKey;
import com.inossem.wms.service.common.ICacheCommonService;
import com.inossem.wms.service.common.IWfCommonService;
import com.inossem.wms.vo.wf.WfNodeVo;
import com.inossem.wms.vo.wf.WfProcTaskSearchVo;

@Service
public class WfCommonServiceImpl implements IWfCommonService {
	
    @Autowired
    protected WfReceiptMapper wfReceiptMapper;
    
    
    
   
    
    @Autowired
	protected ICacheCommonService cacheCommonServiceSubImpl;
    
	@Override
	public List<WfNodeVo> getWfList(String receiptCode,int receiptType){
		
		WfReceiptKey key = new WfReceiptKey();
		key.setReceiptCode(receiptCode);
		key.setReceiptType(receiptType);
		WfReceipt wf = wfReceiptMapper.selectByPrimaryKey(key);
		
		List<WfNodeVo> wfNodeVoList = wfReceiptMapper.selectRealTimeNodeByProcId(wf.getPiId());
		
        return wfNodeVoList;
   }
	
	@Override
	public boolean getWhetherApprovalCompleted(String receiptCode,int receiptType){
		
		WfReceiptKey key = new WfReceiptKey();
		key.setReceiptCode(receiptCode);
		key.setReceiptType(receiptType);
		WfReceipt WfReceipt = wfReceiptMapper.selectByPrimaryKey(key);
		if(WfReceipt == null) {
			return false;
		}
		// TODO 审批流
		/*//获取当前办理完成任务的信息
        ProcTaskSearch searchTask = new ProcTaskSearch();
        searchTask.setProcinsId(WfReceipt.getPiId());
        
        List<ProcTask> procTaskList = procTaskMapper.selectTaskBySearchInfo(searchTask);
        if(procTaskList != null && procTaskList.size() > 0 ){
        	ProcTask procTask = procTaskList.get(0);
            //获取下一步可能的路径
            List<RouteDef> routeList = routeDefMapper.selectRoutesByFromNodeId(procTask.getNodedefId());
            //若无下一步则流程结束
            if((routeList == null || routeList.size() <= 0) && Constants.TASK_STATUS_FINISH.equals(procTask.getTaskStatus())){
                return true;
            }
        }*/
		
        return false;
   }
	
	@Override
	public void deleteWfReciptCode(String receiptCode,int receiptType) {
		
		WfReceiptKey key = new WfReceiptKey();
		key.setReceiptCode(receiptCode);
		key.setReceiptType(receiptType);
		WfReceipt wfReceipt = wfReceiptMapper.selectByPrimaryKey(key);
		if(wfReceipt != null) {
			String pilId = wfReceipt.getPiId();
			WfReceiptCo wfReceiptCo = new WfReceiptCo();
			wfReceiptCo.setPiId(pilId);
			List<WfProcTaskSearchVo> searchList = wfReceiptMapper.selectAgencyTaskList(wfReceiptCo);
			for(WfProcTaskSearchVo vo : searchList) {
				int num = Const.ZERO;
				if(cacheCommonServiceSubImpl.get(Const.PUSH_MESSAGE_ACTOR,vo.getUserId() + Const.STRING_EMPTY) != null) {
					num = (int)cacheCommonServiceSubImpl.get(Const.PUSH_MESSAGE_ACTOR,vo.getUserId() + Const.STRING_EMPTY);
				}
		    	cacheCommonServiceSubImpl.put(Const.PUSH_MESSAGE_ACTOR,vo.getUserId() + Const.STRING_EMPTY,(num - 1));  
			}
			// TODO 删除实例内容
			// procTaskMapper.deleteTaskByProcInsId(pilId);
			// 删除审批单据
			wfReceiptMapper.deleteByPrimaryKey(key);
		}
	}
	
	@Override
	public Byte wfRequired(Integer receiptType) throws WMSException {
		if (UtilConst.getInstance().getWfByReceiptType(receiptType)) {
			return EnumEnable.ENABLE.getValue();
		}else {
			return EnumEnable.UNABLE.getValue();
		}
	}

	@Override
	public String getWfProcId(Integer receiptType) throws WMSException {
		return UtilConst.getInstance().getWfProcIdByReceiptType(receiptType);
	}
}
