package project.spring.ps.dao;

import java.util.List;

import project.spring.ps.model.ReplyVO;

public interface ReplyDao {

	List<ReplyVO> selectReplyList(int photoId);

}
