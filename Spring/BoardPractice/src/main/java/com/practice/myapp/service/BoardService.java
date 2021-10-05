package com.practice.myapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.myapp.BoardDto;
import com.practice.myapp.dao.BoardDao;


@Service
public class BoardService {

	private BoardDao dao;

    @Autowired
    private SqlSessionTemplate template;
    
    // 리스트 출력
    public List<BoardDto> list() {
		dao = template.getMapper(BoardDao.class);
		return dao.list();
	}
    
    // 게시물 작성
    public int write(Map<String, String> map) {
		dao = template.getMapper(BoardDao.class);
		return dao.write(map);
	}
    
    // 게시물 수정
    public BoardDto getEdit(int idx) {
		dao = template.getMapper(BoardDao.class);
		return dao.getEdit(idx);
	}

    // 게시물 수정
    public int edit(Map<String, Object> map) {
		dao = template.getMapper(BoardDao.class);
		return dao.edit(map);
	}
    
    // 게시물 수정
    public int delete(int idx) {
		dao = template.getMapper(BoardDao.class);
		return dao.delete(idx);
	}
}
