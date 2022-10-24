package kr.kwangan2.test;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) //현재 테스트 코드가 스프링을 실행하는 역할을 할 것이라는 것을 @runwith 어노테이션으로 표시함
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 내에 객체로 등록하게 된다.(스프링의 빈으로 등록된다)
@Log4j//롬복을 이용해 로그를 기록하는 logger을 변수로 생성
public class DataSourceTest {
	
	@Setter(onMethod_ = {@Autowired})
	private DataSource dataSource;
	
	@Setter(onMethod_= {@Autowired})
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnection() {
		
		try{
			SqlSession sqlSession =  sqlSessionFactory.openSession();
			Connection conn = sqlSession.getConnection();
			log.info(sqlSession);
			log.info(conn);
			
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
