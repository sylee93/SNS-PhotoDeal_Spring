package project.spring.ps.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.spring.ps.model.PhotoMemberVO;

@Repository
public class PhotoDaoImpl implements PhotoDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<PhotoMemberVO> latestBoard() {
		return session.selectList("latestBoard");
	}

	@Override
	public List<PhotoMemberVO> likeBoard() {
		return session.selectList("likeBoard");
	}

	@Override
	public List<PhotoMemberVO> downloadBoard() {
		return session.selectList("downloadBoard");
	}
}
