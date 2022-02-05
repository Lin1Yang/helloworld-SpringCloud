package com.inossem.wms.service.impl.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.inossem.wms.common.util.UtilConst;
import com.inossem.wms.dao.biz.BizReceiptItemImgMapper;
import com.inossem.wms.dao.file.ImgFileMapper;
import com.inossem.wms.model.biz.BizReceiptItemImg;
import com.inossem.wms.model.biz.BizReceiptItemImgVo;
import com.inossem.wms.model.biz.IBizReceiptItem;
import com.inossem.wms.service.common.IBizReceiptItemImgService;

@Transactional
@Service
/**
 * 各单据行项目号对应的图片服务层
 * @author cdq
 *
 */
public class BizReceiptItemImgServiceImpl implements IBizReceiptItemImgService {

	@Autowired
	protected BizReceiptItemImgMapper bizReceiptItemImgDao;
	@Autowired
	protected ImgFileMapper imgFileDao;

	/**
	 * 新增单据图片信息
	 */
	@Override
	public void addBizReceiptItemImg(Integer receiptType, String receiptCode, String receipt_rid, String file_code,
			Integer userid) {
		if(file_code==null || "".equals(file_code)) {
			return;
		}
		BizReceiptItemImg receiptItemImg = new BizReceiptItemImg();
		receiptItemImg.setReceiptType(receiptType);
		receiptItemImg.setReceiptCode(receiptCode);
		receiptItemImg.setReceiptRid(receipt_rid);
		receiptItemImg.setFileCode(file_code);
		receiptItemImg.setCreateUserId(userid);
		receiptItemImg.setModifyUserId(userid);
		bizReceiptItemImgDao.insertSelective(receiptItemImg);
		
	}
	/**
	 * 查询单据图片信息
	 */
	@Override
	public List<BizReceiptItemImgVo> getBizReceiptItemImgList(Integer receiptType, String receiptCode,
			String receipt_rid) {
		BizReceiptItemImg receiptItemImg = new BizReceiptItemImg();
		receiptItemImg.setReceiptType(receiptType);
		receiptItemImg.setReceiptCode(receiptCode);
		receiptItemImg.setReceiptRid(receipt_rid);
		List<BizReceiptItemImgVo> list = bizReceiptItemImgDao.selectByCondition(receiptItemImg);
		String fileRootPath = UtilConst.getInstance().getFilePath();
		for(BizReceiptItemImgVo vo:list) {
			//因为图片有很多类型 没法指定前端指定要哪样图片   
			//所以absolutepath就如"C:\Users\cdq\Desktop\img"
			vo.setAbsolutePath(fileRootPath+vo.getPath());
		}
		return list;
	}

	@Override
	public List<BizReceiptItemImgVo> getBizReceiptItemImgList(List<BizReceiptItemImg> imgList) {
		List<BizReceiptItemImgVo> list = bizReceiptItemImgDao.selectByReceiptList(imgList);
		String fileRootPath = UtilConst.getInstance().getFilePath();
		for(BizReceiptItemImgVo vo:list) {
			//因为图片有很多类型 没法指定前端指定要哪样图片
			//所以absolutepath就如"C:\Users\cdq\Desktop\img"
			vo.setAbsolutePath(fileRootPath+vo.getPath());
		}
		return list;
	}

	/**
	 * 批量插入单据图片信息
	 */
	/*@Override
	public void batchSaveBizReceiptItemImg(List<BizReceiptItemImgVo> list,Integer receiptType, String receiptCode, String receiptRid,Integer userid) {
		// 之前保存过图片,删除图片后不添加新图片,点保存时list为空
		BizReceiptItemImgVo voo = new BizReceiptItemImgVo();
		voo.setReceiptType(receiptType);
		voo.setReceiptCode(receiptCode);
		voo.setReceiptRid(receiptRid);
		bizReceiptItemImgDao.delByCondition(voo);
		if(list==null || list.size()==0) {
			return;
		}
		Iterator<BizReceiptItemImgVo> iterator = list.iterator();
		while (iterator.hasNext()) {
			BizReceiptItemImgVo vo = iterator.next();
			if(vo.getImgCode()!=null &&!"".equals(vo.getImgCode())) {
				vo.setFileCode(vo.getImgCode());
			}
			vo.setReceiptType(receiptType);
			vo.setReceiptCode(receiptCode);
			vo.setReceiptRid(receiptRid);
			vo.setCreateUserId(userid);
			vo.setModifyUserId(userid);
			
		}
		bizReceiptItemImgDao.insertBatch(list);
	}*/

	@Override
	public void insertBizReceiptItemImgList(List<BizReceiptItemImgVo> insertList) {
		if (!CollectionUtils.isEmpty(insertList)) {
			bizReceiptItemImgDao.insertBatch(insertList);
		}
	}

	@Override
	public void deleteBizReceiptItemImgList(List<BizReceiptItemImgVo> deleteList) {
		if (!CollectionUtils.isEmpty(deleteList)){
			bizReceiptItemImgDao.deleteByReceiptList(deleteList);
		}
	}

	/*
	 * 填充行项目列表中所有item的图片列表信息
	 *
	 * @author 李斌
	 * @see com.inossem.wms.service.common.IBizReceiptItemImgService#fillBizReceiptItemImg(java.util.List, java.lang.Integer, java.lang.String)
	 */
	@Override
	public List<? extends IBizReceiptItem> fillBizReceiptItemImg(List<? extends IBizReceiptItem> itemList, Integer receiptType, String receiptCode) {

		BizReceiptItemImg receiptItemImg = new BizReceiptItemImg();
		receiptItemImg.setReceiptType(receiptType);
		receiptItemImg.setReceiptCode(receiptCode);
		List<BizReceiptItemImgVo> list = bizReceiptItemImgDao.selectByCondition(receiptItemImg);
		String fileRootPath = UtilConst.getInstance().getFilePath();
		for (BizReceiptItemImgVo vo : list) {
			// 因为图片有很多类型 没法指定前端指定要哪样图片
			// 所以absolutepath就如"C:\Users\cdq\Desktop\img"
			vo.setAbsolutePath(fileRootPath + vo.getPath());
		}

		// 按照rid对imgList进行分组
		Map<String, List<BizReceiptItemImgVo>> itemImgMap = list.stream().collect(Collectors.groupingBy(BizReceiptItemImgVo::getReceiptRid));

		for (IBizReceiptItem receiptItem : itemList) {
			for (String key : itemImgMap.keySet()) {
				if (receiptItem.getReceiptItemRid().equals(key)) {
					receiptItem.setImgList(itemImgMap.get(key));
					break; // 找到对应rid的imgList， 放入到对应item的imgList中
				}
			}
		}
		return itemList;
	}

	@Override
	public List<? extends IBizReceiptItem> saveBizReceiptItemImg(List<? extends IBizReceiptItem> itemList, Integer receiptType, String receiptCode, List<String> ridList,Integer createUserId) {
		//删除之前图片
		if (!CollectionUtils.isEmpty(ridList)){
			List<BizReceiptItemImgVo> deleteList = new ArrayList<>();
			for(String rid : ridList){
				BizReceiptItemImgVo itemImgVo = new BizReceiptItemImgVo();
				itemImgVo.setReceiptType(receiptType);
				itemImgVo.setReceiptCode(receiptCode);
				itemImgVo.setReceiptRid(rid);
				deleteList.add(itemImgVo);
			}
			bizReceiptItemImgDao.deleteByReceiptList(deleteList);
		}

		//重新插入图片
		if (!CollectionUtils.isEmpty(itemList)) {
			List<BizReceiptItemImgVo> insertList = new ArrayList<>();
			for (IBizReceiptItem receiptItem : itemList) {
				List<BizReceiptItemImgVo> list = receiptItem.getImgList();
				if (CollectionUtils.isEmpty(list)){
					list = new ArrayList<>();
				}
				Iterator<BizReceiptItemImgVo> iterator = list.iterator();
				while (iterator.hasNext()) {
					BizReceiptItemImgVo vo = iterator.next();
					if (StringUtils.hasText(vo.getImgCode())) {
						vo.setFileCode(vo.getImgCode());
					}
					vo.setReceiptType(receiptItem.getReceiptType());
					vo.setReceiptCode(receiptItem.getReceiptCode());
					vo.setReceiptRid(receiptItem.getReceiptItemRid());
					vo.setCreateUserId(createUserId);
					vo.setModifyUserId(createUserId);
					insertList.add(vo);
				}
			}
			if (!CollectionUtils.isEmpty(insertList)) {
				bizReceiptItemImgDao.insertBatch(insertList);
			}
		}

		return null;
	}

}
