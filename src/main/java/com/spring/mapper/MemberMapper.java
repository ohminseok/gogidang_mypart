package com.spring.mapper;

import java.util.ArrayList;

import com.spring.gogidang.member.EventVO;
import com.spring.gogidang.member.MemberVO;
import com.spring.gogidang.member.ReviewVO;
import com.spring.gogidang.member.Shop_regVO;

public interface MemberMapper {

	public int insertMember(MemberVO member);
	public int userCheck(MemberVO member);
	public ArrayList<MemberVO> getMembers();
	public MemberVO selectMember(MemberVO memberVO);
	public ArrayList<EventVO> getEvents();
	public EventVO selectEvent(EventVO event);
	public ArrayList<Shop_regVO> getShop_regs();
	public ArrayList<ReviewVO> getReviews();
	
	
	
}
