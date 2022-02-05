package com.inossem.wms.model.dic;

import java.io.Serializable;

import com.inossem.wms.constant.Const;

import io.swagger.annotations.ApiModelProperty;

public class DicWhStorageBinKey implements Serializable {
	/**  */
	private static final long serialVersionUID = 5104778748918144174L;

	@ApiModelProperty(value="仓库编码")
	private String whCode;

	@ApiModelProperty(value="存储类型编码")
	private String typeCode;

	@ApiModelProperty(value="仓位编码")
	private String binCode;



	private int hash;

	public DicWhStorageBinKey() {
	}

	public DicWhStorageBinKey(String whCode, String typeCode, String binCode) {
		this.whCode = whCode == null ? null : whCode.trim();
		this.typeCode = typeCode == null ? null : typeCode.trim();
		this.binCode = binCode == null ? null : binCode.trim();
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

	public String getBinCode() {
		return binCode;
	}

	public void setBinCode(String binCode) {
		this.binCode = binCode == null ? null : binCode.trim();
	}

	@Override
	public int hashCode() {
		int h = hash;
		if (h == 0) {
			h = this.whCode == null ? 0 : this.whCode.hashCode();

			h = 13131 * h + (this.typeCode == null ? 0 : this.typeCode.hashCode());

			h = 13131 * h + (this.binCode == null ? 0 : this.binCode.hashCode());

			hash = h;
		}
		return h;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof DicWhStorageBinKey) {
			DicWhStorageBinKey another = (DicWhStorageBinKey) obj;
			if (this.whCode == null || this.typeCode == null || this.binCode == null) {
				return false;
			} else if (this.whCode.equalsIgnoreCase(another.whCode) && this.typeCode.equalsIgnoreCase(another.typeCode)
					&& this.binCode.equalsIgnoreCase(another.binCode)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		/*sb.append(Const.CONDITION_TYPE_SMALL_SYMBOL_BY_HTML).append(this.whCode).append(Const.HORIZONTAL_LINE)
				.append(this.typeCode).append(Const.HORIZONTAL_LINE).append(this.binCode)
				.append(Const.CONDITION_TYPE_BIG_SYMBOL_BY_HTML);*/
		sb.append(Const.SQUARE_BRACKETS_LEFT)
		.append(this.typeCode).append(Const.LEFT_SLASH_LINE).append(this.binCode)
		.append(Const.SQUARE_BRACKETS_RIGHT);
		return sb.toString();
	}
}