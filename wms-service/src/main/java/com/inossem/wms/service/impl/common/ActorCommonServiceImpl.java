package com.inossem.wms.service.impl.common;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.inossem.wms.co.actor.ActorCo;
import com.inossem.wms.co.actor.ActorGroupCo;
import com.inossem.wms.co.biz.BizReceiptActorCo;
import com.inossem.wms.common.auth.CurrentUser;
import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.common.util.UtilBean;
import com.inossem.wms.constant.Const;
import com.inossem.wms.dao.actor.ActorGroupMapper;
import com.inossem.wms.dao.actor.ActorGroupPostMapper;
import com.inossem.wms.dao.actor.ActorPostMapper;
import com.inossem.wms.dao.biz.BizReceiptActorMapper;
import com.inossem.wms.enums.EnumActorGroupType;
import com.inossem.wms.enums.EnumEnable;
import com.inossem.wms.enums.EnumIsDefault;
import com.inossem.wms.enums.EnumIsRequired;
import com.inossem.wms.enums.EnumReturnCode;
import com.inossem.wms.model.actor.ActorGroupPost;
import com.inossem.wms.model.biz.BizReceiptActor;
import com.inossem.wms.model.biz.BizReceiptActorKey;
import com.inossem.wms.model.sys.SysUser;
import com.inossem.wms.service.common.IActorCommonService;
import com.inossem.wms.service.common.ICacheCommonService;
import com.inossem.wms.service.common.ICommonService;
import com.inossem.wms.vo.actor.ActorGroupUserMo;
import com.inossem.wms.vo.actor.ActorGroupVo;
import com.inossem.wms.vo.actor.ActorPostUserVo;
import com.inossem.wms.vo.actor.BizReceiptActorVo;
import com.inossem.wms.vo.sys.SysUserVo;

@Service
public class ActorCommonServiceImpl implements IActorCommonService {
	
	enum PROCESS_STATUS {
		/** 未提交 value=0 */
		UN_SUBMIT((byte) 0),
		/** 处理中 value=1 */
		PROCESSING((byte) 1),
		/** 已办结 */
		DONE((byte) 2);
		
		private byte val;
		private PROCESS_STATUS(byte val) {
			this.val = val;
		}
		public byte value() {
			return this.val;
		}
	}
	
	enum RECEIPT_STATUS {
		/** 初始状态 */
		INIT((byte) 0),
		/** 待审经办确认状态 */
		TODO((byte) 1),
		/** 已经办确认状态 */
		DONE((byte) 2),
		/** 默认经办确认状态(非会签状态经办岗位中某人人已经确认，其它人默认为此状态) */
		DONE_BY_OTHER((byte) 3),
		;
		
		private byte val;
		private RECEIPT_STATUS(byte val) {
			this.val = val;
		}
		public byte value() {
			return this.val;
		}
	}
	
	@Autowired
	protected BizReceiptActorMapper bizReceiptActorDao;
	
	@Autowired
	protected ActorGroupPostMapper actorGroupPostDao;
	
	@Autowired
	protected ActorGroupMapper actorGroupDao;
	
	@Autowired
	protected ActorPostMapper actorPostDao;
	
	@Autowired
	protected ICommonService commonServiceSubImpl;
	
	@Autowired
	protected ICacheCommonService cacheCommonServiceSubImpl;
	
	@Override
	public List<ActorPostUserVo> getReceiptActorList(Integer receiptType, String receiptCode) throws WMSException {
		List<BizReceiptActorVo> receiptActorVoList = bizReceiptActorDao.selectByReceiptTypeAndReceiptCode(receiptType, receiptCode);
		List<ActorPostUserVo> actorList = new ArrayList<>();
		Map<String, ActorPostUserVo> map = new LinkedHashMap<String, ActorPostUserVo>();
		if (receiptActorVoList!=null&&receiptActorVoList.size()>0) {
			for (BizReceiptActorVo receiptActorVo : receiptActorVoList) {				
				SysUserVo sysUser = new SysUserVo();
				UtilBean.getBean(receiptActorVo, sysUser);
				String postCode = receiptActorVo.getPostCode();
				if (map.containsKey(postCode)) {
					map.get(postCode).getUserList().add(sysUser);
				}else {
					ActorPostUserVo actorPostUserVo = new ActorPostUserVo();
					UtilBean.getBean(receiptActorVo, actorPostUserVo);
					List<SysUserVo> sysUserList = new ArrayList<>();
					sysUserList.add(sysUser);
					actorPostUserVo.setUserList(sysUserList);
					map.put(postCode, actorPostUserVo);
				}
			}
		}
		for (String postCode : map.keySet()) {
			actorList.add(map.get(postCode));
		}
		return actorList; 		
	}

	@Override
	public void removeReceiptActorList(Integer receiptType, String receiptCode) throws WMSException {
		bizReceiptActorDao.deleteByReceiptTypeAndReceiptCodePhysically(receiptType, receiptCode);
		
	}

	@Override
	public void deleteReceiptActorList(Integer receiptType, String receiptCode) throws WMSException {
    	List<BizReceiptActorVo> actorList = bizReceiptActorDao.selectByReceiptTypeAndReceiptCode(receiptType, receiptCode);
    	// 对于处在待办状态的经办人，经办计数需要扣减
    	List<BizReceiptActorVo> minusList = actorList.stream().filter(item -> item.getProcessStatus().equals(PROCESS_STATUS.PROCESSING.value())).collect(Collectors.toList());
    	minusList.forEach(item -> this.minusTodoNum(item.getOperatorId().toString()));
		bizReceiptActorDao.deleteByReceiptTypeAndReceiptCode(receiptType, receiptCode);
	}

	@Transactional
	@Override
	public void saveReceiptActorList(Integer receiptType, String receiptCode,Integer userId, List<ActorPostUserVo> actorList)
			throws WMSException {
		this.removeReceiptActorList(receiptType, receiptCode);				
		if (actorList!=null&&actorList.size()>0) {
			List<BizReceiptActor> list = new ArrayList<>();
			int index = 0;
			for (ActorPostUserVo actorPostUserVo : actorList) {
				if (actorPostUserVo.getUserList() == null || actorPostUserVo.getUserList().size() == 0) {
					// 只填写了岗位没有填写经办人时,给出提示
					throw new WMSException(EnumReturnCode.RETURN_CODE_NULL_ACTOR);
				}
				for (SysUserVo sysUser : actorPostUserVo.getUserList()) {
					BizReceiptActor receiptActor = new BizReceiptActor();
					receiptActor.setReceiptType(receiptType);
					receiptActor.setReceiptCode(receiptCode);
					receiptActor.setOperatorId(sysUser.getUserId());
					receiptActor.setPostCode(actorPostUserVo.getPostCode());
					receiptActor.setCreateUserId(userId);
					receiptActor.setModifyUserId(userId);
					receiptActor.setPostIndex(index);
					receiptActor.setFileCode(sysUser.getFileCode());
					receiptActor.setReceiptStatus(index == 0 ? RECEIPT_STATUS.TODO.value() : RECEIPT_STATUS.INIT.value());
					receiptActor.setProcessStatus(PROCESS_STATUS.UN_SUBMIT.value());
					//bizReceiptActorDao.insertSelective(receiptActor);
					list.add(receiptActor);
				}
				index++;
			}
			//性能优化 改为批量插入
			if (list != null && list.size()>0) {
				bizReceiptActorDao.insertOrUpdateListSelective(list);
			}
		}
		
	}

	@Override
	public ActorGroupVo getDefaultActorGroupVo(Integer receiptType, CurrentUser currentUser) {
		ActorGroupCo actorGroupCo = new ActorGroupCo();
        //首先按照当前登录用户查询其默认自定义岗位组

        //当前用户所在公司
        actorGroupCo.setCorpCode(currentUser.getCorpCode());

        //当前用户使用的单据类型
        actorGroupCo.setReceiptType(receiptType);

        //查询默认岗位组
        actorGroupCo.setIsDefault(new Byte(Const.STRING_ONE));

        //查询岗位组类型为个人
        actorGroupCo.setGroupType(EnumActorGroupType.PERSONAL_ACTOR_POST_GROUP.getValue());

        //查询自己创建的
        actorGroupCo.setCreateUserId(currentUser.getUserId());

        ActorGroupVo actorGroupVo=null;
        List<ActorGroupVo> res =getGroupList(actorGroupCo);
        //多条数据默认选择第一条
        if(res!=null && res.size()>0){
            actorGroupVo= res.get(0);
            //获取对应岗位列表和岗位下人员
            List<ActorPostUserVo> actorPostUserVoList = getOwnPostUserByGroup(actorGroupVo.getGroupCode());
            actorGroupVo.setActorPostUserVoList(actorPostUserVoList);
        }else{
            //没查到数据时查询所在公司默认岗位组

            //查询岗位组类型为公司
            actorGroupCo.setGroupType(0);

            //不查询自己创建的
            actorGroupCo.setCreateUserId(null);
            res =getGroupList(actorGroupCo);
            if(res!=null && res.size()>0){
                actorGroupVo= res.get(0);
                //获取对应岗位列表和岗位下人员
                List<ActorPostUserVo> actorPostUserVoList = getCorpPostUserByGroup(actorGroupVo.getGroupCode());
                actorGroupVo.setActorPostUserVoList(actorPostUserVoList);
            }
        }
        return actorGroupVo;
	}
	
	@Override
    public List<ActorGroupVo> getGroupList(ActorGroupCo actorGroupCo) {
        return actorGroupDao.selectByParamsSelectiveOnPaging(actorGroupCo);
    }
	
	@Override
    public List<ActorPostUserVo> getOwnPostUserByGroup(String groupCode) {
        List<ActorGroupUserMo> actorGroupUserMoList = actorGroupPostDao.selectJoinedGroupAndUserByOwnGroupCode(groupCode);
        return getActorPostUserVoList(actorGroupUserMoList);
    }
	
	@Override
    public List<ActorPostUserVo> getCorpPostUserByGroup(String groupCode) {
        List<ActorGroupUserMo> actorGroupUserMoList = actorGroupPostDao.selectJoinedGroupAndUserByGroupCode(groupCode);
        return getActorPostUserVoList(actorGroupUserMoList);
    }
	
	private List<ActorPostUserVo> getActorPostUserVoList(List<ActorGroupUserMo> actorGroupUserMoList) {
        List<ActorPostUserVo> actorPostUserVoList = new ArrayList<>();
        Map<String, ActorPostUserVo> actorPostUserVoMap = new LinkedHashMap<>();
        //封装成 List<ActorPostUserVo>
        for (ActorGroupUserMo actorGroupUserMo : actorGroupUserMoList) {
            if (actorPostUserVoMap.get(actorGroupUserMo.getPostCode()) != null) {
            	SysUserVo user = new SysUserVo();
                user.setUserId(actorGroupUserMo.getUserId());
                user.setUserName(actorGroupUserMo.getUserName());
                actorPostUserVoMap.get(actorGroupUserMo.getPostCode()).getUserList().add(user);
            } else {
                SysUserVo user = new SysUserVo();
                user.setUserId(actorGroupUserMo.getUserId());
                user.setUserName(actorGroupUserMo.getUserName());
                ArrayList<SysUserVo> sysUserArrayList = new ArrayList<SysUserVo>();
                sysUserArrayList.add(user);
                ActorPostUserVo actorPostUserVo = new ActorPostUserVo();
                actorPostUserVo.setPostCode(actorGroupUserMo.getPostCode());
                actorPostUserVo.setCountersign(actorGroupUserMo.getCountersign());
                actorPostUserVo.setRequired(actorGroupUserMo.getRequired());
                actorPostUserVo.setPostName(actorGroupUserMo.getPostName());
                actorPostUserVo.setUserList(sysUserArrayList);
                actorPostUserVoMap.put(actorPostUserVo.getPostCode(), actorPostUserVo);
            }
        }
        for (ActorPostUserVo actorPostUserVo : actorPostUserVoMap.values()) {
            actorPostUserVoList.add(actorPostUserVo);
        }
        return actorPostUserVoList;
    }

	@Override
	public List<ActorPostUserVo> getDefaultActorList(Integer receiptType, CurrentUser currentUser) {
		ActorGroupVo actorGroupVo  = this.getDefaultActorGroupVo(receiptType, currentUser);
		List<ActorPostUserVo> actorList = new ArrayList<>();
		if (actorGroupVo!=null) {
			actorList = actorGroupVo.getActorPostUserVoList();
		}
		return actorList;
	}

	@Override
	public List<ActorGroupPost> getActorGroupPostByGroupCode(List<String> groupCodeList) {
		
		return actorGroupPostDao.selectByGroupCodeList(groupCodeList);
	}
	@Override
	public List<BizReceiptActorVo> getReceiptList(BizReceiptActorCo bizReceiptActorCo){
		return actorGroupPostDao.getReceiptListOnPaging(bizReceiptActorCo);
	}
	@Override
	public List<BizReceiptActorVo> getReceiptDetail(BizReceiptActorCo bizReceiptActorCo){
		List<BizReceiptActorVo> bizReceiptActorVoList = actorGroupPostDao.getAllReceiptByDoneAndToBeDone(bizReceiptActorCo);
		Map<Integer,BizReceiptActorVo> bizReceiptActorVoMap = new HashMap<>(3);
		BizReceiptActorVo bizReceiptActorVoTemp;
		for(BizReceiptActorVo bizReceiptActorVo:bizReceiptActorVoList){
			bizReceiptActorVoTemp = bizReceiptActorVoMap.get(bizReceiptActorVo.getPostIndex());
			if(bizReceiptActorVoTemp!=null){
				SysUser user = new SysUser();
				user.setUserId(bizReceiptActorVo.getOperatorId());
				user.setUserName(bizReceiptActorVo.getOperatorName());
				bizReceiptActorVoTemp.getUserList().add(user);
			}else{
				bizReceiptActorVoMap.put(bizReceiptActorVo.getPostIndex(),bizReceiptActorVo);
				SysUser user = new SysUser();
				user.setUserId(bizReceiptActorVo.getOperatorId());
				user.setUserName(bizReceiptActorVo.getOperatorName());
				bizReceiptActorVo.getUserList().add(user);
			}
		}
		List<BizReceiptActorVo> resultList = new ArrayList<>();
		for(int i = 0 ; i < bizReceiptActorVoMap.keySet().size();i++){
			resultList.add(bizReceiptActorVoMap.get(i));
		}
		return resultList;
	}
	@Override
	@Transactional
	public void doReceiptApproval(BizReceiptActorCo bizReceiptActorCo, CurrentUser user){
		//获取确认数据，条件为：操作人为当前登录人，单据编号，单据类别，状态为1
		BizReceiptActorVo bizReceiptActorVo;
		List<BizReceiptActorVo> bizReceiptActorVoList = actorGroupPostDao.getReceiptListOnPaging(bizReceiptActorCo);
		if(bizReceiptActorVoList!=null && bizReceiptActorVoList.size()==1){
			bizReceiptActorVo = bizReceiptActorVoList.get(0);
			int currentPosition = bizReceiptActorVo.getPostIndex();
			//按照岗位编号查找岗位，看是不是会签，如果是会签，只更新当前确认人员信息
			if("1".equals(bizReceiptActorVo.getCountersign())){
				bizReceiptActorVo.setReceiptStatus(RECEIPT_STATUS.DONE.value());
				bizReceiptActorVo.setApproverId(bizReceiptActorCo.getOperatorId());
				bizReceiptActorVo.setApproveTime(new Date());
				bizReceiptActorVo.setProcessStatus(PROCESS_STATUS.DONE.value());
				bizReceiptActorDao.updateByPrimaryKeySelective(bizReceiptActorVo);
				updateNextPostInfo(bizReceiptActorCo, currentPosition);
				// 扣减经办人待办事项数量
				this.minusTodoNum(user.getUserId().toString());
			}else{
				//如果不是会签，更新当岗位前其它需要经办人员
				Integer currentOperatorId = bizReceiptActorCo.getOperatorId();
				bizReceiptActorCo.setOperatorId(null);
				List<BizReceiptActorVo> bizReceiptActorVoListCurrentPost = actorGroupPostDao.getReceiptListOnPaging(bizReceiptActorCo);
				for(BizReceiptActorVo bizReceiptActorVo1 : bizReceiptActorVoListCurrentPost){
					if(!bizReceiptActorVo1.getOperatorId().equals(currentOperatorId)) {
						bizReceiptActorVo1.setReceiptStatus(RECEIPT_STATUS.DONE_BY_OTHER.value());
						bizReceiptActorVo1.setApproverId(currentOperatorId);
						bizReceiptActorVo1.setApproveTime(new Date());
						bizReceiptActorVo1.setProcessStatus(PROCESS_STATUS.DONE.value());
					}else{
						bizReceiptActorVo1.setReceiptStatus(RECEIPT_STATUS.DONE.value());
						bizReceiptActorVo1.setApproverId(currentOperatorId);
						bizReceiptActorVo1.setApproveTime(new Date());
						bizReceiptActorVo1.setProcessStatus(PROCESS_STATUS.DONE.value());
					}
					bizReceiptActorDao.updateByPrimaryKeySelective(bizReceiptActorVo1);
					// 扣减经办人待办事项数量
					this.minusTodoNum(bizReceiptActorVo1.getOperatorId().toString());
				}
				updateNextPostInfo(bizReceiptActorCo, currentPosition);
			}
			//如果不是会签，更新当前机构全部信息
		}
		
	}
	
	/**
	 * 扣减经办人待办事项数量
	 * @param userId
	 * @author libin
	 */
	private void minusTodoNum(String userId) {
		int num = (int) cacheCommonServiceSubImpl.get(Const.PUSH_MESSAGE_ACTOR, userId);
		int newNum = num - 1 > 0 ? num - 1 : 0; // 增加经办人待办事项最小为0的设置，避免显示异常
		cacheCommonServiceSubImpl.put(Const.PUSH_MESSAGE_ACTOR, userId, newNum);
	}
	
	/**
	 * 增加经办人待办事项数量
	 * 
	 * @param userId
	 * @author libin
	 */
	private void addTodoNum(String userId) {
		int num = Const.ZERO;
		if (cacheCommonServiceSubImpl.get(Const.PUSH_MESSAGE_ACTOR, userId) != null) {
			num = (int) cacheCommonServiceSubImpl.get(Const.PUSH_MESSAGE_ACTOR, userId);
		}
		cacheCommonServiceSubImpl.put(Const.PUSH_MESSAGE_ACTOR, userId, (num + 1));
	}

	private void updateNextPostInfo(BizReceiptActorCo bizReceiptActorCo, int currentPosition) {
		//查询是否有剩余未审批人员，有不做操作，没有进入下一步
		bizReceiptActorCo.setOperatorId(null);
		List<BizReceiptActorVo> bizReceiptActorVoListTemp = actorGroupPostDao.getReceiptListOnPaging(bizReceiptActorCo);
		if(bizReceiptActorVoListTemp.size()==0){
			bizReceiptActorCo.setPostIndex(++currentPosition);
			bizReceiptActorCo.setReceiptStatus(RECEIPT_STATUS.INIT.value());
			List<BizReceiptActorVo> bizReceiptActorVoListNext = actorGroupPostDao.getReceiptListOnPaging(bizReceiptActorCo);
			//有下一个经办岗位
			if(bizReceiptActorVoListNext!=null && bizReceiptActorVoListNext.size()>0){
				for(BizReceiptActorVo temp : bizReceiptActorVoListNext){
					temp.setArriveTime(new Date());
					temp.setReceiptStatus(RECEIPT_STATUS.TODO.value());
					bizReceiptActorDao.updateByPrimaryKeySelective(temp);
					this.addTodoNum(temp.getOperatorId().toString());
				}
			}
		}
	}


	@Override
	public void checkReceiptRequiredPost(Integer receiptType,List<ActorPostUserVo> actorList,CurrentUser cUser) throws WMSException {
		Byte actorRequired = commonServiceSubImpl.actorRequired(receiptType);
		if (EnumEnable.ENABLE.getValue().equals(actorRequired)) {
			if (actorList==null||actorList.size()==0) {
				throw new WMSException(EnumReturnCode.RETURN_CODE_NULL_ACTOR);
			}
			for (ActorPostUserVo actorPostUserVo : actorList) {
				if (actorPostUserVo.getUserList() == null || actorPostUserVo.getUserList().size() == 0) {
					throw new WMSException(EnumReturnCode.RETURN_CODE_NULL_ACTOR);
				}
			}
		}
		// 根据当前登录人的公司代码、单据类型查询公司的默认经办组
		ActorGroupCo actorGroupCo = new ActorGroupCo();
        actorGroupCo.setCorpCode(cUser.getCorpCode());
        actorGroupCo.setReceiptType(receiptType);
        actorGroupCo.setIsDefault(EnumIsDefault.DEFAULT.getValue());
        actorGroupCo.setGroupType(EnumActorGroupType.CORPORATION_ACTOR_POST_GROUP.getValue());
        // 当前登录人公司的指定业务类型对应的默认经办组列表（只有一个）
        List<ActorGroupVo> corpDefaultActorGroupList = this.getGroupList(actorGroupCo);
        Set<String> errorSet = new HashSet<>();
        if (corpDefaultActorGroupList!=null&&corpDefaultActorGroupList.size()>0) {
        	// 经办组code列表，用于筛选必填的经办组岗位
        	List<String> groupCodeList = corpDefaultActorGroupList.stream().map(ActorGroupVo::getGroupCode).collect(Collectors.toList());
        	// 查询出公司默认经办组中的必填经办组岗位列表
			List<ActorGroupPost> requiredGroupPostList = actorGroupPostDao.selectRequiredByGroupCodeList(groupCodeList, EnumIsRequired.REQUIRED.getValue());
			if (requiredGroupPostList!=null&&requiredGroupPostList.size()>0) {
				// 必填岗位列表不为空时，需要校验传入的经办组中是否填写了必填岗位及岗位人员
				for (ActorGroupPost requiredActorGroupPost : requiredGroupPostList) {
					String requiredPostCode = requiredActorGroupPost.getPostCode();				
					ActorPostUserVo postUserVo  = actorList.stream()
							.filter(p -> p.getPostCode().equals(requiredPostCode))
							.findFirst().orElse(null);
					if (postUserVo == null || postUserVo.getUserList() == null || postUserVo.getUserList().size() == 0) {
						errorSet.add(requiredActorGroupPost.getPostCode());
					}
				}
			}
		}
        if (!errorSet.isEmpty()) {
			throw new WMSException(EnumReturnCode.RETURN_CODE_REQUIRED_POST_NOT_ENOUGH_EXCEPTION, errorSet.toString());
		}
	}
	
	/**
	 * 调用MQ发起经办
	 */
	@Transactional
    @JmsListener(destination = Const.START_ACTOR_REQUEST_CODE, containerFactory = Const.QUEUE_LISTENER_CONTAINER)
	public void startApproval(ActorCo actorCo) throws WMSException { 
    	/** ********** 处理经办发起标识************* */
    	bizReceiptActorDao.updateProcessStatusByReceiptTypeAndReceiptCode(actorCo.getReceiptType(), actorCo.getReceiptCode(), PROCESS_STATUS.PROCESSING.value());
    	
    	/** ********** 处理经办人签字************* */
    	// 处理经办人签字，已经签字的
    	List<BizReceiptActorVo> receiptActorList = bizReceiptActorDao.selectByReceiptTypeAndReceiptCode(actorCo.getReceiptType(), actorCo.getReceiptCode());
    	// 按照岗位对单据经办人列表分组
    	Map<String, List<BizReceiptActorVo>> postActorMap = receiptActorList.stream().collect(Collectors.groupingBy(BizReceiptActorVo::getPostCode));
    	for (String postCode : postActorMap.keySet()) {
    		// 对每一个经办岗位单独处理
    		Byte countersign = actorPostDao.getCountersignByPostCode(postCode);
			boolean isCountersign = countersign == (byte) 1; // 当前岗位是否会签
			// 当前岗位是否有人签过（fileCode不为空即认为有签字）
			boolean isSigned = postActorMap.get(postCode).stream().anyMatch(item -> StringUtils.hasText(item.getFileCode()));
    		for (BizReceiptActorVo vo : postActorMap.get(postCode)) {
    			
    			// 得到主键，用于后续修改对应数据
    			BizReceiptActorKey actorPrimarykey = new BizReceiptActorKey();
    			actorPrimarykey.setReceiptType(vo.getReceiptType());
    			actorPrimarykey.setReceiptCode(vo.getReceiptCode());
    			actorPrimarykey.setPostCode(vo.getPostCode());
    			actorPrimarykey.setOperatorId(vo.getOperatorId());
    			
    			// 经办人签字图片文件code存在
    			if (StringUtils.hasText(vo.getFileCode())) {
    				// 当前经办人通过签字的方式通过了经办审批，直接在发起经办审批时将状态修改成已处理
    				bizReceiptActorDao.updateReceiptStatusByPrimaryKey(actorPrimarykey, RECEIPT_STATUS.DONE.value());
    				bizReceiptActorDao.updateProcessStatusByPrimaryKey(actorPrimarykey, PROCESS_STATUS.DONE.value());
    			} else {
    				if (!isCountersign && isSigned) {
    					// 非会签，且同岗位的其他经办人已经审批同意时，修改其他经办人的状态
    					bizReceiptActorDao.updateReceiptStatusByPrimaryKey(actorPrimarykey, RECEIPT_STATUS.DONE_BY_OTHER.value());
        				bizReceiptActorDao.updateProcessStatusByPrimaryKey(actorPrimarykey, PROCESS_STATUS.DONE.value());
    				}
    			}
    			// 其他情况不修改单据经办状态
    		}
    	}
    	
    	// 重新查询修改后的列表
    	receiptActorList = bizReceiptActorDao.selectByReceiptTypeAndReceiptCode(actorCo.getReceiptType(), actorCo.getReceiptCode());
    	boolean isTodoStatusExist = receiptActorList.stream().anyMatch(item -> item.getReceiptStatus().equals(RECEIPT_STATUS.TODO.value()));
    	if (!isTodoStatusExist) {
    		// 不存在todo状态的经办记录，则说明由于手持端签字修改了待办经办
    		// 需要继续判断是否所有的经办都已经办结
    		boolean isAllDone = receiptActorList.stream().allMatch(item -> item.getProcessStatus().equals(PROCESS_STATUS.DONE.value()));
    		if (!isAllDone) {
    			// 存在处理状态为【处理中】的经办人或经办岗位，找到它们并将postIndex最小的其设置为待办状态
    			BizReceiptActorVo tempVo = receiptActorList.stream()
						.filter(item -> item.getProcessStatus().equals(PROCESS_STATUS.PROCESSING.value()))
						.min(Comparator.comparing(BizReceiptActorVo::getPostIndex)).get();
    			// 修改相同岗位的所有经办人状态为待办
    			BizReceiptActorKey actorPrimarykey = new BizReceiptActorKey();
    			actorPrimarykey.setReceiptType(tempVo.getReceiptType());
    			actorPrimarykey.setReceiptCode(tempVo.getReceiptCode());
    			actorPrimarykey.setPostCode(tempVo.getPostCode());
    			// 这里更新条件中不要设置操作人，以便对同岗位的其他经办人一并更新
    			bizReceiptActorDao.updateReceiptStatusByPrimaryKey(actorPrimarykey, RECEIPT_STATUS.TODO.value());
    		}
    	}
    	
    	/** ********** 处理经办人待办计数************* */
    	// 重新查询修改后的列表
    	receiptActorList = bizReceiptActorDao.selectByReceiptTypeAndReceiptCode(actorCo.getReceiptType(), actorCo.getReceiptCode());
    	// 经办处于待办状态的，汇总成一个列表，对应的经办人计算待办计数
		List<BizReceiptActorVo> actorTodoList = receiptActorList.stream()
				.filter(item -> item.getReceiptStatus().equals(RECEIPT_STATUS.TODO.value()))
				.collect(Collectors.toList());
		
		actorTodoList.forEach(item -> {
			// 经办人待办计数增加
			this.addTodoNum(item.getOperatorId().toString());
		});
    }
	
	
}
