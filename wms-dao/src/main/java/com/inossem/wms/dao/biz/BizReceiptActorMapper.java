package com.inossem.wms.dao.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.inossem.wms.model.biz.BizReceiptActor;
import com.inossem.wms.model.biz.BizReceiptActorKey;
import com.inossem.wms.vo.actor.BizReceiptActorVo;

@Repository
public interface BizReceiptActorMapper {
    //int deleteByPrimaryKey(BizReceiptActorKey key);

    //int insert(BizReceiptActor record);

    int insertSelective(BizReceiptActor record);

    BizReceiptActor selectByPrimaryKey(BizReceiptActorKey key);

    int updateByPrimaryKeySelective(BizReceiptActor record);

    //int updateByPrimaryKey(BizReceiptActor record);
    
    
    /**
	 * 根据单据类型、单据号物理删除经办人
	 * 
	 * @param receiptType
	 * @param receiptCode

	 * @throws Exception
	 * @author lys
	 */
    int deleteByReceiptTypeAndReceiptCodePhysically(@Param("receiptType") Integer receiptType,
			@Param("receiptCode") String receiptCode);
    
    /**
	 * 根据单据类型、单据号逻辑删除经办人
	 * 
	 * @param receiptType
	 * @param receiptCode

	 * @throws Exception
	 * @author lys
	 */
    int deleteByReceiptTypeAndReceiptCode(@Param("receiptType") Integer receiptType,
			@Param("receiptCode") String receiptCode);
    
    /**
   	 * 根据单据类型、单据号查询经办人
   	 * 
   	 * @param receiptType
   	 * @param receiptCode

   	 * @throws Exception
   	 * @author lys
   	 */
     List<BizReceiptActorVo> selectByReceiptTypeAndReceiptCode(@Param("receiptType") Integer receiptType,
   			@Param("receiptCode") String receiptCode);

	/**
	 * 更新单据经办人的处理状态
	 * 
	 * @param receiptType
	 * @param receiptCode
	 * @param processStatus
	 * @return
	 * @author libin
	 */
	int updateProcessStatusByReceiptTypeAndReceiptCode(@Param("receiptType") Integer receiptType, @Param("receiptCode") String receiptCode, @Param("processStatus") byte processStatus);

	/**
	 * 修改receiptStatus
	 * 
	 * @param actorPrimarykey
	 * @param value
	 * @return
	 * @author libin
	 */
	int updateReceiptStatusByPrimaryKey(@Param("primarykey") BizReceiptActorKey primarykey, @Param("receiptStatus") byte receiptStatus);

	/**
	 * 修改processStatus
	 * 
	 * @param primarykey
	 * @param processStatus
	 * @return
	 * @author libin
	 */
	int updateProcessStatusByPrimaryKey(@Param("primarykey") BizReceiptActorKey primarykey, @Param("processStatus") byte processStatus);

	/**
	 * 批量新增或修改
	 * @param list
	 * @return
	 */
	int insertOrUpdateListSelective(List<BizReceiptActor> list);
}