package mydb;

import java.sql.*;
import java.util.ArrayList;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
//모델파트
//DAO : select (setter.getter 모두 생성해서 사용하기)
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class model_dao {
//xml에 있는 id값을 model에서 직접적으로 핸들링 할 수 없습니다.
	@Autowired
	BasicDataSource dataSource; //null로 표기가 됨 ( 모델까지 안오고 컨트롤에서 끝남.. , 컨트롤에서 view, module에서사용됨.)
	
	Connection con = null;
	PreparedStatement pr = null;
	
	
	private String midx;
	private String mid;
	private String mpw;
	private String mnm;
	private String mtel;
	private String mage;
	
	
	public String getMidx() {
		return midx;
	}
	public void setMidx(String midx) {
		this.midx = midx;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMnm() {
		return mnm;
	}
	public void setMnm(String mnm) {
		this.mnm = mnm;
	}
	public String getMtel() {
		return mtel;
	}
	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	public String getMage() {
		return mage;
	}
	public void setMage(String mage) {
		this.mage = mage;
	}
	
	//의존성 DAO, getter, setter.. 
	//컨트롤러에서 정보값을 받는 역활을 하게 될 예정
	public model_dao(BasicDataSource dataSource) {
		this.dataSource = dataSource;
		// 모델 dataSource를 끌어와서 넣음
		// 모델에선 xml로 바로 접근하기 힘듬 ( mapping이힘듬, xml에 bean 등록하지않은이상)
		
		System.out.println(dataSource);
	}
	 
	public String d_select() {   //DB을 연결 시켜서 SQL을 실행시킴
		//getter,setter 사용시 public arraylist 사용
		
		
		//Model 사용안됨! 리퀘스트매핑 사용하지않아서 .. 
		String ct = null;
		
		try {
			con = this.dataSource.getConnection();
			String sql = "select count(*) as ctn from test3 ";
			pr = con.prepareStatement(sql);

			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				ct = rs.getString("ctn"); 
			}
			System.out.println(rs.next());  //false
			
		}catch (Exception e) {
		
		}finally {
			try {  //con.pr 둘다 종료시켜줘야됨. 
				if(pr != null) pr.close();
				if(con != null) con.close();
			}catch (Exception ee) {
			}
		}
		
		
		
		return ct;
		
	}
	
	
	
}
