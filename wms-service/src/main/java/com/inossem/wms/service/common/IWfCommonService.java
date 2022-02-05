package com.inossem.wms.service.common;

import java.util.List;

import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.vo.wf.WfNodeVo;

public interface IWfCommonService {
	
	/**
	 * 获取审批列表
	 * 
	 * @author yuely
	 * @return
	 * @throws WMSException
	 */
	List<WfNodeVo> getWfList(String receiptCode,int receiptType) throws WMSException;
	
	/**
	 * 查询审批是否结束
	 * 
	 * @author yuely
	 * @return
	 * @throws WMSException
	 */
	boolean getWhetherApprovalCompleted(String receiptCode,int receiptType);
	
	/**
	 * 删除审批流单据
	 * 
	 * @author yuely
	 * @return
	 * @throws WMSException
	 */
	void deleteWfReciptCode(String receiptCode,int receiptType);
	
	/**
	 * 根据业务单据类型获取当前业务单据是否需要审批 0 不需要 1需要
	 * @return
	 * @throws WMSException
	 */
	Byte wfRequired(Integer receiptType) throws WMSException;
	
	/**
	 * 根据业务单据类型获取当前业务单据是否配置，未配置返回值为null或""已配置返回有效的procId
	 * @return
	 * @throws WMSException
	 */
	String getWfProcId(Integer receiptType) throws WMSException;
}
