package com.inossem.wms.model.dic;

import java.io.Serializable;
import java.util.Date;

public class DicLanguage implements Serializable {
	
	private static final long serialVersionUID = 340888972944433486L;

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

    private String langExt0;

    private String langExt1;

    private String langExt2;

    private String langExt3;

    private String langExt4;

    private String langExt5;

    private String langExt6;

    private String langExt7;

    private String langExt8;

    private String langExt9;

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

    public String getLangExt0() {
        return langExt0;
    }

    public void setLangExt0(String langExt0) {
        this.langExt0 = langExt0 == null ? null : langExt0.trim();
    }

    public String getLangExt1() {
        return langExt1;
    }

    public void setLangExt1(String langExt1) {
        this.langExt1 = langExt1 == null ? null : langExt1.trim();
    }

    public String getLangExt2() {
        return langExt2;
    }

    public void setLangExt2(String langExt2) {
        this.langExt2 = langExt2 == null ? null : langExt2.trim();
    }

    public String getLangExt3() {
        return langExt3;
    }

    public void setLangExt3(String langExt3) {
        this.langExt3 = langExt3 == null ? null : langExt3.trim();
    }

    public String getLangExt4() {
        return langExt4;
    }

    public void setLangExt4(String langExt4) {
        this.langExt4 = langExt4 == null ? null : langExt4.trim();
    }

    public String getLangExt5() {
        return langExt5;
    }

    public void setLangExt5(String langExt5) {
        this.langExt5 = langExt5 == null ? null : langExt5.trim();
    }

    public String getLangExt6() {
        return langExt6;
    }

    public void setLangExt6(String langExt6) {
        this.langExt6 = langExt6 == null ? null : langExt6.trim();
    }

    public String getLangExt7() {
        return langExt7;
    }

    public void setLangExt7(String langExt7) {
        this.langExt7 = langExt7 == null ? null : langExt7.trim();
    }

    public String getLangExt8() {
        return langExt8;
    }

    public void setLangExt8(String langExt8) {
        this.langExt8 = langExt8 == null ? null : langExt8.trim();
    }

    public String getLangExt9() {
        return langExt9;
    }

    public void setLangExt9(String langExt9) {
        this.langExt9 = langExt9 == null ? null : langExt9.trim();
    }
}