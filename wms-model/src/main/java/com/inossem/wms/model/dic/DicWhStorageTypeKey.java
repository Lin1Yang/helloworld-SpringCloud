package com.inossem.wms.model.dic;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicWhStorageTypeKey", description="存储类型主键")
public class DicWhStorageTypeKey implements Serializable {
	
	private static final long serialVersionUID = -1067946254819187774L;

	@ApiModelProperty(value="仓库编码")
	private String whCode;

	@ApiModelProperty(value="存储类型编码")
	private String typeCode;


	private int hash;

	public DicWhStorageTypeKey() {

	}

	public DicWhStorageTypeKey(String whCode, String typeCode) {
		this.whCode = whCode;
		this.typeCode = typeCode;
	}

	public String getWhCode() {
		return whCode;
	}

	public void setWhCode(String whCode) {
		this.whCode = whCode == null ? null : whCode.trim();
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode == null ? null : typeCode.trim();
	}

	@Override
	public int hashCode() {
		int h = hash;
		if (h == 0) {
			h = this.whCode == null ? 0 : this.whCode.hashCode();

			h = 13131 * h + (this.typeCode == null ? 0 : this.typeCode.hashCode());

			hash = h;
		}
		return h;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof DicWhStorageTypeKey) {
			DicWhStorageTypeKey another = (DicWhStorageTypeKey) obj;
			if (this.whCode == null || this.typeCode == null) {
				return false;
			} else if (this.whCode.equalsIgnoreCase(another.whCode)
					&& this.typeCode.equalsIgnoreCase(another.typeCode)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}
}
