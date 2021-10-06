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
	
	@Autowired
	private SqlSessionTemplate template;
	
	private BoardDao dao;
	
	public List<BoardDto> list(){
		dao = template.getMapper(BoardDao.class);
		return dao.list();
	}
	
	
	public int write(Map<String, String> map){
		dao = template.getMapper(BoardDao.class);
		return dao.write(map);
	}
	
	public BoardDto getEdit(int idx){
		dao = template.getMapper(BoardDao.class);
		return dao.getEdit(idx);
	}
	
	public int edit(Map<String, String> map){
		dao = template.getMapper(BoardDao.class);
		return dao.edit(map);
	}
	
	public int delete(int idx){
		dao = template.getMapper(BoardDao.class);
		return dao.delete(idx);
	}

}
