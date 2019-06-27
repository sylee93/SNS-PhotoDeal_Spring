package project.spring.ps.dao;

import java.util.List;

import project.spring.ps.model.MemberVO;
import project.spring.ps.model.PhotoVO;

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

	List<PhotoVO> latestBoard();

	int selectFollowCount(String id);

	int selectFollowCount2(String id);

	int selectFollowerCount(String id);

	int selectFollowerCount2(String id);

}
