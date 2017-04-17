package systemanalysis.movieticket.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import systemanalysis.movieticket.persistence.service.userInfoService;

@Controller
public class mainController {
	
	@Autowired
	private userInfoService service;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/signin")
	public void signin(String username, String password) {
		
	}
}
