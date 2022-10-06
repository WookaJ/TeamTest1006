package com.sample.service;

import org.springframework.stereotype.Service;

import com.sample.dao.BBSDAO;
import com.sample.dao.UserDAO;
import com.sample.vo.UserVO;

@Service
public class BBSService1 {
	
	private UserDAO userDAO;
	private BBSDAO bbsDAO;
	
	public BBSService1(UserDAO userDAO, BBSDAO bbsDAO) {
		super();
		this.userDAO = userDAO;
		this.bbsDAO = bbsDAO;
	}
	
	public boolean isUser(UserVO vo) {
		UserVO rvo = userDAO.selectUser(vo);
		return (rvo != null)?true:false;
	}
	
	
}
