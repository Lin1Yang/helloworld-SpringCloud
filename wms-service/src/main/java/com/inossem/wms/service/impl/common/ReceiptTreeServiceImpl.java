package com.inossem.wms.service.impl.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inossem.wms.common.ReceiptKey;
import com.inossem.wms.common.ReceiptRidKey;
import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.dao.biz.BizStockInputMapper;
import com.inossem.wms.dao.rel.RelReceiptRidMapper;
import com.inossem.wms.enums.EnumEnable;
import com.inossem.wms.enums.EnumReceiptTreeType;
import com.inossem.wms.enums.EnumReturnCode;
import com.inossem.wms.model.rel.RelReceiptRidKey;
import com.inossem.wms.service.common.ICommonService;
import com.inossem.wms.service.common.IReceiptTreeService;
import com.inossem.wms.vo.rel.RelReceiptRidVo;

@Service
public class ReceiptTreeServiceImpl implements IReceiptTreeService {
	@Autowired
	protected RelReceiptRidMapper relReceiptRidDao;
	
	@Autowired
	protected ICommonService commonServiceSubImpl;
	
	@Autowired
	protected BizStockInputMapper bizStockInputMapper;
	

	
	
	
	

	/**
	 * 新增单据凭证流
	 * @author lys
	 */
	@Override
	public void addReceiptTree(RelReceiptRidKey rel) throws WMSException {
		try {
			relReceiptRidDao.insertSelective(rel);
		} catch (Exception e) {
			throw new WMSException(EnumReturnCode.RETURN_CODE_REL_RECEIPT_RID_GENERATE_FAILURE);
		}
			
	}
	
	/**
	 * 批量新增单据流
	 * @author lys
	 */	
	@Override
	public void addReceiptTree(List<RelReceiptRidKey> list) throws WMSException {
		try {
			relReceiptRidDao.insertReceiptTree(list);
		} catch (Exception e) {
			throw new WMSException(EnumReturnCode.RETURN_CODE_REL_RECEIPT_RID_GENERATE_FAILURE);
		}
	}
	

	/**
	 * 删除单据流
	 * @author cdq
	 */
	@Override
	public void deleteReceiptTree(Integer receiptType,String receiptCode) throws WMSException {
		
		relReceiptRidDao.deleteByTypeAndCode( receiptType,receiptCode);
		
	}
	

	@Override
	public void deleteReceiptRidTree(Integer receiptType, String receiptCode, List<String> receiptRidList)
			throws WMSException {
		
		relReceiptRidDao.deleteByTypeAndCodeAndRidList(receiptType, receiptCode, receiptRidList);
	}
	
	
	/**
	 * 查询单据凭证流(树形)
	 * @author hsp
	 */
	@Override
	public List<RelReceiptRidVo> getReceiptTree(Integer receiptType, String receiptCode,List<String> receiptRidList) throws WMSException {
		//单据关系还是单据行关系
		boolean relReceipt;
		
		//判断是查询单据关系树还是单据行关系树
		if (receiptRidList == null || receiptRidList.size() == 0) {
			receiptRidList = null;
			relReceipt = true;
		} else {
			// 去重排序
			receiptRidList = receiptRidList.stream().distinct().sorted().collect(Collectors.toList());
			relReceipt = false;
		}
		
		List<RelReceiptRidVo> voList = new ArrayList<RelReceiptRidVo>();		
	
		//递归下级节点
		if (relReceipt) {
			//单据关系树
			//祖先和后裔都是树结构，都是以当前单据为根节点，对应的祖先树是反向树，后裔树是正向树
			
			RelReceiptRidVo ancestor = new RelReceiptRidVo();
			ancestor.setReceiptType(receiptType);
			ancestor.setReceiptCode(receiptCode);
			ancestor.setSelf(EnumEnable.ENABLE.getValue());
			ancestor.setChildrenList(new ArrayList<RelReceiptRidVo>());	
			
			this.setPropertiesForRelReceiptRidVo(ancestor);
			//向祖先递归
			this.getChildNodesByReceipt(0,true, ancestor);
			
			RelReceiptRidVo descendant = new RelReceiptRidVo();
			descendant.setReceiptType(receiptType);
			descendant.setReceiptCode(receiptCode);
			descendant.setSelf(EnumEnable.ENABLE.getValue());
			descendant.setChildrenList(new ArrayList<RelReceiptRidVo>());	
			
			this.setPropertiesForRelReceiptRidVo(descendant);
			//向后裔递归
			this.getChildNodesByReceipt(0,false, descendant);
			
			ancestor.setTopDown(EnumReceiptTreeType.BOTTOM_UP.getValue());
			descendant.setTopDown(EnumReceiptTreeType.TOP_DOWN.getValue());
			voList.add(ancestor);
			voList.add(descendant);
		} else {
			//单据行关系树
			for (String receiptRid : receiptRidList) {				
				RelReceiptRidVo vo = new RelReceiptRidVo();
				vo.setReceiptType(receiptType);
				vo.setReceiptCode(receiptCode);
				vo.setReceiptRid(receiptRid);
				vo.setSelf(EnumEnable.ENABLE.getValue());
				vo.setChildrenList(new ArrayList<RelReceiptRidVo>());				
				voList.add(vo);
			}

			//祖先单据行关系是一个线，后裔单据行关系是一个树
			//祖先关系和后裔关系可以连城一个树，当前单据之前是线，之后是树
			//由于是一个关系树，所以当前单据行对象必须是一个
			
			
			//先递归后裔后递归祖先，因为祖先递归之后当前节点已经不在voList中
			this.setPropertiesForRelReceiptRidVoList(receiptType,receiptCode,voList);
			//向后裔递归
			this.getDescendantNodesByReceiptRid(0,voList);			
			
			this.setPropertiesForRelReceiptRidVoList(receiptType,receiptCode,voList);
			//向祖先递归
			this.getAncestorNodesByReceiptRid(0,voList);
			
			for (RelReceiptRidVo relReceiptRidVo : voList) {
				relReceiptRidVo.setTopDown(EnumReceiptTreeType.TOP_DOWN.getValue());
			}	
		}
		
		return voList;
	}
	
	
	/**
	 * 递归子节点
	 * @param recursions
	 * @param current
	 * @param preReceiptType
	 * @param preReceiptCode
	 * @param receiptRidList
	 */
	private void getChildNodesByReceipt(int recursions, boolean ancestor, RelReceiptRidVo current) {
		int maxRecursions = 10;
		if (++recursions > maxRecursions) {
			return;
		}
		List<ReceiptKey> receiptKeyList ;
		if (ancestor) {
			// 获取所有父单据
			receiptKeyList = relReceiptRidDao.selectByReceipt(current.getReceiptType(),
								current.getReceiptCode());
		} else {
			// 获取所有子单据
			receiptKeyList = relReceiptRidDao.selectByPreReceipt(current.getReceiptType(),
					current.getReceiptCode());
		}
		
		if (receiptKeyList != null && receiptKeyList.size() > 0) {
			current.setChildrenList(new ArrayList<RelReceiptRidVo>());
			// 循环每个子单据
			for (ReceiptKey receiptKey : receiptKeyList) {
				RelReceiptRidVo child = new RelReceiptRidVo();
				child.setReceiptType(receiptKey.getReceiptType());
				child.setReceiptCode(receiptKey.getReceiptCode());
				current.getChildrenList().add(child);
				this.setPropertiesForRelReceiptRidVo(child);
				this.getChildNodesByReceipt(recursions,ancestor, child);
			}
		}
	}
	
	/**
	 * 递归子节点
	 * @param recursions
	 * @param current
	 * @param preReceiptType
	 * @param preReceiptCode
	 * @param receiptRidList
	 */
	private void getAncestorNodesByReceiptRid(int recursions, List<RelReceiptRidVo> currentList) {
		int maxRecursions = 10;	
		if(++recursions > maxRecursions){
			return;
		} 
		
		// 获取所有父单据行
		List<RelReceiptRidVo> relReceiptRidKeyList =			
			relReceiptRidDao.selectByReceiptRid(currentList.get(0).getReceiptType(),
					currentList.get(0).getReceiptCode(),
					currentList.stream().map(key -> key.getReceiptRid()).collect(Collectors.toList()));

		if (relReceiptRidKeyList == null || relReceiptRidKeyList.size() <= 0) {
			return;
		}
		
		// 以子单据Rid分组
		Map<ReceiptRidKey, List<RelReceiptRidVo>> receiptRidKeyMap;		

			receiptRidKeyMap = relReceiptRidKeyList.stream()
					.collect(Collectors.groupingBy(
							receipt -> new ReceiptRidKey(receipt.getReceiptType(),receipt.getReceiptCode(), receipt.getReceiptRid()),
							Collectors.toList()));
		// 下级单据列表初始化
		for (int i = 0; i < currentList.size(); ++i) {
			RelReceiptRidVo current = currentList.get(i);
			List<RelReceiptRidVo> list = receiptRidKeyMap.get(
					new ReceiptRidKey(current.getReceiptType(), current.getReceiptCode(), current.getReceiptRid()));
			if (list != null && list.size() > 0) {
				if (list.size() > 1) {
					// TODO
					throw new WMSException(EnumReturnCode.RETURN_CODE_PRE_RECEIPT_RID_MUST_BE_UNIQUE,current.getReceiptCode(), current.getReceiptRid());
				}
				RelReceiptRidVo next = list.get(0);
				next.setReceiptType(next.getPreReceiptType());
				next.setReceiptCode(next.getPreReceiptCode());
				next.setReceiptRid(next.getPreReceiptRid());
				next.setPreReceiptType(null);
				next.setPreReceiptCode(null);
				next.setPreReceiptRid(null);
				// 祖先逆向递归
				next.setChildrenList(new ArrayList<RelReceiptRidVo>());
				// 对象值替换
				RelReceiptRidVo.exchangeProperties(current, next);
				current.getChildrenList().add(next);
				// 递归
				List<RelReceiptRidVo> tmpList = new ArrayList<RelReceiptRidVo>();
				tmpList.add(current);
				this.setPropertiesForRelReceiptRidVoList(current.getReceiptType(), current.getReceiptCode(), tmpList);
				this.getAncestorNodesByReceiptRid(recursions, tmpList);
			}
		}	
	}
	
	/**
	 * 递归子节点
	 * @param recursions
	 * @param current
	 * @param preReceiptType
	 * @param preReceiptCode
	 * @param receiptRidList
	 */
	private void getDescendantNodesByReceiptRid(int recursions, List<RelReceiptRidVo> currentList) {
		int maxRecursions = 10;	
		if(++recursions > maxRecursions){
			return;
		} 
		// 获取所有子单据行
		List<RelReceiptRidVo> relReceiptRidKeyList =
			relReceiptRidDao.selectByPreReceiptRid(currentList.get(0).getReceiptType(),
					currentList.get(0).getReceiptCode(),
					currentList.stream().map(key -> key.getReceiptRid()).collect(Collectors.toList()));
		
		if (relReceiptRidKeyList == null || relReceiptRidKeyList.size() <= 0) {
			return;
		}
		
		// 以子单据Rid分组
		Map<ReceiptRidKey, List<RelReceiptRidVo>> receiptRidKeyMap;		
	
		receiptRidKeyMap = relReceiptRidKeyList.stream()
					.collect(Collectors.groupingBy(
							receipt -> new ReceiptRidKey(receipt.getPreReceiptType(),receipt.getPreReceiptCode(), receipt.getPreReceiptRid()),
							Collectors.toList()));
		// 下级单据列表初始化
		for (int i = 0; i < currentList.size(); ++i) {
			RelReceiptRidVo current = currentList.get(i);
			List<RelReceiptRidVo> list = receiptRidKeyMap.get(
					new ReceiptRidKey(current.getReceiptType(), current.getReceiptCode(), current.getReceiptRid()));
			if (list != null && list.size() > 0) {
				if(current.getChildrenList()==null){
					current.setChildrenList(new ArrayList<RelReceiptRidVo>());
				}
				for (RelReceiptRidVo next : list) {
					// 子孙正向递归					
					current.getChildrenList().add(next);
				}
			}
		}

		// 以下级单据分组
		Map<ReceiptKey, List<RelReceiptRidVo>> receiptKeyMap = relReceiptRidKeyList.stream()
				.collect(Collectors.groupingBy(
						receipt -> new ReceiptKey(receipt.getReceiptType(), receipt.getReceiptCode()),
						Collectors.toList()));

		// 循环每个下级单据
		for (ReceiptKey receiptKey : receiptKeyMap.keySet()) {
			List<RelReceiptRidVo> list = receiptKeyMap.get(receiptKey);
			if (list != null && list.size() > 0) {
				this.setPropertiesForRelReceiptRidVoList(receiptKey.getReceiptType(), receiptKey.getReceiptCode(),
						list);
				this.getDescendantNodesByReceiptRid(recursions, list);
			}
		}	
	}
	
	private void setPropertiesForRelReceiptRidVo(RelReceiptRidVo vo) {
		RelReceiptRidVo temp = null;
		if (commonServiceSubImpl.isInput(vo.getReceiptType())) {
			temp = bizStockInputMapper.selectRelReceiptRidVoByReceipt(vo);
		} else if (commonServiceSubImpl.isOutput(vo.getReceiptType())) {
			temp = new RelReceiptRidVo();
		} 
		if (temp != null) {
			//UtilBean.getBean(temp, vo);
			vo.setCreateTime(temp.getCreateTime());
			vo.setCreateUserId(temp.getCreateUserId());
			vo.setCreateUserCode(temp.getCreateUserCode());
			vo.setCreateUserName(temp.getCreateUserName());
			vo.setReceiptStatus(temp.getReceiptStatus());
			vo.setItemStatus(temp.getItemStatus());
		}
	}

	private void setPropertiesForRelReceiptRidVoList(Integer receiptType,String receiptCode,List<RelReceiptRidVo> list) {
		List<RelReceiptRidVo> tempList = null;
		if (commonServiceSubImpl.isInput(receiptType)) {
			tempList = bizStockInputMapper.selectRelReceiptRidVoByReceiptRid(receiptType,receiptCode,list.stream().map(key -> key.getReceiptRid()).collect(Collectors.toList()));
		} else if (commonServiceSubImpl.isOutput(receiptType)) {
			tempList = new ArrayList<RelReceiptRidVo>();
		} 
		if (tempList == null || tempList.size() <= 0) {
			return;
		}
		Map<ReceiptKey, List<RelReceiptRidVo>> receiptKeyMap = tempList.stream()
				.collect(Collectors.groupingBy(
						receipt -> new ReceiptKey(receipt.getReceiptType(), receipt.getReceiptCode()),
						Collectors.toList()));
		
		for (RelReceiptRidVo relReceiptRidVo : list) {
			List<RelReceiptRidVo> l = receiptKeyMap
					.get(new ReceiptKey(relReceiptRidVo.getReceiptType(), relReceiptRidVo.getReceiptCode()));
			if (l != null && l.size() > 0) {
				RelReceiptRidVo temp = l.get(0);
				if (temp != null) {
					//UtilBean.getBean(vo, relReceiptRidVo);		
					relReceiptRidVo.setCreateTime(temp.getCreateTime());
					relReceiptRidVo.setCreateUserId(temp.getCreateUserId());
					relReceiptRidVo.setCreateUserCode(temp.getCreateUserCode());
					relReceiptRidVo.setCreateUserName(temp.getCreateUserName());
					relReceiptRidVo.setReceiptStatus(temp.getReceiptStatus());
					relReceiptRidVo.setItemStatus(temp.getItemStatus());
				}
			}
		}
	}
}
