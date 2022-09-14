package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class aop6 {

	//aop6 class에서만 log 발동.
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("aop1.xml");
	
	@RequestMapping("/member_insert.do")
	public void member_insert() throws Exception {
		
		aop_class6 ac6 = ac.getBean("member", aop_class6.class);
		
		//System.currentTimeMillis() : 메소드가 실행 하는 지연시간을 확인할 때 사용하는 class 입니다. 
		
		long start = System.currentTimeMillis(); //시작시간
		Thread.sleep(3000);
		ac6.memberin();
		long end = System.currentTimeMillis(); //끝시간        
		
		long result = end-start;  //최종 해당 메소드 지연시간 확인
		
		System.out.println("지연시간 "+result);
		
		ac6.memberinfo();
		ac6.memberlogin();
		ac6.memberupdate();
		ac6.memberdel();
		
	}
	
}
