package test3;

import java.sql.*;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/*
Spring Database 연동 종류 형태

1. servlet 형태로 연결
2. IOC 형태로 연결(bean)
3. Mybatis 이용하여 연결하는 형태
-------------------------------------------
4. JPA 형태로 연결 ▶ spring boot 형태 (특강..)  

* */

@Controller
public class dbquerys {

	//DI (dependency Injection) web.xml 을 이용해서 기본적으로 잡고있음..
	//IOC (Inversion of Control) 객체에 따른 의존성 메소드 호출 - bead,  xml에 있는 정보를 받아와서 사용
	//class 로드를 별도 로드 할 필요 없이 xml에 있는 정보를 가져와서 사용.	ex)select도 한번 설정 하면 불러와서 사용가능..
	
	
	@Autowired		// ioc에 등록된 bean에 대한 id 값을 가져와서 사용하는 형태
	
	BasicDataSource dataSource;  //dbquerys에 db 접속 한번에 가능
	
	@RequestMapping("/select.do")
	public String db_select(Model m) {
		
		Connection con = null;
		PreparedStatement pr = null;
		
		try {
			
			con = dataSource.getConnection();
			String sql = "select count(*) as cnt from test3";
			
			pr = con.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			
			System.out.println(rs.next());
			
			while(rs.next()) {
				m.addAttribute("data_row", rs.getString("cnt"));
			}
			
		}catch(Exception e) {
		
			System.out.println(e.getMessage());
		
		}finally {
			
			try {
				if(pr != null)pr.close();
				
			}catch(Exception zz) {
				zz.printStackTrace();
			}
			try {
				if(con != null)con.close();
				
			}catch(Exception z) {
				
			}
			
		}
		
	return "view/select";	
	}
	
	
}


