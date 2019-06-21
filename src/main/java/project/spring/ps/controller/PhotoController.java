package project.spring.ps.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import project.spring.ps.model.AttentionlistVO;
import project.spring.ps.model.MemberVO;
import project.spring.ps.model.PhotoVO;
import project.spring.ps.model.ReplyVO;
import project.spring.ps.service.PhotoService;
import project.spring.ps.service.ReplyService;

@Controller
public class PhotoController {
	@Autowired
	private PhotoService ps;
	@Autowired
	private ReplyService rs;
	
	@RequestMapping("/detailPhotoView")
	public String detailPhotoView(HttpServletRequest request, Model model, HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		int photoId = Integer.parseInt(request.getParameter("photoId"));
		if(member != null) {
			AttentionlistVO attentionlist = new AttentionlistVO();
			String id = member.getId();
			attentionlist.setAttentionId(id);
			attentionlist.setLikePhotoId(photoId);
			attentionlist = ps.selectZzim(attentionlist);
			model.addAttribute("attentionlist",attentionlist);
		}		
		PhotoVO photo = ps.selectPhoto(photoId);
		List<ReplyVO> replyList = rs.selectReplyList(photoId);
		if (replyList != null) {
			model.addAttribute("replyList", replyList);
		}
		model.addAttribute("photo",photo);
		return "detailPhotoView";
	}
	
	@RequestMapping("/updateReply")
	public String updateReply(HttpServletRequest request, Model model) {
		ReplyVO reply = new ReplyVO();
		int photoId = Integer.parseInt(request.getParameter("photoId"));
		System.out.println("photoId ::::::" + photoId);
		String content = request.getParameter("content");
		int replyId = Integer.parseInt(request.getParameter("replyId"));
		reply.setContent(content);
		reply.setReplyId(replyId);
		rs.updateReply(reply);
		PhotoVO photo = ps.selectPhoto(photoId);
		List<ReplyVO> replyList = rs.selectReplyList(photoId);
		if (replyList != null) {
			model.addAttribute("replyList", replyList);
		}
		model.addAttribute("photo",photo);
		return "detailPhotoView";
	}
}
