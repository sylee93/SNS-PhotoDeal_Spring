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
		return session.selectOne("checkLogin", id);
	}

	@Override
	public int userInsert(MemberVO member) {
		System.out.println("[MemberDaoImpl.java] userInsert : member = " + member);
		System.out.println("[MemberDaoImpl.java] userInsert : memberId = " + member.getId());
		System.out.println("[MemberDaoImpl.java] userInsert : memberPw = " + member.getPw());
		System.out.println("[MemberDaoImpl.java] userInsert : memberEmail = " + member.getEmail());
		System.out.println("[MemberDaoImpl.java] userInsert : memberNicName = " + member.getNicName());
		return session.insert("userInsert", member);
	}

	@Override
	public String selectId(String id) {
		System.out.println("[MemberDaoImpl.java] selectId : id = " + id);
		return session.selectOne("selectId", id);
	}

	@Override
	public String selectNic(String nicName) {
		System.out.println("[MemberDaoImpl.java] selectNic : nicName = " + nicName);
		return session.selectOne("selectNic", nicName);
	}
}
