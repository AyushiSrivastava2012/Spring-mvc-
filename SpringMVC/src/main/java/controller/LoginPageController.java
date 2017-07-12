package controller;



import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.UserService;
import vo.BusinessException;
import vo.ResponseWrapper;
import vo.User;

@Controller
@RequestMapping(value="/SpringProject")
public class LoginPageController{

	@Autowired
	UserService userService;
	
	final static Logger applicationLogger = Logger.getLogger(LoginPageController.class);
	final static Logger auditLogger = Logger.getLogger(LoginPageController.class);
	@RequestMapping(value="/login")
	public String  getLoginPage(HttpServletRequest req, HttpServletResponse response) throws Exception {
		//so that no other person can put some click-able pop up over your jsp page
		response.addHeader("X-Frame-Options", "DENY");
		return "Login";
	}


	//	public @ResponseBody String validateLogin(@RequestParam String username, @RequestParam String password ){
	@RequestMapping(value="/validateLogin",method = RequestMethod.POST)
	public @ResponseBody  ResponseWrapper<String> validateLogin(@RequestBody User user) throws BusinessException{
		//to decode base64 incoming user name and password:
		auditLogger.info(new String(Base64.getDecoder().decode(user.getName())));
		String methodname="SetDetails";
		auditLogger.info(methodname+" starts");
		if(new String(Base64.getDecoder().decode(user.getName())).compareTo("ayushi")==0 && new String(Base64.getDecoder().decode(user.getPassword())).compareTo("123")==0){
			user.setName(new String(Base64.getDecoder().decode(user.getName())));
			user.setPassword(new String(Base64.getDecoder().decode(user.getPassword())));
			return  new ResponseWrapper<String>().getSuccessResponse(userService.SetDetails(user));
		}
			
		//new ResponseWrapper<String>().getSuccessResponse("Login Successful");
		return  new ResponseWrapper<String>().getSuccessResponse("Login Not Successful");
	}



}
