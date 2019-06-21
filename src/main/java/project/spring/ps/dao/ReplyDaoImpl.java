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

	@Override
	public int insertReply(ReplyVO reply) {
		return session.insert("insertReply", reply);
	}

	@Override
	public ReplyVO selectReplyAjax(ReplyVO reply) {
		return session.selectOne("selectReplyAjax", reply);
	}

	@Override
	public int deleteReply(int replyId) {
		return session.delete("deleteReply", replyId);
	}

	@Override
	public ReplyVO replyMsg(int replyId) {
		return session.selectOne("replyMsg",replyId);
	}

	@Override
	public int updateReply(ReplyVO reply) {
		return session.update("updateReply",reply);
	}
}
