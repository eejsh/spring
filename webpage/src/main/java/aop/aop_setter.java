package aop;

public class aop_setter {

 private String user;
 private String money;
 	public String message(String user, String money) {
 		
 		this.user = user;
 		this.money = money;
 	
 		String msg = this.user + "님 포인트는 " + this.money + "입니다. ";
 		
 		return msg;
 		
 	}
}
