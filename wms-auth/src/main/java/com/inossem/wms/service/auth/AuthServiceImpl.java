package com.inossem.wms.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inossem.wms.dao.sys.SysUserMapper;
import com.inossem.wms.model.sys.SysUser;
import com.inossem.wms.service.common.IDictionaryService;

@Service
public class AuthServiceImpl implements IAuthService {

	@Autowired
	protected SysUserMapper sysUserMapper;


	@Autowired
	protected IDictionaryService dictionaryServiceSubImpl;

	@Override
	public SysUser getSysUserByUserCode(String userCode) {
		return sysUserMapper.selectByUserCode(userCode);
	}

	
	
}
