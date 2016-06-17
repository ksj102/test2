package com.study.springrest.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.study.springrest.domain.Criteria;
import com.study.springrest.domain.ReplyVO;
import com.study.springrest.persistence.ReplyDAO;;
@Repository
public class ReplyDAOImpl implements ReplyDAO{
	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.study.springrest.mapper.replyMapper";
	
	@Override
	public ReplyVO get(int reply_no) {
		sqlSession.update( namespace + ".readcnt", reply_no );
		return sqlSession.selectOne( namespace + ".get", reply_no );
	}

	@Override
	public List<ReplyVO> getList( int board_no ) {
		return sqlSession.selectList( namespace + ".getList", board_no );
	}

	@Override
	public void insert(ReplyVO vo) {
		sqlSession.insert( namespace + ".insert", vo );
	}

	@Override
	public void update(ReplyVO vo) {
		sqlSession.update( namespace + ".update", vo );
	}

	@Override
	public void delete( int reply_no ) {
		sqlSession.delete( namespace + ".delete", reply_no );
	}

	@Override
	public List<ReplyVO> getListPage( int board_no, Criteria criteria ) {
		// Collection 중 Map은 키와 값으로 입력된다.
		// 예) map.put( "키", 오브젝트 )
		Map<String, Object> map = new HashMap<>();
		map.put( "bno", board_no );
		map.put( "cri", criteria );
		
		return sqlSession.selectList( namespace + ".getListPage", map );
	}

	@Override
	public int getTotalCount(int board_no) {
		return sqlSession.selectOne( namespace + ".getTotalCount", board_no );
	}
}
