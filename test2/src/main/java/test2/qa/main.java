package test2.qa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class main implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	

		ModelAndView mv = new ModelAndView("qa.qalist");
//		ModelAndView mv = new ModelAndView();
	
		return mv;
	}

	
	
}
