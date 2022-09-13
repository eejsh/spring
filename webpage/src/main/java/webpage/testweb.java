package webpage;

import java.sql.*;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
/* @Controller 어노테이션 사용 안하는 경우 implement로 controller 추가해서 사용함 */
public class testweb {
	
	
	@Inject
	private SqlSessionFactory sqlFactory; 
	// connect.xml에 sql매핑부분 bean id 사용해서 mybatis config, mapper 읽음 -> 
	// config에 세팅된 getter, setter 가져옴
	
	@Resource(name="dataRepo")
	private DATAREPO repo;

	@RequestMapping("test.do")
	public String abc() {
		try {
			SqlSession s = sqlFactory.openSession();
//			System.out.println(sqlFactory.openSession());
			dataDAO dao =  repo.select_test("aaa");
			System.out.println(dao.getMnm());
		}catch(Exception e) {
			
		}
		return "test";
	}
	
	
	
//	@Autowired
//	BasicDataSource dataConnect;
	
//	@RequestMapping("test.do")
//	public String abc() {
//			dataDAO da = new dataDAO();
//			da.setMid("hong");
//			da.setMpass("test");
//			
//			System.out.println(da.getMid());
//			System.out.println(da.getMpass());
//			
//		return "test";
//	}
}

