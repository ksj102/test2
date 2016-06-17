package com.study.springrest.persistence;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.study.springrest.domain.RestVO;


@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"} )
public class RestDAOImplTest {
			@Inject
			private RestDAO dao;
			
			@Test
			public void test() { System.out.println( "Test DAO = " + dao ); }
			
			@Test
			public void insertTest() throws Exception {
				RestVO vo = new RestVO();
				vo.setTitle( "제목" );
				vo.setContent( "내용" );
				vo.setUser_name( "테스트" );
				vo.setView_cnt( 0 );
				
				dao.insert( vo );
			}
			@Test
			public void getTest() throws Exception {
				int board_no = 1;
				RestVO vo = dao.get( board_no );
				System.out.println( "이름 : " + vo.getUser_name() );
			}
			@Test
			public void getList() throws Exception {
				List<RestVO> list = dao.getList();
				Iterator<RestVO> it = list.iterator();
				while( it.hasNext() ) {
					RestVO vo = it.next();
					System.out.println( "이름 : " + vo.getUser_name() );
				}
			}
			@Test
			public void updateTest() throws Exception {
				RestVO vo = new RestVO();
				vo.setUser_name( "변경" );
				vo.setBoard_no( 2 );
				dao.update( vo );
			}
			@Test
			public void deleteTest() throws Exception {
				RestVO vo = new RestVO();
				vo.setBoard_no( 3 );
				dao.delete( vo.getBoard_no() );
			}
}
