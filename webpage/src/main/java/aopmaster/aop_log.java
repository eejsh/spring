package aopmaster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.aspectj.lang.ProceedingJoinPoint;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

//지연시간 체크 및 계산 

public class aop_log {
	
	//xml에서 property로 값을 가져와서 변수로 저장하게 됨.
	//단 getter, setter 가 무조건 있어야 적용됩니다.
	
	//aopmaster에서 log기록담당에서 db데이터 가져옴
	private String jdbcurl;
	private String url;
	private String name;
	private String pw;
	
	public Object times(ProceedingJoinPoint jp) throws Throwable {
		 
		Class.forName(jdbcurl);
		 Connection con = DriverManager.getConnection(url,name,pw);
		 
		long start = 0;
		long end = 0;
		
		try {
			start = System.currentTimeMillis();
			Object ob = jp.proceed();
			System.out.println(jp.getTarget().getClass().getName());
			
			return ob;
		}catch (Exception e) {
			throw e;
		}finally {
			end = System.currentTimeMillis();
			String sql = "insert into logdata values('0', ?)";
			PreparedStatement pr = con.prepareStatement(sql);
			
			pr.setString(1, "총 지연시간 : " + (end-start));
			pr.executeUpdate();
			
			System.out.println("총 지연시간 : " + (end-start) );
		
			pr.close();
			con.close();
		}
		
	}
	

	public String getJdbcurl() {
		return jdbcurl;
	}


	public void setJdbcurl(String jdbcurl) {
		this.jdbcurl = jdbcurl;
	}


}
