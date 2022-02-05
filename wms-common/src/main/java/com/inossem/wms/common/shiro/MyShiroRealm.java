package com.inossem.wms.common.shiro;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inossem.wms.common.auth.CurrentUser;
import com.inossem.wms.common.auth.MyUsernamePasswordToken;
import com.inossem.wms.common.exception.FreeznAccountException;
import com.inossem.wms.common.util.UtilBean;
import com.inossem.wms.dao.dic.DicAccountPeriodMapper;
import com.inossem.wms.dao.sys.SysRelUserRoleMapper;
import com.inossem.wms.dao.sys.SysUserMapper;
import com.inossem.wms.enums.EnumEnable;
import com.inossem.wms.model.sys.SysUser;
import com.inossem.wms.vo.auth.UserAccountPeriod;

/**
 * Created by Administrator on 2017/12/11.
 * 自定义权限匹配和账号密码匹配
 */
public class MyShiroRealm extends AuthorizingRealm {
	
	private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

	@Resource
    private SysUserMapper userDao;

	@Resource
    private SysRelUserRoleMapper sysRelUserRoleDao;

    
    
    @Resource
    private DicAccountPeriodMapper accountPeriodDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        CurrentUser user =  (CurrentUser) principals.getPrimaryPrincipal();
        //给当前用户设置角色
        for(String roleCode : user.getRoleCode()) {
            authorizationInfo.addRole(roleCode);
        }
        //给当前用户设置权限
        for(String resourceCode : user.getResourceCode()) {
        	authorizationInfo.addStringPermission(resourceCode);
        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        //获取用户的输入的账号.
    	MyUsernamePasswordToken myToken = (MyUsernamePasswordToken) token;
    	
        String username = (String) myToken.getPrincipal();
        //String corpCode = myToken.getCorpCode();  //无法取到corpCode, 因为前端没有传入  // 2021-10-07 注释掉
        // 通过username从数据库中查找 User对象，如果找到，没找到.
		SysUser user = userDao.selectByUserCode(username);

        if (user == null) {
            return null;
        }
        //user.setCorpCode(corpCode);  // 2021-10-07 注释掉
        //账户冻结
        if (EnumEnable.ENABLE.getValue().equals(user.getFreeze())) {
        	logger.debug("用户{}认证失败，原因：账户已冻结", username);
            throw new FreeznAccountException();
        }
        // 账户有效期已过期时，抛出超期异常
        if (isAccountExpired(user.getValidityBeginDate(), user.getValidityEndDate())) {
        	logger.debug("用户{}认证失败，原因：账户有效期已到期", username);
        	throw new DisabledAccountException();
        }
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(getCurrentUser(user),
				user.getPassword(),
				ByteSource.Util.bytes(SysUser.getCredentialsSalt() + user.getUserCode().toLowerCase()),
				MyShiroRealm.class.getName());
        return authenticationInfo;
    }

    public static String getHashPassword(String pwd,String username){
		Object result = new SimpleHash("md5", pwd, SysUser.getCredentialsSalt() + username.toLowerCase(), 2);
        return result.toString();
    }

    private CurrentUser getCurrentUser(SysUser user){
        CurrentUser currentUser = new CurrentUser();
        UtilBean.getBean(user, currentUser);
        currentUser.setRoleCode(sysRelUserRoleDao.selectRoleByUser(user.getUserId()));
        currentUser.setResourceCode(sysRelUserRoleDao.selectPermisstionByUserCode(user.getUserId()));
        currentUser.setUserAccountPeriod(this.getUserAccountPeriod(user.getUserId()));
        return currentUser;
    }
    
    /**
     * 判断用户账户是否过期
     * 
     * @param userValidityEndDate 用户账户有效期的到期时间
     * @return true表示用户账户已过期，false表示未过期
     * @author libin
     */
    private boolean isAccountExpired(Date userValidityStartDate, Date userValidityEndDate) {
    	Calendar cStart = Calendar.getInstance();
    	cStart.setTime(userValidityStartDate);
    	cStart.set(Calendar.HOUR_OF_DAY, 0);
    	cStart.set(Calendar.MINUTE, 0);
    	cStart.set(Calendar.SECOND, 0);
    	Calendar cEnd = Calendar.getInstance();
        cEnd.setTime(userValidityEndDate);
        cEnd.set(Calendar.HOUR_OF_DAY, 23);
        cEnd.set(Calendar.MINUTE, 59);
        cEnd.set(Calendar.SECOND, 59);
        if (cStart.compareTo(Calendar.getInstance()) > 0
        		|| cEnd.compareTo(Calendar.getInstance()) < 0) {
        	// 当前日期在账户有效期之前或之后，均认为不在账户有效期内，按账户有效期过期计
        	return true;
        }
        return false;
    }
    
    /**
     * 查询账期
     * 
     * @param userId
     * @return
     * @author libin
     */
    private UserAccountPeriod getUserAccountPeriod(Integer userId) {
    	UserAccountPeriod userAccountPeriod = accountPeriodDao.selectByUserId(userId);
    	if (userAccountPeriod != null) {
    		userAccountPeriod.setAccountPeriodList(accountPeriodDao.selectByCo(userAccountPeriod.getBoardCode(), userAccountPeriod.getCorpCode()));
    	} else {
    		userAccountPeriod = new UserAccountPeriod();
    		userAccountPeriod.setEnabled(EnumEnable.UNABLE.getValue());
    		userAccountPeriod.setNotifiable(EnumEnable.UNABLE.getValue());
    		userAccountPeriod.setEditable(EnumEnable.UNABLE.getValue());
    		userAccountPeriod.setAccountPeriodList(new ArrayList<>());
    	}
    	return userAccountPeriod;
    }
    
}
