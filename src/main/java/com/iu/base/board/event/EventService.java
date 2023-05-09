package com.iu.base.board.event;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.base.board.BoardVO;
import com.iu.base.util.FileManager;
import com.iu.base.util.Pager;

@Service
public class EventService {
	
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private EventDAO eventDAO;
	
	@Autowired
	private FileManager fileManager;
	
	public List<EventVO> getEventList(Pager pager) throws Exception {
		
		pager.makeStartRow();
		pager.makeNum(eventDAO.getTotalCount(pager));
		
		return eventDAO.getEventList(pager);
	
	}
	
	public int setEventAdd(EventVO eventVO, MultipartFile [] files, HttpSession session) throws Exception {
		int result = eventDAO.setEventAdd(eventVO);
		
		//file HDD에 저장
		String realPath = session.getServletContext().getRealPath("resources/upload/event");
		System.out.println(realPath);
		
		for(MultipartFile multipartFile: files) {
			
			if(multipartFile.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.saveFile(realPath, multipartFile);
					
			//DB INSERT
			EventFileVO eventFileVO = new EventFileVO();
			eventFileVO.setNum(eventVO.getNum());
			eventFileVO.setFileName(fileName);
			eventFileVO.setOriName(multipartFile.getOriginalFilename());
			
			result = eventDAO.setEventFileAdd(eventFileVO);
			
		}
		
		return result;
	}
	public EventVO getEventDetail(EventVO eventVO) throws Exception {
		return eventDAO.getEventDetail(eventVO);
	}
	
	public int setEventDelete(EventVO eventVO) throws Exception {
		int result = eventDAO.setEventDelete(eventVO);
		return result;
		
	}
	
	public int setEventUpdate(EventVO eventVO) throws Exception {
		return eventDAO.setEventUpdate(eventVO);
	}
	
	
//	public EventDTO getDateCheck(EventDTO eventDTO) throws Exception {
//		eventDTO = eventDAO.getEventDetail(eventDTO);
//		boolean check  =  true;
//		Date startDate = eventDTO.getStartDate();
//		Date endDate = eventDTO.getEndDate();
//		if(startDate < endDate) {
//			
//		}
//		
//		
//		return eventDAO.getDateCheck(eventDTO);
//	}
	

}
	
	

