package test3;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class upload {

	@RequestMapping("/fileupload.do")	
	public String filesok(Model m, MultipartFile file1, HttpServletRequest req ) throws Exception{
	
		//fileupload : 바이너리파일은 Exception 필수임. 스프링은 exception만 달아도 인식 잘됨!
		//파일은 오브젝트형태가아님
		/*file1 : files.jsp에 있는 (post)name값이 file1로 옴. multipartfile file1로 설정
		단, 여러개의 파일을 받을 경우 multipartfile[] file1 (배열) 설정으로 해서 받으면됨. */
		
		//로컬로 파일 업로드.
		String dictory = "c:\\upload\\";   //경로만 바꾸면 서버에서 사용 가능함!

		String filename = file1.getOriginalFilename();
		String url = dictory + filename;
		File fe = new File(dictory);
		if(!fe.exists()) {
			fe.mkdir();   //make dictory 의 약자!
		}
		
		if(filename.equals("")) {
		url ="첨부파일은 없습니다.";
			
		}else {
			//사용자가 업로드 하는 파일명을 알아오는 부분
			FileCopyUtils.copy(file1.getBytes(), new File(url));
		//	FileCopyUtils.copy : ajax, (form)post 둘다 사용이 가능합니다.
		//  파일 복사 기능을 말하며, write+stream 을 합친 형태로 인식을 합니다. 	
			System.out.println(filename);
		}
		
		m.addAttribute("result_file",url);
		return "view/okfile";
	}
	
	
	
	@RequestMapping("/fileupload.do2")
	public String serverupload() {
	return null;
	
	}
	
	

}
