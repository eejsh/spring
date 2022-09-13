package mydb;

import java.util.*;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class select4 {
	@Inject
	private SqlSessionFactory sqlFactory;   
			
	@Resource(name="xmlJava")
	private xmljava xmljava;
	
	
	
	
	@RequestMapping("/member_delete.do")
	public String delectdb(String mid, String mpw, String mnm, Model m) {
		
		System.out.println(mid+mpw+mnm);
		SqlSession del = sqlFactory.openSession();
		
		String userdel = xmljava.userdelete(mid, mpw, mnm);
		
		m.addAttribute("msg", userdel);
		
		return "view/insertok";
		
	}
	
	
	
	
	
	
	//정보수정
	@RequestMapping("/member_update.do")
	public String updatemb(String mid, String mnm, String mpw, Model m) {
	
		try {
		SqlSession modify = sqlFactory.openSession();
		String result = xmljava.updateuser(mid,mnm,mpw);
		m.addAttribute("msg",result);
		
			
		}catch (Exception e) {

		}
		
		return "view/insertok";
	}
	
	
	@RequestMapping("/select5.do")
	public String insertmb(Model m, String mid, String mpw, String mnm, String mtel, String mage) {
		
		System.out.println(mid + mpw + mnm + mtel + mage);
		try {
			
			SqlSession session = sqlFactory.openSession();
			String call = xmljava.userinsert(mid, mpw, mnm, mtel, mage);
			System.out.println(call);
			String msg= null;
			
			if(call=="ok") {
				m.addAttribute("msg", call);
			}
			else {
				m.addAttribute("msg","error");
			}
			
		}catch (Exception e) {
			
		}
		
		return "view/insertok";
	}
	
	
	@RequestMapping("/select4.do")
	public String homepage(Model m) {
		try {
			
	SqlSession session = sqlFactory.openSession();
	//System.out.println("db연결");

	//List<uservo> datas = xmljava.selectall();
			
		/*	System.out.println(datas.size()+"명 입니다.");
			uservo uv = xmljava.selectid("park");
			System.out.println("사용자이름 : " + uv.getMnm()
			+ "  사용자 아이디 : " + uv.getMid());
				uservo uv1 = xmljava.selectid("kim");
			System.out.println("사용자이름 : " + uv1.getMnm()
			+ "  사용자 전화번호 : " + uv.getMtel());
			*/
		//m.addAttribute("list", datas);
			
		//나이
		int age = 40;
		List<uservo> datas2 = xmljava.selectage(age);
		m.addAttribute("list", datas2);
		
		
		}catch (Exception e) {
		System.out.println("연결오류");
		e.getStackTrace();
		}
		
		return "view/select4";
		
	}
	
}


