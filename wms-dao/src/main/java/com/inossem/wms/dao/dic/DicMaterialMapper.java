package com.inossem.wms.dao.dic;

import java.util.List;
import java.util.Set;

import com.inossem.wms.co.dic.DicMaterialCo;
import com.inossem.wms.model.dic.DicMaterial;
import com.inossem.wms.vo.dic.DicMaterialManageVo;

public interface DicMaterialMapper {
    int deleteByPrimaryKey(String matCode);

    int insert(DicMaterial record);

    int insertSelective(DicMaterial record);

    int insertBatchDicMaterialInfoCo(List<? extends DicMaterial> list);

    DicMaterial selectByPrimaryKey(String matCode);

    int updateByPrimaryKeySelective(DicMaterial record);

    int updateByPrimaryKey(DicMaterial record);

    int updateBatchByPrimaryKey(List<? extends DicMaterial> list);
    /**
     * 物料code列表查询物料
     * @param matCodeList
     * @return
     */
    List<DicMaterial> selectByPrimaryKeyList(List<String> matCodeList);

    /**
     * 物料主数据列表页查询
     * @param materialCo
     * @return
     * @author 刘宇 2019-1-10 09:19:06
     */
    List<DicMaterialManageVo> selectDicMaterialManageOnPaging(DicMaterialCo materialCo);

    /**
     * 物料主数据列详情查询
     * @param matCode
     * @return
     * @author 刘宇 2019年1月10日11:38:45
     */
    DicMaterialManageVo selectDicMaterialManage(String matCode);

    /**
     * 查询入参中的冻结物料 返回冻结物料code
     * @param list
     * @return
     */
    Set<String> selectFreezeMatreial(List<String> list);

    List<String> selectAllMatCode();

    DicMaterial selectByMatCode(String matCode);

    /**
     *
     * @param matCodeList
     * @return
     */
    List<String> checkMatCode(List<String> matCodeList);

    DicMaterial selectByExt1(String matExt1);

}
