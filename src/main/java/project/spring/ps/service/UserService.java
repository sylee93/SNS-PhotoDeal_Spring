package project.spring.ps.service;

import project.spring.ps.model.MemberVO;

public interface UserService {

	MemberVO checkLogin(String id);

}
