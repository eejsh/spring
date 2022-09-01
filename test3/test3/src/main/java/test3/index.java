package test3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class index implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	//	test3.listdb ld = new test3.listdb();
	
		ModelAndView mv = new ModelAndView();
		dbservice ds = new dbservice("kim", "a123456", "김길동", "01011112222", "35");
		
		listdb ld = new listdb();
		
		String msg = ld.insert(ds);
		
		mv.addObject("msg", msg);
		mv.setViewName("/index.jsp");
		return mv;
	}

}
