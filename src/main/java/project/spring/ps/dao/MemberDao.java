package project.spring.ps.dao;

import project.spring.ps.model.MemberVO;

public interface MemberDao {

	MemberVO checkLogin(String id);

	int userInsert(MemberVO member);

	String selectId(String id);

	String selectNic(String nicName);

	String selectEmail(String email);

	String selectPw(String id);

	int updateUser(MemberVO member);

	String selectMyNic(String id);

	int updateProfile(MemberVO member);

}
