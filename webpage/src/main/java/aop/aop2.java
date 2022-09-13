package aop;
//aop_class2.java 실행

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class aop2 {

	
	@RequestMapping("/aop2.do")
	public void aopbox() {
		//applicationcontext 가 선언 되어있으면 bean.xml 확인하면 값이 어디서 주입되는지 확인 할 수 있음 
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		aop_class2 ac2 = ac.getBean("bb", aop_class2.class);
		//getter 메소드를 로드하여 결과값을 출력하는 부분
//		System.out.println(ac2.getBox1());
//		System.out.println(ac2.getBox2());
//		
		
		
	}
	
}
