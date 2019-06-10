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
		System.out.println("[controller.jsp]homeView : session.getAttributr(member) =  " + member);
		String checkId = null;
		String logOutFlag = request.getParameter("logOutFlag");
		System.out.println("logOutFlag : " +logOutFlag);
		if(logOutFlag != null) { 
			session.invalidate();
			System.out.println("[controller.jsp]homeView : session.invalidate? member = "+member);
		}
		else {
			logOutFlag = "0";
		}
		if (member == null ) {
			System.out.println("^^");
		}
		else {
			checkId = member.getId();
		}
		String id = request.getParameter("id");
		if(id == null) { id = "guest";}
		String pw = request.getParameter("pw");
		System.out.println("[controller.jsp]homeView : checkId =" + checkId);
		System.out.println("[controller.jsp]homeView : getParameter(id) =" + id);
		System.out.println("[controller.jsp]homeView : getParameter(pw) ="+ pw);
		if(id != "guest" && checkId == null) {
			member = us.checkLogin(id);
			if(member == null) {
				System.out.println("homeView member null");
			} else {
				checkId = member.getId();
			}
			String checkResult = "success";
			if(id.equals(checkId)) {
				String checkPw = member.getPw();
				System.out.println("[controller.jsp]homeView : checkPw ="+ member.getPw());
				if(checkPw.equals(pw)) {
					System.out.println("로그인 성공");
					member.setId(checkId);
					member.setPw(checkPw);
					session.setAttribute("member", member);
					System.out.println("[controller.jsp]homeView : session.setAttributr(member) = " + member);
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
	@RequestMapping(value="signUpProView")
	public String signUpProView(HttpServletRequest request, Model model) {
		MemberVO member = new MemberVO();
		String id = request.getParameter("id");
		String nicName = request.getParameter("nicName");
		
		
		member.setId(id);
		member.setNicName(nicName);
		member.setEmail(request.getParameter("email"));
		member.setPw(request.getParameter("pw"));
		
		int resultInsert = 0;
		String loginCheck = null;
		
		String resultId = us.selectId(id);
		String resultNic = us.selectId(nicName);
		
		if(id.equals(resultId)) {
			loginCheck = "sameId";
		} else if (nicName.equals(resultNic)) {
			loginCheck = "sameNic";
		} else {
			if(member != null) {
				resultInsert = us.userInsert(member);
				System.out.println("resultInsert : " + resultInsert);
				System.out.println("[controller.jsp] signUpProView : resultInsert = " + resultInsert);
			}
			model.addAttribute("resultInsert", resultInsert);
			return "signUpProView";
		}
		model.addAttribute("loginCheck",loginCheck);
		return "forward:signUpView";
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
