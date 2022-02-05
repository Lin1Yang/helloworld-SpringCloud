package com.inossem.wms.common.shiro;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.enums.EnumReturnCode;


public class RestAuthenticationFilter extends FormAuthenticationFilter {
	
	private static final Logger logger = LoggerFactory.getLogger(RestAuthenticationFilter.class);
	@Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception{
		if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                if (logger.isTraceEnabled()) {
                    logger.trace("Login submission detected.  Attempting to execute login.");
                }
                return executeLogin(request, response);
            } else {
                if (logger.isTraceEnabled()) {
                    logger.trace("Login page view.");
                }
                //allow them to see the login page ;)
                //throw new UnauthException();
                return true;
            }
        } else {
            if (logger.isTraceEnabled()) {
                logger.trace("Attempting to access a path which requires authentication.  Forwarding to the " +
                        "Authentication url [" + getLoginUrl() + "]");
            }
            throw new WMSException(EnumReturnCode.RETURN_CODE_UNAUTH);
//            saveRequestAndRedirectToLogin(request, response);
        }
	}
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		boolean allowed = super.isAccessAllowed(request, response, mappedValue);
		if (!allowed) {
			// 判断请求是否是options请求
			// options 请求  不拦截
			String method = WebUtils.toHttp(request).getMethod();
			if ("OPTIONS".equalsIgnoreCase(method)) {
				return true;
			}
		}
		return allowed;

	}
	
}
