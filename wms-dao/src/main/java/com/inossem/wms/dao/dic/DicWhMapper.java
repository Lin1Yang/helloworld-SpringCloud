package com.inossem.wms.dao.dic;

import java.util.List;

import com.inossem.wms.model.sinobec.SinobecRelWhPrint;
import org.springframework.stereotype.Component;

import com.inossem.wms.co.dic.DicWhListCo;
import com.inossem.wms.model.dic.DicWh;
import com.inossem.wms.vo.auth.DicWhTreeVo;

@Component
public interface DicWhMapper {
	int deleteByPrimaryKey(String whCode);

	int insert(DicWh record);

	int insertSelective(DicWh record);

	DicWh selectByPrimaryKey(String whCode);

	int updateByPrimaryKeySelective(DicWh record);

	// int updateByPrimaryKey(DicWh record);

	/**
	 * 查询所有 is_delete = 0
	 * 
	 * @return
	 */
	List<DicWh> selectAllWhList();

	/**
	 * 主键查询仓库的treevo
	 * 
	 * @param whCode
	 * @return
	 */

	DicWhTreeVo selectDicWhTreeVoByPrimaryKey(String whCode);

	/**
	 * 主键列表查询仓库的treevo列表
	 * 
	 * @param whCode
	 * @return
	 */
	List<DicWhTreeVo> selectDicWhTreeVoByPrimaryKeyList(List<String> whCodeList);
	
	/**
	 * 查询仓库列表
	 * 
	 * @param DicWhListCo
	 * @return DicWhTreeVo
	 * @author yuely
	 */
	List<DicWhTreeVo> selectDicWhVo(DicWhListCo co);
	
	/**
	 * 查询仓库号是否存在
	 * 
	 * @param DicWhListCo
	 * @return DicWhTreeVo
	 * @author yuely
	 */
	DicWhTreeVo selectWhCodeIsExist(DicWhListCo co);
	
	/**
	 * 插入仓库
	 * 
	 * @param DicWhTreeVo
	 * @return 
	 * @author yuely
	 */
	int insertWh(DicWh record);
	/**
	 * 将已经删除的仓库号重置为正常，并更新内容
	 * 
	 * @param DicWhTreeVo
	 * @return 
	 * @author yuely
	 */
	int updateWh(DicWh record);
	
	/**
	 * 更改仓库状态为删除
	 * 
	 * @param DicWhTreeVo
	 * @return 
	 * @author yuely
	 */
	int deleteWh(DicWh record);
	
	/**
	 * 查询仓库列表
	 * 
	 * @param DicWhTreeVo
	 * @return 
	 * @author yuely
	 */
	List<DicWhTreeVo> selectWhListOnPaging(DicWhListCo co);
	
	/**
	 * 查询仓库号信息
	 * 
	 * @param DicWhStorageTypeListCo
	 * @return DicWhStorageTypeVo
	 * @author yuely
	 */
	DicWhTreeVo getWhInfo(DicWhListCo co);


	SinobecRelWhPrint selectPrintIpByWhCode(String whCode);
}