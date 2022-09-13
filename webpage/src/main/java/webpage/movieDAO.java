package webpage;
//getter, setter  database 와 필드명 동일하게 세팅
//

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class movieDAO {
	
	private String aidx;
	private String arank;  // 랭크
	private String arankpart; // 순위, ODL, NEW
	private String aperson;  //누적관객수
	private String anm;  // 영화제목
	private String indate;  //등록일자
	
}
