package com.iu.base.util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pager {
	
	//page 번호 담을 변수
	private Long page;
	
	//한페이지에 보여줄 글의 갯수
	private Long perPage;
	
	//시작 index 번호
	private Long startRow;
	
	//시작 index 번호를 계산하는 메서드
	public void makeStartRow() {
		//page = 1 , satrtRow = 0
		//page = 2 , satrtRow = 10
		//page = 3 , satrtRow = 20
		this.startRow=(this.getpage()-1)*this.getPerPage();
	}
	public Long getpage() {
		if(this.perPage == null || this.perPage==0) {
			this.perPage=1L;
	}
		return this.page;
}
		
	
	public Long getPerPage() {
		if(this.perPage == null || this.perPage==0) {
			this.perPage=10L;
		}
		
		return this.perPage;
	}
	
}
