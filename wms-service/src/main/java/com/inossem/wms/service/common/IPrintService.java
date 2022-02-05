package com.inossem.wms.service.common;

/**
 *  打印文件
 * @author : sw
 * @date : 2019/1/23
 */
public interface IPrintService {

    Integer print(String printer, String ip, Byte printType, String... param);

}
