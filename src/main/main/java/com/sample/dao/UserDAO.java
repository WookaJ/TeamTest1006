package com.sample.dao;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.UserVO;

@Mapper
public interface UserDAO {
	public UserVO selectUser(UserVO vo);
}
