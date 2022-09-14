package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class aop5 {
// 싱글톤 :  class 로드 (ex :Abc ab = new Abc();   객체 하나에 인스턴스 올리기 )
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("bean3.xml");
	
	@RequestMapping("/aop5.do")
	public void aop5_method() {
		
		
		aop_class5 ac5 = new aop_class5();  //반복문 안에 들어가면 반복문 수만큼 메모리 할당됨
		System.out.println(ac5);
		
		aop_class5 ac5_1 = new aop_class5(); // new 메모리할당
		System.out.println(ac5_1);
		
		//a,b 가 다른 인스턴스(메모리)에 올려짐. c = a 를 로드
		//test1 이라는 객체가 메모리에 등재 
		aop_class5 a = ac.getBean("test1", aop_class5.class);
		//test2 이라는 객채가 메모리에 등재
		aop_class5 b = ac.getBean("test2", aop_class5.class);
		//test1 이라는 객체를 메모리에서 로드함
		aop_class5 c = ac.getBean("test1", aop_class5.class);
		
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		if(a==c) {
			System.out.println("a와 c에 있는 인스턴스는 같습니다.");
		}
		if(a==b) {
			System.out.println("a와 b에 있는 인스턴스는 같습니다.");
		}else {
			System.out.println("b의 인스턴스는 새로운 주소값 입니다");	
		}

		
	}
	
}
