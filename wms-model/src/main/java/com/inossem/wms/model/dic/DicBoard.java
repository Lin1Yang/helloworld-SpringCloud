package com.inossem.wms.model.dic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author Gyl
 */
@ApiModel(value = "com.inossem.wms.model.dic.DicBoard",description = "板块映射类")
public class DicBoard {
    @ApiModelProperty(name="boardCode",value="板块编号",required = true)
    private Integer boardCode;

    @ApiModelProperty(name="boardName",value="板块名称",required = true)
    private String boardName;

    @ApiModelProperty(name="isDelete",value="是否删除")
    private Byte isDelete;

    @ApiModelProperty(name="createTime",value="创建时间")
    private Date createTime;

    @ApiModelProperty(name="modifyTime",value="修改时间")
    private Date modifyTime;

    @ApiModelProperty(name="createUserId",value="创建人ID")
    private Integer createUserId;

    @ApiModelProperty(name="modifyUserId",value="修改人ID")
    private Integer modifyUserId;

    @ApiModelProperty(name="boardExt0",value="扩展字段,boardExt0,boardExt1......boardExt9")
    private String boardExt0;

    @ApiModelProperty(name="boardExt1",value="扩展字段",hidden = true)
    private String boardExt1;

    @ApiModelProperty(name="boardExt2",value="扩展字段",hidden = true)
    private String boardExt2;

    @ApiModelProperty(name="boardExt3",value="扩展字段",hidden = true)
    private String boardExt3;

    @ApiModelProperty(name="boardExt4",value="扩展字段",hidden = true)
    private String boardExt4;

    @ApiModelProperty(name="boardExt5",value="扩展字段",hidden = true)
    private String boardExt5;

    @ApiModelProperty(name="boardExt6",value="扩展字段",hidden = true)
    private String boardExt6;

    @ApiModelProperty(name="boardExt7",value="扩展字段",hidden = true)
    private String boardExt7;

    @ApiModelProperty(name="boardExt8",value="扩展字段",hidden = true)
    private String boardExt8;

    @ApiModelProperty(name="boardExt9",value="扩展字段",hidden = true)
    private String boardExt9;

    public Integer getBoardCode() {
        return boardCode;
    }

    public void setBoardCode(Integer boardCode) {
        this.boardCode = boardCode;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName == null ? null : boardName.trim();
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

    public String getBoardExt0() {
        return boardExt0;
    }

    public void setBoardExt0(String boardExt0) {
        this.boardExt0 = boardExt0 == null ? null : boardExt0.trim();
    }

    public String getBoardExt1() {
        return boardExt1;
    }

    public void setBoardExt1(String boardExt1) {
        this.boardExt1 = boardExt1 == null ? null : boardExt1.trim();
    }

    public String getBoardExt2() {
        return boardExt2;
    }

    public void setBoardExt2(String boardExt2) {
        this.boardExt2 = boardExt2 == null ? null : boardExt2.trim();
    }

    public String getBoardExt3() {
        return boardExt3;
    }

    public void setBoardExt3(String boardExt3) {
        this.boardExt3 = boardExt3 == null ? null : boardExt3.trim();
    }

    public String getBoardExt4() {
        return boardExt4;
    }

    public void setBoardExt4(String boardExt4) {
        this.boardExt4 = boardExt4 == null ? null : boardExt4.trim();
    }

    public String getBoardExt5() {
        return boardExt5;
    }

    public void setBoardExt5(String boardExt5) {
        this.boardExt5 = boardExt5 == null ? null : boardExt5.trim();
    }

    public String getBoardExt6() {
        return boardExt6;
    }

    public void setBoardExt6(String boardExt6) {
        this.boardExt6 = boardExt6 == null ? null : boardExt6.trim();
    }

    public String getBoardExt7() {
        return boardExt7;
    }

    public void setBoardExt7(String boardExt7) {
        this.boardExt7 = boardExt7 == null ? null : boardExt7.trim();
    }

    public String getBoardExt8() {
        return boardExt8;
    }

    public void setBoardExt8(String boardExt8) {
        this.boardExt8 = boardExt8 == null ? null : boardExt8.trim();
    }

    public String getBoardExt9() {
        return boardExt9;
    }

    public void setBoardExt9(String boardExt9) {
        this.boardExt9 = boardExt9 == null ? null : boardExt9.trim();
    }
}