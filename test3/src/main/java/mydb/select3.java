package mydb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class select3 {

@RequestMapping("select3.do")	
	public String lombox(Model m) {
	
	
	//각 setter 값을 전달
	lombok_dao ld = new lombok_dao();
	ld.setUserid("hong");
	ld.setUsername("홍길동");
	ld.setUserage("30");
	
	
	//각각 DAO 값을 가져오는 getter 부분
	m.addAttribute("mid", ld.getUserid());
	m.addAttribute("nm", ld.getUsername());
	m.addAttribute("age", ld.getUserage());
	
	
	//view로 처리하는 부분.
	return "/view/select3";
	
}
}
