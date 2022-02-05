package com.inossem.wms.controller.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inossem.wms.common.auth.CurrentUser;
import com.inossem.wms.model.dic.DicNoticeListVo;
import com.inossem.wms.model.dic.DicNoticeVo;
import com.inossem.wms.service.auth.IAuthService;
import com.inossem.wms.service.common.ICommonService;
import com.inossem.wms.vo.BaseObject;

import io.swagger.annotations.ApiOperation;

/**
 * 公告首页
 * 
 * @author cdq
 */

@Controller
public class DashboardController {
	@Autowired
	protected ICommonService commonServiceSubImpl;

	@Autowired
	protected IAuthService authServiceSubImpl;

	/**
	 * 获取通知
	 * 
	 * @return JSON
	 */
	@ApiOperation(value = "所有发布的通知集合", tags = { "登录有权限", "首页" })
	@RequestMapping(value = "/auth/get_home_notice_list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody BaseObject<DicNoticeListVo> getNotice() {
		List<DicNoticeVo> byConditionDicnoticeList = commonServiceSubImpl.getByConditionDicnoticeList();
		DicNoticeListVo dicNoticeListVo = new DicNoticeListVo();
		dicNoticeListVo.setDicNoticeList(byConditionDicnoticeList);
		return new BaseObject<>(dicNoticeListVo);
	}

	/**
	 * 获取消息(最新通知)
	 * 
	 * @return JSON
	 */
	@ApiOperation(value = "最新消息", tags = { "登录有权限", "首页" })
	@RequestMapping(value = "/auth/get_new_notice", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody BaseObject<DicNoticeVo> getNewNotice() {
		DicNoticeVo dicNotice = commonServiceSubImpl.getNewByConditionDicnotice();
		return new BaseObject<>(dicNotice);
	}

	

	



	/*@Autowired
	private IFactoryMatPriceService  priceService;*/
	@ApiOperation(value = "调用定时任务接口同步物料价格", tags = { "登录有权限", "首页" })
	@RequestMapping(value = "/1/auth/test_price", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody Object test(CurrentUser cUser) {
		//priceService.getFactoryMatPrice();
		return new BaseObject<>();
	}
}
