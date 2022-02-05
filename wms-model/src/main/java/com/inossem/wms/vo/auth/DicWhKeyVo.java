package com.inossem.wms.vo.auth;

import java.util.List;

import com.inossem.wms.vo.dic.DicWhStorageTypeKeyVo;

public class DicWhKeyVo{
	
	private String whCode;
	
	private String whName;
	
	private List<DicWhStorageTypeKeyVo> typeList;
	
	public DicWhKeyVo() {

	}

	public DicWhKeyVo(String whCode, String whName) {
		this.whCode = whCode;
		this.whName = whName;
	}
	
	public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode == null ? null : whCode.trim();
    }

    public String getWhName() {
		return whName;
	}

	public void setWhName(String whName) {
		this.whName = whName;
	}

	public List<DicWhStorageTypeKeyVo> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<DicWhStorageTypeKeyVo> typeList) {
		this.typeList = typeList;
	}
}
