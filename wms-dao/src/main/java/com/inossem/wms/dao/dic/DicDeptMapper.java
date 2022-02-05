package com.inossem.wms.dao.dic;

import java.util.List;

import com.inossem.wms.model.dic.DicDeleteCheckCo;
import com.inossem.wms.model.dic.DicDept;
import com.inossem.wms.vo.dic.DicDeptVo;

public interface DicDeptMapper {
    int deleteByPrimaryKey(String deptCode);

    int insert(DicDept record);

    int insertSelective(DicDept record);

    DicDept selectByPrimaryKey(String deptCode);

    int updateByPrimaryKeySelective(DicDept record);

    int updateByPrimaryKey(DicDept record);
    
    /**
     * 查询所有部门拓展
     * @author 刘宇 2018年12月27日18:43:23
     * @return
     */
    List<DicDeptVo> selectAllDeptVoList();
    
    /**
	 * 主数据删除校验 是否存在未删除的部门
	 * @author lys 
	 * 
	 * @param String
	 */
	List<DicDept> selectByDicDeleteCheckCo(DicDeleteCheckCo deleteCheckCo);
    
}