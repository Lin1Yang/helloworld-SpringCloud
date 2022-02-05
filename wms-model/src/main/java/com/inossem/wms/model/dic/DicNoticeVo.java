package com.inossem.wms.model.dic;

import java.util.Date;

import com.inossem.wms.page.IPageResultCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.model.dic.DicNoticeVo", description="首页通知 消息")
public class DicNoticeVo  implements  IPageResultCommon{
	@ApiModelProperty(value = "总页数",example="2")
	private int totalCount;

	@Override
	public int getTotalCount() {
		return this.totalCount;
	}

	@Override
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	@ApiModelProperty(value = "noticeId",example="2")
    private Integer noticeId;
	
	@ApiModelProperty(value = "通知标题",example="元旦放假")
    private String title;
	@ApiModelProperty(value = "通知内容",example="元旦放假做好放假准备")
    private String content;
	@ApiModelProperty(value = "创建人",example="老毛")
    private String createUser;
	@ApiModelProperty(value = "状态",example="1")
    private Byte status;
	@ApiModelProperty(value = "是否删除标识",example="1")
    private Byte isDelete;
	@ApiModelProperty(value = "创建时间",example="2018-02-02 11:12:21")
    private Date createTime;
	@ApiModelProperty(value = "修改时间",example="2018-02-02 11:12:21")
    private Date modifyTime;
	@ApiModelProperty(value = "创建人id",example="1")
    private Integer createUserId;
	@ApiModelProperty(value = "修改人id",example="1")
    private Integer modifyUserId;
	@ApiModelProperty(value = "扩展字段")
    private String noticeExt0;
	@ApiModelProperty(value = "扩展字段")
    private String noticeExt1;
	@ApiModelProperty(value = "扩展字段")
    private String noticeExt2;
	@ApiModelProperty(value = "扩展字段")
    private String noticeExt3;
	@ApiModelProperty(value = "扩展字段")
    private String noticeExt4;
	@ApiModelProperty(value = "扩展字段")
    private String noticeExt5;
	@ApiModelProperty(value = "扩展字段")
    private String noticeExt6;
	@ApiModelProperty(value = "扩展字段")
    private String noticeExt7;
	@ApiModelProperty(value = "扩展字段")
    private String noticeExt8;
	@ApiModelProperty(value = "扩展字段")
    private String noticeExt9;
    
	@ApiModelProperty(value = "状态名",example="发布")
    private String statusName;

    

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Byte getStatus() {
    	
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public String getNoticeExt0() {
        return noticeExt0;
    }

    public void setNoticeExt0(String noticeExt0) {
        this.noticeExt0 = noticeExt0 == null ? null : noticeExt0.trim();
    }

    public String getNoticeExt1() {
        return noticeExt1;
    }

    public void setNoticeExt1(String noticeExt1) {
        this.noticeExt1 = noticeExt1 == null ? null : noticeExt1.trim();
    }

    public String getNoticeExt2() {
        return noticeExt2;
    }

    public void setNoticeExt2(String noticeExt2) {
        this.noticeExt2 = noticeExt2 == null ? null : noticeExt2.trim();
    }

    public String getNoticeExt3() {
        return noticeExt3;
    }

    public void setNoticeExt3(String noticeExt3) {
        this.noticeExt3 = noticeExt3 == null ? null : noticeExt3.trim();
    }

    public String getNoticeExt4() {
        return noticeExt4;
    }

    public void setNoticeExt4(String noticeExt4) {
        this.noticeExt4 = noticeExt4 == null ? null : noticeExt4.trim();
    }

    public String getNoticeExt5() {
        return noticeExt5;
    }

    public void setNoticeExt5(String noticeExt5) {
        this.noticeExt5 = noticeExt5 == null ? null : noticeExt5.trim();
    }

    public String getNoticeExt6() {
        return noticeExt6;
    }

    public void setNoticeExt6(String noticeExt6) {
        this.noticeExt6 = noticeExt6 == null ? null : noticeExt6.trim();
    }

    public String getNoticeExt7() {
        return noticeExt7;
    }

    public void setNoticeExt7(String noticeExt7) {
        this.noticeExt7 = noticeExt7 == null ? null : noticeExt7.trim();
    }

    public String getNoticeExt8() {
        return noticeExt8;
    }

    public void setNoticeExt8(String noticeExt8) {
        this.noticeExt8 = noticeExt8 == null ? null : noticeExt8.trim();
    }

    public String getNoticeExt9() {
        return noticeExt9;
    }

    public void setNoticeExt9(String noticeExt9) {
        this.noticeExt9 = noticeExt9 == null ? null : noticeExt9.trim();
    }


}
