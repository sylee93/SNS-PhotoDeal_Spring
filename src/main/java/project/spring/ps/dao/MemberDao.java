package project.spring.ps.dao;

import project.spring.ps.model.MemberVO;

public interface MemberDao {

	MemberVO checkLogin(String id);

}
