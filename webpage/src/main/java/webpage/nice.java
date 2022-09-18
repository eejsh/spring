package webpage;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class nice {
//인증만 받으면됨 getter,setter 필요없음	
	
	private String username=null;
	private String usertel = null;
	
	
	//view 에 값 던저줘야됨 -> return
	
	
	@PostMapping(value="/nice_joinok.do")
	//produces=\"text/html; charset=UTF-8
//	@RequestMapping(value="/nice_joinok.do", produces="text/html; charset=utf-8", method = RequestMethod.POST) 
	public String nice_method(Model m, String username, String usertel) {
		//username, usertel : front에서 넘어온 값
		
		this.username = username;
		this.usertel = usertel;
		
		m.addAttribute("username", username);
		m.addAttribute("usertel", usertel);
		
		
		return "nice_check";
		
	}
	
}


//return "nice_check.jsp" .jsp 삭제 가능.. mapping.xml에 <jsp prefix="/WEB-INF/views/" suffix=".jsp"/> 선언해서 .jsp 없어도됨!

//filter-매핑 encoding 없으면 euckr or 직접 설정하고있을수있음..
