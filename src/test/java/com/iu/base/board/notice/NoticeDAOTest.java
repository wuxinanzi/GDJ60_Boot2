package com.iu.base.board.notice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.base.board.BoardVO;

@SpringBootTest
public class NoticeDAOTest {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	void setInsertTest()throws Exception{
		for(int i=0;i<120;i++) {
			BoardVO boardVO  = new NoticeVO();
			
			boardVO.setWriter("iu"+i);
			boardVO.setTitle("Insert Test"+i);
			boardVO.setContents("Insert Test"+i);
			
			int result = noticeDAO.setInsert(boardVO);
			if(i%10==0) {
				Thread.sleep(500);
			}
		}
		System.out.println("종료");
	}
}
