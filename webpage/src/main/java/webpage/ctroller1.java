package webpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//view 와 controller형태를 같이 사용하는 형태

@Controller
public class ctroller1 {
	//ResponseBody : Controller에서 Mapping을 사용하더라도 
	//해당 java에서 웹페이지로 결과값을 바로 출력	
	@ResponseBody 
	@RequestMapping("/ctroller.do")
	public String test1() {
		return "ok";
	}
	
	@RequestMapping("/ctroller_web.do")
	public String test2() {
		return "ok";
	}
	
}
