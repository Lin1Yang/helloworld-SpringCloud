package com.inossem.wms.vo.dic;

import com.inossem.wms.model.dic.DicLanguage;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * 国际化语言映射类
 * @author admin
 */
@ApiModel(value = "国际化语言映射类",description = "存放国际化语言相关信息")
public class DicLanguageVo extends DicLanguage {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3886550717077500900L;

	private String langCode;

    private String langName;

    private String langNameZh;

    private String langNameEn;

    private String country;

    private String alias;

    private Byte isDelete;

    private Date createTime;

    private Date modifyTime;

    private Integer createUserId;

    private Integer modifyUserId;


    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode == null ? null : langCode.trim();
    }

    public String getLangName() {
        return langName;
    }

    public void setLangName(String langName) {
        this.langName = langName == null ? null : langName.trim();
    }

    public String getLangNameZh() {
        return langNameZh;
    }

    public void setLangNameZh(String langNameZh) {
        this.langNameZh = langNameZh == null ? null : langNameZh.trim();
    }

    public String getLangNameEn() {
        return langNameEn;
    }

    public void setLangNameEn(String langNameEn) {
        this.langNameEn = langNameEn == null ? null : langNameEn.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

}