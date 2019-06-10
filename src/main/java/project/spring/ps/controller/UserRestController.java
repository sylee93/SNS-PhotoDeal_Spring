package project.spring.ps.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.spring.ps.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {
	@Autowired
	private UserService us;

	@RequestMapping(value = "idCheck" , produces = "application/text;charset=UTF-8")
	public String idCheck(HttpServletRequest request) {
		String checkMsg = null;
		String id = request.getParameter("id");
		String result = us.selectId(id);
		if(id.length() > 5) {
			if(id.equals(result)) {
				System.out.println("[UserRestController.java] idCheck : result = " + result);
				checkMsg = "이미 등록된 아이디 입니다.";
			} else {
				checkMsg = "사용 가능한 아이디 입니다.";
			}
		} else {
			checkMsg = "아이디의 길이는 6 ~ 16자리로 설정해주시기 바랍니다.";
		}
		return checkMsg;
	}
	@RequestMapping(value = "nicCheck" , produces = "application/text;charset=UTF-8")
	public String nicCheck(HttpServletRequest request) {
		String nicCheckMsg = null;
		String nicName = request.getParameter("nicName");
		String result = us.selectNic(nicName);
		if(nicName.equals(result)) {
			System.out.println("[UserRestController.java] nicNameDuplicateCheck : result = " + result);
			nicCheckMsg = "이미 등록된 닉네임 입니다.";	
		} else {
			nicCheckMsg = "사용 가능한 닉네임 입니다.";
		}
		return nicCheckMsg;
	}
	@RequestMapping(value = "mailCheck" , produces = "application/text;charset=UTF-8")
	public String mailCheck(HttpServletRequest request) {
		String mailCheckMsg = null;
		String email = request.getParameter("email");
		String result = us.selectEmail(email);
		
		// 이메일 형식 지정 및 패턴 추출, 비교
		String regExp = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
		Pattern mailPattern = Pattern.compile(regExp);
		Matcher mailMatcher = mailPattern.matcher(email);
		boolean mailResult = mailMatcher.matches();
		
		System.out.println("mailMatcher : "+ mailMatcher);
		System.out.println("mailResult : "+ mailResult);
		
		if(email.equals(result)) {
			System.out.println("[UserRestController.java] emailCheck : result = " + result);
			mailCheckMsg = "이미 등록된 Email 입니다.";	
		} else if(mailResult == true) {
			mailCheckMsg = "사용 가능한 Email 입니다.";
		} else {
			mailCheckMsg = "이메일 형식이 올바르지 않습니다.";
		}
		return mailCheckMsg;
	}

}
