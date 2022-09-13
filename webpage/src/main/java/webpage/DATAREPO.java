package webpage;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("dataRepo") //testweb.java에 @Resource name 
public class DATAREPO {

	@Resource(name="sqlTemp") //connect.xml에 mapper태그 실행부분id
	private SqlSessionTemplate s;
	
	public dataDAO select_test(String mid) {
		dataDAO t = s.selectOne("sql.select_test",mid); //mapper.xml에 매핑해둔 sql문 실행
		return t;
	}
}
