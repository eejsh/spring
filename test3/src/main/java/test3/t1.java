package test3;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller //컨트롤러 class 지정
public class t1 {
//requserMapping : 내가 사용하고자 하는 주소를 지정함!
	@RequestMapping("/notice")
	public String n(HttpServletRequest req){ //servlet 형태로 mapping
		
		String msg  = "게시판 공지사항 내용 출력";
		req.setAttribute("msg", msg);
		return "view/dataview";
		
	}
	
	@RequestMapping("/notice_write")
	public String n2(Model model) {  //  model로 자료를 저장하는 형태 
		String msg = "게시판 글쓰기 페이지";
		model.addAttribute("msg", msg);
		return "view/dataview";
	}
	
	
	@RequestMapping("/sum")  // 매핑주소 (가상의 주소)
	//매핑주소 장점: 실질적인 서블렛이 있는경우가 아님. 컨트롤러로 작동  sum, notice.. 가상의 주소로 매핑되어있어 실제 파일에 접근하기 어려움. 
	
	//requestMapping은 기본적으로 String 으로 선언
	public String sums(Model model, int a, int b) {
	//int a, int b : 파라미터값(get, post) , spring get, post 구분없이 전송가능
	//단, a, b에 해당되는 파라미터로 보내줘야됨. 해당 파라미터가 없을 경우 오류가 발생하게 됩니다. 
		int data1 = a + b;
		model.addAttribute("msg",data1);
		return "view/dataview";
	}
	
	
//	@RequestMapping("/sum2")
//	public String sums(HttpServletRequest req, Model model, int a, int b) {
//		//a, b에 해당되는 파라미터로 보내줘야됨.. 
//		int data1 = Integer.parseInt(req.getParameter("a"));
//		int data2 = Integer.parseInt(req.getParameter("b"));
//		int data3 = data1 * data2;  // object 출력 됨..
//		model.addAttribute("msg", data3);
//		return "view/dataview";
//	}
	
	@RequestMapping("/login.do")
	public String indata(){ // view 만 사용 (model X)
		return "view/indata";
		
	}
	
	//아이디 찾기 mapping 및 class 주소
	/*ModelAttribute : POST, GET, PUT... 값이 전송이 되면 오브젝트 형태로 매핑을 해주게 됩니다.
	 매핑 형태는 해당 class를 로드 한 후 변수값과 전송된 값을 비교하여 자동으로 매칭을 시켜줍니다. 	*/
	//SessionAttribute : session 
	
	@RequestMapping("/loginok.do")
	public String serachid(Model m, @ModelAttribute login login) {
	    											//일반/클래스이름
		
		//DB - select 파트 ( 아이디 체크 하는부분..)
		String userid="";
		
		if(login.getUsernm().equals("홍길동") && login.getUseremail().equals("hong@nate.com")) {
			userid ="hong_giledong";
		}else {
			userid="해당 아이디는 찾을 수 없습니다.";
			}
		
		//view로 값을 출력하는 부분.
		m.addAttribute("usernm", login.getUsernm());
		m.addAttribute("useremail", login.getUseremail());
		m.addAttribute("userid", userid);
		return "view/result";
		
	}
	
	
	
}
