package com.inossem.wms.service.auth;

import com.inossem.wms.model.sys.SysUser;

public interface IAuthService {

	SysUser getSysUserByUserCode(String userCode);

	

	

}
