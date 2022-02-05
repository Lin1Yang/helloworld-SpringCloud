package com.inossem.wms.constant;



/**
 * @Description  打印_常量
 * @ClassName： :
 * @Package com.inossem.wms.constant
 * @anthor：wyang
 * @date：2019/1/10
 * @版本：V1.0
 */
public class Constant {

    //路径
    public static final String OUTPUTFILE_LABEL_PATH = "static/outputfiles/label/"; // 标签输出路径
    public static final String OUTPUTFILE_TABLE_PATH = "static/outputfiles/table/"; // 单据输出路径
    public static final String OUTPUTFILE_QRCODE_PATH = "static/outputfiles/QRcode/"; // 二维码输出路径

    // 生成文件类型
    public static final String OUTPUTFILE_TYPE_XLS = ".xls";
    public static final String OUTPUTFILE_TYPE_PDF = ".pdf";
    public static final String OUTPUTFILE_TYPE_PNG = ".png";

    // 模版路径
    public static final String TEMPLATE_LABLE_MATERIAL = "template/ej/material_label.xls";
    public static final String TEMPLATE_LABLE_INPUT = "template/input_label.xls";
    // 打印类型

    // 安卓标签识别码


    //ZPL
    public static final String ZPL_BEGIN = "^XA^SEE:GB18030.DAT^CW1,E:SIMSUN.FNT"; // 标签格式以^XA开始，字符集设置为GB18030，字体为宋体
    public static final String ZPL_END = "^XZ"; // 标签格式以^XZ结束

}
