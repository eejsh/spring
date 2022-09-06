package test3;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mydb.model_dao;

/*
Spring Database 연동 종류 형태

1. servlet 형태로 연결
2. IOC 형태로 연결(bean)
3. Mybatis 이용하여 연결하는 형태
-------------------------------------------
4. JPA 형태로 연결 ▶ spring boot 형태 (특강..)  

* */




//컨트롤
@Controller
public class dbquerys {

	@Autowired // ioc에 등록된 bean에 대한 id 값을 가져와서 사용하는 형태
	BasicDataSource dataSource; // dbquerys에 db 접속 한번에 가능
	Connection con = null;
	PreparedStatement pr = null;
	
	
	
//	// DI (dependency Injection) web.xml 을 이용해서 기본적으로 잡고있음..
//	// IOC (Inversion of Control) 객체에 따른 의존성 메소드 호출 - bead, xml에 있는 정보를 받아와서 사용
//	// class 로드를 별도 로드 할 필요 없이 xml에 있는 정보를 가져와서 사용. ex)select도 한번 설정 하면 불러와서 사용가능..
//
//	@Autowired // ioc에 등록된 bean에 대한 id 값을 가져와서 사용하는 형태
//
//	BasicDataSource dataSource; // dbquerys에 db 접속 한번에 가능
//
//	Connection con = null;
//	PreparedStatement pr = null;
//	String sql = null;
//	
//	
//	@RequestMapping("/insert.do")
//	public String dbinsert(Model m) throws Exception{
//
//		con = dataSource.getConnection();
//		sql = "insert into test3 values('0',?,?,?,?,?)";
//		
//		String msg = "error";
//		
//		pr = con.prepareStatement(sql);
//		pr.setString(1, "park");
//		pr.setString(2, "c1234657");
//		pr.setString(3, "박찬호");
//		pr.setString(4, "010123440808");
//		pr.setString(5, "48");
//		int n = pr.executeUpdate();
//		if(n>0) { msg ="ok"; }
//		m.addAttribute("result", msg);
//		
//		
//		return "view/insert";
//	}
//	
//	@RequestMapping("/update.do")
//	public String update(Model m) throws Exception{
//
//		con = dataSource.getConnection();
//		sql = "update test3 set mpw=? where midx =?";
//		
//		String mpw ="a1212";
//		String midx ="2";
//		String msg = "";
//		
//		pr =con.prepareStatement(sql);
//		pr.setString(1, mpw);
//		pr.setString(2, midx);
//		
//		int n = pr.executeUpdate();
//		if(n<0) {msg="변경됨"; }
//		
//		m.addAttribute("result2", msg);
//		
//		return "view/insert";
//	}
//	
//	
//	@RequestMapping("/select.do")	
//	public String db_select(Model m) {
//		try {
//			con = dataSource.getConnection();
//			String sql = "select count(*) as cnt from test3";
//			pr = con.prepareStatement(sql);
//			ResultSet rs = pr.executeQuery();
//
//			
//			//배열을 설정
//			/*class DAO, DTO(VO)
//			DAO : data Access object 객체생성 (getter, setter)
//				  생성(create), 읽기(select), 갱신(update), 삭제(delete)  여러개를 한꺼번에 설정..
//				  배열형태. 
//				  
//			DTO(vo): 읽기 전용! data transfer object 계층간 데이터 교환 , (VO : value object)
//			DTO : 읽기(select) -(getter, setter)  // ex: 1개의 게시판 내의 댓글삭제 시.. ?
//			*/
//			
//			while (rs.next()) {
//				//Map(setter, getter)
//				//add(키 배열로 등록)
//				m.addAttribute("data_row", rs.getString("cnt"));
//			}
//
//		} catch (Exception e) {
//
//			System.out.println(e.getMessage());
//
//		} finally {
//
//			try {
//				if (pr != null)
//					pr.close();
//			} catch (Exception zz) {
//				zz.printStackTrace();
//			}
//			try {
//				if (con != null)
//					con.close();
//			} catch (Exception z) {
//			}
//		}
//
//		return "view/select";
//	}
	
	@RequestMapping("/select.do")
	public String dbselect (Model m) {
	
		//DAO를 사용하지 않고, 배열형태로 생성 후 view 에서 jstl로 출력
	
		
		ArrayList<model_dao> list = new ArrayList<>();
		ArrayList<Map<String, Object>> pso = new ArrayList<Map<String,Object>>();
		
	    String sql = null;
		
		try {
		con = dataSource.getConnection();
//		sql = "select count(*) as cnt from test3";
		
		sql = "select * from test3";
		pr = con.prepareStatement(sql);
		  
			ResultSet rs = pr.executeQuery();
			//DB에 있는 필드값을 map으로 이관하는 형태
			while(rs.next()) {
			
				Map<String, Object> mp = new HashMap<String, Object>();
				mp.put("midx", rs.getString("midx"));
				mp.put("mid", rs.getString("mid"));
				mp.put("mpw", rs.getString("mpw"));
				mp.put("mnm", rs.getString("mnm"));
				mp.put("mtel", rs.getString("mtel"));
				mp.put("mage", rs.getString("mage"));
				
				pso.add(mp);  // 모든 데이터를 반복 ▶ arraylist 생성
				m.addAttribute("pso", pso);  // view 로 전송함s
				
			}
			
		}catch (Exception e) {
				System.out.println(e.getMessage());
		}finally {
			try {
				if (pr != null)	pr.close();
				if (con != null) con.close();
			}catch (Exception ee) {
					ee.printStackTrace();
			}
		}
	
		return "view/select";
		
	}
	
}
