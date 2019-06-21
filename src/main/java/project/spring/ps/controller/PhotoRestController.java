package project.spring.ps.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.spring.ps.model.AttentionlistVO;
import project.spring.ps.model.MemberVO;
import project.spring.ps.model.ReplyVO;
import project.spring.ps.service.PhotoService;

@RestController
@RequestMapping("/photo")
public class PhotoRestController {
	@Autowired
	private PhotoService ps;
	
	@RequestMapping("/clickHeart")
	public String clickHeart(HttpServletRequest request, HttpSession session) {
		System.out.println("sdaffasafsafsd");
		MemberVO member = (MemberVO) session.getAttribute("member");
		String heart = "image/redHeart.png";
		int photoId = Integer.parseInt(request.getParameter("photoId"));
		String check = request.getParameter("check");
		System.out.println("check????????????? " + check);
		AttentionlistVO attention = new AttentionlistVO();
		attention.setAttentionId(member.getId());
		attention.setLikePhotoId(photoId);
		if(check.equals("grey")) {
			int result = ps.insertZzim(attention);
			if (result <= 0){
				heart = "image/greyHeart.png";
			}
		} else {
			int result = ps.deleteZzim(attention);
			if(result > 0) {
				heart = "image/greyHeart.png";
			} else {
				heart = "image/redHeart.png";
			}
		}
		return heart;
	}
}
