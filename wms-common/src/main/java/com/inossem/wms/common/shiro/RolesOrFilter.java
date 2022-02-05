package com.inossem.wms.common.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.enums.EnumReturnCode;

public class RolesOrFilter extends AuthorizationFilter{

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		// 判断请求是否是options请求
		String method = WebUtils.toHttp(request).getMethod();
		if ("OPTIONS".equalsIgnoreCase(method)) {
			// options 请求  不拦截
			return true;
		}
		Subject subject = SecurityUtils.getSubject();
		String[] rolesArray = (String[]) mappedValue;
		if (rolesArray == null || rolesArray.length == 0) {
			return true;
		}
		for (int i = 0; i < rolesArray.length; i++) {
			if (subject.hasRole(rolesArray[i])) {
				return true;
			}
		}
		throw new WMSException(EnumReturnCode.RETURN_CODE_ACCESS_DENY);
	}

}
