package webpage;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class joinpart {

	
	
	@Autowired
	BasicDataSource dataConnect;
	Connection con = null;
	PreparedStatement pr = null;
	
	//자회사몰 회원가입 페이지 (front)
	//자회사몰 회원가입 페이지
	@RequestMapping("/join.do")
	public String join() {
		return "join";
	}

	//자회사몰 회원등록 페이지(back)
	@RequestMapping("/joinok.do")
	public String joinok(Model m, String userid, String username, String useremail) {
	
		try {
			
			con = dataConnect.getConnection();
		    String sql = "insert into mall values('0', ?,?,?)";
			pr = con.prepareStatement(sql);
			pr.setString(1, userid);
			pr.setString(2, username);
			pr.setString(3, useremail);
		
			int n = 0;
			n = pr.executeUpdate();
			if(n>0) {
				m.addAttribute("result", "회원등록완료");
			}
		}catch (Exception e) {
			
				m.addAttribute("result", e);
		}
		return "joinok";
	}
	
	
	//카카오 회원가입 및 로그인 체크
	@RequestMapping("/kakaojoin.do")
	public String kakao(Model m  ,String userid, String username, String useremail) {
				
			try {
			
			con = dataConnect.getConnection();
		    String sql = "insert into kakao values('0', ?,?,?)";
			pr = con.prepareStatement(sql);
			pr.setString(1, userid);
			pr.setString(2, username);
			pr.setString(3, useremail);
		
			int n = 0;
			n = pr.executeUpdate();
			if(n>0) {
				m.addAttribute("result", "회원등록완료");
			}
		}catch (Exception e) {
			
				m.addAttribute("result", e);
		}
		return "kakao";
		
	}
	
	
	
	
}
