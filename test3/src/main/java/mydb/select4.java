package mydb;

import java.sql.Connection;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.jdbc.PreparedStatement;

@Controller
public class select4 {
	
	
	@Inject
	//private DataSource dataSource;
	
	private SqlSessionFactory sqlFactory;
	Connection con = null;
	PreparedStatement ps = null;
	@RequestMapping("/select4.do")
	public String homepage() {
		try {
	//	con = dataSource.getConnection();
	SqlSession session = sqlFactory.openSession();
	System.out.println("db연결");
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "view/select4.jsp";
		
	}
	
}
