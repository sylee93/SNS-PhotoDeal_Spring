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

}
