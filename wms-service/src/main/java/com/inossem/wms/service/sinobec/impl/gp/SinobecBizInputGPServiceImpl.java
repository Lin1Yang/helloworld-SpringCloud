package com.inossem.wms.service.sinobec.impl.gp;

import com.google.common.collect.Lists;
import com.inossem.wms.constant.MessageConstants;
import com.inossem.wms.dao.sinobec.gp.SinobecBizInputGPMapper;
import com.inossem.wms.model.sinobec.gp.ResponseInfo;
import com.inossem.wms.model.sinobec.gp.SinobecBizInputGP;
import com.inossem.wms.service.sinobec.gp.ISinobecBizInputGPService;

import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author myk
 * @Description //入库假接口
 * @Date 10:10 2020/3/23
 * @Param
 * @return
 **/
@Service
public class SinobecBizInputGPServiceImpl implements ISinobecBizInputGPService {

	private static final Logger log = LoggerFactory.getLogger(SinobecBizInputGPServiceImpl.class);
	
    @Autowired
    private SinobecBizInputGPMapper sinobecBizInputGPMapper;

    @Override
    public List<SinobecBizInputGP> getSinobecBizInputGP(SinobecBizInputGP gp) {
        return sinobecBizInputGPMapper.selectList(gp);
    }

	/**
	 * Save or Update records in the table according to list provided
	 * @Author Yong Xiao
	 */
	@Transactional
	@Override
	public ResponseInfo synPoReceiverPartially(List<SinobecBizInputGP> inputList, int chunkSize, boolean needUpdateRid){
		
		List<String> rejectablePoCodeList = null;
		List<String> poCodeList = null;
		String exceptionMessage = null;
		
		int[] result = {0};
		
		try {
			poCodeList = inputList.stream()
								  .map(po -> po.getPoCode()).distinct()
								  .collect(Collectors.toList());
			
			rejectablePoCodeList = sinobecBizInputGPMapper.selectRejectableByPoCodeAndStatus(poCodeList);
			
			if(!CollectionUtils.isEmpty(rejectablePoCodeList)) {
				poCodeList.removeAll(rejectablePoCodeList);
			}
			
			if(!CollectionUtils.isEmpty(poCodeList)) {
				sinobecBizInputGPMapper.deleteInputDocuments(poCodeList);
			
				Set<String> removablePoCodeSet = new HashSet<>(poCodeList);
				
				List<SinobecBizInputGP> filteredInputList = inputList.stream()
																	 .filter(po -> removablePoCodeSet.contains(po.getPoCode()))
																	 .collect(Collectors.toList());
				
				// start splitting outputList to multiple list with chunk size = {chunkSize}
				List<List<SinobecBizInputGP>> insertLists = Lists.partition(filteredInputList, chunkSize);
				
				insertLists.forEach(chunkList ->{ 
					result[0] += sinobecBizInputGPMapper.insertList(chunkList);
				});
				
				if(needUpdateRid) {
					sinobecBizInputGPMapper.updateRId();
				}
				
				log.info("Synchonized SinobecBizInputGP for number of records: " + result);
			}
			
		} catch (Exception e) {
			
			log.error("error occurs when synchronizing SinobecBizInputGP", e);
			
			exceptionMessage = "WMS database exception: "+ e.getMessage();
			
		}
		
		return new ResponseInfo(MessageConstants.API_NAME_SYNC_PO_RECEIVER, poCodeList, rejectablePoCodeList, 
				poCodeList.size()>0 ?poCodeList.get(0): null, rejectablePoCodeList.size() > 0 ?rejectablePoCodeList.get(0): null, exceptionMessage);
		
	}

	/**
	 * Delete records by list of poCode
	 * @Author Yong Xiao
	 */
	@Transactional
	@Override
	public ResponseInfo deleteInputDocuments(List<String> poCodes) {
		
		List<String> rejectablePoCodeList = null;
		String exceptionMessage = null;
		
		try {
			
			rejectablePoCodeList = sinobecBizInputGPMapper.selectRejectableByPoCodeAndStatus(poCodes);
			
			if(!CollectionUtils.isEmpty(rejectablePoCodeList)) {
				poCodes.removeAll(rejectablePoCodeList);
			}
			
			if(!CollectionUtils.isEmpty(poCodes)) {
				sinobecBizInputGPMapper.deleteInputDocuments(poCodes);
			}
			
		} catch (Exception e) {
			
			log.error("error occurs when synchronizing SinobecBizInputGP", e);
			
			exceptionMessage = "WMS database exception: "+ e.getMessage();
			
		}
		
		return new ResponseInfo(MessageConstants.API_NAME_SYNC_PO_RECEIVER_DELETION, poCodes, rejectablePoCodeList,
				poCodes.size()>0 ?poCodes.get(0): null, rejectablePoCodeList.size() > 0 ?rejectablePoCodeList.get(0): null, exceptionMessage);
		
	}
}
