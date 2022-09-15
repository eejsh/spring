package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//어노테이션 AOP 사용시 pom.xml에 aspectj, aspectjweaver, aspectjrt 가 설치 되어있어야 합니다.

//AOP를 실행하는 class 이며, 어노테이션으로 자동 구분되도록 합니다.
@Aspect  //xml 에서 선언하지 않은 <aspect> 태그 대신 사용하는 구문
public class aop_aspect {
	
	
	//Around는 무조건 return을 사용해야합니다. (return사용 안할 시 aop Around 실행만 출력됨.. )
	@Around("within(aop.aop_class7)") 
	//객체 프로그램이 실행 전, 후 모두 적용되게 하는 공통 메소드입니다. (before, after 둘다작동)
	public Object aroundlog(ProceedingJoinPoint jp) throws Throwable {
		//Throwable : Exception과 동일한 예외처리이며, 예외처리 최상위 클래스입니다.
		System.out.println("aop Around 실행");
		return jp.proceed(); 	//proceed class는 thread에서 run 처럼 작동하는 원리입니다. (무조건 리턴) 
	}
	
	
//	//어노테이션은 xml에서 태그 대신 역활을 사용하게 됩니다.   
//	@Before("within(aop.aop_class7)") // 객체 프로그램이 실행하기 전에 작동되는 메소드
//	public void beforelog() {
//		System.out.println("AOP BEFORE 실행");
//	}

//	@After("within(aop.aop_class7)")//객체 프로그램이 실행하고 나서 작동되는 메소드
//	public void afterlog(){
//		System.out.println("AOP After 로그 실행");
//	}
	
}

