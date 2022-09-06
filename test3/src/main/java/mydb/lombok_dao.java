package mydb;

import lombok.Getter;
import lombok.Setter;

@Getter     //getter  메소드 전체 생성
@Setter		//setter 메소드 생성

//lombok 라이브러리 및 플러그인 사용 
public class lombok_dao {  //데이터 통신을 주고 받기 편하게 만들어진 라이브러리.

	private String userid;
	private String username;
	private String userage;
	
}
