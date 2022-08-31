package test3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // controller임을 알려주는 표시파일
@RequestMapping("/getinfo")

public class getinfo{

	
	/*
	 * Mapping 을 사용하는 이유는 컨트롤러를 통합하여 별도의 view가 필요없이 사용할 때 이용하게 됩니다.
	 * view 1개 + controller 1개 <= 다수의 class 파일들 
	 * 
	 * */
	
	
	private String TAG = getinfo.class.getSimpleName();
	
	
	//@GetMapping("/data") // get 형태로 데이터를 받음
	@RequestMapping(value="./t1", method=RequestMethod.GET)
	public String test01_get() { 
	
		return "getinfo/t1";
	}

	//@PostMapping("/data2") // post 형태로 데이터를 받음
	@RequestMapping(value="./t2", method = RequestMethod.POST)
	public String test02_post() { 
	
		return "getinfo/t2";
	
	}

	
//	@Override  // view 에 값을 던저주는 역활
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//	System.out.println("test");
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("getinfo.jsp");
//		
//		return mv;
//	}


}
