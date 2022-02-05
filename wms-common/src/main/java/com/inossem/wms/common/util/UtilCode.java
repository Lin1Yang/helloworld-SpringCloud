package com.inossem.wms.common.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.inossem.wms.vo.dic.DicMatCodeVo;

public class UtilCode {
    private static final String ZERO18 = "000000000000000000";

    public static String matEncode(String matCode) {
        if (matCode != null && matCode.length() < 18) {
            matCode = (ZERO18 + matCode);
            return matCode.substring(matCode.length() - 18);
        } else {
            return matCode;
        }
    }

    /**
     * 字符串左补0
     *
     * @param matCode
     * @param n       一共的位数
     * @return
     */
    public static String matEncode(String matCode, int n) {
        if (matCode != null && matCode.length() < n) {
            matCode = (ZERO18 + matCode);
            return matCode.substring(matCode.length() - n);
        }else {
			return null;
		}
        
    }


    public static String matDecode(String matCode) {
        if (matCode != null) {
            return matCode.replaceAll("^0*(?=[^0])", "");
        } else {
            return matCode;
        }
    }

    /**
     * 将传入的物料联合编码 转变成 物料范围组合类
     *
     * @param unionMatCode
     * @return
     */
    public static List<DicMatCodeVo> getMatCodeList(String unionMatCode) {


        List<DicMatCodeVo> matCodeVoList = new ArrayList<DicMatCodeVo>();
        if (!StringUtils.hasText(unionMatCode)) {
            return matCodeVoList;
        }
        // 将物料编码字符串中文逗号替换成英文逗号
        String str = unionMatCode.trim().replaceAll("，", ",");
        // 英文逗号分隔字符串
        String[] strArray = str.split(",");

        for (String s : strArray) {
            String[] sArray = s.split("-");

			// 不校验 物料code
			// int count = 0;

			// for (String code : sArray) {
			// if (!Pattern.matches("[0-9]*", sArray[count])) {
			// matCodeVoList.clear();
			// return matCodeVoList;
			// }
			// count++;
			// }

            int size = sArray.length;
            if (size > 1) {
                if (sArray[0].length() != sArray[size - 1].length()) continue;
                if (sArray[0].toUpperCase().compareTo(sArray[size - 1].toUpperCase()) > 0) continue;

                DicMatCodeVo vo = new DicMatCodeVo();
                vo.setBeginCode(sArray[0]);
                vo.setEndCode(sArray[size - 1]);
                matCodeVoList.add(vo);
            } else {
                DicMatCodeVo vo = new DicMatCodeVo();
                vo.setBeginCode(sArray[0]);
                matCodeVoList.add(vo);
            }

        }
        return matCodeVoList;
    }


}
