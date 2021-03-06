package com.inossem.wms.controller.auth;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.inossem.c2.log.api.C2Logger;
import com.inossem.wms.co.auth.SccAuthUserCo;
import com.inossem.wms.common.auth.MyUsernamePasswordToken;
import com.inossem.wms.common.exception.AccessDeniedException;
import com.inossem.wms.common.exception.FreeznAccountException;
import com.inossem.wms.common.exception.UnauthException;
import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.common.shiro.MyShiroRealm;
import com.inossem.wms.common.util.UtilText;
import com.inossem.wms.constant.Const;
import com.inossem.wms.enums.EnumLoginCode;
import com.inossem.wms.enums.EnumReturnCode;
import com.inossem.wms.enums.EnumUserType;
import com.inossem.wms.model.dic.DicCorp;
import com.inossem.wms.model.sys.SysUser;
import com.inossem.wms.service.auth.IAuthService;
import com.inossem.wms.service.common.IDictionaryService;
import com.inossem.wms.service.common.IPermissionService;
import com.inossem.wms.vo.BaseObject;
import com.inossem.wms.vo.auth.SccAuthUserVo;
import com.inossem.wms.vo.auth.SysLoginVo;

import io.swagger.annotations.ApiOperation;

@Controller
public class AuthController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(AuthController.class);
//	@Autowired
//	private C2Logger loginLogger;
//
//	@Autowired
//	private C2Logger debugLogger;

	// ??????????????????????????????
	@Autowired
	protected ShiroFilterFactoryBean myShiroFilterFactoryBean;
	@Autowired
	protected IPermissionService permissionService;
	@Autowired
	protected IAuthService authServiceSubImpl;
	@Autowired
	protected IDictionaryService dictionaryServiceSubImpl;

	/** ??????????????????????????????session???????????????Shiro?????????????????????????????????????????????????????? */
	@Value("${wms.login.expire}")
	private int loginExpire;

	/**
	 * ????????????
	 * 
	 * @param user
	 * @return
	 */
	@ApiOperation(value = "????????????", notes = "??????????????????????????????", tags = { "??????" })
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody BaseObject<SysLoginVo> login(@RequestBody SysUser user,
			@RequestHeader(value = Const.LANG_CODE_HEADER_NAME, required = false, defaultValue = Const.DEFAULT_LANG_CODE) String langCode) {
		Subject subject = SecurityUtils.getSubject();
		SysLoginVo sysLoginVo = new SysLoginVo();
		// String str = MyShiroRealm.getHashPassword(user.getPassword(),
		// user.getUserCode());
		// System.out.println("*****************??????????????????: " + str +
		// "****************");
		BaseObject<SysLoginVo> bo = null;
		//UsernamePasswordToken token = new UsernamePasswordToken(user.getUserCode(), user.getPassword());
		MyUsernamePasswordToken token = new MyUsernamePasswordToken(user.getUserCode(), user.getPassword());
		token.setCorpCode(user.getCorpCode());
		try {
			// c2Logger.debug(user.getUserCode());
			// for (int i = 0; i < 100000; i++) {
			// c2Logger
			// .debug("abcdefghijklmnopqrstuvwxyz", "??????" + i, "??????", "??????");
			// }

			subject.login(token);
			Session session = subject.getSession();
			session.setAttribute(Const.LANG_CODE, langCode);
			// session.setTimeout(30 * 1000);
			session.setTimeout(loginExpire * 1000); // ??????setTimeout???????????????????????????????????????loginExpire????????????
			/*
			 * ?????????session??????????????????
			 * shiro??????????????????????????????doFilter???????????????session???????????????touch???????????????????????????
			 */
			sysLoginVo.setCode(EnumLoginCode.LOGIN_SUCCESS.getValue());
			sysLoginVo.setMsg(UtilText.getI18nText(EnumLoginCode.LOGIN_SUCCESS.name()));
			sysLoginVo.setToken(session.getId().toString());

			bo = new BaseObject<SysLoginVo>(sysLoginVo);
			bo.setReturnCode(1);
			bo.setReturnMsg(sysLoginVo.getMsg());
//			debugLogger.info(String.format("??????%s????????????", user.getUserCode()));
		} catch (IncorrectCredentialsException e) {
//			debugLogger.warn(String.format("????????????????????????????????????????????????????????????%s", user.getUserCode()));
			sysLoginVo.setCode(EnumLoginCode.LOGIN_ERROR_USER_NAME_PASS_WORD_WRONG.getValue());
			sysLoginVo.setMsg(UtilText.getI18nText(EnumLoginCode.LOGIN_ERROR_USER_NAME_PASS_WORD_WRONG.name()));
			bo = new BaseObject<SysLoginVo>(sysLoginVo);
			bo.setReturnCode(0);
			bo.setReturnMsg(sysLoginVo.getMsg());
			
		} catch (LockedAccountException e) {
//			debugLogger.warn(String.format("???????????????????????????????????????????????????%s", user.getUserCode()));
			sysLoginVo.setCode(EnumLoginCode.LOGIN_ERROR_USER_FROZEN.getValue());
			sysLoginVo.setMsg(UtilText.getI18nText(EnumLoginCode.LOGIN_ERROR_USER_FROZEN.name()));
			bo = new BaseObject<SysLoginVo>(sysLoginVo);
			bo.setReturnCode(0);
			bo.setReturnMsg(sysLoginVo.getMsg());
		} catch (FreeznAccountException e) {
//			debugLogger.warn(String.format("???????????????????????????????????????????????????%s", user.getUserCode()));
			sysLoginVo.setCode(EnumLoginCode.LOGIN_ERROR_USER_FROZEN.getValue());
			sysLoginVo.setMsg(UtilText.getI18nText(EnumLoginCode.LOGIN_ERROR_USER_FROZEN.name()));
			bo = new BaseObject<SysLoginVo>(sysLoginVo);
			bo.setReturnCode(0);
			bo.setReturnMsg(sysLoginVo.getMsg());
		}

		catch (DisabledAccountException e) {
			// ??????DisabledAccountException????????????LockedAccountException???????????????????????????????????????????????????
//			debugLogger.warn(String.format("?????????????????????????????????????????????????????????%s", user.getUserCode()));
			sysLoginVo.setCode(EnumLoginCode.LOGIN_ERROR_USER_VALIDITY_EXPIRED_EXCEPTION.getValue());
			sysLoginVo.setMsg(UtilText.getI18nText(EnumLoginCode.LOGIN_ERROR_USER_VALIDITY_EXPIRED_EXCEPTION.name()));
			bo = new BaseObject<SysLoginVo>(sysLoginVo);
			bo.setReturnCode(0);
			bo.setReturnMsg(sysLoginVo.getMsg());
		} catch (AuthenticationException e) {
			// debugLogger.warn(String.format("????????????????????????????????????????????????????????????%",
			// user.getUserCode()));
			sysLoginVo.setCode(EnumLoginCode.LOGIN_ERROR_USER_NAME_PASS_WORD_WRONG.getValue());
			sysLoginVo.setMsg(UtilText.getI18nText(EnumLoginCode.LOGIN_ERROR_USER_NAME_PASS_WORD_WRONG.name()));
			bo = new BaseObject<SysLoginVo>(sysLoginVo);
			bo.setReturnCode(0);
			bo.setReturnMsg(sysLoginVo.getMsg());
		} catch (Exception e) {
			// debugLogger.warn(String.format("??????????????????????????????%s??????????????????%s",
			// e.getMessage(), user.getUserCode()));
			throw e;
		}
		return bo;
	}

	@ApiOperation(value = "?????????????????????", notes = "?????????????????????", tags = { "??????" })
	@RequestMapping(value = "/unauth", method = RequestMethod.GET)
	public @ResponseBody Object unauth() {
		throw new UnauthException();
	}

	@ApiOperation(value = "403??????????????????", notes = "403??????????????????", tags = { "??????" })
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public @ResponseBody Object accessDeny() {
		throw new AccessDeniedException();
	}

	@ApiOperation(value = "MD5??????????????????", notes = "MD5??????????????????", tags = { "??????" })
	@RequestMapping(value = "/hash", method = RequestMethod.POST)
	public @ResponseBody String hashPassword(@RequestParam String pwd, @RequestParam String username) {
		return MyShiroRealm.getHashPassword(pwd, username);
	}

	@ApiOperation(value = "???????????????????????????", notes = "??????????????????????????????", tags = { "??????" })
	@RequestMapping(value = "/permission/reload", method = RequestMethod.POST)
	public @ResponseBody BaseObject<?> reload() {
		permissionService.updatePermission(myShiroFilterFactoryBean);
		return new BaseObject<>();
	}

	@ApiOperation(value = "??????????????????", notes = "??????????????????", tags = { "??????" })
	@RequestMapping(value = "/permission/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody BaseObject<?> logout() {
		SecurityUtils.getSubject().logout();
		// SearchLogCo co = new SearchLogCo();
		// co.setBeginDate(new Date());
		// co.setEndDate(new Date());
		// co.setArgs(new String[] { "", "??????", "" });
		//
		// c2Query.searchLog(co);
		return new BaseObject<>();
	}

	@ApiOperation(value = "SCC??????????????????", notes = "SCC??????????????????", tags = { "??????" })
	@RequestMapping(value = "/scc/auth/user_authenticate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody BaseObject<SccAuthUserVo> userAuthenticate(@RequestBody SccAuthUserCo authCo) {
		System.out.println("userCode:" + authCo.getUserCode() + ", credential:" + authCo.getCredential());
		SysUser user = authServiceSubImpl.getSysUserByUserCode(authCo.getUserCode());
		if (user == null) {
			// debugLogger.warn("SCC????????????{}???????????????????????????");
			throw new WMSException();
		}
		if (user.getPassword().equals(authCo.getCredential())) {
			if (authCo.getAuthType().byteValue() == 1
					&& EnumUserType.OUTSIDE_SUPPLIER_USER.getValue().equals(user.getUserType())) {
				// debugLogger.info("SCC????????????{}?????????");
			} else if (authCo.getAuthType().byteValue() == 2
					&& EnumUserType.OUTSIDE_CUSTOMER_USER.getValue().equals(user.getUserType())) {
				// debugLogger.info("SCC????????????{}?????????");
			} else if (authCo.getAuthType().byteValue() == 3
					&& EnumUserType.INSIDE_SYSUSER.getValue().equals(user.getUserType())) {
				// debugLogger.info("SCC????????????{}?????????");
			} else {
				// debugLogger.warn("SCC????????????{}?????????????????????????????????");
				throw new WMSException();
			}
		} else {
			// debugLogger.warn("SCC????????????{}???????????????????????????");
			throw new WMSException();
		}
		SccAuthUserVo vo = new SccAuthUserVo();
		vo.setUserId(user.getUserId().toString());
		vo.setUserName(user.getUserName());
		vo.setCorpCode(user.getCorpCode());
		String corpName = Const.STRING_EMPTY;
		DicCorp dicCorp = dictionaryServiceSubImpl.getCorpCacheByCode(user.getCorpCode());
		if (dicCorp != null) {
			corpName = dicCorp.getCorpName();
		}
		vo.setCorpName(corpName);
		return new BaseObject<>(vo);
	}

}
