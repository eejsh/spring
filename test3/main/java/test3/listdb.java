package test3;

import java.sql.*;

//db접속
public class listdb {

	public String dburl = "";
	public String dbuser = "eejsh08";
	public String dbpw = "";
	public Connection con = null;
	public String dbDriver = "";
	
	public listdb() {

//		System.out.println(dbservice.mid);
		
	}


	public String insert(dbservice dbservice) throws SQLException, ClassNotFoundException{
		String result ="error";
		
		String mid = dbservice.mid;
		String mpw = dbservice.mpw;
		String usernm = dbservice.usernm;
		String tel = dbservice.tel;
		String age = dbservice.age;
		
		String sql = "insert into test3(midx,mid,mpw,mnm,mtel,mage)"
				+ " values('0',?,?,?,?,?)";
		
		
		Class.forName(dbDriver);
		con = DriverManager.getConnection(dburl,dbuser,dbpw);
		PreparedStatement pr = con.prepareStatement(sql);
		pr.setString(1, mid);
		pr.setString(2, mpw);
		pr.setString(3, usernm);
		pr.setString(4, tel);
		pr.setString(5, age);
		
		int n=0;
        n = pr.executeUpdate();
        
        if(n>0) {
        	result = "ok";
        }
        pr.close();
        con.close();
        return result;
		
	}


	

}
