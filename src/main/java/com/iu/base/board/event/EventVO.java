package com.iu.base.board.event;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EventVO {
	
	
	private Long num;
	private String title;
	private String contents;
	private String writer;
	private Date regDate;
	private Long hit;
	private Date startDate;
	private Date endDate;

}
