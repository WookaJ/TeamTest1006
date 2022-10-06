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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sample.service.BBSService5;
import com.sample.vo.BBSVO;
import com.sample.vo.UserVO;

@Controller
@RequestMapping("/bbs5")
public class BBSController5 {
	
	private BBSService5 service;

	public BBSController5(BBSService5 service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/login")
	public String getLogin(UserVO vo) {
		return "bbs5/login";
	}
	
	@PostMapping("/login")
	public String postLogin(UserVO vo, HttpSession session) {
		return (service.isUser(vo, session))?"redirect:/bbs5/bbs":"bbs5/login";
	}
	
	@GetMapping("/bbs")
	public String getBBS(@SessionAttribute("userVO")UserVO vo, Model model) {
		if(vo != null ) {
			service.getBBSList(model);
			return "bbs5/bbs";
		}else {
			return "redirect:/bbs5/login";			
		}
	}
	
	@GetMapping("/bbs/{id}")
	public String getBBSItem(@SessionAttribute("userVO")UserVO vo, Model model, @PathVariable("id")String id) {
		if(vo != null ) {
			service.getBBSContent(model, id);
			return "bbs5/content";
		}else {
			return "redirect:/bbs5/login";			
		}
	}
	
	@GetMapping("/bbs/set")
	public String setBBS(@SessionAttribute("userVO")UserVO vo, 
			@ModelAttribute("bbsVO")BBSVO bvo, Model model) {
		if(vo != null ) {
			String[] cateList = {"공지","잡담","공유","비밀","	알림","고민"};
			model.addAttribute("cateList", cateList);
			return "bbs5/set";
		}else {
			return "redirect:/bbs5/login";
		}
	}
	
	@PostMapping("/bbs/set")
	public String setBBSResult(@SessionAttribute("userVO")UserVO vo, BBSVO bvo) {
		if(vo != null ) {
			bvo.setOwnerId(vo.getId());
			bvo.setOwner(vo.getUsername());
			if(service.setBBS(bvo)) {
				return "redirect:/bbs5/bbs";
			}else{
				return "bbs5/set";
			}
		}else {
			return "redirect:/bbs5/login";			
		}
	}
	
	@GetMapping("/bbs/put/{id}")
	public String setBBS(@SessionAttribute("userVO")UserVO vo, 
			Model model, @PathVariable("id")String id) {
		if(vo != null) {
			service.getBBSContent(model, id);
			String[] cateList = {"공지","잡담","공유","비밀","	알림","고민"};
			model.addAttribute("cateList", cateList);
			return "bbs5/put";
		}else {
			return "redirect:/bbs5/login";
		}
	}
	
	@PostMapping("/bbs/put")
	public String setBBS(@SessionAttribute("userVO")UserVO vo, 
			@ModelAttribute("bbsVO") BBSVO bvo) {
		bvo.setOwner(vo.getUsername());
		bvo.setOwnerId(vo.getId());
		if(service.putBBS(bvo)) {
			return "redirect:/bbs5/bbs";
		}else{
			return "redirect:/bbs5/put/"+bvo.getId();
		}
	}
}
