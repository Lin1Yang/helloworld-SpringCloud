package com.inossem.wms.common.auth;

import org.apache.shiro.SecurityUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.enums.EnumReturnCode;

//@Component
public class CurrentUserArgumentResolver implements WebArgumentResolver {

	@Override
	public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {
		if (methodParameter.getParameterType() != null
				&& methodParameter.getParameterType().equals(CurrentUser.class)) {
			Object principal = SecurityUtils.getSubject().getPrincipal();
			if (principal != null) {
				return SecurityUtils.getSubject().getPrincipal();
			}
			throw new WMSException(EnumReturnCode.RETURN_CODE_UNAUTH);
		}
		return UNRESOLVED;
	}

}
