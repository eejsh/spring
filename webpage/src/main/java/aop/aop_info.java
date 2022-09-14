package aop;

import java.security.Provider.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//log 관련 class 및 method에는 별도로 servlet 관련 정보 및 인자값에 객체를 넣으면 aop시작시 에러 무조건 발생함!

//connect는 상관없으나 	@Autowired 못읽음

//log 기록 class
public class aop_info {
//xml에서 autowired 를 인식 하지 못함. 
//	@Autowired
//	BasicDataSource dataConnect;
//	Connection con = null;
//	PreparedStatement pr = null;

	String dbdriver = "com.mysql.jdbc.Driver";
	String dburl = "jdbc:mysql://umj7-009.cafe24.com/eejsh08";
	String dbuser = "";
	String dbpw = "";

	static String url = "";
	
	//강제setter xml에서 after로..
	public void aop_info2(String url) {
	
	this.url = url;
	System.out.println(this.url);
	}
	
	public void log_indata() throws Exception {
		//public void log_indata(안에 넣으면 인식안됨..)
		
		// logdata : ip, 파라미터값, 실행된url주소, 등등 필요한 데이터 넣기.

		try {
			
		Class.forName(dbdriver);
		Connection con = DriverManager.getConnection(dburl,dbuser,dbpw);

		String sql = "insert into logdata values ('0',?)";
		PreparedStatement pr = con.prepareStatement(sql);

		pr.setString(1, this.url);
		pr.executeUpdate();
		
		System.out.println("로그 실행");
		System.out.println(pr);
			
		}catch (Exception e) {
		}
		

	}

}
