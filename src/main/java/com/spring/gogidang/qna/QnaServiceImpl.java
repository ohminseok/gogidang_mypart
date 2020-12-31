package com.spring.gogidang.qna;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.QnaMapper;

@Service("qnaService")
public class QnaServiceImpl implements QnaService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int getListCount() {
		QnaMapper qnaMapper = sqlSession.getMapper(QnaMapper.class);
		int res= qnaMapper.getListCount();
		return res;
	}

	@Override
	public List<QnaVO> getQnaList(HashMap<String, Integer> hashmap) {
		QnaMapper qnaMapper = sqlSession.getMapper(QnaMapper.class);
		List<QnaVO> qnalist = qnaMapper.getQnaList(hashmap);
		return qnalist;
	}

}
