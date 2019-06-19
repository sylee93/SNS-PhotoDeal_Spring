package project.spring.ps.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.spring.ps.model.ReplyVO;

@Repository
public class ReplyDaoImpl implements ReplyDao {
	@Autowired
	private SqlSession session;
	
	@Override
	public List<ReplyVO> selectReplyList(int photoId) {
		return session.selectList("selectReplyList", photoId);
	}

}
