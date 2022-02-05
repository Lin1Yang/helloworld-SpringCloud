package com.inossem.wms.vo.rel;

public class RelReceiptTreeVo {
	private RelReceiptRidVo ancestors;
	private RelReceiptRidVo descendants;

	public RelReceiptRidVo getAncestors() {
		return ancestors;
	}

	public void setAncestors(RelReceiptRidVo ancestors) {
		this.ancestors = ancestors;
	}

	public RelReceiptRidVo getDescendants() {
		return descendants;
	}

	public void setDescendants(RelReceiptRidVo descendants) {
		this.descendants = descendants;
	}
}
