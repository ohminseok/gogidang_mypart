package com.spring.mapper;

import java.util.HashMap;
import java.util.List;

import com.spring.gogidang.qna.QnaVO;



public interface QnaMapper {
	
	public int getListCount(); // 글 개수 구하기 
	public List<QnaVO> getQnaList(HashMap<String, Integer> hashmap); // 글 목록 보기 

}
