package com.inossem.wms.co.dic;

import com.inossem.wms.model.dic.DicText;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 国际化参数传入类
 * @author Gyl
 */
@ApiModel(value = "com.inossem.wms.co.dic.DicTextCo",description = "区域语言映射类")
public class DicTextCo extends DicText {
    /**
	 * 
	 */
	private static final long serialVersionUID = -946386414308945866L;
	/**
     * 语言code
     */
    @ApiModelProperty(value="语言编码",name = "langCode",example = "zh_CN",required = true)
    private String langCode;
    /**
     * 别名
     */
    @ApiModelProperty(value="语言编码别名",name = "alias",example = "zh",required = true)
    private String alias;


    /**
     * 有参数构造方法
     * @param langCode 语言code
     * @param alias 别名
     */
    public DicTextCo(String langCode, String alias) {
        this.langCode = langCode;
        this.alias = alias;

    }

    /**
     * 无参数构造方法
     */
    public DicTextCo() {
    }

    @Override
    public String getLangCode() {
        return langCode;
    }

    @Override
    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "InternationalizationCO{" +
                "langCode='" + langCode + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}
