package test2;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class main implements Controller{

	//spirng mvc controller에서 사용하는 기본 객체 메소드 입니다.
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	//handleRequest 
		
		//html 에서 넘어온 값 핸들링해주는 곳
	int a = 50;
	int b = 80;
	
	int c = a+b;
	
	ModelAndView mv = new ModelAndView();
	mv.addObject("sum",c);
	//mv.setViewName("WEB-INF/view/main.jsp");
		return mv;
	}
	
	
}

/*
 * mv.setViewName("WEB-INF/viewer/main.jsp"); or 
 * servlet.xml에 설정해서사용하거나..
 <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver.class">
<property name="prefix" value="/WEB-INF/view"></property>
<property name="suffix" value=".jsp"></property>
</bean>
 */