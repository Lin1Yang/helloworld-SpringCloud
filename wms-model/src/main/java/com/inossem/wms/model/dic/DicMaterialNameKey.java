package com.inossem.wms.model.dic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicMaterialNameKey", description="物料描述联合主键")
public class DicMaterialNameKey {
	@ApiModelProperty(value="多语言id", name="tid",example="i18n_0000000001_mid", required=true)
    private String tid;

	@ApiModelProperty(value="语言编码", name="langCode",example="zh-CN", required=true)
    private String langCode;
    
	private int hash;

    public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode == null ? null : langCode.trim();
    }
    

	@Override
	public int hashCode() {
		int h = hash;
		if (h == 0) {
			h = this.tid == null ? 0 : this.tid.hashCode();

			h = 13131 * h + (this.langCode == null ? 0 : this.langCode.hashCode());

			hash = h;
		}
		return h;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof DicMaterialNameKey) {
			DicMaterialNameKey another = (DicMaterialNameKey) obj;
			if (this.tid == null || this.tid.equals("")) {
				return false;
			} else if (this.tid.equalsIgnoreCase(another.tid)
					&& this.langCode.equalsIgnoreCase(another.langCode)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}
}