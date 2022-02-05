package com.inossem.wms.model.rel;

import java.io.Serializable;

import com.inossem.wms.constant.Const;
import com.inossem.wms.page.PageCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.model.rel.RelUnitKey", description="物料计量单位换算对象")
public class RelUnitKey extends PageCommon implements Serializable {
	
	private static final long serialVersionUID = 2391883487062448096L;
	@ApiModelProperty(value="工厂")
	private String ftyCode;
	@ApiModelProperty(value="源单位编码")
	private String sourceUnitCode;
	@ApiModelProperty(value="目标单位编码")
	private String targetUnitCode;
	@ApiModelProperty(value="物料")
	private String matCode;

	private int hash;

	public RelUnitKey() {

	}

	public RelUnitKey(String ftyCode, String sourceUnitCode, String targetUnitCode, String matCode) {
		this.ftyCode = ftyCode;
		this.sourceUnitCode = sourceUnitCode;
		this.targetUnitCode = targetUnitCode;
		this.matCode = matCode;
	}

	public String getFtyCode() {
		return ftyCode;
	}

	public void setFtyCode(String ftyCode) {
		this.ftyCode = ftyCode == null ? null : ftyCode.trim();
	}

	public String getSourceUnitCode() {
		return sourceUnitCode;
	}

	public void setSourceUnitCode(String sourceUnitCode) {
		this.sourceUnitCode = sourceUnitCode == null ? null : sourceUnitCode.trim();
	}

	public String getTargetUnitCode() {
		return targetUnitCode;
	}

	public void setTargetUnitCode(String targetUnitCode) {
		this.targetUnitCode = targetUnitCode == null ? null : targetUnitCode.trim();
	}

	public String getMatCode() {
		return matCode;
	}

	public void setMatCode(String matCode) {
		this.matCode = matCode == null ? null : matCode.trim();
	}

	@Override
	public int hashCode() {
		int h = hash;
		if (h == 0) {
			h = this.ftyCode == null ? 0 : this.ftyCode.hashCode();

			h = 13131 * h + (this.matCode == null ? 0 : this.matCode.hashCode());
			
			h = 13131 * h + (this.sourceUnitCode == null ? 0 : this.sourceUnitCode.hashCode());

			h = 13131 * h + (this.targetUnitCode == null ? 0 : this.targetUnitCode.hashCode());


			hash = h;
		}
		return h;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof RelUnitKey) {
			RelUnitKey another = (RelUnitKey) obj;
			if (this.ftyCode == null || this.sourceUnitCode == null || this.targetUnitCode == null
					|| this.matCode == null) {
				return false;
			} else if (this.ftyCode.equalsIgnoreCase(another.ftyCode)
					&& this.matCode.equalsIgnoreCase(another.matCode)
					&& this.sourceUnitCode.equalsIgnoreCase(another.sourceUnitCode)
					&& this.targetUnitCode.equalsIgnoreCase(another.targetUnitCode)
			) {
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
		sb.append(Const.CONDITION_TYPE_SMALL_SYMBOL_BY_HTML).append(this.ftyCode).append(" ").append(this.sourceUnitCode).append(" ")
				.append(this.targetUnitCode).append(" ").append(this.matCode).append(Const.CONDITION_TYPE_BIG_SYMBOL_BY_HTML);
		return sb.toString();
	}
}