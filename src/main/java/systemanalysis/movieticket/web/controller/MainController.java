package systemanalysis.movieticket.web.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import systemanalysis.movieticket.persistence.service.MainService;
import systemanalysis.movieticket.persistence.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private MainService mainservice;
	
	//@ApiOperation(value = "网站首页", notes = "跳转到welcome页面")  
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String home() {
		return "index";
	}
	
	//@ApiOperation(value = "用户注册", notes = "提交注册时表单进行注册")
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public void register(String email, String password, String phone, String nickname, @RequestParam(value="preference[]") String[] preference, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(email + "........" + password + "............." + nickname + "................" + phone + "............" + preference[0] + "...................");
		if (mainservice.Register(email, password, nickname, phone)) {
			session.setAttribute("email", email);
			System.out.println(session.getAttribute("email").toString() + "........");
			Cookie cookie = new Cookie("JSESSIONID", session.getId());
			response.addCookie(cookie);
			response.setStatus(200);
			userservice.setPreference(email, preference);
		} else response.setStatus(500);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/checkemail")
	public void checkemail(String email, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (mainservice.check(email))
			response.setStatus(200);
		response.setStatus(409);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/logout")
	public void Logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		if (session == null)
			return;
		Cookie cookie = new Cookie("JSESSIONID", null); 
		cookie.setMaxAge(0); 
		cookie.setPath("/"); 
		session.invalidate();
		response.addCookie(cookie);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/Login")
	public void Login(String email, String password, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(email + "........" + password + ".............");
		int status = mainservice.Login(email, password);
		if (status == 0) response.setStatus(404);
		else if (status == 1) response.setStatus(401);
		else if (status == 2) {
			session.setAttribute("email", email);
			//System.out.println(session.getAttribute("email").toString() + "........1");
			//System.out.println(session.getId() + "........");
			Cookie cookie = new Cookie("JSESSIONID", session.getId());
			response.addCookie(cookie);
			response.setStatus(200);
		}
	}
}
