package aop;

public class aop_class6 {
//로그 추가..? 파일마다 수정해야됨. 
//aop_log al = new aop_log();
   
	
	public void memberin() throws Exception {
		//al.logs();
		Thread.sleep(3000);
		System.out.println("회원가입 메소드");
	}
	
	public void memberinfo() {
		//al.logs();
		System.out.println("회원개인 정보 메소드");
	}
	
	public void memberlogin() {
		//al.logs();
		System.out.println("회원로그인 메소드");
	}
	
	public void memberupdate() {
		//al.logs();
		System.out.println("회원정보 수정 메소드");
	}
	
	public void memberdel() {
		//al.logs();
		System.out.println("회원정보 삭제 메소드");
	}
}
