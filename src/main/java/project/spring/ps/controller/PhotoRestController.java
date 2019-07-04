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
			int zzimUp = ps.updateZzimUp(photoId);
			if (result <= 0){
				heart = "image/greyHeart.png";
			}
		} else {
			int result = ps.deleteZzim(attention);
			int zzimDown = ps.updateZzimDown(photoId);
			if(result > 0) {
				heart = "image/greyHeart.png";
			} else {
				heart = "image/redHeart.png";
			}
		}
		return heart;
	}
	@RequestMapping(value = "donwloadCheck", produces = "application/text;charset=UTF-8")
	public String donwloadCheck(HttpServletRequest request, HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		String id = member.getId();
		System.out.println(" id ==== " + id);
		String result = null;
		
		int price = Integer.parseInt(request.getParameter("price"));
		int point = ps.selectPrice(id);
		if (price > point) {
			result = "보유 포인트가 부족합니다.";
		} else {
			MemberVO updateMember = new MemberVO();
			int photoId = Integer.parseInt(request.getParameter("photoId"));
			updateMember.setId(id);
			updateMember.setPoint(price);
			int resultDownCount = ps.updateDownCount(photoId);
			int resultPoint = ps.updatePoint(updateMember);
			int reultUpdate = resultDownCount * resultPoint; 
			if (reultUpdate > 0) {
				result = "성공";
			} else {
				result = "실패";
			}
		}
		return result;
	}
}
