package com.inossem.wms.dao.dic;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.inossem.wms.co.dic.DicWhStorageBinListCo;
import com.inossem.wms.model.dic.DicWhStorageBin;
import com.inossem.wms.model.dic.DicWhStorageBinKey;
import com.inossem.wms.model.sinobec.SinobecInsDocBin;
import com.inossem.wms.model.sinobec.task.SinobecTaskVo;
import com.inossem.wms.vo.dic.DicWhStorageBinVo;
import com.inossem.wms.vo.take.BizStockTakeItemVo;
import com.inossem.wms.vo.take.BizStockTakeMatItemVo;

@Component
public interface DicWhStorageBinMapper {
	int deleteByPrimaryKey(DicWhStorageBinKey key);

	int insert(DicWhStorageBin record);

	int insertSelective(DicWhStorageBin record);

	DicWhStorageBin selectByPrimaryKey(DicWhStorageBinKey key);

	int updateByPrimaryKeySelective(DicWhStorageBin record);

	// int updateByPrimaryKey(DicWhStorageBin record);

	/**
	 * 查询所有 is_delete = 0
	 * 
	 * @return
	 */
	Set<DicWhStorageBinKey> selectAllBinList();
	/**
	 * 仓库号查询仓位列表
	 * 
	 * @param whCode
	 * @return
	 */
	List<DicWhStorageBin> selectDicWhStorageBinByWhCode(String whCode);

	
	/**
	 * 仓库号列表查询仓位列表
	 * 
	 * @param whCodeList
	 * @return
	 */
	List<DicWhStorageBin> selectDicWhStorageBinByWhCodeList(List<String> whCodeList);
	
	/**
	 * 查询仓位列表
	 * 
	 * @param DicWhStorageTypeVo
	 * @return 
	 * @author yuely
	 */
	List<DicWhStorageBinVo> selectDicWhStorageBinListOnPaging(DicWhStorageBinListCo co);
	
	/**
	 * 查询仓库号、存储类型和仓位是否存在
	 * 
	 * @param DicWhStorageBinListCo
	 * @return DicWhStorageTypeVo
	 * @author yuely
	 */
	DicWhStorageBinVo selectWhStorageBinCodeIsExist(DicWhStorageBinListCo co);
	
	/**
	 * 保存仓位信息
	 * 
	 * @param DicWhStorageBinVo
	 * @return 
	 * @author yuely
	 */
	void insertWhStorageBin(DicWhStorageBinVo vo);
	
	/**
	 * 修改仓位信息
	 * 
	 * @param DicWhStorageBinVo
	 * @return 
	 * @author yuely
	 */
	void updateWhStorageBin(DicWhStorageBinVo vo);
	
	/**
	 * 修改仓位信息
	 * 
	 * @param DicWhStorageBinVo
	 * @return 
	 * @author yuely
	 */
	void updateWhStorageBinByList(@Param("list")List<BizStockTakeItemVo> list);
	
	/**
	 * 修改仓位信息
	 * 
	 * @param DicWhStorageBinVo
	 * @return 
	 * @author yuely
	 */
	void updateWhStorageBinByMatList(@Param("list")List<BizStockTakeMatItemVo> list);
	
	/**
	 * 修改仓位状态信息
	 * 
	 * @param DicWhStorageBinVo
	 * @return 
	 * @author yuely
	 */
	void deleteWhStorageBin(DicWhStorageBinKey vo);
	
	/**
	 * 查询仓库号、存储类型和仓位信息
	 * 
	 * @param DicWhStorageBinListCo
	 * @return DicWhStorageTypeVo
	 * @author yuely
	 */
	DicWhStorageBinVo getWhStorageBinInfo(DicWhStorageBinListCo co);
	
	/**
	 * 查询仓库号、存储类型和仓位信息
	 * 
	 * @param DicWhStorageBinListCo
	 * @return DicWhStorageTypeVo
	 * @author yuely
	 */
	List<DicWhStorageBinVo> selectWhStorageBinList(DicWhStorageBinListCo co);
	List<DicWhStorageBinVo> selectWhStorageBinListByZoneAndBin(DicWhStorageBinListCo co);

	/**
	 * 查询仓库号、存储类型和仓位信息,根据 给定顺序排序 x,y,z
	 * @param co
	 * @param one
	 * @param two
	 * @param three
	 * @return
	 */
	List<DicWhStorageBinVo> selectWhStorageBinListOrderXYZ(@Param("co") DicWhStorageBinListCo co,
														   @Param("one")String one,
														   @Param("two")String two,
														   @Param("three")String three);


	
	/**
	 * 修改仓位使用状态信息
	 * 
	 * @param DicWhStorageBinVo
	 * @return
	 * @author haosp
	 */
	void updateUsed(DicWhStorageBinKey key);
	
	
	/**
	 * 查询仓位列表
	 * 
	 * @param DicWhStorageTypeVo
	 * @return 
	 * @author yuely
	 */
	List<DicWhStorageBinVo> getAllWhStorageBinList(DicWhStorageBinListCo co);
	/**
	 * @Author WangDong
	 * @Description //批量维护数据
	 * @Date 2019/2/20 12:01
	 * @Param [vo]
	 * @return int 成功的数量
	 **/
	int doBatchMaintenance(DicWhStorageBinVo vo);
	
	/**
	 * 更新冻结状态
	 * 
	 * @param DicWhStorageTypeVo
	 * @return 
	 * @author yuely
	 */
	void updateFreezeStatus(DicWhStorageBinKey dicWhStorageBinKey);
	
	
	int insertOrUpdateDicWhStorageBin(DicWhStorageBin record);
	
	List<DicWhStorageBinVo> getWhStorageBinListByWhCode(DicWhStorageBinListCo dicWhStorageBinListCo);
	
	List<DicWhStorageBinVo> selectIsFreeze(@Param("list")List<BizStockTakeItemVo> itemList);
	
	/**
	 * 查询仓位对应的 重量单位
	 * @param list
	 * @return
	 */
	List<DicWhStorageBin> selectBinByInsDocBin(List<SinobecInsDocBin> list);
	
	/**
	 * 获取推荐仓位
	 * 
	 * @param tempTaskList
	 * @param matCode
	 * @param tempQty
	 * @return
	 */
	DicWhStorageBinVo getRecommendBin(@Param("tempTaskList") List<SinobecTaskVo> tempTaskList,
			@Param("matCode") String matCode, @Param("tempQty") BigDecimal tempQty);
	
	/**
	 * 校验是否超重
	 * @param taskList
	 * @return
	 */
	List<DicWhStorageBinVo> checkBinWeight(@Param("taskList") List<SinobecTaskVo> taskList);
	
}