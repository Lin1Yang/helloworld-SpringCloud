package com.inossem.wms.common.util;

import com.inossem.wms.constant.Const;
import com.inossem.wms.model.dic.DicUnit;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * FileName: UtilBeanAllFieldNull
 * Date:     2020/4/8 0008 17:16
 * Description: 判断该对象的一部分属性是否 不为空， 没有空值，返回true，有空值返回false
 *
 * @author cxq
 */
public class UtilBeanCheckAllFieldNull {
    /**
     * 校验参数，是否为 null 或者空，如果有返回false，正常返回true
     * @param obj
     * @param excludeNames
     * @return
     * @throws IllegalAccessException
     */
    public static boolean isAllFieldNull(Object obj, List<String> excludeNames) throws IllegalAccessException {
        // 取到obj的class, 并取到所有属性
        Field[] fs = obj.getClass().getDeclaredFields();
        Field[] ffs =obj.getClass().getSuperclass().getDeclaredFields();
        // 定义一个flag, 标记是否所有属性值为空
        boolean flag = true;
        // 遍历所有属性
        for (Field f : fs) {
            // 设置私有属性也是可以访问的
            f.setAccessible(true);
            if(excludeNames.contains(f.getName())&& (f.get(obj)==null||StringUtils.isBlank(f.get(obj).toString()))){
                flag=false;
                break;
            }
        }
        for (Field f : ffs) {
            // 设置私有属性也是可以访问的
            f.setAccessible(true);
            if(excludeNames.contains(f.getName())&& (f.get(obj)==null||StringUtils.isBlank(f.get(obj).toString()))){
                flag=false;
                break;
            }
        }
        return flag;
    }
    
    
    public static String getNullField(Object obj, List<String> excludeNames) throws IllegalAccessException {
        // 取到obj的class, 并取到所有属性
        Field[] fs = obj.getClass().getDeclaredFields();
        Field[] ffs =obj.getClass().getSuperclass().getDeclaredFields();
        // 定义一个flag, 标记是否所有属性值为空
        boolean flag = true;
        String FieldName = Const.STRING_EMPTY;
        // 遍历所有属性
        for (Field f : fs) {
            // 设置私有属性也是可以访问的
            f.setAccessible(true);
            if(excludeNames.contains(f.getName())&& (f.get(obj)==null||StringUtils.isBlank(f.get(obj).toString()))){
                flag=false;
                FieldName = f.getName();
                break;
            }
        }
        for (Field f : ffs) {
            // 设置私有属性也是可以访问的
            f.setAccessible(true);
            if(excludeNames.contains(f.getName())&& (f.get(obj)==null||StringUtils.isBlank(f.get(obj).toString()))){
                flag=false;
                FieldName = f.getName();
                break;
            }
        }
        return FieldName;
    }
    

    public static void main(String[] args) throws Exception {
        // 将不关心的字段丢入excludeNames
        List<String> excludeNames = new ArrayList<String>();
        excludeNames.add("createUserId");

        // 关心的字段全部为空的情况
        DicUnit unit = new DicUnit();
        unit.setUnitName("");
        System.err.println(isAllFieldNull(unit, excludeNames));

        System.out.println("===============");

        // 关心的字段不全部为空的情况
        unit.setCreateUserId(1);
        System.err.println(isAllFieldNull(unit, excludeNames));

    }

}
