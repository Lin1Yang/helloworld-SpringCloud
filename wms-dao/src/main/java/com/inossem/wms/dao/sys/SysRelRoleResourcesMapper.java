package com.inossem.wms.dao.sys;

import java.util.List;

import com.inossem.wms.co.sys.SysRelRoleResourcesInfoCo;
import com.inossem.wms.model.sys.SysRelRoleResources;
import com.inossem.wms.model.sys.SysRelRoleResourcesKey;

public interface SysRelRoleResourcesMapper {
    int deleteByPrimaryKey(SysRelRoleResourcesKey key);

    int insert(SysRelRoleResources record);

    int insertSelective(SysRelRoleResources record);

    SysRelRoleResources selectByPrimaryKey(SysRelRoleResourcesKey key);

    int updateByPrimaryKeySelective(SysRelRoleResources record);

    int updateByPrimaryKey(SysRelRoleResources record);
    
    /**
     * 批量添加角色权限
     * @author 刘宇 2019年1月2日15:33:338
     * @param infoCos
     * @return
     */
    int insertSysRelRoleResources (List<SysRelRoleResourcesInfoCo> infoCos);  

    /**
     * 根据角色编码批量删除角色权限
     * @author 刘宇 2019年1月2日15:59:56
     * @param roleCode
     * @return
     */
    int deleteByRoleCode(String roleCode);
}
