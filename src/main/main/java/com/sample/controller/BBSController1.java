package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.service.BBSService1;
import com.sample.vo.UserVO;

@Controller
@RequestMapping("/bbs1")
public class BBSController1 {
	
	private BBSService1 service;
	
	public BBSController1(BBSService1 service) {
		super();
		this.service = service;
	}

	@GetMapping("/login")
	public String getLogin(UserVO vo) {
		return "bbs1/login";
	}
	
	@PostMapping("/login")
	public String postLogin(UserVO vo) {
		return (service.isUser(vo))?"bbs1/success":"redirect:/bbs1/login";
	}
}
