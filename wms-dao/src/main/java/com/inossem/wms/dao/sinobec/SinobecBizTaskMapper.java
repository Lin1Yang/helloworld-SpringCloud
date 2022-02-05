package com.inossem.wms.dao.sinobec;

import com.inossem.wms.model.sinobec.SinobecBizTask;
import com.inossem.wms.model.sinobec.SinobecInsDocBin;
import com.inossem.wms.model.sinobec.SinobecStock;
import com.inossem.wms.model.sinobec.gp.SinobecBizOutputGp;
import com.inossem.wms.model.sinobec.task.SinobecTaskQueryCo;
import com.inossem.wms.model.sinobec.task.SinobecTaskVo;
import com.inossem.wms.model.sinobec.unload.UnLoadShelfDaoVo;
import com.inossem.wms.model.sinobec.unload.UnLoadShelfQueryCo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SinobecBizTaskMapper {

    /**
     * 根据前置单据+状态 获取单据，未删除未冲销
     * @param gps
     * @param receiptStatus
     * @return
     */
    List<UnLoadShelfDaoVo> queryInfoByGp(@Param(value = "receiptCode") String receiptCode, @Param(value = "receiptStatus") byte receiptStatus);


   /**
    * 功能描述: 〈校验是否已完成，已完成不再创建〉
    *
    * @return:
    * @since: 1.0.0
    * @Author: cxq
    * @Date: 2020/3/30 0030 9:03
    */
     Integer queryInfoByStatusCount(@Param(value = "co") UnLoadShelfQueryCo co, @Param(value = "receiptStatus") byte receiptStatus);


    /**
     * 根据条件+状态获取单据，未删除未冲销
     * @param receiptStatus
     * @return
     */
    List<UnLoadShelfDaoVo> queryInfoByInfo(@Param(value = "unLoadShelfQueryCo") UnLoadShelfQueryCo unLoadShelfQueryCo, @Param(value = "receiptStatus") byte receiptStatus);

    /**
     * 校验是否冲销过
     * @param gps
     * @return
     */
    Integer checkInfoByGp(@Param(value = "receiptCode") String receiptCode);

    /**
     * 校验是否冲销过>包含
     * @return
     */
    Integer checkInfoByInfos(@Param(value = "receiptCode") String receiptCode);
   /**
    * 查询cont  by status
    * @return
    */
    Integer selectCountByStatus(@Param(value = "co") UnLoadShelfQueryCo co, @Param(value = "receiptStatus") byte receiptStatus);

    int deleteByPrimaryKey(Integer taskId);

    /**
     * 删除草稿行项目
     * @param vos
     * @return
     */
    int unLoadTaskDelete(List<SinobecStock> vos);

    int unLoadTaskDeleteByReceiptCode(String receiptCode);

    int insert(SinobecBizTask record);

    int insertSelective(SinobecBizTask record);

    int insertList(List<UnLoadShelfDaoVo> list);

    SinobecBizTask selectByPrimaryKey(Integer taskId);

    int updateByPrimaryKeySelective(SinobecBizTask record);

    int updateByReceiptCode(SinobecBizTask record);

    int updateBundleCodebyRid(String bundleCode, String soRid);

    /**
     * 查询作业列表
     * @param co
     * @return
     */
    List<SinobecTaskVo> getTaskListOnPaging(SinobecTaskQueryCo co);


    /**
     * 查询代发货列表
     * @param co
     * @return
     */
    List<SinobecTaskVo> getDeliveryList(SinobecTaskQueryCo co);
    List<SinobecTaskVo> getDeliveryListUncompleted(SinobecTaskQueryCo co);

    /**
     * 根据库存凭证修改，stock id信息
     * @param sinobecInsDocBins
     * @return
     */
    int updateByInsDoc(List<SinobecInsDocBin> sinobecInsDocBins);

    /**
     * 根据receiptCode 删除作业单
     * @param receiptCode
     * @return
     */
    int deleteByReceiptCode(@Param("receiptCode") String receiptCode);

    /**
     * 获取作业单状态
     * @param receiptCode
     * @return
     */
    Byte getReceiptStatus(@Param("receiptCode") String receiptCode);

    /**
     * 获取作业单列表
     * @param co
     * @return
     */
    List<SinobecTaskVo> getReceiptListOnPaging(SinobecTaskQueryCo co);

    /**
     * 获取作业单详情
     * @param co
     * @return
     */
    List<SinobecTaskVo> getReceiptItemList(@Param("receiptCode") String receiptCode,@Param("taskType") Integer taskType);

 /**
  * update receipt_rid
  * @param sinobecBizTask
  * @return
  */
    int updateByReceiptCodeBath(SinobecBizTask sinobecBizTask);

    int updateStockId(@Param("receiptCode") String receiptCode,@Param("originId") Integer originId,@Param("targetId") Integer targetId);

    List<SinobecTaskVo> getTaskListByReceiptCode(@Param("receiptCode") String receiptCode);

}
