package com.practice.myapp.dao;

import java.util.List;
import java.util.Map;

import com.practice.myapp.BoardDto;

public interface BoardDao {
	
	List<BoardDto> list();
	
	public int write(Map<String, String> map);
	
	BoardDto getEdit(int idx);

	public int edit(Map<String, String> map);
	
	public int delete(int idx);
}
