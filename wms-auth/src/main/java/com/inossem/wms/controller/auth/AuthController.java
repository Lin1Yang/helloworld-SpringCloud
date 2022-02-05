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

	// 加载自定义的拦截工厂
	@Autowired
	protected ShiroFilterFactoryBean myShiroFilterFactoryBean;
	@Autowired
	protected IPermissionService permissionService;
	@Autowired
	protected IAuthService authServiceSubImpl;
	@Autowired
	protected IDictionaryService dictionaryServiceSubImpl;

	/** 登录过期时间分为登录session过期时间和Shiro缓存过期时间，在修改时要注意同步修改 */
	@Value("${wms.login.expire}")
	private int loginExpire;

	/**
	 * 登录方法
	 * 
	 * @param user
	 * @return
	 */
	@ApiOperation(value = "登录方法", notes = "根据用户名和密码登陆", tags = { "登录" })
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody BaseObject<SysLoginVo> login(@RequestBody SysUser user,
			@RequestHeader(value = Const.LANG_CODE_HEADER_NAME, required = false, defaultValue = Const.DEFAULT_LANG_CODE) String langCode) {
		Subject subject = SecurityUtils.getSubject();
		SysLoginVo sysLoginVo = new SysLoginVo();
		// String str = MyShiroRealm.getHashPassword(user.getPassword(),
		// user.getUserCode());
		// System.out.println("*****************密码加密值是: " + str +
		// "****************");
		BaseObject<SysLoginVo> bo = null;
		//UsernamePasswordToken token = new UsernamePasswordToken(user.getUserCode(), user.getPassword());
		MyUsernamePasswordToken token = new MyUsernamePasswordToken(user.getUserCode(), user.getPassword());
		token.setCorpCode(user.getCorpCode());
		try {
			// c2Logger.debug(user.getUserCode());
			// for (int i = 0; i < 100000; i++) {
			// c2Logger
			// .debug("abcdefghijklmnopqrstuvwxyz", "起点" + i, "中间", "终点");
			// }

			subject.login(token);
			Session session = subject.getSession();
			session.setAttribute(Const.LANG_CODE, langCode);
			// session.setTimeout(30 * 1000);
			session.setTimeout(loginExpire * 1000); // 这里setTimeout接受毫秒，而在配置文件中的loginExpire单位是秒
			/*
			 * 设置了session超时时间后，
			 * shiro的过滤器会在每次调用doFilter时自动调用session代理对象的touch方法来更新超时时间
			 */
			sysLoginVo.setCode(EnumLoginCode.LOGIN_SUCCESS.getValue());
			sysLoginVo.setMsg(UtilText.getI18nText(EnumLoginCode.LOGIN_SUCCESS.name()));
			sysLoginVo.setToken(session.getId().toString());

			bo = new BaseObject<SysLoginVo>(sysLoginVo);
			bo.setReturnCode(1);
			bo.setReturnMsg(sysLoginVo.getMsg());
//			debugLogger.info(String.format("用户%s登录成功", user.getUserCode()));
		} catch (IncorrectCredentialsException e) {
//			debugLogger.warn(String.format("登录失败，用户名或密码不正确，用户名称：%s", user.getUserCode()));
			sysLoginVo.setCode(EnumLoginCode.LOGIN_ERROR_USER_NAME_PASS_WORD_WRONG.getValue());
			sysLoginVo.setMsg(UtilText.getI18nText(EnumLoginCode.LOGIN_ERROR_USER_NAME_PASS_WORD_WRONG.name()));
			bo = new BaseObject<SysLoginVo>(sysLoginVo);
			bo.setReturnCode(0);
			bo.setReturnMsg(sysLoginVo.getMsg());
			
		} catch (LockedAccountException e) {
//			debugLogger.warn(String.format("登录失败，用户名已锁定，用户名称：%s", user.getUserCode()));
			sysLoginVo.setCode(EnumLoginCode.LOGIN_ERROR_USER_FROZEN.getValue());
			sysLoginVo.setMsg(UtilText.getI18nText(EnumLoginCode.LOGIN_ERROR_USER_FROZEN.name()));
			bo = new BaseObject<SysLoginVo>(sysLoginVo);
			bo.setReturnCode(0);
			bo.setReturnMsg(sysLoginVo.getMsg());
		} catch (FreeznAccountException e) {
//			debugLogger.warn(String.format("登录失败，用户名已冻结，用户名称：%s", user.getUserCode()));
			sysLoginVo.setCode(EnumLoginCode.LOGIN_ERROR_USER_FROZEN.getValue());
			sysLoginVo.setMsg(UtilText.getI18nText(EnumLoginCode.LOGIN_ERROR_USER_FROZEN.name()));
			bo = new BaseObject<SysLoginVo>(sysLoginVo);
			bo.setReturnCode(0);
			bo.setReturnMsg(sysLoginVo.getMsg());
		}

		catch (DisabledAccountException e) {
			// 注意DisabledAccountException必须放在LockedAccountException后面处理（这两个异常是父子类关系）
//			debugLogger.warn(String.format("登录失败，账户有效期已到期，用户名称：%s", user.getUserCode()));
			sysLoginVo.setCode(EnumLoginCode.LOGIN_ERROR_USER_VALIDITY_EXPIRED_EXCEPTION.getValue());
			sysLoginVo.setMsg(UtilText.getI18nText(EnumLoginCode.LOGIN_ERROR_USER_VALIDITY_EXPIRED_EXCEPTION.name()));
			bo = new BaseObject<SysLoginVo>(sysLoginVo);
			bo.setReturnCode(0);
			bo.setReturnMsg(sysLoginVo.getMsg());
		} catch (AuthenticationException e) {
			// debugLogger.warn(String.format("登录失败，用户名或密码不正确，用户名称：%",
			// user.getUserCode()));
			sysLoginVo.setCode(EnumLoginCode.LOGIN_ERROR_USER_NAME_PASS_WORD_WRONG.getValue());
			sysLoginVo.setMsg(UtilText.getI18nText(EnumLoginCode.LOGIN_ERROR_USER_NAME_PASS_WORD_WRONG.name()));
			bo = new BaseObject<SysLoginVo>(sysLoginVo);
			bo.setReturnCode(0);
			bo.setReturnMsg(sysLoginVo.getMsg());
		} catch (Exception e) {
			// debugLogger.warn(String.format("登录失败，失败原因：%s，用户名称：%s",
			// e.getMessage(), user.getUserCode()));
			throw e;
		}
		return bo;
	}

	@ApiOperation(value = "未登录测试方法", notes = "未登录测试方法", tags = { "登录" })
	@RequestMapping(value = "/unauth", method = RequestMethod.GET)
	public @ResponseBody Object unauth() {
		throw new UnauthException();
	}

	@ApiOperation(value = "403异常测试方法", notes = "403异常测试方法", tags = { "登录" })
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public @ResponseBody Object accessDeny() {
		throw new AccessDeniedException();
	}

	@ApiOperation(value = "MD5加密测试方法", notes = "MD5加密测试方法", tags = { "登录" })
	@RequestMapping(value = "/hash", method = RequestMethod.POST)
	public @ResponseBody String hashPassword(@RequestParam String pwd, @RequestParam String username) {
		return MyShiroRealm.getHashPassword(pwd, username);
	}

	@ApiOperation(value = "权限重新加载测试方", notes = "权限重新加载测试方法", tags = { "登录" })
	@RequestMapping(value = "/permission/reload", method = RequestMethod.POST)
	public @ResponseBody BaseObject<?> reload() {
		permissionService.updatePermission(myShiroFilterFactoryBean);
		return new BaseObject<>();
	}

	@ApiOperation(value = "登出测试方法", notes = "登出测试方法", tags = { "登录" })
	@RequestMapping(value = "/permission/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody BaseObject<?> logout() {
		SecurityUtils.getSubject().logout();
		// SearchLogCo co = new SearchLogCo();
		// co.setBeginDate(new Date());
		// co.setEndDate(new Date());
		// co.setArgs(new String[] { "", "中间", "" });
		//
		// c2Query.searchLog(co);
		return new BaseObject<>();
	}

	@ApiOperation(value = "SCC认证用户身份", notes = "SCC认证用户身份", tags = { "登录" })
	@RequestMapping(value = "/scc/auth/user_authenticate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody BaseObject<SccAuthUserVo> userAuthenticate(@RequestBody SccAuthUserCo authCo) {
		System.out.println("userCode:" + authCo.getUserCode() + ", credential:" + authCo.getCredential());
		SysUser user = authServiceSubImpl.getSysUserByUserCode(authCo.getUserCode());
		if (user == null) {
			// debugLogger.warn("SCC验证用户{}，失败，未找到用户");
			throw new WMSException();
		}
		if (user.getPassword().equals(authCo.getCredential())) {
			if (authCo.getAuthType().byteValue() == 1
					&& EnumUserType.OUTSIDE_SUPPLIER_USER.getValue().equals(user.getUserType())) {
				// debugLogger.info("SCC验证用户{}，通过");
			} else if (authCo.getAuthType().byteValue() == 2
					&& EnumUserType.OUTSIDE_CUSTOMER_USER.getValue().equals(user.getUserType())) {
				// debugLogger.info("SCC验证用户{}，通过");
			} else if (authCo.getAuthType().byteValue() == 3
					&& EnumUserType.INSIDE_SYSUSER.getValue().equals(user.getUserType())) {
				// debugLogger.info("SCC验证用户{}，通过");
			} else {
				// debugLogger.warn("SCC验证用户{}，失败，账号类型不正确");
				throw new WMSException();
			}
		} else {
			// debugLogger.warn("SCC验证用户{}，失败，密码不正确");
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
