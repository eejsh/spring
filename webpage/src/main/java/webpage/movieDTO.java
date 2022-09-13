package webpage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("moviedto") //해당 class 메모리에 등록
public class movieDTO {

	@Resource(name="sqlTemp") // sql 문법을 실행 할 수 있는 문법
	private SqlSessionTemplate session;  //movie_api2.java : sqlsessio = .opensession()에서 넘어온 정보값
	
//	public void apitest() {
//		System.out.println("DTO 출력"); movie_api2 와 연결확인!
//	}
	
	//자바 클래스에 대한것을 넣어주면됨.
	public List<movieDAO> list(String date1, String date2){

		//2개 이상의 인자값을 xml에 적용 시 map을 이용하여 키값으로 동일한 #{value1}.. 이름으로 key배열을 생성함
		Map map = new HashMap();
		map.put("value1", date1);
		map.put("value2", date2);
		
		List<movieDAO> apidata = session.selectList("sql.select_api2", map); //키 배열값을 적용
		
		
		return apidata;
		
	}
	
	
	
}

//select * from apimovie where indate between '2022-09-08 00:00:00' and '2022-09-08 23:59:59'
