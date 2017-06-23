package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/SpringProject")
public class LoginPageController {

	
	@RequestMapping(value="/login")
	public String getLoginPage(){
		return "Login";
	}
}
