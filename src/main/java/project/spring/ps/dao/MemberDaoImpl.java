package project.spring.ps.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.spring.ps.model.MemberVO;
import project.spring.ps.model.PhotoVO;

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
		System.out.println("[MemberDaoImpl.java] userInsert : memberEmail = " + member.getEmail());
		System.out.println("[MemberDaoImpl.java] userInsert : memberPw = " + member.getPw());
		System.out.println("[MemberDaoImpl.java] userInsert : memberEmail = " + member.getEmail());
		System.out.println("[MemberDaoImpl.java] userInsert : memberNicName = " + member.getNicName());
		return session.insert("userInsert", member);
	}

	@Override
	public String selectId(String id) {
		return session.selectOne("selectId", id);
	}

	@Override
	public String selectNic(String nicName) {
		return session.selectOne("selectNic", nicName);
	}

	@Override
	public String selectEmail(String email) {
		return session.selectOne("selectEmail", email);
	}

	@Override
	public String selectPw(String id) {
		return session.selectOne("selectPw", id);
	}

	@Override
	public int updateUser(MemberVO member) {
		return session.update("updateUser", member);
	}

	@Override
	public String selectMyNic(String id) {
		return session.selectOne("selectMyNic", id);
	}

	@Override
	public int updateProfile(MemberVO member) {
		return session.update("updateProfile", member);
	}

	@Override
	public List<PhotoVO> latestBoard() {
		System.out.println("[PhotoDaoImpl.java] latestBoard");
		return session.selectList("latestBoard");
	}

	@Override
	public int selectFollowCount(String id) {
		System.out.println("[PhotoDaoImpl.java] selectFollowCount");
		return session.selectOne("selectFollowCount", id);
	}

	@Override
	public int selectFollowCount2(String id) {
		System.out.println("[PhotoDaoImpl.java] selectFollowCount2");
		return session.selectOne("selectFollowCount2", id);
	}

	@Override
	public int selectFollowerCount(String id) {
		System.out.println("[PhotoDaoImpl.java] selectFollowerCount");
		return session.selectOne("selectFollowerCount", id);
	}

	@Override
	public int selectFollowerCount2(String id) {
		System.out.println("[PhotoDaoImpl.java] selectFollowerCount2");
		return session.selectOne("selectFollowerCount2", id);
	}
}
