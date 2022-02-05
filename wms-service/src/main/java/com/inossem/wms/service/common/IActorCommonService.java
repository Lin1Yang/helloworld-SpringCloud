package com.inossem.wms.service.common;

import com.inossem.wms.co.actor.ActorGroupCo;
import com.inossem.wms.co.biz.BizReceiptActorCo;
import com.inossem.wms.common.auth.CurrentUser;
import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.model.actor.ActorGroupPost;
import com.inossem.wms.vo.actor.ActorGroupVo;
import com.inossem.wms.vo.actor.ActorPostUserVo;
import com.inossem.wms.vo.actor.BizReceiptActorVo;

import java.util.List;

public interface IActorCommonService {
	
	/**
	 * 根据单据类型、单据号查询经办人
	 * 
	 * @author lys 
	 * @return
	 * @throws WMSException
	 */
	List<ActorPostUserVo> getReceiptActorList(Integer receiptType,String receiptCode) throws WMSException;
	
	/**
	 * 根据单据类型、单据号物理删除经办人
	 * 
	 * @author lys 
	 * @return
	 * @throws WMSException
	 */
	void removeReceiptActorList(Integer receiptType,String receiptCode) throws WMSException;
	
	/**
	 * 根据单据类型、单据号逻辑删除经办人
	 * 
	 * @author lys 
	 * @return
	 * @throws WMSException
	 */
	void deleteReceiptActorList(Integer receiptType,String receiptCode) throws WMSException;
	
	/**
	 * 业务单据保存经办人
	 * 
	 * @author lys 2019年1月2日14:39:06
	 * @return
	 * @throws WMSException
	 */
	void saveReceiptActorList(Integer receiptType,String receiptCode,Integer userId,List<ActorPostUserVo> actorList) throws WMSException;
	
	/**
	 * 根据单据类型查询默认的岗位列表以及人员列表
	 * 
	 * @author lys 2019年1月2日14:39:11
	 * @return
	 * @throws WMSException
	 */
	ActorGroupVo getDefaultActorGroupVo(Integer receiptType, CurrentUser currentUser);
	
	List<ActorPostUserVo> getDefaultActorList(Integer receiptType, CurrentUser currentUser);
	
	/**
     * 多条件查询岗位组
     * @param actorGroupCo 查询条件
     * @return
     */
    List<ActorGroupVo> getGroupList(ActorGroupCo actorGroupCo);
    
	List<ActorPostUserVo> getOwnPostUserByGroup(String groupCode);
    
    List<ActorPostUserVo> getCorpPostUserByGroup(String groupCode);
    
    List<ActorGroupPost> getActorGroupPostByGroupCode(List<String> groupCodeList);

    List<BizReceiptActorVo> getReceiptList(BizReceiptActorCo bizReceiptActorCo);

    List<BizReceiptActorVo> getReceiptDetail(BizReceiptActorCo bizReceiptActorCo);

	void doReceiptApproval(BizReceiptActorCo bizReceiptActorCo, CurrentUser user);
	
	/**
	 * 校验公司默认经办人组必填岗位是否全部已填
	 * 
	 * @author lys 
	 * @return
	 * @throws WMSException
	 */
	void checkReceiptRequiredPost(Integer receiptType,List<ActorPostUserVo> actorList,CurrentUser cUser) throws WMSException;
	
}
