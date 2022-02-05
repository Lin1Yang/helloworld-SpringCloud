package com.inossem.wms.model.pushmessage;

import io.swagger.annotations.ApiModelProperty;

public class PushMessage {
    private Integer wf;

    private Integer actor;

    private Integer task;

    private String modify;
    
    @ApiModelProperty(value = "资源类型", example = "0")
    private Byte resourcesType;

	public Integer getWf() {
		return wf;
	}

	public void setWf(Integer wf) {
		this.wf = wf;
	}

	public Integer getActor() {
		return actor;
	}

	public void setActor(Integer actor) {
		this.actor = actor;
	}

	public Integer getTask() {
		return task;
	}

	public void setTask(Integer task) {
		this.task = task;
	}

	public String getModify() {
		return modify;
	}

	public void setModify(String modify) {
		this.modify = modify;
	}

	public Byte getResourcesType() {
		return resourcesType;
	}

	public void setResourcesType(Byte resourcesType) {
		this.resourcesType = resourcesType;
	}
}