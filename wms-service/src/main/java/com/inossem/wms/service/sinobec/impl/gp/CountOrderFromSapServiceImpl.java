package com.inossem.wms.service.sinobec.impl.gp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.inossem.wms.co.dic.DicWhStorageBinListCo;
import com.inossem.wms.common.auth.CurrentUser;
import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.constant.MessageConstants;
import com.inossem.wms.dao.sinobec.gp.CountOrderFromSapMapper;
import com.inossem.wms.enums.EnumStockTakeType;
import com.inossem.wms.model.sinobec.gp.CountOrderFromSap;
import com.inossem.wms.model.sinobec.gp.ResponseInfo;
import com.inossem.wms.service.sinobec.gp.ICountOrderFromSapService;
import com.inossem.wms.service.stocktake.IBizStockTakeService;
import com.inossem.wms.vo.take.BizStockTakeDataVo;
import com.inossem.wms.vo.take.BizStockTakeHeadVo;
import com.inossem.wms.vo.take.BizStockTakeItemVo;


@Service
public class CountOrderFromSapServiceImpl implements ICountOrderFromSapService {

	private static final Logger log = LoggerFactory.getLogger(CountOrderFromSapServiceImpl.class);
	
	@Autowired
	private CountOrderFromSapMapper countOrderFromSapMapper;
	
	@Autowired
	private IBizStockTakeService bizStockTakeService;// 盘点 
	
	@Override
	public List<CountOrderFromSap> getCountOrder(CountOrderFromSap countOrderFromSap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public ResponseInfo startCountOrders(List<CountOrderFromSap> inputList, int chunkSize) { 
		List<String> rejectablePoCodeList = null;
		List<String> cOrderList = null;
		String exceptionMessage = null;
		
		int[] result = {0};
		
		try {
			cOrderList = inputList.stream()
								  .map(co -> co.getCountOrder()).distinct()
								  .collect(Collectors.toList());
			
			rejectablePoCodeList = countOrderFromSapMapper.selectRejectableByCoAndStatus(cOrderList);
			
			if(!CollectionUtils.isEmpty(rejectablePoCodeList)) {
				cOrderList.removeAll(rejectablePoCodeList);
			}
			
			if(!CollectionUtils.isEmpty(cOrderList)) {
				
				Set<String> selectedCountOrderSet = new HashSet<>(cOrderList);
				
				List<CountOrderFromSap> filteredInputList = inputList.stream()
																	 .filter(co -> selectedCountOrderSet.contains(co.getCountOrder()))
																	 .collect(Collectors.toList());
				// start splitting outputList to multiple list with chunk size = {chunkSize}
				List<List<CountOrderFromSap>> insertLists = Lists.partition(filteredInputList, chunkSize);

				insertLists.forEach(chunkList ->{ 
					result[0] += countOrderFromSapMapper.insertList(chunkList);
				});
				
				this.createStockTake(filteredInputList);
				
				log.info("Start count order for number of records: " + result);
				
			}
			
		} catch (Exception e) {
			
			log.error("error occurs when Starting count order", e);
			
			exceptionMessage = "WMS database exception: "+ e.getMessage();
			
		};
		
		
		return new ResponseInfo(MessageConstants.API_NAME_STOCK_TAKE, cOrderList, rejectablePoCodeList, 
				cOrderList.size()>0 ?cOrderList.get(0): null, rejectablePoCodeList.size() > 0 ? rejectablePoCodeList.get(0): null, exceptionMessage);
		
	}
	
	// predicate to filter the duplicates by the given key extractor.
	private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> uniqueMap = new ConcurrentHashMap<>();
		return t -> uniqueMap.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	private void createStockTake(List<CountOrderFromSap> filteredInputList ) {
		CurrentUser user = new CurrentUser();
		user.setUserId(1);
		user.setUserName("admin");
		
		BizStockTakeDataVo bizStockTakeDataVo = new BizStockTakeDataVo();
		bizStockTakeDataVo.setDocumentNumber( filteredInputList.get(0).getCountOrder());
		
		DicWhStorageBinListCo bin = new DicWhStorageBinListCo();
		bin.setStockTakeType(EnumStockTakeType.STOCK_TAKE_TYPE_CYCLE.getName());
		
		List<BizStockTakeItemVo> tempItemList = new ArrayList<>();
		filteredInputList.forEach(co ->{
			
			bin.setMatCode(co.getMatCode());
			bin.setLotNumb(co.getLotNumb());
			bin.setExt0(co.getExt0());
			bin.setExt1(co.getExt1());
			
			tempItemList.addAll(bizStockTakeService.getStorageBinList(bin));

		});
	
//		List<BizStockTakeItemVo> itemList = tempItemList.stream()
//												.filter(distinctByKey(item -> item.getBinCode()))
//												.collect(Collectors.toList());
		List<BizStockTakeItemVo> itemList = tempItemList.stream()  
				.collect(Collectors.collectingAndThen  
				(Collectors.toCollection(() ->  
				new TreeSet<>(Comparator.comparing(t -> t.getBinCode()+t.getTypeCode()))),  
				ArrayList::new  
				)  
				);
//		List<BizStockTakeItemVo> itemList = new ArrayList<BizStockTakeItemVo>();
//		itemList.add(tempItemList.get(0));
//		for (BizStockTakeItemVo tmp : tempItemList) {
//			itemList.add(tmp);
//		
//		}
		

		if(!CollectionUtils.isEmpty(itemList)) {
			itemList.forEach(item -> {
				item.setIsDelete((byte)0);
				item.setStockTakeUser("");
			});
			
			bizStockTakeDataVo.setItemList(itemList);
			BizStockTakeHeadVo head = new BizStockTakeHeadVo();
			head.setReceiptStatus(bizStockTakeDataVo.getItemList().get(0).getReceiptStatus());
			head.setStockTakeDate(new Date());
			head.setStockTakeType(EnumStockTakeType.STOCK_TAKE_TYPE_CYCLE.getName());
			head.setStockTakeMode((byte)1);
			head.setSaveOrUpdate((byte) 10);
			bizStockTakeDataVo.setHead(head);
			
			try {
				
				bizStockTakeService.saveOrUpdateStockTakeData(bizStockTakeDataVo, user);
				
			} catch (Exception e) {
				log.error("error occurs when Starting count order", e);
				
				throw  new WMSException();
			}
		}
	}
	
	@Override
	public ResponseInfo deleteCountOrders(List<String> countOrders) {
		// TODO Auto-generated method stub
		return null;
	}

}
