package com.inossem.wms.model.sinobec.unload;

import com.inossem.wms.model.sinobec.gp.SinobecBizOutputGp;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * FileName: QueryShelfLoadCo
 * Date:     2020/3/20 0020 15:25
 * Description: 下架单查询Co
 *
 * @author cxq
 */
public class UnLoadShelfQueryCo extends SinobecBizOutputGp implements Serializable  {


    /**
	 * 
	 */
	private static final long serialVersionUID = -4234239232269047814L;

	@ApiModelProperty(value="是否创建", name="create",  required=true)
    private Boolean create;

    private String sdate;

    private String edate;

    private  String whCode;   //2021-10-07 新加


    public Boolean getCreate() {
        return create;
    }

    public void setCreate(Boolean create) {
        this.create = create;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public String getWhCode() {
        return whCode;
    }    //2021-10-07 新加

    public void setWhCode(String whCode) {         //2021-10-07 新加
        this.whCode = whCode == null ? null : whCode.trim();
    }
}
