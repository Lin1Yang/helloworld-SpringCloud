package com.inossem.wms.common.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemLogoutFilter extends LogoutFilter {
	
	private static final Logger logger = LoggerFactory.getLogger(SystemLogoutFilter.class);
	
	@Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        String redirectUrl = getRedirectUrl(request, response, subject);
        try {
            subject.logout();
        } catch (Exception ise) {
        	logger.error(ise.getMessage());
        }
        issueRedirect(request, response, redirectUrl);
        return false;
    }

}
