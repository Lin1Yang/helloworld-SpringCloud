package com.inossem.wms.model.dic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.model.dic.DicTextKey",description = "国际化语言key封装类")
public class DicTextKey {
    @ApiModelProperty(name="国际化语言编码",value = "tid",example = "i18n_0000000001_tid",required = true)
    private String tid;
    @ApiModelProperty(name="语言编码",value = "langCode",example = "zh_CN",required = true)
    private String langCode;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode == null ? null : langCode.trim();
    }
}