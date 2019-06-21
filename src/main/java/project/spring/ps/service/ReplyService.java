package project.spring.ps.service;

import java.util.List;

import project.spring.ps.model.ReplyVO;

public interface ReplyService {

	List<ReplyVO> selectReplyList(int photoId);

	int insertReply(ReplyVO reply);

	ReplyVO selectReplyAjax(ReplyVO reply);

	int deleteReply(int replyId);

	int updateReply(ReplyVO reply);

	ReplyVO replyMsg(int replyId);

}
