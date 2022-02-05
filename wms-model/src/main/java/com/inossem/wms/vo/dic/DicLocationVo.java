package com.inossem.wms.vo.dic;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.dic.DicLocationVo", description="库存地点")
public class DicLocationVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="储存地点", name="locationName",  required=true)
	private String locationCode;

	@ApiModelProperty(value="储存地点国际化编码", name="locationName",  required=true)
	private String locationName;

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
}
