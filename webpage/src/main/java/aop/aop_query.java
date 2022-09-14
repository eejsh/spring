package aop;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.DigestUtils;

//각종 query
public class aop_query {
	
	//setter, getter
	aop_info info = new aop_info();
	
	//회원가입 파트
	public void insert() {
		info.aop_info2("insert");
	}
	
	public void delete() throws Exception{
		 //해당값을 주입
		info.aop_info2("delete");
		System.out.println("사용자삭제");
	}
	
}
