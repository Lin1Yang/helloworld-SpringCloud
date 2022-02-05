package com.inossem.wms.dao.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import com.inossem.wms.co.sys.SysRelUserRoleCo;
import com.inossem.wms.co.sys.SysRelUserRoleInfoCo;
import com.inossem.wms.model.sys.SysRelUserRole;
import com.inossem.wms.model.sys.SysRelUserRoleKey;
import com.inossem.wms.vo.sys.SysRelUserRoleVo;

public interface SysRelUserRoleMapper {
    int deleteByPrimaryKey(SysRelUserRoleKey key);

    int insert(SysRelUserRole record);

    int insertSelective(SysRelUserRole record);

    SysRelUserRole selectByPrimaryKey(SysRelUserRoleKey key);

    int updateByPrimaryKeySelective(SysRelUserRole record);

    int updateByPrimaryKey(SysRelUserRole record);

    List<String> selectRoleByUser(Integer userid);

    List<String> selectRoleByUserCode(String userCode);

    List<String> selectPermisstionByUserCode(Integer userId);
    /**
     * 用户已经被分配的角色
     * @param relUserRoleCo user_id
     * @author 刘宇 2018年12月24日10:39:40
     * @return
     */
    List<SysRelUserRoleVo> selectByUserId(SysRelUserRoleCo relUserRoleCo);

    /**
     * 根据用户id userId删除用户角色
     * @author 刘宇 2018年12月25日14:34:02
     * @param key
     * @return
     */
    int deleteByUserId(SysRelUserRoleKey key);

    /**
     * 批量添加用户角色
     * @author 刘宇 2018年12月25日14:33:58
     * @param sysRelUserRoleInfoCos
     * @return
     */
    int insertRelSysRelUserRoles (List<SysRelUserRoleInfoCo> sysRelUserRoleInfoCos);

    /**
     * 查询同一用户角色数量
     * @author 刘宇 2018年12月25日14:34:06
     * @param key
     * @return
     */
    SysRelUserRole selectSysRelUserRoleCountByPrimaryKey(SysRelUserRoleKey key);

    /**
     * 根据角色编码删除用户角色
     * @author 刘宇 2019年1月2日16:43:52
     * @param roleCode
     * @return
     */
    int deleteByRoleCode(String roleCode);

    /**
     * 根据角色编码查询分配用户列表
     * @author
     * @param roleCode
     * @return
     */
    List<SysRelUserRoleVo>  selectUserListByRoleCode(String roleCode);
    @MapKey("roleCode")
    Map<String, SysRelUserRoleVo> selectUserMapByListRoleCode(List<String> list);
}
