package project.spring.ps.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import project.spring.ps.model.MemberVO;
import project.spring.ps.model.PhotoVO;
import project.spring.ps.service.PhotoService;
import project.spring.ps.service.UserService;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService us;
	@Autowired
	private PhotoService ps;
	
	@RequestMapping(value = "homeView", method = { RequestMethod.POST, RequestMethod.GET })
	public String homeView(HttpServletRequest request, HttpSession session, Model model) {
		// 홈화면에 뿌려줄 사진 리스트	
		String sortType = request.getParameter("sortType");
		int checkSort = 0;
		int btnStatus = 0;
		if(sortType != null) {
			checkSort = Integer.parseInt(request.getParameter("sortType"));
			System.out.println("[UserController.java] homeView : sortType = " + sortType);
		}
		if (checkSort == 0) {
			System.out.println("[UserController.java] homeView : 최신순");
			List<PhotoVO> latestPhotoList = ps.latestBoard();
			btnStatus = 0;
			model.addAttribute("PhotoList",latestPhotoList);
			model.addAttribute("btnStatus",btnStatus);
		}else if(checkSort == 1) {
			System.out.println("[UserController.java] homeView : 인기순");
			List<PhotoVO> likePhotoList = ps.likeBoard();
			btnStatus = 1;
			model.addAttribute("PhotoList",likePhotoList);
			model.addAttribute("btnStatus",btnStatus);
		}else {
			System.out.println("[UserController.java] homeView : 다운순");
			List<PhotoVO> downloadPhotoList = ps.downloadBoard();
			btnStatus = 2;
			model.addAttribute("PhotoList",downloadPhotoList);
			model.addAttribute("btnStatus",btnStatus);
		}
		
		
		// 로그인
		MemberVO member = (MemberVO) session.getAttribute("member");
		System.out.println("[UserController.java] homeView : session.getAttributr(member) =  " + member);
		String checkId = null;
		String logOutFlag = request.getParameter("logOutFlag");
		System.out.println("[UserController.java] homeView : logOutFlag = " + logOutFlag);
		if (logOutFlag != null) {
			session.invalidate();
			System.out.println("[UserController.java] homeView : session.invalidate? member = " + member);
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
		System.out.println("[UserController.java] homeView : checkId =" + checkId);
		System.out.println("[UserController.java] homeView : getParameter(id) =" + id);
		System.out.println("[UserController.java] homeView : getParameter(pw) =" + pw);
		if (id != "guest" && checkId == null) {
			member = us.checkLogin(id);
			if (member == null) {
				System.out.println("[UserController.java] homeView : homeView member null");
			} else {
				checkId = member.getId();
			}
			String checkResult = "success";
			if (id.equals(checkId)) {
				String checkPw = member.getPw();
				System.out.println("[UserController.java] homeView : checkPw =" + member.getPw());
				if (checkPw.equals(pw)) {
					System.out.println("로그인 성공");
					session.setAttribute("member", member);
					System.out.println("[UserController.java] homeView : session.setAttributr(member) = " + member);
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
		String profile = null;

		String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
		System.out.println("[UserController.java] signUpProView : uploadForm POST Start");
		System.out.println("[UserController.java] signUpProView : originalName = " + profilePath.getOriginalFilename());
		System.out.println("[UserController.java] signUpProView : size = " + profilePath.getSize());
		System.out.println("[UserController.java] signUpProView : contentType = " + profilePath.getContentType());
		String savedName = uploadFile(profilePath.getOriginalFilename(), profilePath.getBytes(), uploadPath);
		System.out.println("[UserController.java] signUpProView : savedName = " + savedName);
		if (profilePath.getOriginalFilename() == null || profilePath.getOriginalFilename() == "") {
			profile = "user.png";
		} else {
			profile = savedName;
		}
		System.out.println("[UserController.java] signUpProView : profileResult => " + profile);
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
				System.out.println("[UserController.java] signUpProView : resultInsert = " + resultInsert);
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

	@RequestMapping(value = "categoryView")
	public String categoryView() {
		return "categoryView";
	}

	@RequestMapping(value = "userModifyView")
	public String userModifyView() {
		return "userModifyView";
	}
	@RequestMapping(value = "myPageView")
	public String myPageView(HttpServletRequest request, Model model, MultipartFile profilePath, String path, HttpSession session) throws IOException {
		MemberVO member = (MemberVO) session.getAttribute("member");
		String myPageStatus = request.getParameter("myPageStatus");
		System.out.println("[UserController.java] myPageView : myPageStatus: " +myPageStatus);
		String id = member.getId();
		System.out.println("[UserController.java] myPageView : sessionId = " + id);
		if(myPageStatus != null) {
			if(myPageStatus.equals("userModi")) {
				String pw = request.getParameter("pw");
				String beforePw = request.getParameter("beforePw");
				String checkPw = us.selectPw(id);
				String resultPw = "success";
				System.out.println("[UserController.java] myPageView : checkPw = "+checkPw);
				String resultModify = "successUpdateModify";
				
				if(checkPw.equals(beforePw)) {
					member.setNicName(request.getParameter("nicName"));
					member.setId(id);
					member.setPw(pw);
					int modUpdateResult = us.updateUser(member);
					if(modUpdateResult < 1) {
						resultModify = "failUpdateModify";
					}	
				} else {
					resultPw = "failPwCheck";
					model.addAttribute("resultPw",resultPw);
					return "forward:userModifyView";
				}
				model.addAttribute("resultModify",resultModify);
			} else if(myPageStatus.equals("profileModi")) {
				String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
				String profile = null;
				String baseImg = request.getParameter("baseImg");
				
				System.out.println("[UserController.java] myPageView : baseImg = " + baseImg);
				System.out.println("[UserController.java] myPageView : uploadForm POST Start");
				System.out.println("[UserController.java] myPageView : originalName = " + profilePath.getOriginalFilename());
				System.out.println("[UserController.java] myPageView : size = " + profilePath.getSize());
				System.out.println("[UserController.java] myPageView : contentType = " + profilePath.getContentType());
				String savedName = uploadFile(profilePath.getOriginalFilename(), profilePath.getBytes(), uploadPath);
				System.out.println("[UserController.java] myPageView : savedName = " + savedName);
				if (profilePath.getOriginalFilename() == null || profilePath.getOriginalFilename() == "" || baseImg == "0") {
					profile = "user.png";
				} else {
					profile = savedName;
				}
				member.setProfile(profile);
				member.setId(id);
				System.out.println("profile => " + profile);
				int profileResult = us.updateProfile(member);
				String resultProfile = "successUpdateProfile";
				if(profileResult < 1) {
					resultProfile = "failUpdateProfile";
				}
				model.addAttribute("resultProfile", resultProfile);
			}
		}
		/*model.addAttribute("myPageStatus",myPageStatus);*/
		return "myPageView";
	}
	@RequestMapping(value = "profileModifyView")
	public String profileModifyView() {
		return "profileModifyView";
	}
/*	@RequestMapping(value = "leaveProc")
	public String leaveProc() {
		return "homeView";
	}*/
}
