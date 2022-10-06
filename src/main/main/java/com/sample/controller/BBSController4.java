package com.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.sample.service.BBSService4;
import com.sample.vo.BBSVO;
import com.sample.vo.UserVO;

@Controller
@RequestMapping("/bbs4")
public class BBSController4 {
	
	private BBSService4 service;

	public BBSController4(BBSService4 service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/login")
	public String getLogin(UserVO vo) {
		return "bbs4/login";
	}
	
	@PostMapping("/login")
	public String postLogin(UserVO vo, HttpSession session) {
		return (service.isUser(vo, session))?"redirect:/bbs4/bbs":"bbs4/login";
	}
	
	@GetMapping("/bbs")
	public String getBBS(@SessionAttribute("userVO")UserVO vo, Model model) {
		if(vo != null ) {
			service.getBBSList(model);
			return "bbs4/bbs";
		}else {
			return "redirect:/bbs4/login";			
		}
	}
	
	@GetMapping("/bbs/{id}")
	public String getBBSItem(@SessionAttribute("userVO")UserVO vo, Model model, @PathVariable("id")String id) {
		if(vo != null ) {
			service.getBBSContent(model, id);
			return "bbs4/content";
		}else {
			return "redirect:/bbs4/login";			
		}
	}
	
	@GetMapping("/bbs/set")
	public String setBBS(@SessionAttribute("userVO")UserVO vo, 
			@ModelAttribute("bbsVO")BBSVO bvo, Model model) {
		if(vo != null ) {
			String[] cateList = {"공지","잡담","공유","비밀","	알림","고민"};
			model.addAttribute("cateList", cateList);
			return "bbs4/set";
		}else {
			return "redirect:/bbs4/login";
		}
	}
	
	@PostMapping("/bbs/set")
	public String setBBSResult(@SessionAttribute("userVO")UserVO vo, BBSVO bvo) {
		if(vo != null ) {
			bvo.setOwnerId(vo.getId());
			bvo.setOwner(vo.getUsername());
			if(service.setBBS(bvo)) {
				return "redirect:/bbs4/bbs";
			}else{
				return "bbs4/set";
			}
		}else {
			return "redirect:/bbs4/login";			
		}
	}
}
