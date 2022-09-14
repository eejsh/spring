package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class aop4 {
//보통 필드에 올려서 필요할때마다 호출해서 사용함..
	ApplicationContext ac = new ClassPathXmlApplicationContext("bean2.xml");
	
	aop_person ap = ac.getBean("person", aop_person.class);
	aop_class4 ap4 = ac.getBean("aop4",aop_class4.class );

	@RequestMapping("/aop4.do")
	public void aop4_data() {
		//databases
		System.out.println(ap.getName());
		System.out.println(ap.getId());
		System.out.println(ap.getAge());
		
		System.out.println(ap4.getListdata());

		//레벨에 맞춰 출력..
		System.out.println(ap4.getListdata().get(ap.getLevel()));
	
	}
}

/*
  [내부시스템]
  직책, 상황[근무중=0(Y), 휴직상태=1(N), 퇴사상태=2(C)], 
  0,Y 등 한글로 출력할 때 사용함. 
  
  [회원정보]
  회원레벨, 빅데이터 / 지역[서울~제주도 ex(서울=0, 경기=1......등등] , 상태구분[가입, 휴먼]
 
  [프로젝트]
 사수[DB생성- Field를 공유...]
 enum('Y','B','C','N','D') --aop사용? class사용?  switch..
 
 */