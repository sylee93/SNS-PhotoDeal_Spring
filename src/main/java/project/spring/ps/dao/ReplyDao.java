package project.spring.ps.dao;

import java.util.List;

import project.spring.ps.model.ReplyVO;

public interface ReplyDao {

	List<ReplyVO> selectReplyList(int photoId);

	int insertReply(ReplyVO reply);

	ReplyVO selectReplyAjax(ReplyVO reply);

	int deleteReply(int replyId);

	int updateReply(ReplyVO reply);

	ReplyVO replyMsg(int replyId);

}
