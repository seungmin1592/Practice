package com.java.spring_ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class SampleRequestMapping {

	
	@RequestMapping("/view")
	public String view() {
		return "/board/view";
	}
}
