package project.spring.ps.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.spring.ps.model.PhotoVO;

@Repository
public class PhotoDaoImpl implements PhotoDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<PhotoVO> latestBoard() {
		return session.selectList("latestBoard");
	}

	@Override
	public List<PhotoVO> likeBoard() {
		return session.selectList("likeBoard");
	}

	@Override
	public List<PhotoVO> downloadBoard() {
		return session.selectList("downloadBoard");
	}

}
