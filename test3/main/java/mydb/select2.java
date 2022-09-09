package mydb;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


// DI + DAO

@Controller
public class select2 {
	
	@Autowired
	BasicDataSource dataSource;   //dbconnect.xml 로드

	//select2 생략가능. this.datasource에 바로들어갈수잇음. 단, 생략시 this.dataSource 사용x, datasource(o)
	
	public select2(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	//컨트롤파트! requestMapping 이 있으면 컨트롤!
	
	@RequestMapping("select2.do")
	public String dbselect2(Model m) {
		//model_dao (DAO class를 호출하면서 db정보를 DI 해주는 형태)
		
	model_dao da = new model_dao(this.dataSource);  //model_dao에 보내줌.
	da.d_select();
	
	String ct = da.d_select();
	
	//System.out.println(ct); model_dao에서 값이 넘어옴
	
	m.addAttribute("count", ct);
	
	
	return "view/select2";
		
	}
	
	
	
}
