package com.inossem.wms.service.impl.common;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.common.util.UtilString;
import com.inossem.wms.constant.Const;
import com.inossem.wms.enums.EnumReturnCode;
import com.inossem.wms.service.common.ILangCommonService;

@Service
public class LangCommonServiceImpl implements ILangCommonService {
	
	
	@Override
	public String getLangcode(Integer userId) throws WMSException {
		String langCode = Const.STRING_EMPTY;
		if (null != userId) {
			langCode = SecurityUtils.getSubject().getSession().getAttribute(Const.LANG_CODE).toString();// 语言类型
		} else {
			throw new WMSException(EnumReturnCode.RETURN_CODE_INCORRECT_LOGIN_INFORMATION);
		}
		// 语言类型不合法
		if (UtilString.isNullOrEmpty(langCode)) {
			throw new WMSException(EnumReturnCode.RETURN_CODE_LANGUAGE_NOT_EXIST);
		}
		return langCode;
	}

}
