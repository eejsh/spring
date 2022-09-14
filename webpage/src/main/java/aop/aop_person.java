package aop;

import lombok.Getter;

@Getter
public class aop_person {

	
	private String name;
	public String id;
	public int age;
	public int level;
	// aop4로 가져가서 사용(출력)하려면 getter는 만들어야됨..

	// 값이 두개 !
	// bean에서 값이 2개 이상 올때.. (constructor)

	public aop_person(String name, String id, int age, int level) {
		this.name = name;
		this.id = id;
		this.age = age;
		this.level = level;
	}


}
