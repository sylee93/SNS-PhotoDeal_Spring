package project.spring.ps.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.spring.ps.model.MemberVO;
import project.spring.ps.model.ReplyVO;
import project.spring.ps.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyRestController {
	@Autowired
	private ReplyService rs;
	
	@RequestMapping("/writeReply")
	public ReplyVO writeReply(HttpServletRequest request, HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute("member");	
		ReplyVO reply = new ReplyVO();
		reply.setCreator(member.getId());
		reply.setPhotoId(Integer.parseInt(request.getParameter("photoId")));
		reply.setContent(request.getParameter("writeRf"));
		int result = rs.insertReply(reply);
		ReplyVO replyAjax = new ReplyVO();
		if(result > 0) {
			replyAjax = rs.selectReplyAjax(reply);
		} else {
			replyAjax = null;
		}
		return replyAjax;	
	}
	@RequestMapping("/deleteReply")
	public int deleteReply(HttpServletRequest request) {
		int replyId = Integer.parseInt(request.getParameter("replyId"));
		int result = rs.deleteReply(replyId);
		return replyId;	
	}
	@RequestMapping("/updateReply")
	public ReplyVO updateReply(HttpServletRequest request) {
		int replyId = Integer.parseInt(request.getParameter("replyId"));
		ReplyVO replyMsg = rs.replyMsg(replyId);
		return replyMsg;	
	}
}
