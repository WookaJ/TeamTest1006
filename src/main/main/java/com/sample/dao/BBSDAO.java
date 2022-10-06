package com.sample.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.BBSVO;
import com.sample.vo.PageVO;

@Mapper
public interface BBSDAO {
	
	public int selectBBSCount();
	
	public List<BBSVO> selectBBSList(PageVO vo);
	
	public BBSVO selectBBS(String id);
	
	public int insertBBS(BBSVO vo);
	
	public int updateBBS(BBSVO vo);
	
	public int deleteBBS(BBSVO vo);
	
}
