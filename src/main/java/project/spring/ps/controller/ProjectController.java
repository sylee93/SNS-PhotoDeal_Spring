package project.spring.ps.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import project.spring.ps.model.MemberVO;
import project.spring.ps.service.UserService;

@Controller
public class ProjectController {
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	@Autowired
	private UserService us;

	@RequestMapping(value = "homeView", method = { RequestMethod.POST, RequestMethod.GET })
	public String homeView(HttpServletRequest request, HttpSession session, Model model) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		System.out.println("[controller.jsp]homeView : session.getAttributr(member) =  " + member);
		String checkId = null;
		String logOutFlag = request.getParameter("logOutFlag");
		System.out.println("logOutFlag : " + logOutFlag);
		if (logOutFlag != null) {
			session.invalidate();
			System.out.println("[controller.jsp]homeView : session.invalidate? member = " + member);
		} else {
			logOutFlag = "0";
		}
		if (member == null) {
			System.out.println("^^");
		} else {
			checkId = member.getId();
		}
		String id = request.getParameter("id");
		if (id == null) {
			id = "guest";
		}
		String pw = request.getParameter("pw");
		System.out.println("[controller.jsp]homeView : checkId =" + checkId);
		System.out.println("[controller.jsp]homeView : getParameter(id) =" + id);
		System.out.println("[controller.jsp]homeView : getParameter(pw) =" + pw);
		if (id != "guest" && checkId == null) {
			member = us.checkLogin(id);
			if (member == null) {
				System.out.println("homeView member null");
			} else {
				checkId = member.getId();
			}
			String checkResult = "success";
			if (id.equals(checkId)) {
				String checkPw = member.getPw();
				System.out.println("[controller.jsp]homeView : checkPw =" + member.getPw());
				if (checkPw.equals(pw)) {
					System.out.println("로그인 성공");
					member.setId(checkId);
					member.setPw(checkPw);
					session.setAttribute("member", member);
					System.out.println("[controller.jsp]homeView : session.setAttributr(member) = " + member);
				} else {
					System.out.println("비밀번호 틀림");
					checkResult = "failPw";
				}
			} else {
				System.out.println("아이디 틀림");
				checkResult = "failId";
			}
			model.addAttribute("checkResult", checkResult);

		}
		return "homeView";
	}

	@RequestMapping(value = "signUpView")
	public String signUpView() {
		return "signUpView";
	}

	@RequestMapping(value = "signUpProView", method = RequestMethod.POST)
	public String signUpProView(HttpServletRequest request, Model model, MultipartFile profilePath, String path)
			throws Exception {
		MemberVO member = new MemberVO();
		String id = request.getParameter("id");
		String nicName = request.getParameter("nicName");
		String email = request.getParameter("email");
		String profile = request.getParameter("profilePath");

		String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
		System.out.println("uploadForm POST Start");
		System.out.println("originalName: " + profilePath.getOriginalFilename());
		System.out.println("size: " + profilePath.getSize());
		System.out.println("contentType: " + profilePath.getContentType());
		String savedName = uploadFile(profilePath.getOriginalFilename(), profilePath.getBytes(), uploadPath);
		System.out.println("savedName: " + savedName);
		System.out.println("profile => " + profile);
		if (profilePath.getOriginalFilename() == null || profilePath.getOriginalFilename() == "") {
			profile = "user.png";
		} else {
			profile = savedName;
		}
		System.out.println("profile1 => " + profile);
		member.setId(id);
		member.setProfile(profile);
		member.setNicName(nicName);
		member.setEmail(email);
		member.setPw(request.getParameter("pw"));

		int resultInsert = 0;
		String userCheck = null;

		String resultId = us.selectId(id);
		String resultNic = us.selectId(nicName);
		String resultEmail = us.selectEmail(email);

		if (id.equals(resultId)) {
			userCheck = "sameId";
		} else if (nicName.equals(resultNic)) {
			userCheck = "sameNic";
		} else if (email.equals(resultEmail)) {
			userCheck = "sameEmail";
		} else {
			if (member != null) {
				resultInsert = us.userInsert(member);
				System.out.println("resultInsert : " + resultInsert);
				System.out.println("[controller.jsp] signUpProView : resultInsert = " + resultInsert);
			}
			model.addAttribute("resultInsert", resultInsert);
			return "signUpProView";
		}
		model.addAttribute("userCheck", userCheck);
		return "forward:signUpView";
	}

	private String uploadFile(String originalName, byte[] fileData, String uploadPath) throws IOException {
		UUID uid = UUID.randomUUID();
		// requestPath = requestPath + "/resources/image";
		System.out.println("uploadPath->" + uploadPath);
		// Directory 생성
		File fileDirectory = new File(uploadPath);
		if (!fileDirectory.exists()) {
			fileDirectory.mkdirs();
			System.out.println("업로드용 폴더 생성 : " + uploadPath);
		}

		String savedName = uid.toString() + "_" + originalName;
		// String path1 =
		// "C:\\spring\\springSrc39\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\sMybatis\\resources\\image";
		File target = new File(uploadPath, savedName);
		// File target = new File(requestPath, savedName);
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}

	@RequestMapping(value = "categoryView")
	public String categoryView() {
		return "categoryView";
	}

	@RequestMapping(value = "myPageView")
	public String myPageView() {
		return "myPageView";
	}
}
