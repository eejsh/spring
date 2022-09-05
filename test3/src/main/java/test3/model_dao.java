package test3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;

//DAO : select (setter.getter 모두 생성해서 사용하기)


public class model_dao {
	
	@Autowired // ioc에 등록된 bean에 대한 id 값을 가져와서 사용하는 형태

	BasicDataSource dataSource; // dbquerys에 db 접속 한번에 가능

	Connection con = null;
	PreparedStatement pr = null;
	String sql = null;
	
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

	//모델 형태
	
	//dbdatabase 로드 부분
	//arraylist<>에 model_dao 바로 집어넣겠음..
	public ArrayList<model_dao> getAlllist(){
		
		ArrayList<model_dao> list = new ArrayList<>();
		
		try {
			
			con = dataSource.getConnection();
			String sql = "select count(*) as cnt from test3";

			pr = con.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			
			
			while(rs.next()) {
			
				model_dao bean = new model_dao();        
				bean.setMidx(rs.getString("midx"));
				bean.setMid(rs.getString("mid"));
				bean.setMpw(rs.getString("mpw"));
				bean.setMnm(rs.getString("mnm"));
				bean.setMtel(rs.getString("mtel"));
				bean.setMage(rs.getString("mage"));
				list.add(bean);
				
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
		
		
		return list;
		
	}
	
	
	
	
}
