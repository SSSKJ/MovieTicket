package systemanalysis.movieticket.web.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import systemanalysis.movieticket.persistence.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	private MainService service;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/Register")
	public void register(String email, String password, String nickname, String phone, String[] preference, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (service.Register(email, password, nickname, phone)) {
			//sessions
			response.getWriter().write("true");
			service.setPreference(email, preference);
		} else response.getWriter().write("false");;
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/CheckEmail")
	public void checkemail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader br;
		try {
			br = request.getReader();
			String str, wholeStr = "";
			while((str = br.readLine()) != null){
				wholeStr += str;
				}
			System.out.println(wholeStr);
			} catch (IOException e) {
				e.printStackTrace();
			}
		System.out.println(request.getAttribute("") + ".....................................................");
		/*if (service.check(email))
			response.getWriter().write("true");
		else response.getWriter().write("false");*/
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/Login")
	public void Login(String email, String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
		int status = service.Login(email, password);
		if (status == 2) {
			//session
		}
		response.getWriter().write("" + status);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/ModifyNickname")
	public void modifynickname() {}
	
	@RequestMapping("/GetOrderForms")
	public void getOrderForms() {
		
	}
}
