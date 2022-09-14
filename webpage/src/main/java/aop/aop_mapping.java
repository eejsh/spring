package aop;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

//web실행부분
@Controller
public class aop_mapping {
	
	
	
	@Autowired
	BasicDataSource dataConnect;
	
	Connection con = null;
	PreparedStatement pr = null;
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("aop_log.xml");
	
	@RequestMapping("/memberin.do")
	public void memberin(){
	try {
		this.con = dataConnect.getConnection();
		
		String mid = "jung";
		String pass = "a123456";
		//MD5로 변경
		String pass2 = DigestUtils.md5DigestAsHex(pass.getBytes());
		//Object pass2 = DigestUtils.md5DigestAsHex(pass.getBytes()); //pass - md5로 암호화시킴
		
		String mnm = "정경호";
		String mtel = "01023567845";
		String mage = "37";
		
		String sql = "insert into test3 values('0',?,?,?,?,?)";
		this.pr = con.prepareStatement(sql);
		this.pr.setString(1, mid);
		this.pr.setString(2, pass2);
		this.pr.setString(3, mnm);
		this.pr.setString(4, mtel);
		this.pr.setString(5, mage);
		
		System.out.println(this.pr);
		
		int n = 0;
		n=pr.executeUpdate();
		if(n>0) {
			System.out.println("회원가입이 완료되었습니다.");
		}
		
		
		aop_query aq = ac.getBean("querys", aop_query.class);
	
	//	aq.delete();
		aq.insert();
		
	}catch (Exception e) {
		e.getStackTrace();
	}
	
		
	}
	

	@RequestMapping("/memberdel.do")
	public void memberdel() {
		 	try {
				aop_query aq = ac.getBean("querys", aop_query.class);
				aq.delete();
			}catch (Exception e) {
				// TODO: handle exception
			}
	}
	
	
}
