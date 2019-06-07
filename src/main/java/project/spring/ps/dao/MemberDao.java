package project.spring.ps.dao;

import project.spring.ps.model.MemberVO;

public interface MemberDao {

	MemberVO checkLogin(String id);

	int userInsert(MemberVO member);

	String selectId(String id);

	String selectNic(String nicName);

}
