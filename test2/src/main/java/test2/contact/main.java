package test2.contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class main implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
/*		String pg = "contact." + request.getParameter("page");
		내용은 똑같은데 ?page= (view 만 계속 바뀔수 있음)
				http://abc.co.kr/notice/notice.do?page=(파라미터)
				http://abc.co.kr/notice/notice.do?page=list
				http://abc.co.kr/notice/notice.do?page=update
				http://abc.co.kr/notice/notice.do?page=wirte
				http://abc.co.kr/notice/notice.do?page=delete
				.....

	*/
		
		
		ModelAndView mv = new ModelAndView("contact.contact");
		//"contact.contact" : . 사용이유는 tiles.xml 과 연동. 그 외에는 / 가 기본으로 사용되어야 함. 
		//ModelAndView mv = new ModelAndView();
		return mv;
	}

}
