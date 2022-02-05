package com.inossem.wms.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.inossem.wms.model.test.PropertiesModel;

public class UtilMessage {
	
	//读取EXCEL
	public static List<PropertiesModel> getExcel(String url){
		
		List<PropertiesModel> list = new ArrayList<PropertiesModel>();
		try {
				InputStream inputStream = new FileInputStream(url);
				Sheet sheet = null;
				Workbook book = WorkbookFactory.create(inputStream);
				boolean isXSSFWorkbook = !(book instanceof HSSFWorkbook);
				
				if (isXSSFWorkbook) {
					sheet = (XSSFSheet) book.getSheetAt(0);
                } else {
                    sheet = (HSSFSheet) book.getSheetAt(0);
                }
				int rowNum = sheet.getLastRowNum();
				
				//获取第一行列数
				int coloumNum = sheet.getRow(1).getPhysicalNumberOfCells();
				//要使用的KEY
				List<String> coloumCodes = new ArrayList<String>();
				
				int j = 0;
				//循环出表头
				for(j = 0 ; j < coloumNum ; j ++){
					String coloumName = sheet.getRow(0).getCell(j).toString();
					coloumCodes.add(coloumName);
				}
				for (int i = 1 ; i <= rowNum ; i++) {
					//判断为空行则退出
					Row row = sheet.getRow(i);
					//判断如果是空行则退出
					if(row == null){
						break;
					}
					PropertiesModel propertiesModel = new PropertiesModel();
					//循环列获取数据
					for(j = 0; j < coloumCodes.size(); j++){
						
						String coloumCode = coloumCodes.get(j);
						//获取单元格数据
						String value = row.getCell(j).toString();
						//给对象赋值
						setFieldValueByCode(coloumCode, value, propertiesModel);
					}
					
					list.add(propertiesModel);
				}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
    private static Field getFieldByName(String fieldName, Class<?>  clazz){  
        //拿到本类的所有字段  
        Field[] selfFields = clazz.getDeclaredFields();  
        
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
    
	private static void setFieldValueByCode(String fieldName,String fieldValue, Object entity) throws Exception{
		
	    Field field = getFieldByName(fieldName, entity.getClass());
	    if(field != null){
	        field.setAccessible(true);
	        //获取字段类型
	        Class<?> fieldType = field.getType();
	        //根据字段类型给字段赋值
	        if (String.class == fieldType) {
	        	field.set(entity,fieldValue);
	        }
	    }else{
	        throw new Exception(entity.getClass().getSimpleName() + "类不存在字段名 "+fieldName);
	    }
	}
	
	
	//写入生成之后还没有读取的数据
	public static void writeLastProperties(List<PropertiesModel> wirtList,String last_file) {          
        try {
        	createFile(last_file);
        	writeFile(wirtList,last_file,null);
        	
        } catch (Exception e) {   
            System.err.println("属性文件更新错误");   
        }   
    }   
	
	
	//读取Properties
	public static void getProperties(List<PropertiesModel> list,List<PropertiesModel> lastList,String inputPath,String wirteUrl,String error_file){
		
		Properties prop = new UtilMessageOrder();
		//最后要写入的对象
		List<PropertiesModel> wirtList = new ArrayList<PropertiesModel>();
		//有KEY但汉字对不上的对象
		List<PropertiesModel> errorList = new ArrayList<PropertiesModel>();
	      try{
	          //读取属性文件a.properties
	          InputStream in = new BufferedInputStream (new FileInputStream(inputPath));
	          prop.load(in);     ///加载属性列表
	          Iterator<String> it = prop.stringPropertyNames().iterator();
	          while(it.hasNext()){
	        	  //是否存在
	        	  boolean notFound = true;
	        	  
	              String key = it.next();
	              for(PropertiesModel p : list){
	            	  if(key.equals(p.getKey())){
	            		  //如果KEY相同，汉字不同，则插入
	            		  if(!prop.getProperty(key).equals(p.getZh())){
	            			  errorList.add(p);
	            		  }
	            		  //剩余未被使用的KEY值计数
	            		  if(lastList.contains(p)){
	            			  lastList.remove(p);
	            		  }
	            		  wirtList.add(p);
	            		  notFound = false;
	            	  }
	              }
	              if(notFound){//如果不存在，则插入换行
	            	  PropertiesModel notp = new PropertiesModel();
	            	  notp.setKey(key);
	            	  notp.setValue("");
	            	  notp.setZh("");
	            	  wirtList.add(notp);
	              }
	          }
	      in.close();
	      
	      //写入生成的文件 start
	      File file = createFile(wirteUrl);
          prop = new UtilMessageOrder();
	      FileOutputStream oFile = new FileOutputStream(wirteUrl, true);
          for(PropertiesModel p :wirtList){
        	  prop.setProperty(p.getKey(), p.getValue());
          }
          prop.store(oFile, file.getName());
          oFile.close();
          //写入生成的文件 end
          
          //写入KEY值相同，但汉字不同的文件 start
          if(errorList.size() > 0){
        	  
        	  writeFile(errorList,error_file,file.getName());
        	  
//        	  prop = new UtilMessageOrder();
//        	  oFile = new FileOutputStream(error_file, true);
//        	  for(PropertiesModel p : errorList){
//        		  prop.setProperty(p.getKey(), p.getZh());
//        	  }
//        	  prop.store(oFile, file.getName());
//        	  oFile.close();
          }
          //写入KEY值相同，但汉字不同的文件 end
          
      }
      catch(Exception e){
          System.out.println(e);
      }
	}
	
	//生成对应文件,如果存在则删除
	public static File createFile(String wirteUrl){
		File file = null;
        try {
        	file = new File(wirteUrl);
        	if(file.exists()){
        		file.delete();
        	}
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return file;
	}
	
	public static void writeFile(List<PropertiesModel> wirtList,String last_file,String fileName) {
		
		try {
			File writeName = new File(last_file);
			writeName.createNewFile();
			try (FileWriter writer = new FileWriter(writeName,true);
	                 BufferedWriter out = new BufferedWriter(writer)
					) {
//                out.write("文件\r\n");
				if(fileName != null){
					out.write("#" + fileName + "\r\n");
				}
				for(PropertiesModel p : wirtList){
		          	out.write(p.getKey() + "=" + p.getZh() + "\r\n");
		        }
                out.flush();
                out.close();
			 }
			
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static void main(String [] args){
		
		String in_properties_text = "F:/p/text_messages_zh-cn.properties";
		String in_properties_retur= "F:/p/return_code_messages_zh-cn.properties";
		String in_properties_name = "F:/p/name_messages_zh-cn.properties";
		
		String out_properties_text = "F:/p/text_messages_fr-fr.properties";
		String out_properties_retur= "F:/p/return_code_messages_fr-fr.properties";
		String out_properties_name = "F:/p/name_messages_fr-fr.properties";
		
		String last_file = "F:/p/last_file.txt";
		//先生成ERROR文件（存储汉字对不上的值）
		String error_file = "F:/p/error_file.txt";
		createFile(error_file);
		
		//读取EXCEL文件  EXCEL里三列列表对应 key、zh、value
		List<PropertiesModel> list = getExcel("C:/Users/wsail/Desktop/fr.xlsx");
		
		//记录剩下没有被使用的KEY
		List<PropertiesModel> lastList = new ArrayList<PropertiesModel>();
		lastList.addAll(list);
		
		getProperties(list,lastList,in_properties_text,out_properties_text,error_file);
		System.out.println(lastList.size());
		getProperties(list,lastList,in_properties_retur,out_properties_retur,error_file);
		System.out.println(lastList.size());
		getProperties(list,lastList,in_properties_name,out_properties_name,error_file);
		System.out.println(lastList.size());
		//写入遗留下来，没有被生成的数据
		if(lastList.size() > 0){
			writeLastProperties(lastList,last_file);
		}
	}
	
}
