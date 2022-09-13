package test3;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class api {
////httpservletResponse resp : 외부서버에 대한 값을 전달
//	@RequestMapping("/check_page.do")
//	public void postck(@ModelAttribute ck ck, Model m, HttpServletResponse resp) throws IOException {   //ck이름 ck 클래스명
//		String result = "";
//		
//		if(ck.getSecurity().intern()=="a123456") {
//			result = "ok";
//			
//		}else{
//			result = "cancel";
//		}
//		System.out.println(result);
//		//allAttribute: 배열로 보내줄때 사용. (Map<String, ?>, attribute);
////		return "http://192.168.100.203:8080/test33/result.jsp";
//		
//		m.addAttribute("result", result);
//		
//	//	String url = "http://192.168.100.204:8080/test3/result.jsp?result="+result;
//		
//		String url = "http://192.168.100.239:8080/test33/result.jsp?result="+result;
//		resp.sendRedirect(url);
//		
//	}
	

	@RequestMapping("/dataload.do")
	public String da(Model m, @RequestParam("users") String user2) {
		/*requestparam : 받는 변수값을 다른 변수명으로 변환할 때 사용 하게 됩니다.. 임시방편용으로 쓰임..ㅠ
		 * 중복된 변수명이 있을 경우 requestparam으로 사용하면 사용가능. (users로 넘어오나 user2로 변환시켜 처리) */
		String callsign = user2;
		String call = "";
		if(callsign.equals("hong")) {
			call ="ok";
		}else {
			call="no";
		}
		m.addAttribute("call", call);
		
		return "view/result";
		
	}
	
}
