package project.spring.ps.controller;

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
	@RequestMapping(value = "idLengthCheck" , produces = "application/text;charset=UTF-8")
	public String idCheck(HttpServletRequest request ) {
		String checkMsg = null;
		String id = request.getParameter("id");
		System.out.println("[UserRestController.java] idLengthCheck : id.length() = " + id.length());
		if(id.length() < 6) {
			checkMsg = "아이디의 길이는 6 ~ 16자리로 설정해주시기 바랍니다.";
		}
		System.out.println("[UserRestController.java] idLengthCheck : checkMsg = " + checkMsg);
		
		return checkMsg;
	}
	@RequestMapping(value = "idDuplicate" , produces = "application/text;charset=UTF-8")
	public String idDuplicate(HttpServletRequest request) {
		String idDupleMsg = null;
		String id = request.getParameter("id");
		String result = us.selectId(id);
		if(id.equals(result)) {
			System.out.println("[UserRestController.java] idDuplicateCheck : result = " + result);
			idDupleMsg = "이미 등록된 아이디 입니다.";
		} else {
			idDupleMsg = "사용 가능한 아이디 입니다.";
		}
		return idDupleMsg;
	}
	@RequestMapping(value = "nicDuplicate" , produces = "application/text;charset=UTF-8")
	public String nicDuplicate(HttpServletRequest request) {
		String nicDupleMsg = null;
		String nicName = request.getParameter("nicName");
		String result = us.selectNic(nicName);
		if(nicName.equals(result)) {
			System.out.println("[UserRestController.java] nicNameDuplicateCheck : result = " + result);
			nicDupleMsg = "이미 등록된 닉네임 입니다.";	
		} else {
			nicDupleMsg = "사용 가능한 닉네임 입니다.";
		}
		return nicDupleMsg;
	}

}
