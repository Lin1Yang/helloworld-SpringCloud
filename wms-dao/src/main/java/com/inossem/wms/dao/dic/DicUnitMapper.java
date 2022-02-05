package com.inossem.wms.dao.dic;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inossem.wms.co.dic.DicUnitCo;
import com.inossem.wms.model.dic.DicUnit;

public interface DicUnitMapper {
    int deleteByPrimaryKey(String unitCode);

    int insert(DicUnit record);

    int insertSelective(DicUnit record);

    DicUnit selectByPrimaryKey(String unitCode);
    
    int updateByPrimaryKeySelective(DicUnit record);

    //int updateByPrimaryKey(DicUnit record);
    
    /**
     * 查询所有	is_delete = 0
     * @return
     */
    List<DicUnit> selectAllUnitList();
   
    /**
	 * 查询单位列表（分页）
	 * 
	 * @param unitCode unitName
	 *            
	 * @return
	 * @throws WMSException
	 * @author lys
	 */
    List<DicUnit> selectUnitListOnPaging(DicUnitCo unitCo);
    
    /**
	 * 查询未删除的单位
	 * 
	 * @param unitCode
	 *            
	 * @return
	 * @throws WMSException
	 * @author lys
	 */
    DicUnit selectUnitView(String unitCode);
	List<DicUnit> selectUnitViewList(List<String> list);
    
    /**
	 * 删除
	 * 
	 * @param unitCode modifyUserId
	 *            
	 * @return
	 * @throws WMSException
	 * @author lys
	 */
    int deleteUnit(@Param("unitCode") String unitCode, @Param("modifyUserId") Integer modifyUserId);
    
    /**
     * 查询固定单位
     * @return
     */
    List<DicUnit> selectFixedUnitList();
    
    /**
     * 保存或新增
     * @return
     */
    void insertOrUpdateSelective(DicUnit dicUnit);
}