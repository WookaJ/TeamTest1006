package com.sample.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.sample.dao.BBSDAO;
import com.sample.dao.UserDAO;
import com.sample.vo.PageVO;
import com.sample.vo.UserVO;

@Service
public class BBSService3 {
	
	private UserDAO userDAO;
	private BBSDAO bbsDAO;

	public BBSService3(UserDAO userDAO, BBSDAO bbsDAO) {
		super();
		this.userDAO = userDAO;
		this.bbsDAO = bbsDAO;
	}
	
	public boolean isUser(UserVO vo, HttpSession session) {
		UserVO rvo = userDAO.selectUser(vo);
		if(rvo != null) {
			session.setAttribute("userVO", rvo);
			return true;
		}else {
			return false;
		}
	}

	public void getBBSList(Model model) {
		PageVO vo = new PageVO();
		vo.setStart(0);
		vo.setCntPerPage(15);
		model.addAttribute("list", bbsDAO.selectBBSList(vo));
	}
	
	public void getBBSContent(Model model, String id) {
		model.addAttribute("bbsVO", bbsDAO.selectBBS(id));
	}
}
