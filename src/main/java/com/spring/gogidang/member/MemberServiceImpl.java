package com.spring.gogidang.member;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.MemberMapper;




@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertMember(MemberVO memberVO) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		int res = memberMapper.insertMember(memberVO);
		System.out.println("res = " + res);
		
		return res;
	}
	
	@Override
	public int userCheck(MemberVO memberVO) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		int res = memberMapper.userCheck(memberVO);
		
		return res;
	}
	
	@Override
	public ArrayList<MemberVO> getMemberlist() {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		memberList = memberMapper.getMembers();
		
		return memberList;
	}
	
	@Override
	public MemberVO selectMember(MemberVO memberVO) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		MemberVO vo = memberMapper.selectMember(memberVO);
		
		return vo;
	}
	
	@Override
	public ArrayList<EventVO> getEventlist() {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		ArrayList<EventVO> eventList = new ArrayList<EventVO>();
		eventList = memberMapper.getEvents();
		
		return eventList;
	}
	
	@Override
	public ArrayList<Shop_regVO> getShop_reglist() {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		ArrayList<Shop_regVO> shop_regList = new ArrayList<Shop_regVO>();
		shop_regList = memberMapper.getShop_regs();
		
		return shop_regList;
	}
	
	@Override
	public ArrayList<ReviewVO> getReviewlist() {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		ArrayList<ReviewVO> reviewList = new ArrayList<ReviewVO>();
		reviewList = memberMapper.getReviews();
		
		return reviewList;
	}
	
	@Override
	public EventVO selectEvent(EventVO eventVO) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		EventVO vo = memberMapper.selectEvent(eventVO);
		return vo;
	}
	
	
	

}
