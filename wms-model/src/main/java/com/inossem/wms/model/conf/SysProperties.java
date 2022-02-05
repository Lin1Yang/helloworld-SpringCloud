package com.inossem.wms.model.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author libin
 */
@Configuration
public class SysProperties {
	
	/**
	 * WMS系统日志启用状态,启用: true, 关闭: false
	 */
	@Value("${wms.syslog.active}")
	private Boolean active;

/*	*//**
	 * 日志级别 [all|trace|debug|info|warn|error|off]
	 *//*
	@Value("${wms.syslog.level}")
	private List<String> level;
	
	*//**
	 * 我的审批待办，缓存加载 启用true, 关闭false
	 *//*
	@Value("${wms.sysinit.private-workflow-caching}")
	private Boolean privateWorkflowCaching;
	
	*//**
	 * 我的任务加载 启用true, 关闭false
	 *//*
	@Value("${wms.sysinit.pravate-task-caching}")
	private Boolean pravateTaskCaching;
	
	*//**
	 * 定时任务初始化加载 启用true, 关闭false
	 *//*
	@Value("${wms.sysinit.schedule-task-init}")
	private Boolean scheduleTaskInit;*/

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

/*	public List<String> getLevel() {
		return level;
	}

	public void setLevel(List<String> level) {
		this.level = level;
	}

	public Boolean getPrivateWorkflowCaching() {
		return privateWorkflowCaching;
	}

	public void setPrivateWorkflowCaching(Boolean privateWorkflowCaching) {
		this.privateWorkflowCaching = privateWorkflowCaching;
	}

	public Boolean getPravateTaskCaching() {
		return pravateTaskCaching;
	}

	public void setPravateTaskCaching(Boolean pravateTaskCaching) {
		this.pravateTaskCaching = pravateTaskCaching;
	}

	public Boolean getScheduleTaskInit() {
		return scheduleTaskInit;
	}

	public void setScheduleTaskInit(Boolean scheduleTaskInit) {
		this.scheduleTaskInit = scheduleTaskInit;
	}*/
	
}
