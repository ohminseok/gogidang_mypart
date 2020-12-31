package com.spring.gogidang.qna;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class QnaController {
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping("/qnalist.bo") 
	public String getQnalist(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page) { 
		int limit=10;
		
		
		int listcount = qnaService.getListCount();
		
		int startrow = (page-1)*10+1;
		int endrow = startrow+limit-1;
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		hashmap.put("startrow", startrow);
		hashmap.put("endrow", endrow);
		List<QnaVO> qnalist = qnaService.getQnaList(hashmap);
		
		
		// 총 페이지 수
   		int maxpage=(int)((double)listcount/limit+0.95); // 0.95을 더해서 올림 처리
   		// 현재 페이지에 보여줄 시작 페이지 수 (1, 11, 21 ...)
   		int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		// 현재 페이지에 보여줄 마지막 페이지 수 (10, 20, 30 ...)
   		int endpage = maxpage;
   		
   		if (endpage>startpage+10-1) endpage=startpage+10-1;
   		
		model.addAttribute("page", page);
		model.addAttribute("listcount", listcount);
		model.addAttribute("qnalist", qnalist);
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);
		
		return "qna/qna_board_list";
	}
	
	
}
