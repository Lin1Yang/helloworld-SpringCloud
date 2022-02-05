package com.inossem.wms.model.sinobec;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "com.inossem.wms.model.sinobec.SinobecRelUserCorp")
public class SinobecRelUserCorp {
    private Integer userId;

    private String corpCode;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode == null ? null : corpCode.trim();
    }
}
