package com.study.springrest.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.springrest.domain.Criteria;
import com.study.springrest.domain.ReplyVO;
import com.study.springrest.domain.RestVO;
import com.study.springrest.persistence.ReplyDAO;
import com.study.springrest.persistence.RestDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Inject
	private ReplyDAO dao;
	
	@Inject
	private RestDAO restDao;

	@Override
	public ReplyVO get(int reply_no) {
		return dao.get( reply_no );
	}

	@Override
	public List<ReplyVO> getList( int board_no ) {
		return dao.getList( board_no );
	}


	@Override
	public void insert(ReplyVO vo) {
		dao.insert( vo );
		restDao.increaseReply( vo.getBoard_no() );
	}

	@Override
	public void update(ReplyVO vo) {
		dao.update( vo );
	}

	@Override
	public void delete(int reply_no) {
		dao.delete( reply_no );
	}

	@Override
	public List<ReplyVO> getListPage(int board_no, Criteria criteria) {
		return dao.getListPage( board_no, criteria );
	}

	@Override
	public int getTotalCount(int board_no) {
		return dao.getTotalCount( board_no );
	}
}
