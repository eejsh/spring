package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import junit.framework.Test;

@Controller
public class aop_test {

	
	/*
	 AOP 의존성 여부에 대한 사항을 프로세서로 구현하시오.
	 bean에서는 class만 로드를 해야 하며, controller에서 값이 이입이 되어서 출력이 되어야 합니다.
	 결과 출력은 다음과 같습니다.
	 김옥자 님의 포인트는 2500 입니다.
	 */
	
	@RequestMapping("/aop_test.do")
	public void testaop() {
	
		ApplicationContext ac = new ClassPathXmlApplicationContext("test.xml");
		//object? 둘다 문자? :선택의나름..
		
		aop_setter as  = ac.getBean("test", aop_setter.class);
		String result = as.message("김옥자", "2500");   //의존성 주입	, 변수값에 인자값태워서보내세요..
		
		System.out.println(result);
		
		
	}
}
