package test1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class index implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		System.out.println("test");

	//addObject : 배열형식
	
	ModelAndView mv = new ModelAndView();
	mv.addObject("msg", "spring 잘 되고있습니다..");
	//mv.setViewName("/WEB-INF/view/index.jsp");
	
	//setView  : URL이 이동되면서 완전 다른 화면으로 (강제)이동 할 때 (location)
	//setViewName : URL이동엔 변화가 없고 해당 화면을 자신의 페이지에서 출력 및 request 가 실행됨.
	
	request.setCharacterEncoding("utf-8");
	
	String aa = "hong";
	request.setAttribute("id", aa);
	
	
	return mv;
	
 //view 
	
	}
	
}
