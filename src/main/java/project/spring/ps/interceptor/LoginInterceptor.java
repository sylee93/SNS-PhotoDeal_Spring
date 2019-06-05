package project.spring.ps.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import project.spring.ps.model.MemberVO;
import project.spring.ps.service.UserService;


public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	/*	HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		String checkId = member.getId();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("인터셉터"+id);
		if(checkId == null) {
			checkId = us.checkId(id);
			if(checkId == id) {
				member = us.memberInfo(checkId);
				String checkPw = member.getPw();
				
				if(pw == checkPw) {
				System.out.println("로그인 성공");
				session.setAttribute("member", member);
			}else {
				System.out.println("비밀번호 틀림");
				id = null;
				pw = null;
			} 
			}
		}
	*/
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
	}
		
}
