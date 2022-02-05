package com.inossem.wms.dao.dic;

import java.util.List;

import com.inossem.wms.co.dic.DicNoticeCo;
import com.inossem.wms.model.dic.DicNotice;
import com.inossem.wms.model.dic.DicNoticeVo;

public interface DicNoticeMapper {
    int deleteByPrimaryKey(Integer noticeId);

    int insert(DicNotice record);

    int insertSelective(DicNotice record);

    DicNotice selectByPrimaryKey(Integer noticeId);

    int updateByPrimaryKeySelective(DicNotice record);

    int updateByPrimaryKey(DicNotice record);

	List<DicNoticeVo> selectAllNoticeOnPaging(DicNoticeCo notice);
	
	List<DicNoticeVo> selectNoDelAndFbNoticeList();
	
	DicNoticeVo selectNewNoDelAndFbNotice();
}