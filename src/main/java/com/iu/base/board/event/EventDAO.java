package com.iu.base.board.event;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.iu.base.board.BoardVO;

import com.iu.base.util.Pager;

@Mapper
public interface EventDAO {
	
	public Long getTotalCount(Pager pager) throws Exception;
	
	// 글조회
	public List<EventVO> getEventList(Pager pager) throws Exception;
	
	// 글 하나 조회
	public EventVO getEventDetail(EventVO eventVO) throws Exception;
	
	// 글쓰기
	public int setEventAdd(EventVO eventVO) throws Exception;
	
	// 글수정
	public int setEventUpdate(EventVO eventVO) throws Exception;
	
	// 글삭제
	public int setEventDelete(EventVO eventVO) throws Exception;
	
	// 파일 등록
	public int setEventFileAdd(EventFileVO eventFileVO) throws Exception;
	
	// 파일조회
	public EventFileVO getFileDetail(EventFileVO eventFileVO) throws Exception;
	


}
