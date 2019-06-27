package project.spring.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.ps.dao.MemberDao;
import project.spring.ps.model.MemberVO;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private MemberDao md;

	@Override
	public MemberVO checkLogin(String id) {
		System.out.println("[UserServiceImpl.java] checkLogin");
		return md.checkLogin(id);
	}

	@Override
	public int userInsert(MemberVO member) {
		System.out.println("[UserServiceImpl.java] userInsert");
		return md.userInsert(member);
	}

	@Override
	public String selectId(String id) {
		System.out.println("[UserServiceImpl.java] selectId");
		return md.selectId(id);
	}

	@Override
	public String selectNic(String nicName) {
		System.out.println("[UserServiceImpl.java] selectNic");
		return md.selectNic(nicName);
	}

	@Override
	public String selectEmail(String email) {
		System.out.println("[UserServiceImpl.java] selectEmail");
		return md.selectEmail(email);
	}

	@Override
	public String selectPw(String id) {
		System.out.println("[UserServiceImpl.java] selectPw");
		return md.selectPw(id);
	}

	@Override
	public int updateUser(MemberVO member) {
		System.out.println("[UserServiceImpl.java] updateUser");
		return md.updateUser(member);
	}

	@Override
	public String selectMyNic(String id) {
		System.out.println("[UserServiceImpl.java] selectMyNic");
		return md.selectMyNic(id);
	}

	@Override
	public int updateProfile(MemberVO member) {
		System.out.println("[UserServiceImpl.java] updateProfile");
		return md.updateProfile(member);
	}

	@Override
	public int selectFollowCount(String id) {
		System.out.println("[UserServiceImpl.java] selectFollowCount");
		return md.selectFollowCount(id);
	}

	@Override
	public int selectFollowCount2(String id) {
		System.out.println("[UserServiceImpl.java] selectFollowCount2");
		return md.selectFollowCount2(id);
	}

	@Override
	public int selectFollowerCount(String id) {
		System.out.println("[UserServiceImpl.java] selectFollowerCount");
		return md.selectFollowerCount(id);
	}

	@Override
	public int selectFollowerCount2(String id) {
		System.out.println("[UserServiceImpl.java] selectFollowerCount2");
		return md.selectFollowerCount2(id);
	}
}
