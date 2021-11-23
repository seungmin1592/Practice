package com.cos.person.web;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.person.domain.CommonDto;
import com.cos.person.domain.JoinReqDto;
import com.cos.person.domain.UpdateReqDto;
import com.cos.person.domain.User;
import com.cos.person.domain.UserRepository;


@RestController
public class UserController {
	
	private UserRepository userRepository;
	
	// DI = 의존성 주입
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	// http://localhost:8080/user
	@GetMapping("/user")
	public CommonDto<List<User>> findAll() {
		System.out.println("findAll()");
		return new CommonDto<List<User>>(HttpStatus.OK.value(), userRepository.findAll()); // MessageConverter (JavaObject => Json String);
	}
	
	
	// http://localhost:8080/user/1
	@GetMapping("/user/{id}")
	public CommonDto<User> findById(@PathVariable int id) {
		System.out.println("findById() : id	: " + id);
		return new CommonDto<User>(HttpStatus.OK.value(), userRepository.findById(id));
	}
	
	// http://localhost:8080/user/2
	@PostMapping("/user")
	// x-www-form-urlencoded => request.getParameter()
	// text/plain => @RequestBody 어노테이션
	// application/json => @ResponseBody 어노테이션 + 오브젝트로 받기
	
	public CommonDto<?> save(@Valid @RequestBody JoinReqDto user,BindingResult bindingResult) {
		
		
		System.out.println("save()");
		System.out.println("user : " + user);
		userRepository.save(user);
//		System.out.println("username : " + username);
//		System.out.println("password : " + password);
//		System.out.println("phone : " + phone );
		
		
		return new CommonDto<>(HttpStatus.OK.value(),"ok");
	}
	
	// http://localhost:8080/user/2
	@DeleteMapping("/user/{id}")
	public CommonDto<String> delete(@PathVariable int id) {
		System.out.println("delete()");
		userRepository.delete(id);
		
		return new CommonDto<>(HttpStatus.OK.value(), null);
	}
	
	// http://localhost:8080/user/2
	@PutMapping("/user/{id}")
	public CommonDto update(@PathVariable int id, @Valid @RequestBody UpdateReqDto dto, BindingResult bindingResult) {
		
	
		System.out.println("update()");
		userRepository.update(id, dto);
		return new CommonDto<>(HttpStatus.OK.value(), null);
	}
	
	

}
