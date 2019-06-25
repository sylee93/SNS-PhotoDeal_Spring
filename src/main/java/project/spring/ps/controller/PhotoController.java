package project.spring.ps.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

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
		int viewUp = ps.updateView();
		PhotoVO photo = ps.selectPhoto(photoId);
		String creatorId = photo.getPhotoCreator();
		MemberVO creator = ps.selectCreator(creatorId);
		List<ReplyVO> replyList = rs.selectReplyList(photoId);
		if (replyList != null) {
			model.addAttribute("replyList", replyList);
		}
		model.addAttribute("photo",photo);
		model.addAttribute("creator",creator);
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
	@RequestMapping("/writeView")
	public String whriteView() {
		return "writeFormView";
	}
	@RequestMapping("/writeInfoView")
	public String writeInfoView(HttpServletRequest request, Model model, MultipartFile photoPath) throws IOException {
		String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
		String savedName = uploadFile(photoPath.getOriginalFilename(), photoPath.getBytes(), uploadPath);
		model.addAttribute("savedName",savedName);
		return "writeInfoView";
	}
	private String uploadFile(String originalName, byte[] fileData, String uploadPath) throws IOException {
		UUID uid = UUID.randomUUID();
		// requestPath = requestPath + "/resources/image";
		System.out.println("[UserController.java] uploadFile : uploadPath = " + uploadPath);
		// Directory 생성
		File fileDirectory = new File(uploadPath);
		if (!fileDirectory.exists()) {
			fileDirectory.mkdirs();
			System.out.println("[UserController.java] uploadFile : 업로드용 폴더 생성 : " + uploadPath);
		}

		String savedName = uid.toString() + "_" + originalName;
		// String path1 =
		// "C:\\spring\\springSrc39\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\sMybatis\\resources\\image";
		File target = new File(uploadPath, savedName);
		// File target = new File(requestPath, savedName);
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}
	
	@RequestMapping("/writeProView")
	public String writeProView(HttpServletRequest request, Model model, HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		String id = member.getId();
		String savedName = request.getParameter("savedName");
		int priceStatus = Integer.parseInt(request.getParameter("priceStatus"));
		int point = Integer.parseInt(request.getParameter("point"));
		String hashTag = request.getParameter("hashTag");
		String comment = request.getParameter("comment");
		comment = comment.replaceAll("\r\n", "<br>");
		if(priceStatus == 0) {
			priceStatus = 1;
		} else {
			priceStatus = 2;
		}
		
		System.out.println("savedName : " + savedName);
		System.out.println("priceStatus : " + priceStatus);
		System.out.println("point : " + point);
		System.out.println("hashTag : " + hashTag);
		System.out.println("comment : " + comment);
		System.out.println("id : " + id);
		
		PhotoVO photo = new PhotoVO();
		photo.setPhotoCreator(id);
		photo.setHashTag(hashTag);
		photo.setPhotoPath(savedName);
		photo.setPrice(point);
		photo.setPriceStatus(priceStatus);
		photo.setComment(comment);
		
		int result = ps.insertPhoto(photo);
		int insertPhotoResult = result;
		model.addAttribute("insertPhotoResult",insertPhotoResult);
		return "writeProView";
	}
	@RequestMapping("/photoModifyView")
	public String photoModifyView(HttpServletRequest request) {
		String photoId = request.getParameter("photoId");
		return null;
	}
}