package aop;

import org.aspectj.lang.annotation.Aspect;

@Aspect //AOP 기본 어노테이션
public class aop_class1 {

	public String test() {
		String data = "홍길동";
	return data;
	}
	
	 public int testbox() {
		 int data = 10;
		 return data;
	 }
	
}





//파일에 s붙음.. : spring에서 가져옴
