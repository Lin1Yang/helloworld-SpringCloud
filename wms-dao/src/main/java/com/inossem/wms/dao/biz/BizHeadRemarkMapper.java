package com.inossem.wms.dao.biz;

import com.inossem.wms.model.biz.BizHeadRemark;

public interface BizHeadRemarkMapper {
    int deleteByPrimaryKey(Integer headRemarkId);

    int insert(BizHeadRemark record);

    int insertSelective(BizHeadRemark record);

    BizHeadRemark selectByPrimaryKey(Integer headRemarkId);

    int updateByPrimaryKeySelective(BizHeadRemark record);

    int updateByPrimaryKey(BizHeadRemark record);
    
    //以下是自定义方法
    
    /**
	 * 根据单据类型和单号查询抬头备注
	 * 
	 * @param  BizHeadRemark
	 * @return 
	 * @throws Exception
	 * @author lys
	 */	
    BizHeadRemark selectRemark(BizHeadRemark record);
    
    /**
	 * 根据单据类型和单号更新抬头备注
	 * 
	 * @param  BizHeadRemark
	 * @return 
	 * @throws Exception
	 * @author lys
	 */	
    int updateReceiptRemark(BizHeadRemark record);

	/**
	 * 插入或更新抬头备注信息
	 *  需要写sql实现
	 * 
	 * @param receiptCode
	 * @param remark
	 * @return
	 * @author libin
	 */
	int insertOrUpdate(BizHeadRemark record);
	
	/**
	 * 查询仓储作业申请明细表是否有当前仓库号
	 * 
	 * @param String
	 * @return 
	 * @author yuely
	 */
	BizHeadRemark whCodeIsExistCheck(String whCode);
}