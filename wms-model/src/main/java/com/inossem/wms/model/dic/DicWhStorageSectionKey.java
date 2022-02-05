package com.inossem.wms.model.dic;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicWhStorageSectionKey", description="这是存储区映射类")
public class DicWhStorageSectionKey implements Serializable {
	
	private static final long serialVersionUID = 1178246554213730785L;
	
	@ApiModelProperty(value = "仓库号", example = "001")
	private String whCode;
	@ApiModelProperty(value = "存储区类型编码", example = "002")
	private String typeCode;
	@ApiModelProperty(value = "存储区编码", example = "002")
	private String sectionCode;

	private int hash;

	public DicWhStorageSectionKey() {
	}

	public DicWhStorageSectionKey(String whCode, String typeCode, String sectionCode) {
		this.whCode=whCode;
		this.typeCode=typeCode;
		this.sectionCode=sectionCode;
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

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode == null ? null : sectionCode.trim();
	}

	@Override
	public int hashCode() {
		int h = hash;
		if (h == 0) {
			h = this.whCode == null ? 0 : this.whCode.hashCode();

			h = 13131 * h + (this.typeCode == null ? 0 : this.typeCode.hashCode());

			h = 13131 * h + (this.sectionCode == null ? 0 : this.sectionCode.hashCode());

			hash = h;
		}
		return h;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof DicWhStorageSectionKey) {
			DicWhStorageSectionKey another = (DicWhStorageSectionKey) obj;
			if (this.whCode == null || this.typeCode == null || this.sectionCode == null) {
				return false;
			} else if (this.whCode.equalsIgnoreCase(another.whCode) && this.typeCode.equalsIgnoreCase(another.typeCode)
					&& this.sectionCode.equalsIgnoreCase(another.sectionCode)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}
}