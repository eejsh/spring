package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//aop_class를 aop1에서 작동시킴
@Controller
public class aop1 {
	

	@RequestMapping("/aop1.do")
	public String aop(Model m) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		// ApplicationContext : 스프링 컨테이너 , bean.xml을 가져와서 로드함
		
						//getBean( bean id명, 클래스명 )
		aop_class1 z = ac.getBean("aa", aop_class1.class); //1 
		//aop_class1 z = (aop_class1) ac.getBean("aa");    //2
		//aop 패키지 안에 aop_class1 로드하겠다 선언..   1,2 방식
		//getBean : bean 태그를 조회 할 때 사용합니다.
		

		
		String zresult = z.test() + z.testbox();
		m.addAttribute("result", zresult);
		
				return "aop1";

	}

}
