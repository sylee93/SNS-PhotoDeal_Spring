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
}
