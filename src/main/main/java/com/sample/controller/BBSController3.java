package com.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.sample.service.BBSService3;
import com.sample.vo.UserVO;

@Controller
@RequestMapping("/bbs3")
public class BBSController3 {
	
	private BBSService3 service;

	public BBSController3(BBSService3 service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/login")
	public String getLogin(UserVO vo) {
		return "bbs3/login";
	}
	
	@PostMapping("/login")
	public String postLogin(UserVO vo, HttpSession session) {
		return (service.isUser(vo, session))?"redirect:/bbs3/bbs":"bbs3/login";
	}
	
	@GetMapping("/bbs")
	public String getBBS(@SessionAttribute("userVO")UserVO vo, Model model) {
		if(vo != null ) {
			service.getBBSList(model);
			return "bbs3/bbs";
		}else {
			return "bbs3/login";			
		}
	}
	
	@GetMapping("/bbs/{id}")
	public String getBBSItem(@SessionAttribute("userVO")UserVO vo, Model model, @PathVariable("id")String id) {
		if(vo != null ) {
			service.getBBSContent(model, id);
			return "bbs3/content";
		}else {
			return "bbs3/login";			
		}
	}
	
}
