package aopmaster;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class aop_controller {

	public static long start=0;
	
	@Autowired
	private BasicDataSource dataConnect;
	
	@RequestMapping("/aop.do")
	public void aop(String idx) {
		
		//http://localhost:8080/webpage/aop.do?idx=4 , 절대 get으로 받아처리하지않음..(외부에서 처리할수있음)
		
		// servie_class를 호출합니다. (interface setdao..등 인식) 
		// aop_servicetmp(interface)를 바로 불러오면 에러남 xml을 거쳐서 로드
		
		/* java(객체언어)는 웹에서 작동안됨! (servlet통해야됨) 
		  
		① interface 사용 시 해당 interface 메소드 이름을 먼저 로드해야 합니다.
		② web에서는 implements를 실행하지 못함. 객체지향 프로그램 형태이므로 interface를 로드해야 하며,
		xml(aopmaster.xml)에서 id로 연결된 class를 로드하게 됩니다.
		servicetmp를 실행
		*/
		ApplicationContext ac = new ClassPathXmlApplicationContext("aopmaster.xml");
		aop_service as = ac.getBean("service_class", aop_service.class);
		
		
		System.currentTimeMillis();  // 지연시간 체크
		System.out.println("웹프로그램실행");
		
		//aop에서는 DB Connect을 객체프로그램에서 직접적으로 운영하기는 힘듬니다.
		//xml에서 로드하여 출력하기때문에 다른 xml을 인식하지 못하는 사항이 발생합니다.
		try {
			System.out.println(idx);
			
			Connection con = dataConnect.getConnection();
			
			
			
			//삭제파트
			
			String sql = as.deletedb(idx);
			PreparedStatement pr = con.prepareStatement(sql);
			pr.executeUpdate();
			
			
			
		//	String sql = as.insertdb("./review/aop.jpg"); 	//해당 값을 주입시킵니다. sql문법으로 리턴받음 
		//	PreparedStatement pr =  con.prepareStatement(sql); //실행
		//	pr.executeUpdate(); //DB 입력

			
			//as.register();  //aop_servicetmp안에 메소드를 실행시키면 aop_daotmp가 적용되도록 힙나다.
			//System.out.println("웹프로그램실행");
			
			as.modify();
			System.out.println("웹프로그램실행");
			
		}catch (Exception e) {
			System.out.println("error");
		}
				
	}
	
}
