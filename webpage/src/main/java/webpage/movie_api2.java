package webpage;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//리턴없는 api 메소드사용법
@RestController
public class movie_api2 extends HttpServlet{
	String apikey = null;
	String apidate = null;
	String result = null;
	PrintWriter pr = null;
	
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Resource(name="moviedto") //DTO세팅
	private movieDTO dto;  //moviedto class 모두 호출.
	
	
	
	@RequestMapping(value = "/movie_api", produces = "text/html; charset=utf-8", method = RequestMethod.GET)
	public void apidata (String apikey , String apidate, HttpServletResponse resp) {
		//System.out.println(apikey + apidate); 
		//http://localhost:8080/webpage/movie_api?apikey=movie_abc&apidate=2022-09-08 ->확인
		this.apikey = apikey;
		this.apidate = apidate;
		
		resp.setContentType("text/html; charset=utf-8"); // 한글깨짐방지용
		
		
		try {
			pr = resp.getWriter();
		//printwriter 사용시 httpservlet 사용 , model 사용시 별도 method, view 필요
			
				if(this.apikey.equals("movie_abc") && !this.apidate.equals("")) {   //날자값있고 키는 movie_abc이여아만..
			//	dto.apitest();  DTO출력
				String date1 = this.apidate + " 00:00:00";
				String date2 = this.apidate + " 23:59:59";
				
			SqlSession session = sqlFactory.openSession();
			List<movieDAO> apidata = dto.list(date1, date2);
			
			//System.out.println(apidata.size());
			
			//api 키 배열 생성 및 출력 파트 
			int w = 0;
			JSONArray ja = new JSONArray();  //묶음단위 배열생성
			while(w < apidata.size()) {
				JSONObject jo = new JSONObject();  //키배열 생성
				jo.put("arank", apidata.get(w).getArank());
				jo.put("arankpart", apidata.get(w).getArankpart());
				jo.put("aperson", apidata.get(w).getAperson());
				jo.put("anm", apidata.get(w).getAnm());
				
				ja.add(jo);
				w++;
			}
			pr.write(ja.toString());			
				
			}else {
			//key, date 오류 시 error 31 실행
				pr.print("Error:31");
			}
		//else{result ="error 32"}  32번 오류? 데이터날짜 키 안보냄.. 이런식으로 엑셀에 정리하여 파악
		}catch (Exception e) {

			pr.print("ERROR : 32");
		}
		
		
		
	}
	
	
}
