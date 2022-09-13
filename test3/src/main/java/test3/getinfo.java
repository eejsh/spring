package test3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // controller임을 알려주는 표시파일

public class getinfo{
	//url 에 method를 연결시켜주는 어노테이션 입니다.
	
	@RequestMapping("/userinfo")
	public String abc(Model model) { 
		//modelandview : 배열 키값이 있는 형태로 저장하는 방식 
		//model : 서버 메모리에 자료를 저장하는 방식 입니다. (메모리저장소)
		
		String user ="홍길동";
		model.addAttribute("usernm", user);
	//	return "info";
		
		
		return "view/info2"; 
		
		//어드민이라는 디렉토리안에 info2 파일을 매칭..
//		return "admin.info2";
	// 디렉토리가 여러개 있으면 /해당 디렉토리명/을 넣어주기->리턴..> 매핑
		
		//q	/web-inf/view
		//mapping.xml에 view-resolver를 설정하지 않을경우 전부 작성해야됨!
		
		
	}

}
