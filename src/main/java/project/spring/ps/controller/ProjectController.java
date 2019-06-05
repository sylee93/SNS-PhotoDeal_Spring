package project.spring.ps.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.spring.ps.model.MemberVO;
import project.spring.ps.service.UserService;

@Controller
public class ProjectController {
	@Autowired
	private UserService us;
	
	@RequestMapping(value="homeView", method = {RequestMethod.POST,RequestMethod.GET})
	public String homeView(HttpServletRequest request,HttpSession session ,Model model) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		System.out.println("member확인 2222: " + member);
		String checkId = null;
		String logOutFlag = request.getParameter("logOutFlag");
		System.out.println("logOutFlag : " +logOutFlag);
		if(logOutFlag != null) { 
			session.invalidate();
			System.out.println("if:"+member);
		}
		else {
			logOutFlag = "0";
			System.out.println("else:"+member);
		}
		if (member == null ) {
			System.out.println("wellcome!!");
		}
		else {
			checkId = member.getId();
		}
		System.out.println();
		String id = request.getParameter("id");
		if(id == null) { id = "guest";}
		String pw = request.getParameter("pw");
		System.out.println("[controller.jsp]homeView33 : checkId =" + checkId);
		System.out.println("[controller.jsp]homeView33 : id =" + id);
		System.out.println("[controller.jsp]homeView34 : pw ="+ pw);
		if(id != "guest" && checkId == null) {
			member = us.checkLogin(id);
			if(member == null) {
				System.out.println("homeView member null");
			} else {
				checkId = member.getId();
			}
			String checkResult = "success";
			System.out.println("[controller.jsp]homeView39 : CheckId = " + checkId);
			System.out.println("[controller.jsp]homeView40 : id = " + id);
			if(id.equals(checkId)) {
				String checkPw = member.getPw();
				System.out.println("[controller.jsp]homeView43 : pw ="+ pw);
				System.out.println("[controller.jsp]homeView44 : checkPw ="+ member.getPw());
				if(checkPw.equals(pw)) {
					System.out.println("로그인 성공");
					member.setId(checkId);
					member.setPw(checkPw);
					session.setAttribute("member", member);
					System.out.println("member확인 1111: " + member);
				} else {
					System.out.println("비밀번호 틀림");
					checkResult = "failPw";
				}				
			} else { 
				System.out.println("아이디 틀림");
				checkResult = "failId";
		}
		model.addAttribute("checkResult", checkResult);
		
		}
		return "homeView";
	}
	
	@RequestMapping(value="signUpView")
	public String signUpView() {
		return "signUpView";
	}
	
	@RequestMapping(value="categoryView")
	public String categoryView() {
		return "categoryView";
	}
	@RequestMapping(value="myPageView")
	public String myPageView() {
		return "myPageView";
	}
}
