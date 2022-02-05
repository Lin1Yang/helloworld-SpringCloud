package com.inossem.wms.model.dic;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicMaterialFactoryKey", description="工厂物料主键")
public class DicMaterialFactoryKey implements Serializable {

	private static final long serialVersionUID = 3360058866198167816L;

	@ApiModelProperty(value = "物料编码", name="matCode", example="60000001", required=true)
    private String matCode;

    @ApiModelProperty(value = "工厂编码", name="ftyCode", example="1000", required=true)
    private String ftyCode;
    
    private int hash;
    
    public DicMaterialFactoryKey() {
		super();
	}

    public DicMaterialFactoryKey(String matCode, String ftyCode) {
		super();
		this.matCode = matCode;
		this.ftyCode = ftyCode;
	}

	public String getMatCode() {
        return matCode;
    }

    public void setMatCode(String matCode) {
        this.matCode = matCode == null ? null : matCode.trim();
    }

    public String getFtyCode() {
        return ftyCode;
    }

    public void setFtyCode(String ftyCode) {
        this.ftyCode = ftyCode == null ? null : ftyCode.trim();
    }
    
    @Override
	public int hashCode() {
		int h = hash;
		if (h == 0) {
			h = this.ftyCode == null ? 0 : this.ftyCode.hashCode();

			h = 13131 * h + (this.matCode == null ? 0 : this.matCode.hashCode());

			hash = h;
		}
		return h;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof DicMaterialFactoryKey) {
			DicMaterialFactoryKey another = (DicMaterialFactoryKey) obj;
			if (this.ftyCode == null || this.matCode == null) {
				return false;
			} else if (this.ftyCode.equalsIgnoreCase(another.ftyCode)
					&& this.matCode.equalsIgnoreCase(another.matCode)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}
    
    
}
