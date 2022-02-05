package com.inossem.wms.dao.rel;

import java.util.List;

import com.inossem.wms.co.rel.RelUnitCo;
import com.inossem.wms.model.dic.DicDeleteCheckCo;
import com.inossem.wms.model.rel.RelUnit;
import com.inossem.wms.model.rel.RelUnitKey;
import com.inossem.wms.model.sinobec.gp.SinobecBizInputGP;
import com.inossem.wms.vo.rel.RelUnitVo;

public interface RelUnitMapper {
	int deleteByPrimaryKey(RelUnitKey key);

	int insert(RelUnit record);

	int insertSelective(RelUnit record);

	RelUnit selectByPrimaryKey(RelUnitKey key);

	int updateByPrimaryKeySelective(RelUnit record);

	// int updateByPrimaryKey(RelUnit record);

	List<RelUnit> selectAllRelUnitList();

	/**
	 * 查询单位换算列表（分页）
	 * 
	 * @param condition
	 *            物料编码/物料描述
	 * 
	 * @return
	 * @throws WMSException
	 * @author lys
	 */
	List<RelUnitVo> selectRelUnitListOnPaging(RelUnitCo relUnitCo);

	/**
	 * 查询未删除的单位换算
	 * 
	 * @param RelUnitKey
	 * 
	 * @return
	 * @throws WMSException
	 * @author lys
	 */
	RelUnitVo selectRelUnitView(RelUnitKey key);

	/**
	 * 删除
	 * 
	 * @param RelUnit 
	 * 
	 * @return
	 * @throws WMSException
	 * @author lys
	 */
	int deleteRelUnit(RelUnit relUnit);
	
	/**
	 * 主数据删除校验 是否存在未删除的单位换算关系
	 * @author lys 
	 * 
	 * @param String
	 */
	List<RelUnit> selectByDicDeleteCheckCo(DicDeleteCheckCo deleteCheckCo);

	int insertOrUpdateList(List<RelUnit> relunit);
}