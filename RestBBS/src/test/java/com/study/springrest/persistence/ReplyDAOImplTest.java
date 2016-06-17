package com.study.springrest.persistence;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.study.springrest.domain.ReplyVO;


@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"} )
public class ReplyDAOImplTest {
			@Inject
			private ReplyDAO dao;
			
			@Test
			public void test() { System.out.println( "Test DAO = " + dao ); }
//			
//			@Test
//			public void insertTest() throws Exception {
//				ReplyVO vo = new ReplyVO();
//				vo.setBoard_no( 15 );
//				vo.setContent( "내용" );
//				vo.setUser_name( "테스트" );
//				dao.insert( vo );
//			}
//			@Test
//			public void getTest() throws Exception {
//				int reply_no = 1;
//				ReplyVO vo = dao.get( reply_no );
//				System.out.println( "이름 : " + vo.getUser_name() );
//			}
//			@Test
//			public void getList() throws Exception {
//				List<ReplyVO> list = dao.getList();
//				Iterator<ReplyVO> it = list.iterator();
//				while( it.hasNext() ) {
//					ReplyVO vo = it.next();
//					System.out.println( "이름 : " + vo.getUser_name() );
//				}
//			}
//			@Test
//			public void updateTest() throws Exception {
//				ReplyVO vo = new ReplyVO();
//				vo.setUser_name( "변경" );
//				vo.setBoard_no( 2 );
//				dao.update( vo );
//			}
			@Test
			public void deleteTest() throws Exception {
				ReplyVO vo = new ReplyVO();
				vo.setReply_no( 21 );
				dao.delete( vo.getReply_no() );
			}
}
