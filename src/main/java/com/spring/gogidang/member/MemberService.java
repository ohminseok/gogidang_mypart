package com.spring.gogidang.member;

import java.util.ArrayList;


public interface MemberService {

	public int insertMember(MemberVO memberVO);
	public int userCheck(MemberVO memberVO);
	public ArrayList<MemberVO> getMemberlist();
	public MemberVO selectMember(MemberVO memberVO);
	public ArrayList<EventVO> getEventlist();
	public EventVO selectEvent(EventVO eventVO);
	public ArrayList<Shop_regVO> getShop_reglist();
	public ArrayList<ReviewVO> getReviewlist();
}
