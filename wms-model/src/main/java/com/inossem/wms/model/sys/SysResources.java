package com.inossem.wms.model.sys;

import java.util.Date;
import java.util.List;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.sys.SysResources", description="菜单对象")
public class SysResources{
		
	@ApiModelProperty(value = "菜单code", example = "wer-123")
    private String resourcesCode;

	@ApiModelProperty(value = "功能名称", example = "系统管理")
    private String resourcesName;
	
	@ApiModelProperty(value = "功能描述", example = "系统管理描述")
    private String resourcesDesc;
	
	@ApiModelProperty(value = "功能路径", example = "/biz/output/getMenu")
    private String resourcesPath;
	
	@ApiModelProperty(value = "功能URL", example = "/biz/output/memu.html")
    private String resourcesUrl;
	
	@ApiModelProperty(value = "父code", example = "1")
    private String parentCode;
	
	@ApiModelProperty(value = "菜单显示顺序", example = "1")
    private Integer displayIndex;
	
	@ApiModelProperty(value = "是否可用", example = "1")
    private Boolean enabled;
	
	@ApiModelProperty(value = "资源类型", example = "0")
    private Byte resourcesType;
	
	@ApiModelProperty(value = "快捷方式是否可选", example = "1")
    private Byte shortcut;
	
	@ApiModelProperty(value = "待选项是否可选", example = "0")
    private Byte todolist;
	
	@ApiModelProperty(value = "待办项查询sql", example = "")
	private String todolistSql;
	
	@ApiModelProperty(value = "待办项状态", example = "")
	private String todolistReceiptStatus;
	
	@ApiModelProperty(value = "权限类型", example = "")
    private Integer permissionType;
	
	@ApiModelProperty(value = "角色Code", example = "")
	private String roleCode;
	
	@ApiModelProperty(value = "角色列表", example = "")
    private List<String> roleList;
	
	@ApiModelProperty(value = "创建时间", example = "2018-02-12 12:30:12")
    private Date createTime;
	
	@ApiModelProperty(value = "修改时间", example = "2018-02-12 12:30:12")
    private Date modifyTime;
	
	@ApiModelProperty(value = "创建人ID", example = "1")
    private Integer createUserId;
	
	@ApiModelProperty(value = "修改人ID", example = "1")
    private Integer modifyUserId;
	
	@ApiModelProperty(value = "附加字段", example = "")
    private String resourcesExt0;
	
	@ApiModelProperty(value = "附加字段", example = "")
    private String resourcesExt1;
	
	@ApiModelProperty(value = "附加字段", example = "")
    private String resourcesExt2;
	
	@ApiModelProperty(value = "附加字段", example = "")
    private String resourcesExt3;
	
	@ApiModelProperty(value = "附加字段", example = "")
    private String resourcesExt4;
	
	@ApiModelProperty(value = "是否选中", example = "1")
	private String isChecked;

    public String getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}


    public String getResourcesCode() {
		return resourcesCode;
	}

	public void setResourcesCode(String resourcesCode) {
		this.resourcesCode = resourcesCode;
	}

	public String getResourcesName() {
        return resourcesName;
    }

    public void setResourcesName(String resourcesName) {
        this.resourcesName = resourcesName == null ? null : resourcesName.trim();
    }

    public String getResourcesDesc() {
        return resourcesDesc;
    }

    public void setResourcesDesc(String resourcesDesc) {
        this.resourcesDesc = resourcesDesc == null ? null : resourcesDesc.trim();
    }

    public String getResourcesPath() {
        return resourcesPath;
    }

    public void setResourcesPath(String resourcesPath) {
        this.resourcesPath = resourcesPath == null ? null : resourcesPath.trim();
    }

    public String getResourcesUrl() {
        return resourcesUrl;
    }

    public void setResourcesUrl(String resourcesUrl) {
        this.resourcesUrl = resourcesUrl == null ? null : resourcesUrl.trim();
    }


    public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public Integer getDisplayIndex() {
        return displayIndex;
    }

    public void setDisplayIndex(Integer displayIndex) {
        this.displayIndex = displayIndex;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Byte getResourcesType() {
        return resourcesType;
    }

    public void setResourcesType(Byte resourcesType) {
        this.resourcesType = resourcesType;
    }

    public Byte getShortcut() {
        return shortcut;
    }

    public void setShortcut(Byte shortcut) {
        this.shortcut = shortcut;
    }

    public Byte getTodolist() {
        return todolist;
    }

    public void setTodolist(Byte todolist) {
        this.todolist = todolist;
    }

    public String getTodolistSql() {
		return todolistSql;
	}

	public void setTodolistSql(String todolistSql) {
		this.todolistSql = todolistSql;
	}

	public String getTodolistReceiptStatus() {
		return todolistReceiptStatus;
	}

	public void setTodolistReceiptStatus(String todolistReceiptStatus) {
		this.todolistReceiptStatus = todolistReceiptStatus;
	}

	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getResourcesExt0() {
        return resourcesExt0;
    }

    public void setResourcesExt0(String resourcesExt0) {
        this.resourcesExt0 = resourcesExt0 == null ? null : resourcesExt0.trim();
    }

    public String getResourcesExt1() {
        return resourcesExt1;
    }

    public void setResourcesExt1(String resourcesExt1) {
        this.resourcesExt1 = resourcesExt1 == null ? null : resourcesExt1.trim();
    }

    public String getResourcesExt2() {
        return resourcesExt2;
    }

    public void setResourcesExt2(String resourcesExt2) {
        this.resourcesExt2 = resourcesExt2 == null ? null : resourcesExt2.trim();
    }

    public String getResourcesExt3() {
        return resourcesExt3;
    }

    public void setResourcesExt3(String resourcesExt3) {
        this.resourcesExt3 = resourcesExt3 == null ? null : resourcesExt3.trim();
    }

    public String getResourcesExt4() {
        return resourcesExt4;
    }

    public void setResourcesExt4(String resourcesExt4) {
        this.resourcesExt4 = resourcesExt4 == null ? null : resourcesExt4.trim();
    }

	public Integer getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(Integer permissionType) {
		this.permissionType = permissionType;
	}

	public List<String> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<String> roleList) {
		this.roleList = roleList;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

}