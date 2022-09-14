package aop;

public class aop_log {
	
	//aop에서 before, after 든 사용 시 발동되는 메소드
	//로그 : 별도로 빼서 사용하는 경우가 많음.
	
	public void logs() {
		System.out.println("로그기록 처리");
		System.out.println("******************");
		System.out.println("로그기록 처리완료");
	}
}
