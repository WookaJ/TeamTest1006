package com.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.sample.service.BBSService2;
import com.sample.vo.UserVO;

@Controller
@RequestMapping("/bbs2")
public class BBSController2 {
	
	private BBSService2 service;

	public BBSController2(BBSService2 service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/login")
	public String getLogin(UserVO vo) {
		return "bbs2/login";
	}
	
	@PostMapping("/login")
	public String postLogin(UserVO vo, HttpSession session) {
		return (service.isUser(vo, session))?"redirect:/bbs2/bbs":"bbs2/login";
	}
	
	@GetMapping("/bbs")
	public String getBBS(@SessionAttribute("userVO")UserVO vo, Model model) {
		if(vo != null ) {
			service.getBBSList(model);
			return "bbs2/bbs";
		}else {
			return "bbs2/login";			
		}
	}
	
}
