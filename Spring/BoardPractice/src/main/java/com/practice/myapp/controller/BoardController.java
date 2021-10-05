package com.practice.myapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.myapp.BoardDto;
import com.practice.myapp.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getList(Model model) {
		List<BoardDto> list = service.list();
		
		model.addAttribute("list", list);
	}
	
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void write() {
		
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public void getWrite(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", request.getParameter("name"));
		map.put("nickname", request.getParameter("nickname"));
		map.put("content", request.getParameter("content"));
		
		service.write(map);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public void edit(@RequestParam("idx") int idx, Model model) {
		BoardDto edit = service.getEdit(idx);
		model.addAttribute("edit", edit);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String getEdit(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", request.getParameter("name"));
		map.put("nickname", request.getParameter("nickname"));
		map.put("content", request.getParameter("content"));
		map.put("idx", request.getParameter("idx"));
		
		service.edit(map);
		
		return "redirect:/board/list";
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("idx") int idx) {
		service.delete(idx);
		
		return "redirect:/board/list";
	}

}
