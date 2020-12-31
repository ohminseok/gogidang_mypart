package com.spring.gogidang.qna;

import java.util.HashMap;
import java.util.List;

public interface QnaService {
	
	public int getListCount(); // 글 개수 구하기 
	public List<QnaVO> getQnaList(HashMap<String, Integer> hashmap); // 글 목록 보기 

}
