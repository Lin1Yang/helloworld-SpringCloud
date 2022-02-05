package com.inossem.wms.service.sinobec.impl.gp;

import com.google.common.collect.Lists;
import com.inossem.wms.constant.MessageConstants;
import com.inossem.wms.dao.sinobec.gp.SinobecBizOutputGpMapper;
import com.inossem.wms.model.sinobec.gp.ResponseInfo;
import com.inossem.wms.model.sinobec.gp.SinobecBizOutputGp;
import com.inossem.wms.service.sinobec.gp.ISinobecBizOutputGPService;

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
 * @ClassName SinobecBizOutputGPServiceImpl
 * @Description 出库假接口
 * @Author wsail
 * @Date 2020/3/23 9:47
 **/
@Service
public class SinobecBizOutputGPServiceImpl implements ISinobecBizOutputGPService {

	private static final Logger log = LoggerFactory.getLogger(SinobecBizOutputGPServiceImpl.class);
	
    @Autowired
    private SinobecBizOutputGpMapper sinobecBizOutputGpMapper;

    @Override
    public List<SinobecBizOutputGp> getSinobecBizOutputGP(SinobecBizOutputGp gp) {
        return sinobecBizOutputGpMapper.selectList(gp);
    }
    

	/**
	 * Save or Update records in the table according to list provided
	 * @Author Yong Xiao
	 */
	@Transactional
	@Override
	public ResponseInfo synSoDeliveryPartially(List<SinobecBizOutputGp> outputList, int chunkSize, boolean needUpdateRid) {
		
		List<String> soCodeList = null;
		List<String> rejectableSoCodeList = null;
		String exceptionMessage = null;
		
		int[] result = {0};
		
		try {
			soCodeList =  outputList.stream()
									.map(so -> so.getSoCode()).distinct()
									.collect(Collectors.toList());
			
			rejectableSoCodeList = sinobecBizOutputGpMapper.selectRejectableBySoCodeAndStatus(soCodeList);
			
			if(!CollectionUtils.isEmpty(rejectableSoCodeList)) {
				
				soCodeList.removeAll(rejectableSoCodeList);
				
			}
			
			if(!CollectionUtils.isEmpty(soCodeList)) {
				
				sinobecBizOutputGpMapper.deleteOutputDocuments(soCodeList);
				
				Set<String> removableSoCodeSet = new HashSet<>(soCodeList);
				
				List<SinobecBizOutputGp> filteredOutputList = outputList.stream()
																	 	.filter(so -> removableSoCodeSet.contains(so.getSoCode()))
																	 	.collect(Collectors.toList());
	
				
				// split outputList to multiple list with chunk size = {chunkSize}
				List<List<SinobecBizOutputGp>> insertLists = Lists.partition(filteredOutputList, chunkSize);
				
				insertLists.forEach(chunkList ->{ 
					result[0] += sinobecBizOutputGpMapper.insertList(chunkList);
				});
				
				if(needUpdateRid) {
					sinobecBizOutputGpMapper.updateRId();
				}
				
				log.info("Synchonized SinobecBizOutputGp for number of records: " + result);
			}
			
		} catch (Exception e) {
			
			log.error("error occurs when synchronizing SinobecBizOutputGp ", e);
			
			exceptionMessage = "WMS database exception: " + e.getMessage();
			
		}

		return new ResponseInfo(MessageConstants.API_NAME_SYNC_SO_DELIVERY, soCodeList, rejectableSoCodeList,
				soCodeList.size()>0 ? soCodeList.get(0) : null, rejectableSoCodeList.size() > 0 ? rejectableSoCodeList.get(0): null, exceptionMessage);
		
	}
	
	
	/**
	 * Delete records by list of soCode
	 * @Author Yong Xiao
	 */
	@Transactional
	@Override
	public ResponseInfo deleteOutputDocuments(List<String> soCodes) {
		
		List<String> rejectableSoCodeList = null;
		String exceptionMessage = null;
		
		try {
			
			rejectableSoCodeList = sinobecBizOutputGpMapper.selectRejectableBySoCodeAndStatus(soCodes);
			
			if(!CollectionUtils.isEmpty(rejectableSoCodeList)) {
				
				soCodes.removeAll(rejectableSoCodeList);
				
			}
			
			if(!CollectionUtils.isEmpty(soCodes)) {
				
				sinobecBizOutputGpMapper.deleteOutputDocuments(soCodes);
			}
			
		} catch(Exception e) {
			
			log.error("error occurs when synchronizing SinobecBizOutputGp ", e);
			
			exceptionMessage = "WMS database exception: " + e.getMessage();
			
		}
		return new ResponseInfo(MessageConstants.API_NAME_SYNC_SO_DELIVERY_DELETION, soCodes, rejectableSoCodeList,
				soCodes.size()>0 ? soCodes.get(0): null, rejectableSoCodeList.size() > 0 ? rejectableSoCodeList.get(0) : null, exceptionMessage);
	}
}
