package com.spring.gogidang.member;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;







@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	
	
	@RequestMapping("/loginform.me") 
	public String loginForm() throws Exception { 
		return "member/loginForm";
	}
	
	
	
	@RequestMapping("/login.me")
	public String userCheck(MemberVO memberVO, HttpSession session, 
			HttpServletResponse response) throws Exception { 
		int res = memberService.userCheck(memberVO);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		if (res == 1)
		{
			session.setAttribute("u_id",memberVO.getU_id());
			writer.write("<script>alert('로그인 성공!!');location.href='./main.me';</script>");
			//return "redirect:/main.me";
		}
		else 
		{
			writer.write("<script>alert('로그인 실패!!');location.href='./loginform.me';</script>");
			//return "redirect:/loginform.me";
		}
		return null;
	}
	
	@RequestMapping("/joinform.me") 
	public String joinForm() throws Exception { 
		return "member/joinForm";
	}
	
	@RequestMapping("/joinprocess.me") 
	public String insertMember(MemberVO memberVO, HttpServletResponse response) 
		throws Exception { 
		int res = memberService.insertMember(memberVO);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		if (res != 0)
		{
			writer.write("<script>alert('회원 가입 완료!!');"
					+ "location.href='./loginform.me';</script>");
		}
		else
		{
			writer.write("<script>alert('회원 가입 실패!!');"
					+ "location.href='./joinform.me';</script>");
		}
		
		return null;
	}
	
	@RequestMapping("/main.me") 
	public String mainPage(Model model) throws Exception { 
		ArrayList<EventVO> event_list = memberService.getEventlist();
		ArrayList<Shop_regVO> shop_reg_list = memberService.getShop_reglist();
		ArrayList<ReviewVO> review_list = memberService.getReviewlist();
		model.addAttribute("event_list", event_list);
		model.addAttribute("shop_reg_list", shop_reg_list);
		model.addAttribute("review_list", review_list);
		return "member/main";
	}
	
	@RequestMapping("/eventpage.me") 
	public String eventPage(Model model) throws Exception { 
		ArrayList<EventVO> event_list = memberService.getEventlist();
		model.addAttribute("event_list", event_list);
		return "member/eventpage";
	}
	
	@RequestMapping("/eventinfo.me") 
	public String selectEvent(EventVO eventVO, Model model) throws Exception { 
		EventVO vo = memberService.selectEvent(eventVO);
		model.addAttribute("eventVO",vo);
		return "member/eventpage_info";
	}
}
