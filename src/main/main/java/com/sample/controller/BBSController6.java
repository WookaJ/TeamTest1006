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

import com.sample.service.BBSService6;
import com.sample.vo.BBSVO;
import com.sample.vo.UserVO;

@Controller
@RequestMapping("/bbs6")
public class BBSController6 {
	
	private BBSService6 service;

	public BBSController6(BBSService6 service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/login")
	public String getLogin(UserVO vo) {
		return "bbs6/login";
	}
	
	@PostMapping("/login")
	public String postLogin(UserVO vo, HttpSession session) {
		return (service.isUser(vo, session))?"redirect:/bbs6/bbs":"bbs6/login";
	}
	
	@GetMapping("/bbs")
	public String getBBS(@SessionAttribute("userVO")UserVO vo, Model model) {
		if(vo != null ) {
			service.getBBSList(model);
			return "bbs6/bbs";
		}else {
			return "redirect:/bbs6/login";			
		}
	}
	
	@GetMapping("/bbs/{id}")
	public String getBBSItem(@SessionAttribute("userVO")UserVO vo, Model model, @PathVariable("id")String id) {
		if(vo != null ) {
			service.getBBSContent(model, id);
			return "bbs6/content";
		}else {
			return "redirect:/bbs6/login";			
		}
	}
	
	@GetMapping("/bbs/set")
	public String setBBS(@SessionAttribute("userVO")UserVO vo, 
			@ModelAttribute("bbsVO")BBSVO bvo, Model model) {
		if(vo != null ) {
			String[] cateList = {"공지","잡담","공유","비밀","	알림","고민"};
			model.addAttribute("cateList", cateList);
			return "bbs6/set";
		}else {
			return "redirect:/bbs6/login";
		}
	}
	
	@PostMapping("/bbs/set")
	public String setBBSResult(@SessionAttribute("userVO")UserVO vo, BBSVO bvo) {
		if(vo != null ) {
			bvo.setOwnerId(vo.getId());
			bvo.setOwner(vo.getUsername());
			if(service.setBBS(bvo)) {
				return "redirect:/bbs6/bbs";
			}else{
				return "bbs6/set";
			}
		}else {
			return "redirect:/bbs6/login";			
		}
	}
	
	@GetMapping("/bbs/put/{id}")
	public String setBBS(@SessionAttribute("userVO")UserVO vo, 
			Model model, @PathVariable("id")String id) {
		if(vo != null) {
			service.getBBSContent(model, id);
			String[] cateList = {"공지","잡담","공유","비밀","	알림","고민"};
			model.addAttribute("cateList", cateList);
			return "bbs6/put";
		}else {
			return "redirect:/bbs6/login";
		}
	}
	
	@PostMapping("/bbs/put")
	public String setBBS(@SessionAttribute("userVO")UserVO vo, 
			@ModelAttribute("bbsVO") BBSVO bvo) {
		bvo.setOwner(vo.getUsername());
		bvo.setOwnerId(vo.getId());
		if(service.putBBS(bvo)) {
			return "redirect:/bbs6/bbs";
		}else{
			return "redirect:/bbs6/bbs/put/"+bvo.getId();
		}
	}
	
	@GetMapping("/bbs/delete/{id}")
	public String deleteBBS(@SessionAttribute("userVO")UserVO vo,
			@ModelAttribute("bbsVO") BBSVO bvo,
			@PathVariable("id") String id) {
		bvo.setOwner(vo.getUsername());
		bvo.setOwnerId(vo.getId());
		if(service.deleteBBS(bvo)) {
			return "redirect:/bbs6/bbs";
		}else{
			return "redirect:/bbs6/bbs/"+bvo.getId();
		}
	}
}
