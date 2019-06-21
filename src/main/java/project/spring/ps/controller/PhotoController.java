package project.spring.ps.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import project.spring.ps.model.PhotoVO;
import project.spring.ps.service.PhotoService;

@Controller
public class PhotoController {
	@Autowired
	private PhotoService ps;
	@RequestMapping(value = "detailPhotoView.do")
	public String detailPhotoView(HttpServletRequest request, Model model) {
		int photoId = Integer.parseInt(request.getParameter("photoId"));
		PhotoVO photo = ps.selectPhoto(photoId);
		model.addAttribute("photo",photo);
		return "detailPhotoView";
	}
}
