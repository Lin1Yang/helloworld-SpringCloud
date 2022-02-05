package com.inossem.wms.vo.dic;

import java.util.List;

import com.inossem.wms.model.dic.DicBoard;
import io.swagger.annotations.ApiModel;

@ApiModel(value="com.inossem.wms.vo.dic.DicBoardVo")
public class DicBoardVo extends DicBoard {
	
	private List<DicCorpVo> corpList;

	public List<DicCorpVo> getCorpList() {
		return corpList;
	}

	public void setCorpList(List<DicCorpVo> corpList) {
		this.corpList = corpList;
	}
	
	
}
