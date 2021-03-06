package project.spring.ps.service;


import project.spring.ps.model.MemberVO;

public interface UserService {

	MemberVO checkLogin(String id);

	int userInsert(MemberVO member);

	String selectId(String id);

	String selectNic(String nicName);

	String selectEmail(String email);

	String selectPw(String id);

	int updateUser(MemberVO member);

	String selectMyNic(String id);

	int updateProfile(MemberVO member);

	int selectFollowCount(String id);

	int selectFollowCount2(String id);

	int selectFollowerCount(String id);

	int selectFollowerCount2(String id);


}
