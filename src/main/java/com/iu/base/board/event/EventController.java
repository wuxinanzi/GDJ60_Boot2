package com.iu.base.board.event;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.base.util.Pager;

@Controller
@RequestMapping("/event/*")
public class EventController {
			
	@Autowired
	private EventService eventService;
	
	
	@GetMapping("allEvent")
	public ModelAndView getEventStateAll(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<EventVO> ar = eventService.getEventList(pager);
		
		mv.addObject("list",ar);
		mv.setViewName("board/eventDate/allEvent");
		return mv;
	}
	

	@GetMapping("continueEvent")
	public ModelAndView getEventStateContinue(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<EventVO> ar = eventService.getEventList(pager);
		
		mv.addObject("list",ar);
		mv.setViewName("board/eventDate/continueEvent");
		return mv;
	}
	
	@GetMapping("endEvent")
	public ModelAndView getEventStateEnd(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<EventVO> ar = eventService.getEventList(pager);
		
		mv.addObject("list",ar);
		mv.setViewName("board/eventDate/endEvent");
		
		return mv;
	}
	
	@GetMapping("test")
	public ModelAndView Test() throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/menu");
		
		return mv;
	}
	
	
	
	
	
	
	
	
	
	//list
	@GetMapping("list")
	public ModelAndView getEventList(Pager pager, EventVO eventVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<EventVO> ar = eventService.getEventList(pager); 
		
		mv.addObject("list", ar);
		
		
		
		mv.addObject("list", ar);
		mv.setViewName("event/list");
		return mv;
		
	}
	
	
	//add
	
	@GetMapping("add")
	public ModelAndView setEventAdd() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/eventAdd");
		return mv;
		
	}
	
	@PostMapping("add")
	public ModelAndView setEventAdd(EventVO eventVO, MultipartFile [] files, HttpSession session) throws Exception {
	
		ModelAndView mv = new ModelAndView();
		
		int result = eventService.setEventAdd(eventVO, files, session);
		
		mv.setViewName("redirect:./list");
		
		return mv; 
		
	}
	
	@GetMapping("detail")
	public ModelAndView getEventDetail(EventVO eventVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		eventVO = eventService.getEventDetail(eventVO);
		
		//int result = eventService.setNoticeHit(noticeDTO);
		
		mv.addObject("dto",eventVO);
		mv.setViewName("board/eventDetail");
		return mv;
	
	}
	
	//delete
	
		@GetMapping("delete")
		public ModelAndView setEventDelete(EventVO eventVO) throws Exception {
			
			ModelAndView mv = new ModelAndView();
			
			int result = eventService.setEventDelete(eventVO);
			
			mv.setViewName("redirect:./list");
			return mv;
			
		}
		
		@GetMapping("update")
		public ModelAndView setEventUpdate(EventVO eventVO) throws Exception {
			ModelAndView mv = new ModelAndView();
			eventVO = eventService.getEventDetail(eventVO);
			
			mv.addObject("dto",eventVO);
			mv.setViewName("board/eventUpdate");
			return mv;
		}
		
		@PostMapping("update")
		public ModelAndView setEventUpdate(ModelAndView mv, EventVO eventVO ) throws Exception {
			
			int result = eventService.setEventUpdate(eventVO);
			mv.setViewName("redirect:./list");
			return mv;
		}
		
		@GetMapping("eventHome")
		public ModelAndView getEventHome(Pager pager, EventVO eventVO) throws Exception {
			ModelAndView mv = new ModelAndView();
			pager.setPerPage(5L);
			List<EventVO> ar = eventService.getEventList(pager);
			mv.addObject("list",ar);
			mv.setViewName("eventHome");
			return mv;
		}
	
	
}

