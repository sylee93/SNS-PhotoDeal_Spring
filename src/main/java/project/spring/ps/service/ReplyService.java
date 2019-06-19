package project.spring.ps.service;

import java.util.List;

import project.spring.ps.model.ReplyVO;

public interface ReplyService {

	List<ReplyVO> selectReplyList(int photoId);

}
