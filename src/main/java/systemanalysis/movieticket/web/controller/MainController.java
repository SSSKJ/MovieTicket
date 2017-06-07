package systemanalysis.movieticket.web.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiOperation;
import systemanalysis.movieticket.persistence.dto.InfoDto;
import systemanalysis.movieticket.persistence.dto.UserDto;
import systemanalysis.movieticket.persistence.service.MainService;
import systemanalysis.movieticket.persistence.service.UserService;

@Controller
public class MainController {
	
	private static final Logger logger = Logger.getLogger(MainController.class);
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private MainService mainservice;
	
	@ApiOperation(value = "网站首页", notes = "用于跳转到welcome页面")  
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String home() {
		return "index";
	}
	
	@ApiOperation(value = "用户注册", notes = "用于提交注册时表单进行注册")
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public void register(UserDto user, InfoDto info, @RequestParam(value="preference[]") String[] preference, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(user.getEmail() + "........" + user.getPassword() + "............." + info.getNickname() + "................" + info.getPhone() + "............" + preference[0] + "...................");
		if (mainservice.Register(user, info)) {
			session.setAttribute("email", user.getEmail());
			//System.out.println(session.getAttribute("email").toString() + "........");
			Cookie cookie = new Cookie("JSESSIONID", session.getId());
			response.addCookie(cookie);
			response.setStatus(200);
			userservice.setPreference(user.getEmail(), preference);
			logger.info("Successful Register: " + user.getEmail() + ", and Login");
		} else response.setStatus(500);
	}
	
	@ApiOperation(value = "邮箱是否存在", notes = "用于检测要注册邮箱是否已存在")
	@RequestMapping(method = RequestMethod.POST, value = "/checkemail")
	public void checkemail(String email, HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("Check if Email: " + email + " Exist");
		if (!mainservice.check(email)) {
			response.setStatus(200);
			return;
		}
		response.setStatus(409);
	}
	
	@ApiOperation(value = "用户登出", notes = "用于登出并删除cookie")
	@RequestMapping(method = RequestMethod.GET, value = "/logout")
	public void Logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		String email = session.getAttribute("email").toString();
		if (session == null)
			return;
		Cookie cookie = new Cookie("JSESSIONID", null); 
		cookie.setMaxAge(0); 
		cookie.setPath("/"); 
		session.invalidate();
		response.addCookie(cookie);
		logger.info("Successful Logout: " + email);
	}
	
	@ApiOperation(value = "用户登录", notes = "用于用户信息验证并登录")
	@RequestMapping(method = RequestMethod.POST, value = "/Login")
	public void Login(UserDto user, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(user.getEmail() + "........" + user.getPassword() + ".............");
		int status = mainservice.Login(user);
		if (status == 0) {
			logger.info("Login, but Email: " + user.getEmail() + " doesn't Exist");
			response.setStatus(404);
		} else if (status == 1) {
			logger.info("Login, but Password for Email: " + user.getEmail() + " is Incorrect");
			response.setStatus(401);
		} else if (status == 2) {
			session.setAttribute("email", user.getEmail());
			//System.out.println(session.getAttribute("email").toString() + "........1");
			//System.out.println(session.getId() + "........");
			Cookie cookie = new Cookie("JSESSIONID", session.getId());
			response.addCookie(cookie);
			response.setStatus(200);
			logger.info("Successful Login: " + user.getEmail());
		}
	}
}
