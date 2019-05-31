package project.spring.ps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {

	@RequestMapping(value="homeView")
	public String home() {
		return "homeView";
	}
	
	@RequestMapping(value="test")
	public String test() {
		return "test";
	}
	
	@RequestMapping(value="signUpView")
	public String signUp() {
		return "signUpView";
	}
	
	@RequestMapping(value="categoryView")
	public String category() {
		return "categoryView";
	}
}
