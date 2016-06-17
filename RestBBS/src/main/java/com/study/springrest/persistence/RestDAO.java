package com.study.springrest.persistence;

import java.util.List;

import com.study.springrest.domain.RestVO;

public interface RestDAO {
	public RestVO get( int board_no );
	public List<RestVO> getList();
	public void insert( RestVO vo );
	public void update( RestVO vo );
	public void delete( int board_no );
	public void increaseReply( int board_no );
	public void readcnt(int board_no);

}
