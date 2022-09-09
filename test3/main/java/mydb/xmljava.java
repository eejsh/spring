package mydb;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

//xml + controller + module


@Repository("xmlJava")  //repository : 해당 메소드 모두를 시스템 메모리 저장소에 기억시킴.
public class xmljava {
	
	
	/* 똑같이 bean으로 제작..
	 * @Autowired :특정값을 입력 받아 처리가 가능한 template //  <property>
	 * @Resource : 전체에 대한 template만 이용 //  <constructor>
	 
	*/ 
	@Resource(name="sqlSessionTemplate")  
	private SqlSessionTemplate session;  // sql 문법을 실행하기 위한 변수 세팅. bean 아이디와 동일해야됨. (SqlSessionTemplate 변수명아무거나..)
	
	// XMl에서 사용하는 ID 값이 중복 또는 오타가 발생할 경우 연결되지 않습니다. 
	
	/* mybatis언어 
	 * -selectList(여러개의 데이터를 가져올 때 사용)
	   -selectOne (1개의 데이터만 가져올 때 사용) */
	
	//사용자 전체 리스트 
	//모든 sql 문법 코드는 xml에 있는 namespace.id를 이용하게 됩니다. 
	//select에 관련된 메소드는 getter, setter에 이용되는 class명을 이용함. 
	public List<uservo> selectall (){
		List<uservo> userlist = session.selectList("userDB.selectall");
		return userlist;
		
	}
	//사용자에 대한 정보만 출력
	public uservo selectid(String id) {
		uservo user = session.selectOne("userDB.selectid", id);
		return user;
	}
	
	//public uservo 는 매핑되어있으므로 동일하게 사용해야 작동됨. selectage , selectid 부분만 변경해서 사용. 
	
	//사용자에 대한 해당 나이 범위만 출력
	public List<uservo> selectage(int age) {
		
		List<uservo> userlist = session.selectList("userDB.selectage", age);
		return  userlist;
	}
	
	//사용자 값 입력파트 
	public String userinsert(String mid, String mpw,String mnm, String mtel, String mage) {
		//getter, setter를 DTO상태에서 로드하여 mapper로 연동이 되도록 하게돕니다.
		uservo vo = new uservo();
		vo.setMid(mid);
		vo.setMpw(mpw);
		vo.setMnm(mnm);
		vo.setMtel(mtel);
		vo.setMage(mage);
		
		System.out.println(vo);
		
		session.insert("userDB.userinsert", vo);
		String sign ="ok";
		
		return sign;
	}
	
	public String updateuser(String mid, String mnm, String mpw) {
		
		uservo vo = new uservo();
		vo.setMid(mid);
		vo.setMnm(mnm);
		vo.setMpw(mpw);
		
		//session = null (데이터 수정 실패)
		session.update("userDB.userupdate", vo);
		String sign = "ok";
		
		return sign;
	}

	
	public String userdelete(String mid, String mpw, String mnm) {
		
		uservo vo = new uservo();
		vo.setMid(mid);
		vo.setMpw(mpw);
		vo.setMnm(mnm);
		
		session.delete("userDB.userdelete", vo);
		String sign="ok";
		return sign;
	
	
	}
	
	//session.selectOn : 1개의 데이터
	//session.selectlist : 여러개의 데이터를 불러올때 사용.
	//session.insert : 입력파트
	//session.update : 수저파트
	//session.delete : 삭제파트
	//session.clearCache(""); 비워주기..
	//session.selectMap("userDB.userupdate", "mid", vo);  : 키값 설정. 
	//session.selectMap : Object 데이터 입력을 사용함. 
	
 
	
	
}
