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
	
	
	
	@RequestMapping("/fileupload2.do")
	public String serverupload(Model m, MultipartFile file2, HttpServletRequest req)throws Exception {
	
		//첨부파일에 파일이 등록 되었을 경우.
		if(!file2.equals("")) { 
			//req.getServletContext().getRealPath(""); : 서버 상대경로. 
			
			//업로드할 파일 type을 확인 하는 사항. 특히 exe파일은 꼭 막는게 좋음.
			String filetype = file2.getContentType();  
			System.out.println(filetype); 
			
			//스플릿이나 indexof , datatype, text.. doc 등 이미지 파일이 없을 시 오류메세지 출력할수있음. 
			//indexof -1 로 출력 시 파일확인하세요! 식으로사용가능... 
			if(!filetype.equals("image/jpeg") || !filetype.equals("image/png") || !filetype.equals("image/jpg")) {				System.out.println("해당 업로드는 이미지만 가능합니다..");
			System.out.println("해당 업로드는 이미지만 가능합니다.. ");
			}else {
				
			String dictory = req.getServletContext().getRealPath("");
			
			String upload_dictory = dictory + "upload/"; 
			// 상대경로 + upload 
			
			File fe = new File(upload_dictory);
			if(!fe.exists()) {
				fe.mkdir();
			}
			System.out.println(upload_dictory);

			//String filename = file2.getName();
			String filename = file2.getOriginalFilename(); //추천..
			String copyfile	= upload_dictory+filename;
			
			FileCopyUtils.copy(file2.getBytes(), new File(copyfile));
			
			m.addAttribute("result_file", copyfile);
		
			}//filetype if문끝!
				
		}else {
			m.addAttribute("result_file", "첨부파일이 없습니다.");
		}
		
		return "view/okfile";
	

	}

	
		@RequestMapping("/fileupload3.do")
		public String fileup2(Model m, MultipartFile files[], HttpServletRequest req)  throws Exception{
		
		String directory = req.getServletContext().getRealPath("");
		System.out.println(directory);
		
		String upload_dd = directory + "upload/";
		File fe = new File(upload_dd);
		String filess[] = new String[3];
		String url = null;
		
		if(!fe.exists()) {
			fe.mkdir();
		}

		int w=0;
		while(w<3) {
		 filess[w] = files[w].getOriginalFilename();
		 url = upload_dd+filess[w];
		 String copyfile = upload_dd+filess[w];
		 FileCopyUtils.copy(filess[w].getBytes(), new File(copyfile));
			w++;
		}
		
		m.addAttribute("result_ff", url);
			return "view/fileview";
			
		}
	}


/*
 * 자바 : 객체지향프로그램, 로컬경로만 사용했었음.
fileinputstream
				
서블릿 : input, outputstream

jsp: 라이브러리 cos

스프링 : 라이브러리를 xml 으로 설정,(파일 용량 등)
multifile로 업로드 시킴

파일 업로드 구현?
스프링안씀.......--> 서블릿으로 구현해야됨
스프링사용시 스프링으로...........
 * 
 * 
 * */
