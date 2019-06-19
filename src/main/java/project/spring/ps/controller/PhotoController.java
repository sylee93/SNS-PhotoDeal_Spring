package project.spring.ps.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping(value = "detailPhotoView.do")
	public String detailPhotoView(HttpServletRequest request, Model model) {
		int photoId = Integer.parseInt(request.getParameter("photoId"));
		PhotoVO photo = ps.selectPhoto(photoId);
		List<ReplyVO> replyList = rs.selectReplyList(photoId); 
		System.out.println("[PhotoController.java] detailPhotoView : nicName = " + replyList.get(0).getNicName());
		model.addAttribute("photo",photo);
		model.addAttribute("replyList", replyList);
		return "detailPhotoView";
	}
}
