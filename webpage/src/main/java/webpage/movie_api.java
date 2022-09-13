package webpage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp.BasicDataSource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class movie_api {
//매핑주소는 .do 안붙이는게 좋음, 한글깨짐..ㄴ
//restcontroller -? 별도의 view를 안쓰고 자체적으로 사용할떄 선언함.
// http://localhost:8080/webpage/movie?apikey=123456789
	
	//requestmapping 은 get, post 둘다 받을수 있음
	//method=RequestMethod.GET : front에서 전송된 데이터를 get으로만 통신하겠다는 뜻입니다.
	//@GetMapping,@PostMapping,@PutMapping,@DeleteMapping 은 method 속성을 절대 별도로 지정하지 않습니다.
	private String apikey = null;
	private String apidate = null;
	private String result = null;
	
	protected String json_parsing = null;
	
	@Autowired
	BasicDataSource dataConnect;
	
	@RequestMapping(value="/movie", produces="text/html; charset=utf-8", method=RequestMethod.GET) //리턴값에 대한 인코딩셋
	public String apiserver(String apikey, String apidate, HttpServletResponse res) {
		
	//	res.setContentType("text/html; charset=utf-8");  //html 강제 출력이므로 한글 깨짐있을수 있음(서블릿 관련 )
		
		this.apikey = apikey;
		this.apidate = apidate;
		
		//get으로 오면 null로 올 경우는 없습니다..
		//if(apikey=="" || apikey==null) {
		//this.out.print("<script>alert('올바른 접근이 아닙니다.'); history.go(-1); </script>");}
		
		//http://localhost:8080/webpage/movie 로 접근시 .. apikey값이 없을 시 null 조건으로 잡음. catch로 던진다고 생각해야됨. 

		// apikey, 날짜가 안넘어오면 올바른접근이아닙니다 출력!
		//http://localhost:8080/webpage/movie?apikey=12345   date값 없음. 
		try {

			this.apikey = apikey;
			if(!this.apikey.equals("null")||!this.apikey.equals("")) {
				if(this.apikey.equals("movie_abc") && !this.apidate.equals("")) {   //날자값있고 키는 movie_abc이여아만..
					//DB호출
					//http://localhost:8080/webpage/movie?apikey=movie_abc&apidate=2022-09-08  ->ok
					
					
					//mybatis 사용시 없어짐. sql
					Connection con = dataConnect.getConnection();
					String sdata = this.apidate + " 00:00:00";
					String edata = this.apidate + " 23:59:59";
					
					String sql = "select * from apimovie where indate >= ? and indate <= ? ";
					
					// order by 조심..ㅋㅋ 데이터는 1부터 오름차순으로 주는게 좋음..
					
					PreparedStatement pr = con.prepareStatement(sql);
					pr.setString(1, sdata);
					pr.setString(2, edata);
					
					ResultSet rs = pr.executeQuery();

					JSONArray ja = new JSONArray();
					//JSON 배열 형태로 받아야 프론트로 값이 넘어감!
					while(rs.next()) {
						JSONObject jb = new JSONObject();
						jb.put("aidx", rs.getString("aidx"));
						jb.put("arank", rs.getString("arank"));
						jb.put("arankpart", rs.getString("arankpart"));
						jb.put("aperson", rs.getString("aperson"));
						jb.put("anm", rs.getString("anm"));
						jb.put("indate", rs.getString("indate"));
						//json_parsing = jb.toString();
					//	ja.add(jb.toJSONString());  //..\까지 나옴.. 
						ja.add(jb);
						
					}
					result =ja.toJSONString();
					
				}else {
					
					//http://localhost:8080/webpage/movie?apikey=123&2022-09-08 -> error : {해당 api가 올바르지 않습니다. }
				
					result = " error1 : {해당 api가 올바르지 않습니다. }";
				}
				
			}
			
		}catch (Exception e) { // null값이 오면 발동되는 파트
			result = " error2 : {해당 api가 올바르지 않습니다. }";
			
			
		}
		return result;
	}
	
	
}


/*  --- api 기본세팅 , 페이지 로드 확인!
	@RequestMapping(value="/movie", produces="text/html; charset=utf-8")
	public String apiserver() {
		return "이순신";
	}  */