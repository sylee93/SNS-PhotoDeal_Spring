package project.spring.ps.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.spring.ps.model.MemberVO;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSession session;

	@Override
	public MemberVO checkLogin(String id) {
		System.out.println("[MemberDaoImpl.java] checkLogin : id = " + id);
		return session.selectOne("checkId", id);
	}
}
