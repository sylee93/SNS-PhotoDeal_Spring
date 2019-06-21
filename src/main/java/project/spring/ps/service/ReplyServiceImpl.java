package project.spring.ps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.ps.dao.ReplyDao;
import project.spring.ps.model.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyDao rd;
	
	@Override
	public List<ReplyVO> selectReplyList(int photoId) {
		System.out.println("[ReplyServiceImpl.java] selectReplyList");
		return rd.selectReplyList(photoId);
	}

	@Override
	public int insertReply(ReplyVO reply) {
		System.out.println("[ReplyServiceImpl.java] insertReply");
		return rd.insertReply(reply);
	}

	@Override
	public ReplyVO selectReplyAjax(ReplyVO reply) {
		System.out.println("[ReplyServiceImpl.java] insertReply");
		return rd.selectReplyAjax(reply);
	}

	@Override
	public int deleteReply(int replyId) {
		System.out.println("[ReplyServiceImpl.java] deleteReply");
		return rd.deleteReply(replyId);
	}

	@Override
	public ReplyVO replyMsg(int replyId) {
		System.out.println("[ReplyServiceImpl.java] replyMsg");
		return rd.replyMsg(replyId);
	}

	@Override
	public int updateReply(ReplyVO reply) {
		System.out.println("[ReplyServiceImpl.java] updateReply");
		return rd.updateReply(reply);
	}
}
