package com.inossem.wms.service.impl.common;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inossem.wms.common.shiro.MyShiroRealm;
import com.inossem.wms.dao.dic.DicExcelRuleCheckMapper;
import com.inossem.wms.dao.dic.DicExcelRuleHeadMapper;
import com.inossem.wms.dao.dic.DicExcelRuleItemMapper;
import com.inossem.wms.enums.EnumExcelChecke;
import com.inossem.wms.model.dic.DicExcelRuleCheck;
import com.inossem.wms.model.dic.DicExcelRuleHead;
import com.inossem.wms.model.dic.DicExcelRuleItem;
import com.inossem.wms.model.dic.DicExcellCheck;
import com.inossem.wms.service.common.IPoiExcelImportService;


/**
 * POIExcel导入
 * @author 田阳
 * @date 2019年1月11日
 */
@Component
public class PoiExcelImportServiceImpl implements IPoiExcelImportService {
	
	@Autowired
	protected DicExcelRuleHeadMapper dicExcelRuleHeadMapper;
	
	@Autowired
	protected DicExcelRuleItemMapper dicExcelRuleItemMapper;
	
	@Autowired
	protected DicExcelRuleCheckMapper dicExcelRuleCheckMapper;
	
	@SuppressWarnings("resource")
	public void insertExcelData(String url, Integer sheetIndex, String enumExcelType, Class<?> entityClass,List<DicExcellCheck> dicExcellCheck,boolean cutFlag) throws Exception {

		if ("".equals(url)) {
				throw new Exception("文件路径为空!");
		}
			
		//获取要导入的配置信息
		List<DicExcelRuleHead> DicExcelRuleHeadList = dicExcelRuleHeadMapper.selectExcelRuleByEnumExcelType(enumExcelType);
		
		if(DicExcelRuleHeadList == null || DicExcelRuleHeadList.size() != 1){
			
			throw new Exception("配置表数据错误");
		}
		
		DicExcelRuleHead  dicExcelRuleHead = DicExcelRuleHeadList.get(0);
		//获取要插入的表明
		String tableName = dicExcelRuleHead.getTableName();
		//导入字段配置表
		List<DicExcelRuleItem> dicExcelRuleItemLitst = dicExcelRuleItemMapper.selectExcelRuleItemByHeadId(dicExcelRuleHead.getExcelRuleHeadId());
		//导入规则配置表
		List<DicExcelRuleCheck> dicExcelRuleCheckList = dicExcelRuleCheckMapper.selectExcelRuleCheckByHeadId(dicExcelRuleHead.getExcelRuleHeadId());
		//要使用的KEY
		List<String> coloumCodes = new ArrayList<String>();
	    //要返回的value
	    List<List<Object>> coloumValues = new ArrayList<List<Object>>();
		//重复验证需要的集合
		HashMap<String,List<String>> repeatMap = new HashMap<String,List<String>>();
		
		InputStream inputStream = new FileInputStream(url);
		POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem(inputStream);
		Workbook workbook = new HSSFWorkbook(pOIFSFileSystem);
	
		Sheet sheet = (HSSFSheet) workbook.getSheetAt(sheetIndex);
		int rowNum = sheet.getLastRowNum();
		
		//获取第一行列数
		int coloumNum = sheet.getRow(0).getPhysicalNumberOfCells();
		//循环出要导入的表头
		List<String> excelTitleList = new ArrayList<String>();
		
		int j = 0;
		//循环出表头
		for(j = 0 ; j < coloumNum ; j ++){
			
			String coloumName = sheet.getRow(0).getCell(j).toString();
			excelTitleList.add(coloumName);
		}
		//循环表头，找出对应的code
		for(j = 0; j < excelTitleList.size(); j++){
			//列名CODE：如:user_name
			String coloumCode = this.getColoumCodeByName(excelTitleList.get(j),dicExcelRuleItemLitst);
			if(coloumCode == null || "".equals(coloumCode)){
				throw new Exception("配置表ITEM数据错误");
			}
			coloumCodes.add(coloumCode);
		}
		
		Integer sucessCount = 0;
		Integer failCount = 0;
		
		for (int i = 1 ; i <= rowNum ; i++) {
			//判断为空行则退出
			Row row = sheet.getRow(i);
			//判断如果是空行则退出
			if(row == null){
				break;
			}
			List<Object> valueList = new ArrayList<Object>();
			
			//预先保存的USERID，用于生成MD5密码
			String userCode = "";
			
			//验证成功标识
			Object successValue = true;
			
			//循环列获取数据
			for(j = 0; j < excelTitleList.size(); j++){
				
				//列名NAME：如:用户名称
				String coloumName = excelTitleList.get(j);
				//列名CODE：如:user_name
				String coloumCode = coloumCodes.get(j);
				if("".equals(coloumName)){
//					throw new Exception("配置表数据字段"+coloumName+"配置错误!");
				}
				//列名CODE：如:userName
				Integer itemId = this.getColoumIdByName(coloumCode,dicExcelRuleItemLitst);
				
				//获取单元格数据
				Object value = row.getCell(j);
				
				//导入规则校验方法  success == true 验证通过
				successValue = this.checkCellValue(coloumCode,entityClass,value ,itemId,dicExcelRuleCheckList,dicExcellCheck,repeatMap);
				
				//如果返回的是BOOLEAN，说明校验错误
				if (successValue instanceof Boolean){
					break;
				}
				
				/**密码转MD5，暂时没办法处理，写死**/
				//判断如果导入的数据有USERID则存储
				if("userCode".equals(this.UnderlineToHump(coloumCode)) && successValue != null){
					userCode = String.valueOf(successValue);
				}
				//如果是密码。则转换MD5
				if(coloumName.contains("密码") && !"".equals(userCode) && successValue != null){
					
					successValue = MyShiroRealm.getHashPassword(String.valueOf(successValue), userCode);
				}
				/**密码转MD5，暂时没办法处理，写死**/
				//给对象赋值
				this.setFieldValueByCode(coloumCode, successValue, entityClass,valueList);
	            
			}
			
			//校验有错误则跳出
			if (successValue instanceof Boolean){
				//错误条数
				failCount ++ ;
				continue;
			}

			//成功条数
			sucessCount ++ ;
			coloumValues.add(valueList);
		}

		//如果失败也插入数据库，或者没有失败，则执行INSERT
		if(!cutFlag || failCount == 0){
			//批量插入条件
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("tableName", tableName);//要插入的表名
			paramMap.put("coloumCodes", coloumCodes);//要插入的字段集合
//			System.out.println(failCount);
//			System.out.println(sucessCount);
			//每500条一插入
			Integer toIndex = 500;
			Integer valueListSize = coloumValues.size();
			//分组每500条插入一次。
			for(int i = 0 ; i < valueListSize ; i += 500){
				
				if(i + 500 > valueListSize){
	                toIndex = valueListSize - i;
	            }
				List<List<Object>> newValuesList = coloumValues.subList(i , i + toIndex);
				paramMap.compute("coloumValues", (key, val) -> val = newValuesList);
				dicExcelRuleItemMapper.inserCommonList(paramMap);
				
			}
		}
	}
	
	/**
	 * 数据校验
	 * @param coloumCode   列名
	 * @param entityClass  实体类
	 * @param value  单元格值
	 * @param itemId  对应表ID
	 * @param dicExcelRuleCheckList  校验规则数据
	 * @param dicExcellCheckList  校验包含数据
	 * @param repeatMap  校验重复数据
	 * @return
	 * @throws Exception
	 */
	private Object checkCellValue(String coloumCode , Class<?>  entityClass ,Object value ,Integer itemId,List<DicExcelRuleCheck> dicExcelRuleCheckList,List<DicExcellCheck> dicExcellCheckList,HashMap<String,List<String>> repeatMap) throws Exception{
		
//		boolean success = true;
		//循环导入验证规则
		for(DicExcelRuleCheck derc : dicExcelRuleCheckList){
			
			if(itemId.equals(derc.getExcelRuleItemId())){
				//EnumExcelChecke 中类型匹配数据  ----非空验证
				if(EnumExcelChecke.CHECK_NULL.getValue().equals(derc.getCheckCode())){
					
					if(value == null || "".equals(String.valueOf(value))){
						//验证不通过 
//						throw new Exception("CHECK_NULL" + coloumCode);
						return false;
					}
					
				}
				//重复验证
				if(EnumExcelChecke.CHECK_REPEAT.getValue().equals(derc.getCheckCode())){
					
					if(repeatMap.get(coloumCode) != null){
						
						List<String> checkList = repeatMap.get(coloumCode);
						if(checkList.contains(value.toString())){
							//验证不通过
//							throw new Exception("CHECK_REPEAT" + coloumCode);
							return false;
						}
					}
				}
				//转换值验证
				if(EnumExcelChecke.CHANGE_VALUE.getValue().equals(derc.getCheckCode())){
					
					if(value.toString().equals(derc.getChangeValue())){
						//判断之后转换
						value = derc.getChangeToValue();
					}
				}
				//区间验证
				if(EnumExcelChecke.OPERATOR.getValue().equals(derc.getCheckCode())){
					
					//如果是区间转换，获取该字段的类型，数字和日期分开判断
					Field field = getFieldByName(coloumCode, entityClass);
				    if(field != null){
				    	
				    	field.setAccessible(true);
				    	//获取字段类型
				    	Class<?> fieldType = field.getType();
				    	//如果是日期需要区间判断
				    	if (Date.class == fieldType) {
				    		
				    		//如果是日期则转换格式之后判断
				    		String strFieldValue = value.toString();
			                String format = "yyyy-MM-dd";
			                if (strFieldValue.indexOf("/") != -1) {
			                    format = "yyyy/MM/dd";
			                }
			                Date valueDate = new SimpleDateFormat(format).parse(value.toString());
			                Date beginDate = new SimpleDateFormat(format).parse(derc.getBeginValue().toString());
			                Date endDate = new SimpleDateFormat(format).parse(derc.getEndValue().toString());
			                //之间
					    	if("between".equals(derc.getOperator())){
					    		
					    		if(valueDate.compareTo(beginDate) < 0 || valueDate.compareTo(endDate) > 0){
//					    			throw new Exception("OPERATOR" + "between"+"/" + coloumCode + "/" +value.toString());
					    			return false;
					    		}
					    	//等于	
							}else if("equal".equals(derc.getOperator())){
								
								if(valueDate.compareTo(beginDate) != 0){
//									throw new Exception("OPERATOR" + "equal"+"/" + coloumCode + "/" +value.toString());
									return false;
					    		}
							//大于	
							}else if("greater".equals(derc.getOperator())){
								
								if(valueDate.compareTo(beginDate) <= 0){
//									throw new Exception("OPERATOR" + "greater"+"/" + coloumCode + "/" +value.toString());
									return false;
					    		}
							//小于	
							}else if("less".equals(derc.getOperator())){
								
								if(valueDate.compareTo(beginDate) >= 0){
//									throw new Exception("OPERATOR" +"less"+ "/" + coloumCode + "/" +value.toString());
									return false;
					    		}
							}
				    		
				    	}else{//其余一律转换成字符串判断
				    		
				    		String valueString = value.toString();
				    		String beginString = derc.getBeginValue().toString();
				    		String endString = derc.getEndValue().toString();
				    		//之间
				    		if("between".equals(derc.getOperator())){
					    		
					    		if(valueString.compareTo(beginString) < 0 || valueString.compareTo(endString) > 0){
//					    			throw new Exception("OPERATOR" + "between"+"/" + coloumCode + "/" +value.toString());
					    			return false;
					    		}
					    	//等于	
							}else if("equal".equals(derc.getOperator())){
								
								if(valueString.compareTo(beginString) != 0){
//									throw new Exception("OPERATOR" +"equal"+ "/" + coloumCode + "/" +value.toString());
									return false;
					    		}
							//大于	
							}else if("greater".equals(derc.getOperator())){
								
								if(valueString.compareTo(beginString) <= 0){
//									throw new Exception("OPERATOR" + "greater"+"/" + coloumCode + "/" +value.toString());
									return false;
					    		}
							//小于	
							}else if("less".equals(derc.getOperator())){
								
								if(valueString.compareTo(beginString) >= 0){
									
//									throw new Exception("OPERATOR" + "less"+"/" + coloumCode + "/" +value.toString());
									return false;
					    		}
							}
				    	}
				    }
				}
				//集合包含验证
				if(EnumExcelChecke.INCLUDE_IN.getValue().equals(derc.getCheckCode())){
					
					if(dicExcellCheckList == null || dicExcellCheckList.size() < 1){
						
						throw new Exception("INCLUDE_IN验证请检查DicExcellCheckList");
					}

					for(DicExcellCheck dec : dicExcellCheckList){
						if(derc.getIncludeResultName().equals(dec.getResultName())){
							
							List<String> list = dec.getList();
							//不包含则验证不通过
							if(!list.contains(value.toString())){
								//验证不通过
//								throw new Exception("INCLUDE_IN" +coloumCode);
								return false;
							}
						}
					}
				}
				//集合不包含验证
				if(EnumExcelChecke.INCLUDE_OUT.getValue().equals(derc.getCheckCode())){
					
					if(dicExcellCheckList == null || dicExcellCheckList.size() < 1){
						
						throw new Exception("INCLUDE_OUT验证请检查DicExcellCheckList");

					}
					for(DicExcellCheck dec : dicExcellCheckList){
						if(derc.getIncludeResultName().equals(dec.getResultName())){
							
							List<String> list = dec.getList();
							//包含则验证不通过
							if(list.contains(value.toString())){
								//验证不通过
//								throw new Exception("INCLUDE_OUT" +coloumCode);
								return false;
								
							}
						}
					}
				}
			}
		}
		
		//如果存在则加入
		if(repeatMap.containsKey(coloumCode)){
			repeatMap.get(coloumCode).add(value.toString());
		}else{//不存在则新建
			
			List<String> list = new ArrayList<String>();
			list.add(value.toString());
			repeatMap.put(coloumCode, list);
		}
		
		return value;
		
	}
	
	
	/**
	 * @MethodName  : setFieldValueByCode 
	 * @Description : 根据字段名给对象的字段赋值 
	 * @param fieldCode  字段名
	 * @param fieldValue    字段值 
	 * @param o 对象
	 */  
	private void setFieldValueByCode(String fieldCode,Object fieldValue, Class<?>  entityClass ,List<Object> valueList) throws Exception{
		
	    Field field = getFieldByName(fieldCode, entityClass);
	    
	    if(field != null){
	    	
	        field.setAccessible(true);
	        //获取字段类型
	        Class<?> fieldType = field.getType();
	        //根据字段类型给字段赋值
	        if (String.class == fieldType) {
	        	
	        	valueList.add(String.valueOf(fieldValue));
	        } else if ((Integer.TYPE == fieldType)|| (Integer.class == fieldType)) {
	        	
	            valueList.add(Integer.parseInt(fieldValue.toString()));
	            
	        } else if ((Long.TYPE == fieldType)|| (Long.class == fieldType)) {
	        	
	            valueList.add(Long.valueOf(fieldValue.toString()));
	            
	        } else if ((Float.TYPE == fieldType)|| (Float.class == fieldType)) {
	        	
	            valueList.add(Float.valueOf(fieldValue.toString()));
	            
	        } else if ((Short.TYPE == fieldType)|| (Short.class == fieldType)) {
	        	
	            valueList.add( Short.valueOf(fieldValue.toString()));
	            
	        } else if ((Byte.TYPE == fieldType)|| (Byte.class == fieldType)) {
	        	
	            valueList.add(Byte.valueOf(fieldValue.toString()));
	            
	        } else if ((Double.TYPE == fieldType)|| (Double.class == fieldType)) {
	        	
	            valueList.add(Double.valueOf(fieldValue.toString()));
	            
	        } else if (Character.TYPE == fieldType) {
	        	
	            if ((fieldValue!= null) && (fieldValue.toString().length() > 0)) {
	            	
	                valueList.add(Character.valueOf(fieldValue.toString().charAt(0)));
	            }
	            
	        } else if (Date.class==fieldType){

	            if (fieldValue != null && (fieldValue.toString().length() > 0)) {
	                String strFieldValue = fieldValue.toString();
	                String format = "yyyy-MM-dd";
	                if (strFieldValue.indexOf("/") != -1) {
	                    format = "yyyy/MM/dd";
	                }
	                valueList.add(new SimpleDateFormat(format).parse(fieldValue.toString()));
	            }
	        } else if (BigDecimal.class == fieldType) {
	            valueList.add(new BigDecimal(fieldValue.toString()));
	        } else{
	            valueList.add(fieldValue);
	        }
	    }else{
	    	
	        throw new Exception(entityClass.getSimpleName() + "类不存在字段名 "+fieldCode);
	    }
	}
//	
//    /** 
//     * @MethodName  : getFieldByName 
//     * @Description : 根据字段名获取字段 
//     * @param fieldName 字段名 
//     * @param clazz 包含该字段的类 
//     * @return 字段 
//     */  
    private Field getFieldByName(String fieldName, Class<?>  clazz){  
        //拿到本类的所有字段  
        Field[] selfFields = clazz.getDeclaredFields();  
        
        fieldName = this.UnderlineToHump(fieldName);
        
        //如果本类中存在该字段，则返回  
        for(Field field : selfFields){
            if(field.getName().equals(fieldName)){  
                return field;  
            }  
        }  
           
        //否则，查看父类中是否存在此字段，如果有则返回  
        Class<?> superClazz = clazz.getSuperclass();  
        if(superClazz != null && superClazz != Object.class){  
            return getFieldByName(fieldName, superClazz);  
        }  
           
        //如果本类和父类都没有，则返回空  
        return null;  
    }
    
    /**
     * 下划线转驼峰
     * @param para
     * @return
     */
    private String UnderlineToHump(String para){
    	 
    	 StringBuilder result=new StringBuilder();
    	 String p[] = para.split("_");
    	 for(String s : p){
    		 if(result.length() == 0){
	    		 result.append(s.toLowerCase());
	    	 }else{
	    		 result.append(s.substring(0, 1).toUpperCase());
	    		 result.append(s.substring(1).toLowerCase());
	    	 }
    	 } return result.toString();
     
     }
    
//	
//    //根据中文注解获取字段
	private String getColoumCodeByName(String  columnName, List<DicExcelRuleItem> dicExcelRuleItemLitst){
		String coloumCode = "";
		for(DicExcelRuleItem deri : dicExcelRuleItemLitst){
			if(columnName.equals(deri.getColumnName())){
				coloumCode = deri.getColumnCode();
				break;
			}
		}
		return coloumCode;
	}
	
//  //根据中文注解获取ITEMID
	private Integer getColoumIdByName(String  coloumCode, List<DicExcelRuleItem> dicExcelRuleItemLitst){
		Integer itemId = 0 ;
		for(DicExcelRuleItem deri : dicExcelRuleItemLitst){
			if(coloumCode.equals(deri.getColumnCode())){
				itemId = deri.getExcelRuleItemId();
				break;
			}
		}
		return itemId;
	}
	
	
}